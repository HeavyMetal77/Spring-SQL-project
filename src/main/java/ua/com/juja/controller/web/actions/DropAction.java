package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DropAction extends AbstractAction {

    public DropAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/drop");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "drop.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String tableName = req.getParameter("nameTable");
        DBManager manager = getManager(req, resp);
        manager.drop(tableName);
        req.setAttribute("listtable", manager.getTables());
        try {
            req.getRequestDispatcher("tables.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
