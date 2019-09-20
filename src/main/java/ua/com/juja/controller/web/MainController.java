package ua.com.juja.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.juja.model.DBManager;
import ua.com.juja.service.Service;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(HttpSession session) {
        if (getManager(session) == null) {
            return "redirect:/connect";
        } else {
            return "redirect:/menu";
        }
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu(Model model) {
        model.addAttribute("list", service.commands());
        return "menu";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help() {
        return "help";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connect(HttpSession session, Model model) {
        String page = (String) session.getAttribute("from-page");
        session.removeAttribute("from-page");
        model.addAttribute("connection", new Connection(page));
        if (getManager(session) == null) {
            return "connect";
        } else {
            return "menu";
        }
    }

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public String connecting(@ModelAttribute("connection") Connection connection,
                             HttpSession session, Model model) {
        try {
            DBManager manager = service.connect(connection.getDbName(), connection.getUserName(),
                    connection.getPassword());
            session.setAttribute("db_manager", manager);
            String fromPage = connection.getFromPage();
            if (!fromPage.equals("")) {
                return "redirect:" + fromPage;
            } else {
                return "redirect:/";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "error";
        }
    }

    private DBManager getManager(HttpSession session) {
        return (DBManager) session.getAttribute("db_manager");
    }
}