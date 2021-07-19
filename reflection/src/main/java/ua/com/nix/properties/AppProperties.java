package ua.com.nix.properties;

import ua.com.nix.annotation.PropertyKey;

public class AppProperties {

    @PropertyKey("connection.limit")
    public int maxConnections;

    @PropertyKey("connection.name")
    public String connectionName;

    @PropertyKey("isConnectionExist")
    public boolean isConnectionExist;

    public String fileName = "Hello";

    @Override
    public String toString() {
        return "AppProperties{" +
                "maxConnections=" + maxConnections +
                ", name='" + connectionName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", isConnectionExist=" + isConnectionExist +
                '}';
    }
}
