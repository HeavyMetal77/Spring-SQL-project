package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorAction extends AbstractAction {

    public ErrorAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/error");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("message", "Ошибка");
        gotoJsp(req, resp, "error.jsp");
    }
}
