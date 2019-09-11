package ua.com.juja.controller.web;

import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;
import ua.com.juja.model.configuration.ConnectionManager;

import java.sql.Connection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class NullDbManager implements DBManager {

    @Override
    public void connect(String database, String login, String password) {
        // do nothing
    }

    @Override
    public Set<String> getTables() {
        return new HashSet<>();
    }

    @Override
    public void createTable(String requestSql, String nameTable) {
        // do nothing
    }

    @Override
    public void drop(String nameTable) {
        // do nothing
    }

    @Override
    public void clear(String nameTable) {
        // do nothing
    }

    @Override
    public int getSize(String tableName) {
        return 0;
    }

    @Override
    public List<Integer> getWidthAtribute(String nameTable) {
        return new LinkedList<>();
    }

    @Override
    public Set<String> getAtribute(String nameTable) {
        return new HashSet<>();
    }

    @Override
    public List<DataSet> getDataSetTable(String nameTable) {
        return new LinkedList<>();
    }

    @Override
    public void insert(String nameTable, DataSet dataSet) {
        // do nothing
    }

    @Override
    public void update(String nameTable, String column1, String value1, DataSet dataSet) {
        // do nothing
    }

    @Override
    public void setConnection(ConnectionManager connectionManager) {
        // do nothing
    }

    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public void delete(String nameTable, String columnName, String columnValue) {
        // do nothing
    }

    @Override
    public void closeOpenedConnection() {
        // do nothing
    }

    @Override
    public void createDatabase(String databaseName) {
        // do nothing
    }

    @Override
    public Set<String> getDatabases() {
        return new HashSet<>();
    }

    @Override
    public void dropDatabase(String databaseName) {
        // do nothing
    }
}
