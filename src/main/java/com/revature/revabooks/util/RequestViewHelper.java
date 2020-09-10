package com.revature.revabooks.util;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {

    public String process(HttpServletRequest req){
        switch (req.getRequestURI()){
            case "/revabooks/login.view":
                return "partials/login.html";
            default:
                return null;
        }
    }
}
