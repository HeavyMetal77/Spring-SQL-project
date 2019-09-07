package ua.com.juja.service;

import ua.com.juja.model.DataSet;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public interface Service {
    List<String> commands();

    Connection connect(String databaseName, String userName, String password);

    List<List<String>> find(String databaseName);

    void clear(String databaseName);

    void delete(String nameTable, String columnName, String columnValue);

    void drop(String nameTable);

    Set<String> tables();

    void createDataBase(String databaseName);

    Set<String> databases();

    void createTable(String[] params);

    void dbDrop(String nameDB);

    void update(String nameTable, String column1, String value1, DataSet dataSets);
}
