package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DatabasesAction extends AbstractAction {

    public DatabasesAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/databases");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("listdatabases", getManager(req, resp).getDatabases());
            req.getRequestDispatcher("databases.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
