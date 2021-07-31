package ua.com.nix;

import ua.com.nix.properties.PropertyLoader;
import ua.com.nix.start.Starter;


public class Main {

    public static void main(String[] args) {
        PropertyLoader propertyLoader = new PropertyLoader();
        new Starter().start(propertyLoader, args);
    }
}

