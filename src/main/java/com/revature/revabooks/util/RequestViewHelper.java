package com.revature.revabooks.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

    public String process(HttpServletRequest req) {

        switch (req.getRequestURI()) {
            case "/login.view":
            case "/revabooks/login.view":
                return "partials/login.html";
            case "/register.view":
            case "/revabooks/register.view":
                return "partials/register.html";
            case "/home.view":
            case "/revabooks/home.view":
                String pr = (String) req.getSession().getAttribute("principal");
                if(pr == null || pr.equals("")){
                    return "partials/login.html";
                }
                return "partials/home.html";
            default:
                return null;

        }

    }
}
