package ua.com.juja.controller.command;

import ua.com.juja.model.DBManager;
import ua.com.juja.view.View;

public class IsConnected implements Command {
    private DBManager dbManager;
    private View view;

    public IsConnected(DBManager dbManager, View view) {
        this.dbManager = dbManager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return dbManager.getConnection() == null;
    }

    @Override
    public void process(String command) {
        view.write(String.format("Вы не можете пользоваться командой '%s', пока не подключитесь к базе данных командой " +
                "connect|database|login|password", command));
    }
}
