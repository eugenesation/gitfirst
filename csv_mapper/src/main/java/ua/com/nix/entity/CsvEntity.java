package ua.com.nix.entity;

import ua.com.nix.annotation.CsvCell;

public class CsvEntity {

    @CsvCell("id")
    private int id;

    @CsvCell("name")
    private String name;

    @CsvCell("isSacked")
    private boolean isSacked;

//    public CsvEntity(int id, String name, boolean isSacked) {
//        this.id = id;
//        this.name = name;
//        this.isSacked = isSacked;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSacked() {
        return isSacked;
    }

    public void setSacked(boolean sacked) {
        isSacked = sacked;
    }

    @Override
    public String toString() {
        return "CsvEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isSacked=" + isSacked +
                '}';
    }
}
