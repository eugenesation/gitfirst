package ua.com.nix.table;

import java.util.ArrayList;
import java.util.List;

public class CsvTable {
    private final List<String[]> tableData;

    public CsvTable(){
        this.tableData = new ArrayList<>();
    }

    public CsvTable(List<String[]> data){
        this.tableData = data;
    }

    public String getCell(int row, int column){
        return this.tableData.get(row)[column];
    }

    public String getCell(int row, String columnName){
        String[] header = getHeaders();
        int columnIndex = -1;
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(columnName)){
                columnIndex = i;
                break;
            }
        }
        if (columnIndex == -1) return null;
        return this.tableData.get(row)[columnIndex];
    }

    public String[] getHeaders(){
        return this.tableData.get(0);
    }

    public int size(){
        return this.tableData.size();
    }
}
