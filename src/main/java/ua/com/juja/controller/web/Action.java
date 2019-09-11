package ua.com.juja.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

    Boolean canProcess(String url);

    void processGet(HttpServletRequest req, HttpServletResponse resp);

    void processPost(HttpServletRequest req, HttpServletResponse resp);
}
