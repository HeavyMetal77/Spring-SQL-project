package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuAction extends AbstractAction {

    public MenuAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/menu");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        if (getManager(req, resp) != null) {
            req.setAttribute("list", service.commands());
            gotoJsp(req, resp, "menu.jsp");
        } else {
            gotoJsp(req, resp, "connect.jsp");
        }
    }
}
