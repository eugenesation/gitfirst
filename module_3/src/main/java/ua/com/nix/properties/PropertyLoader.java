package ua.com.nix.properties;

import ua.com.nix.start.Starter;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertyLoader {

    public static Properties loadProperties(String[] args) {
        Properties props = new Properties();
        try(InputStream input = Starter.class.getResourceAsStream("/jdbc.properties")) {
            props.load(input);
            props.setProperty("user", args[1]);
            props.setProperty("password", args[2]);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }

}
