package ua.com.nix.dao;

import ua.com.nix.entity.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {
    private final Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    public Location read(int locationId) {
        try (PreparedStatement readLocationById = connection.prepareStatement(
                "select * from Location where id = (?)")) {
            String name;
            readLocationById.setInt(1, locationId);
            ResultSet rs = readLocationById.executeQuery();
            if(rs.next()){
                name = rs.getString("name");
                int id = rs.getInt("id");
                return new Location(id, name);
            } else return null;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<Location> read() {
        try (PreparedStatement readAll = connection.prepareStatement(
                "select * from Location")) {
            ResultSet rs = readAll.executeQuery();
            List<Location> loc = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                loc.add(new Location(id, name));
            }
            return loc;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
