package com.revature.revabooks.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

	public static String process(HttpServletRequest req){
		switch (req.getRequestURI()){
			case "/revabooks/login.view":
			case "/login.view":
				return "partials/login.html";

			case "/revabooks/register.view":
			case "/register.view":
				return "partials/register.html";

			case "/revabooks/home.view":
			case "/home.view":
				String principal = (String) req.getSession().getAttribute("principal");
				if(principal == null || principal.equals("")){
					return "partials/login.html";
				}
				return "partials/home.html";

			default:
				return null;
		}
	}
}
