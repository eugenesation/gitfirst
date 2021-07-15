package ua.com.nix.dao;

import ua.com.nix.entity.Solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolutionDao {

    private final Connection connection;

    public SolutionDao(Connection connection) {
        this.connection = connection;
    }

    public Solution read(int solutionId) {
        try (PreparedStatement readById = connection.prepareStatement(
                "select * from Solution where problem_id = (?)")) {
            readById.setInt(1, solutionId);
            ResultSet rs = readById.executeQuery();
            if(rs.next()){
                int id = rs.getInt("problem_id");
                int cost = rs.getInt("cost");
                return new Solution(id, cost);
            }
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
