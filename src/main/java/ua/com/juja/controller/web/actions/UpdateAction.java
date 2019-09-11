package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataSet;
import ua.com.juja.model.DataSetImpl;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAction extends AbstractAction {

    public UpdateAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/update");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "update.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String[] params = req.getParameterValues("table");
        String nameTable = params[0];
        String column1 = params[1];
        String value1 = params[2];
        DataSet dataSets = new DataSetImpl();
        dataSets.put(params[3], params[4]);
        DBManager manager = getManager(req, resp);
        manager.update(nameTable, column1, value1, dataSets);
        req.setAttribute("listdataset", service.find(manager, nameTable));
        try {
            req.getRequestDispatcher("findResult.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
