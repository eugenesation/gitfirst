package ua.com.nix;

import ua.com.nix.bind.AppPropertiesBinder;
import ua.com.nix.properties.AppProperties;
import ua.com.nix.properties.PropertyLoader;

public class Main {

    public static void main(String[] args) {

        AppPropertiesBinder appPropertiesBinder = new AppPropertiesBinder();
        appPropertiesBinder.bind(AppProperties.class, PropertyLoader.loadProperties());

    }

}
