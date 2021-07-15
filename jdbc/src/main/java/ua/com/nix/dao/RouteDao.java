package ua.com.nix.dao;

import ua.com.nix.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDao {

    private final Connection connection;

    public RouteDao(Connection connection) {
        this.connection = connection;
    }

    public List<Route> read() {
        try (PreparedStatement readAll = connection.prepareStatement(
                "select * from Route")) {
            ResultSet rs = readAll.executeQuery();
            List<Route> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFrom = rs.getInt("from_id");
                int idTo = rs.getInt("to_id");
                int cost = rs.getInt("cost");
                list.add(new Route(id, idFrom, idTo, cost));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
