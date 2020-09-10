package com.revature.revabooks.util;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {

    public String process(HttpServletRequest req) {

        switch (req.getRequestURI()) {

            case "/revabooks/login.view":
                return "partials/login.html";

            case "/revabooks/register.view":
                return "partials/register.html";

            case "/revabooks/home.view":

                String principal = (String) req.getSession().getAttribute("principal");
                if (principal == null || principal.equals("")) {
                    return "partials/login.html";
                }

                return "partials/home.html";

            default:
                return null;

        }

    }
}
