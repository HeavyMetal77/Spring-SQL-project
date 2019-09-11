package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction extends AbstractAction {

    public InsertAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/insert");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "insert.jsp");
    }
}
