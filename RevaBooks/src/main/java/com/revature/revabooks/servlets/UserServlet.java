package com.revature.revabooks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	private UserService userService = new UserService(new UserRepository());

	/*
		doGet can be used to respond to requests for:
		-get all users
		-get a user by ikd
		-get a user by username
		-etc.

		determining which pf these you want to fo weill require that you parse the
		requestURI to see which operation should be performed:

			- GET request to /users = get al;l users
			- GET request to /users/id/1 = get the user with id 1
			- GET request to /users?username=aandsersonm = get the user with the username aanderson

	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Hi, tom!
		PrintWriter respWriter = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");

		System.out.println("Retrieving all users... ");
		Set<AppUser> users = userService.getAllUsers();
		String usersJSON = mapper.writeValueAsString(users);
		respWriter.write(usersJSON);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter respWriter = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("aaplication/json");

		try{

			InputStream reqBody = req.getInputStream();
			// tells Jackson how to map the req body.
			AppUser newUser = mapper.readValue(reqBody, AppUser.class);
			userService.register(newUser); //After this line, the user will have a role and id
			String registeredUser = mapper.writeValueAsString(newUser);
			respWriter.write(registeredUser);
			resp.setStatus(201); //created

		} catch(Exception e) {
		    e.printStackTrace();
		}
	}
}
