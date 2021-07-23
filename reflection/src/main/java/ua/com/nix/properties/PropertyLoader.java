package ua.com.nix.properties;

import ua.com.nix.bind.AppPropertiesBinder;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class PropertyLoader {

    public static Properties loadProperties() {
        Properties props = new Properties();
        try(InputStream input = AppPropertiesBinder.class.getResourceAsStream("/app.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }

}
