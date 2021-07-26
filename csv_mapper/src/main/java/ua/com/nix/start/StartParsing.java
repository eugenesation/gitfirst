package ua.com.nix.start;

import ua.com.nix.entity.CsvEntity;
import ua.com.nix.util.Mapper;

import java.util.List;

public class StartParsing {

    public static final String filePath = "listofworkers.csv";

    public void starter() {

        try {

            List<CsvEntity> objects = Mapper.initialize(filePath, CsvEntity.class);
            System.out.println("List of objects based on data from csv file:\n ");
            for (CsvEntity object : objects) {
                System.out.println(object);

            }
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}
