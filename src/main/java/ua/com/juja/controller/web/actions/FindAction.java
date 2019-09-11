package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindAction extends AbstractAction {

    public FindAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/find");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        String nameTable = req.getParameter("nameTable");
        req.setAttribute("listdataset", service.find(getManager(req, resp), nameTable));
        try {
            req.getRequestDispatcher("findResult.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
