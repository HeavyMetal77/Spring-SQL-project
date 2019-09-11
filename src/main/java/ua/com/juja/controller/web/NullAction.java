package ua.com.juja.controller.web;

import ua.com.juja.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullAction extends AbstractAction {

    public NullAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return false;
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        //do nothing
    }
}
