package ua.com.nix.dao;

import ua.com.nix.entity.Problem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDao {

    private final Connection connection;

    public ProblemDao(Connection connection) {
        this.connection = connection;
    }

    public List<Problem> read() {
        try (PreparedStatement readAll = connection.prepareStatement(
                "select * from Problem")) {
            ResultSet rs = readAll.executeQuery();
            List<Problem> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idFrom = rs.getInt("from_id");
                int idTo = rs.getInt("to_id");
                list.add(new Problem(id, idFrom, idTo));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
