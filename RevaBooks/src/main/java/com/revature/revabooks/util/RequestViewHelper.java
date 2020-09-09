package com.revature.revabooks.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestViewHelper {

	public String process(HttpServletRequest req){
		switch (req.getRequestURI()){
			case "/revabooks/login.view":
				return "partials/login.html";
			case "revabooks/register.view":

			default:
				return null;
		}
	}
}
