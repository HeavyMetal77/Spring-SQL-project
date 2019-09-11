package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction extends AbstractAction {

    public DeleteAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/delete");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "delete.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String tableName = req.getParameter("nameTable");
        String columnName = req.getParameter("columnName");
        String columnValue = req.getParameter("columnValue");
        DBManager manager = getManager(req, resp);
        manager.delete(tableName, columnName, columnValue);
        req.setAttribute("listdataset", service.find(manager, tableName));
        try {
            req.getRequestDispatcher("findResult.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
