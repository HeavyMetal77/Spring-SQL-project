package ua.com.juja.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.juja.model.DBManager;
import ua.com.juja.model.DataBases;
import ua.com.juja.model.Table;
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
    public String menu(Model model, HttpSession session) {
        if (getManager(session) == null) {
            return "redirect:/connect";
        }
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
            return "redirect:/menu";
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

    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    public String tablesGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/tables");
            return "redirect:/connect";
        }
        model.addAttribute("listtable", manager.getTables());
        return "tables";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String tablesPOST(Model model, HttpSession session, String nameTable) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/tables");
            return "redirect:/connect";
        }
        model.addAttribute("listdataset", service.find(manager, nameTable));
        return "findResult";
    }

    @RequestMapping(value = "/databases", method = RequestMethod.GET)
    public String databases(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/databases");
            return "redirect:/connect";
        }
        model.addAttribute("listdatabases", manager.getDatabases());
        return "databases";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    public String clearGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/clear");
            return "redirect:/connect";
        }
        model.addAttribute("table", new Table());
        return "clear";
    }

    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public String clearPOST(Model model, HttpSession session, @RequestParam(value = "nameTable") String nameTable) {
        DBManager manager = getManager(session);
        manager.clear(nameTable);
        model.addAttribute("listdataset", service.find(manager, nameTable));
        return "findResult";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/delete");
            return "redirect:/connect";
        }
        model.addAttribute("table", new Table());
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePOST(Model model, HttpSession session,
                             @RequestParam(value = "nameTable") String nameTable,
                             @RequestParam(value = "columnName") String columnName,
                             @RequestParam(value = "columnValue") String columnValue) {
        DBManager manager = getManager(session);
        manager.delete(nameTable, columnName, columnValue);
        model.addAttribute("listdataset", service.find(manager, nameTable));
        return "findResult";
    }

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    public String dropGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/drop");
            return "redirect:/connect";
        }
        model.addAttribute("table", new Table());
        return "drop";
    }

    @RequestMapping(value = "/drop", method = RequestMethod.POST)
    public String dropPOST(Model model, HttpSession session,
                           @RequestParam(value = "nameTable") String nameTable) {
        DBManager manager = getManager(session);
        manager.drop(nameTable);
        model.addAttribute("listtable", manager.getTables());
        return "tables";
    }

    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public String createGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/createTable");
            return "redirect:/connect";
        }
        model.addAttribute("table", new Table());
        return "createTable";
    }

    @RequestMapping(value = "/createTable", method = RequestMethod.POST)
    public String createTablePOST(Model model, HttpSession session,
                                  @RequestParam(value = "nameTable") String nameTable,
                                  @RequestParam(value = "columnName") String columnName) {
        DBManager manager = getManager(session);
        String[] params = {nameTable, columnName};
        service.createTable(manager, params);
        model.addAttribute("listtable", manager.getTables());
        return "tables";
    }

    @RequestMapping(value = "/createDB", method = RequestMethod.GET)
    public String createDbGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/createDB");
            return "redirect:/connect";
        }
        model.addAttribute("database", new DataBases());
        return "createDB";
    }

    @RequestMapping(value = "/createDB", method = RequestMethod.POST)
    public String createDbPOST(Model model, HttpSession session,
                               @RequestParam(value = "databaseName") String databaseName) {
        DBManager manager = getManager(session);
        manager.createDatabase(databaseName);
        model.addAttribute("listdatabases", manager.getDatabases());
        return "databases";
    }

    @RequestMapping(value = "/DBdrop", method = RequestMethod.GET)
    public String dbDropGET(Model model, HttpSession session) {
        DBManager manager = getManager(session);
        if (manager == null) {
            session.setAttribute("from-page", "/DBdrop");
            return "redirect:/connect";
        }
        model.addAttribute("database", new DataBases());
        return "dbDrop";
    }

    @RequestMapping(value = "/DBdrop", method = RequestMethod.POST)
    public String dbDropPOST(Model model, HttpSession session,
                             @RequestParam(value = "databaseName") String databaseName) {
        DBManager manager = getManager(session);
        manager.dropDatabase(databaseName);
        model.addAttribute("listdatabases", manager.getDatabases());
        return "databases";
    }

    private DBManager getManager(HttpSession session) {
        return (DBManager) session.getAttribute("db_manager");
    }
}
