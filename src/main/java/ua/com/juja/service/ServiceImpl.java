package ua.com.juja.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class ServiceImpl implements Service, ApplicationContextAware {

    public ApplicationContext applicationContext;

    @Bean
    public DBManager getDBManager() {
        return (DBManager) applicationContext.getBean("JDBCDBManager");
    }

    @Override
    public List<String> commands() {
        List<String> list = new ArrayList<>();
        list.add("connect");
        list.add("help");
        list.add("menu");
        list.add("tables");
        list.add("find");
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
        dbManager.connect(databaseName, userName, password);
        return dbManager;
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
    public void clear(DBManager dbManager, String nameTable) {
        dbManager.clear(nameTable);
    }

    @Override
    public void delete(DBManager dbManager, String nameTable, String columnName, String columnValue) {
        dbManager.delete(nameTable, columnName, columnValue);
    }

    @Override
    public void drop(DBManager dbManager, String nameTable) {
        dbManager.drop(nameTable);
    }

    @Override
    public Set<String> tables(DBManager dbManager) {
        return dbManager.getTables();
    }

    @Override
    public void createDataBase(DBManager dbManager, String databaseName) {
        dbManager.createDatabase(databaseName);
    }

    @Override
    public Set<String> databases(DBManager dbManager) {
        return dbManager.getDatabases();
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

    @Override
    public void dbDrop(DBManager dbManager, String nameDB) {
        dbManager.dropDatabase(nameDB);
    }

    @Override
    public void update(DBManager dbManager, String nameTable, String column1, String value1, DataSet dataSets) {
        dbManager.update(nameTable, column1, value1, dataSets);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
