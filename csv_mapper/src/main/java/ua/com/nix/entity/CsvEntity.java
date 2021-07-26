package ua.com.nix.entity;

import ua.com.nix.annotation.CsvCell;

public class CsvEntity {

    @CsvCell("id")
    private int id;

    @CsvCell("name")
    private String name;

    @CsvCell("isSacked")
    private boolean isSacked;

    @Override
    public String toString() {
        return "CsvEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isSacked=" + isSacked +
                '}';
    }
}
