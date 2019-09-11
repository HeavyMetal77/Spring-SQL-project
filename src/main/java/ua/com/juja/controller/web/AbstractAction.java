package ua.com.juja.controller.web;

import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractAction implements Action {
    protected Service service;

    public AbstractAction(Service service) {
        this.service = service;
    }

    protected void gotoJsp(ServletRequest req, ServletResponse resp, String nameJsp) {
        try {
            req.getRequestDispatcher(nameJsp).forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected DBManager getManager(HttpServletRequest req, HttpServletResponse resp) {
        DBManager db_manager = (DBManager) req.getSession().getAttribute("db_manager");
        if (db_manager != null) {
            return db_manager;
        } else {
            try {
                resp.sendRedirect(resp.encodeRedirectURL("connect"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void processPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
