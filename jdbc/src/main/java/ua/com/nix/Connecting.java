package ua.com.nix;

import ua.com.nix.dao.LocationDao;
import ua.com.nix.dao.ProblemDao;
import ua.com.nix.dao.RouteDao;
import ua.com.nix.dao.SolutionDao;
import ua.com.nix.entity.Location;
import ua.com.nix.entity.Problem;
import ua.com.nix.entity.Route;
import ua.com.nix.entity.Solution;
import ua.com.nix.util.Graph;
import ua.com.nix.util.MinPath;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Connecting {

    public void start() {
        Properties props = loadProperties();
        String url = props.getProperty("url");

        Graph graph = new Graph();
        MinPath minPath = new MinPath();

        try(Connection connection = DriverManager.getConnection(url, props)) {
            connection.setAutoCommit(false);

            ProblemDao problemDao = new ProblemDao(connection);
            SolutionDao solutionDao = new SolutionDao(connection);
            RouteDao routeDao = new RouteDao(connection);
            LocationDao locationDao = new LocationDao(connection);

            List<Location> locations = locationDao.read();
            List<Route> routes = routeDao.read();
            for (Location lo: locations) {
                graph.addVertex(lo.getName());
            }
            for (Route route : routes) {
                String nameFrom = locationDao.read(route.getFromId()).getName();
                String nameTo = locationDao.read(route.getToId()).getName();
                int cost = route.getCost();
                graph.addVertexWithWeight(nameFrom, nameTo, cost);
            }

            List<Problem> problems = problemDao.read();
            List<Solution> solutions = new ArrayList<>();
            for (Problem problem : problems) {
                if(solutionDao.read(problem.getId()) == null){
                    String nameFrom = locationDao.read(problem.getFromId()).getName();
                    String nameTo = locationDao.read(problem.getToId()).getName();
                    double path = minPath.getShortestPath(graph, nameFrom, nameTo);
                    solutions.add(new Solution(problem.getId(), ((int) path)));
                }
            }

            try(PreparedStatement insertSolution = connection.prepareStatement(
                    "insert into Solution (problem_id, cost) values (?, ?)"
            )) {
                for (Solution solution : solutions) {
                    insertSolution.setInt(1, solution.getId());
                    insertSolution.setInt(2, solution.getCost());
                    insertSolution.addBatch();
                }
                insertSolution.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {
        Properties props = new Properties();
        try(InputStream input = Connecting.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}

