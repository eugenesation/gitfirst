package ua.com.nix.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ua.com.nix.table.CsvTable;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Parser {

    public static CsvTable readFromCsv(InputStream input) {
        List<String[]> fromCsv;
        try (CSVReader reader = new CSVReader(new InputStreamReader(input))) {
            fromCsv = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return new CsvTable(fromCsv);
    }

}
