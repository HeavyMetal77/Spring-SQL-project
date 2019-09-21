package ua.com.juja.model;

public class Table {
    private String nameTable;
    private String columnName;
    private String columnValue;
    private String changeColumnName;
    private String changeColumnValue;

    public String getChangeColumnName() {
        return changeColumnName;
    }

    public void setChangeColumnName(String changeColumnName) {
        this.changeColumnName = changeColumnName;
    }

    public String getChangeColumnValue() {
        return changeColumnValue;
    }

    public void setChangeColumnValue(String changeColumnValue) {
        this.changeColumnValue = changeColumnValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }
}
