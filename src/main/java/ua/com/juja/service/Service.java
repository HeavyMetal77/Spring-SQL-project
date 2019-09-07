package ua.com.juja.service;

import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;

import java.util.List;
import java.util.Set;

public interface Service {
    List<String> commands();

    DBManager connect(String databaseName, String userName, String password);

    List<List<String>> find(DBManager dbManager, String nameTable);

    void clear(DBManager dbManager, String nameTable);

    void delete(DBManager dbManager, String nameTable, String columnName, String columnValue);

    void drop(DBManager dbManager, String nameTable);

    Set<String> tables(DBManager dbManager);

    void createDataBase(DBManager dbManager, String databaseName);

    Set<String> databases(DBManager dbManager);

    void createTable(DBManager dbManager, String[] params);

    void dbDrop(DBManager dbManager, String nameDB);

    void update(DBManager dbManager, String nameTable, String column1, String value1, DataSet dataSets);
}
