package ua.com.juja.service;

import ua.com.juja.model.DBManager;

import java.util.List;

public interface Service {
    List<String> commands();

    DBManager connect(String databaseName, String userName, String password);

    List<List<String>> find(DBManager dbManager, String nameTable);

    void createTable(DBManager dbManager, String[] params);
}
