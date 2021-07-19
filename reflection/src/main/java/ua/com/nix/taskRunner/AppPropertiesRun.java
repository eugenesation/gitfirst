package ua.com.nix.taskRunner;

import ua.com.nix.annotation.PropertyKey;
import ua.com.nix.properties.AppProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class AppPropertiesRun {

    public void getProperties() {

        Properties props = loadProperties();

        Object instance = new AppProperties();
        Class<?> classOfInstance = instance.getClass();
        Field[] fields = classOfInstance.getFields();
        System.out.println("Initialization of fields: \n");
        for (Field field : fields) {
            try {
                PropertyKey propertyKeyAnnotation = field.getAnnotation(PropertyKey.class);
                if (propertyKeyAnnotation == null) continue;
                else  {

                    if (field.getType().getTypeName().equals(int.class.getTypeName()))
                        field.set(instance, Integer.parseInt(props.getProperty(propertyKeyAnnotation.value())));

                    else if (field.getType().getTypeName().equals(String.class.getTypeName()))
                        field.set(instance, props.getProperty(propertyKeyAnnotation.value()));

                    else if (field.getType().getTypeName().equals(boolean.class.getTypeName()))
                        field.set(instance, Boolean.parseBoolean(props.getProperty(propertyKeyAnnotation.value())));

                }
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getTypeName() + " "
                        + field.getName() + " = " + field.get(instance));
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("\nAfter  initialization: " + instance);
    }


    private static Properties loadProperties() {
        Properties props = new Properties();
        try(InputStream input = AppPropertiesRun.class.getResourceAsStream("/app.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return props;
    }
}
