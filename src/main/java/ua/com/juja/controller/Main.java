package ua.com.juja.controller;

import ua.com.juja.model.DBManager;
import ua.com.juja.model.JDBCDBManager;
import ua.com.juja.view.Console;
import ua.com.juja.view.View;

public class Main {
    public static void main(String[] args) {
        DBManager dbmanager = new JDBCDBManager();
        View view = new Console();
        MainController mainController = new MainController(view, dbmanager);
        mainController.run();
    }
}