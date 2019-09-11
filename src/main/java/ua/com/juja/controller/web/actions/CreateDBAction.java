package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateDBAction extends AbstractAction {

    public CreateDBAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/createDB");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "createDB.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String databaseName = req.getParameter("databaseName");
        DBManager manager = getManager(req, resp);
        manager.createDatabase(databaseName);
        req.setAttribute("listdatabases", manager.getDatabases());
        try {
            req.getRequestDispatcher("databases.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
