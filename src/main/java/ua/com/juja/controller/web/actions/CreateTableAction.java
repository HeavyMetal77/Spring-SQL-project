package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTableAction extends AbstractAction {

    public CreateTableAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/createTable");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "createTable.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String[] params = req.getParameterValues("table");
        DBManager manager = getManager(req, resp);
        service.createTable(manager, params);
        req.setAttribute("listtable", manager.getTables());
        try {
            req.getRequestDispatcher("tables.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
