package ua.com.juja.controller.web.actions;

import ua.com.juja.controller.web.AbstractAction;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConnectAction extends AbstractAction {

    public ConnectAction(Service service) {
        super(service);
    }

    @Override
    public Boolean canProcess(String url) {
        return url.startsWith("/connect") || url.equals("/");
    }

    @Override
    public void processGet(HttpServletRequest req, HttpServletResponse resp) {
        gotoJsp(req, resp, "connect.jsp");
    }

    @Override
    public void processPost(HttpServletRequest req, HttpServletResponse resp) {
        String databaseName = req.getParameter("dbname");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            DBManager manager = service.connect(databaseName, userName, password);
            req.getSession().setAttribute("db_manager", manager);
            resp.sendRedirect(resp.encodeRedirectURL("menu"));
        } catch (Exception e) {
            req.setAttribute("message", e.getMessage());
            try {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            } catch (ServletException | IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
