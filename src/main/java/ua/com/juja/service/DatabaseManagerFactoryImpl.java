package ua.com.juja.service;

import ua.com.juja.model.DBManager;


public class DatabaseManagerFactoryImpl implements DatabaseManagerFactory {

    private String className;

    @Override
    public DBManager createDatabaseManager() {
        try {
            return (DBManager) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setClassName(String className) {
        this.className = className;
    }
}
