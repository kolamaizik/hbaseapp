package by.mk.hbaseapp.model;

import java.util.List;

public class HbaseTable {
    private String tableName;

    private String familyName;
    private List<String> familiesName;

    private String columnName;
    private List<String> columnsName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<String> getFamiliesName() {
        return familiesName;
    }

    public void setFamiliesName(List<String> familiesName) {
        this.familiesName = familiesName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<String> getColumnsName() {
        return columnsName;
    }

    public void setColumnsName(List<String> columnsName) {
        this.columnsName = columnsName;
    }
}
