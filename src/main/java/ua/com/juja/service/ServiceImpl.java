package ua.com.juja.service;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public abstract class ServiceImpl implements Service {

    @Lookup
    public abstract DBManager getDBManager();

    @Override
    public List<String> commands() {
        List<String> list = new ArrayList<>();
        list.add("help");
        list.add("tables");
        list.add("clear");
        list.add("delete");
        list.add("drop");
        list.add("DBdrop");
        list.add("databases");
        list.add("createDB");
        list.add("createTable");
        list.add("update");
        return list;
    }

    @Override
    public DBManager connect(String databaseName, String userName, String password) {
        DBManager dbManager = getDBManager();
        if (dbManager != null) {
            dbManager.connect(databaseName, userName, password);
            return dbManager;
        } else {
            throw new RuntimeException("DBManager is null!");
        }
    }

    @Override
    public List<List<String>> find(DBManager dbManager, String nameTable) {
        List<List<String>> result = new LinkedList<>();
        List<String> columns = new LinkedList<>(dbManager.getAtribute(nameTable));
        List<DataSet> tableData = dbManager.getDataSetTable(nameTable);
        result.add(columns);
        for (DataSet dataSet : tableData) {
            List<String> row = new ArrayList<>(columns.size());
            result.add(row);
            for (String column : columns) {
                Object value = dataSet.get(column);
                if (value != null) {
                    row.add(value.toString());
                } else {
                    row.add("null");
                }
            }
        }
        return result;
    }

    @Override
    public void createTable(DBManager dbManager, String[] params) {
        String nameTable = params[0];
        String[] nameColumns = new String[params.length - 1];
        for (int i = 1, j = 0; i < params.length; i++) {
            nameColumns[j++] = params[i];
        }
        String requestSql = "CREATE TABLE IF NOT EXISTS " +
                nameTable + " (ID SERIAL PRIMARY KEY,";
        String textNameColumn = "";
        for (String text : nameColumns) {
            textNameColumn += " " + text + " TEXT NOT NULL,";
        }
        textNameColumn = textNameColumn.substring(0, (textNameColumn.length() - 1));
        requestSql += textNameColumn + ")";
        dbManager.createTable(requestSql, nameTable);
    }
}
