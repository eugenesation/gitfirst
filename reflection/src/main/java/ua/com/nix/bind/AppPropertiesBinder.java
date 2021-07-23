package ua.com.nix.bind;

import ua.com.nix.annotation.PropertyKey;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class AppPropertiesBinder {


    public <T> void bind(Class<T> type, Properties props) {

        T object;
        try {
            object = type.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException();
        }
        Class<?> classOfInstance = object.getClass();
        Field[] fields = classOfInstance.getFields();
        System.out.println("Initialization of fields: \n");
        for (Field field : fields) {
            try {
                PropertyKey propertyKeyAnnotation = field.getAnnotation(PropertyKey.class);
                if (propertyKeyAnnotation == null) continue;
                else  {

                    if (field.getType().getTypeName().equals(int.class.getTypeName()))
                        field.set(object, Integer.parseInt(props.getProperty(propertyKeyAnnotation.value())));

                    else if (field.getType().getTypeName().equals(String.class.getTypeName()))
                        field.set(object, props.getProperty(propertyKeyAnnotation.value()));

                    else if (field.getType().getTypeName().equals(boolean.class.getTypeName()))
                        field.set(object, Boolean.parseBoolean(props.getProperty(propertyKeyAnnotation.value())));

                }
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getTypeName() + " "
                        + field.getName() + " = " + field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException();
            }
        }
        System.out.println("\nAfter  initialization: " + type);
    }
}
