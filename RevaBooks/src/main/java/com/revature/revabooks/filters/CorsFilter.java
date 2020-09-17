package com.revature.revabooks.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class CorsFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		res.setHeader("Access-Control-Allow-Origin", "*"); // for dev purposes, specifying * is fine, but not for TODO production (http://localhost:4200)
		res.setHeader("Access-Control-Allow-Headers", "Content-type");
		chain.doFilter(req, res);
	}
}
