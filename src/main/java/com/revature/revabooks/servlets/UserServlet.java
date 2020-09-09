package com.revature.revabooks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.revabooks.dtos.ErrorResponse;
import com.revature.revabooks.dtos.Principal;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourceNotFoundException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();
        resp.setContentType("application/json");

        String principalJSON = (String)req.getSession().getAttribute("principal");
        Principal principal = mapper.readValue(principalJSON, Principal.class);

        if (principal == null) {
            ErrorResponse err = new ErrorResponse(401, "No principal Object found");
            respWriter.write(mapper.writeValueAsString(err));
            resp.setStatus(401);
            return; // necesary to skip the rest, cleaner than else brackets
        }

        if (!principal.getRole().equalsIgnoreCase("Admin")){
            ErrorResponse err = new ErrorResponse(403,"Not permited");
            respWriter.write(mapper.writeValueAsString(err));
            resp.setStatus(403);
            return;

        }

        try {

            String idParam = req.getParameter("id");

            if (idParam != null) {

                int id = Integer.parseInt(idParam);
                AppUser user = userService.getUserById(id);
                String userJSON = mapper.writeValueAsString(user);
                respWriter.write(userJSON);

            } else {

                Set<AppUser> users = userService.getAllUsers();
                String usersJSON = mapper.writeValueAsString(users);
                respWriter.write(usersJSON);
                resp.setStatus(200); // not required, 200 by default so long as no exceptions/errors are thrown

            }
        } catch (ResourceNotFoundException rnfe) {

            resp.setStatus(404);
            ErrorResponse err = new ErrorResponse(404, rnfe.getMessage());
            respWriter.write(mapper.writeValueAsString(err));

        } catch (NumberFormatException | InvalidRequestException e) {

            resp.setStatus(400);
            ErrorResponse err = new ErrorResponse(400, "Malformed user id parameter value provided.");
            String errJSON = mapper.writeValueAsString(err);
            respWriter.write(errJSON);

        }  catch (Exception e) {

            e.printStackTrace();
            resp.setStatus(500); // 500 = INTERNAL SERVER ERROR
            ErrorResponse err = new ErrorResponse(500, "It's not you, it's us. Our bad...");
            respWriter.write(mapper.writeValueAsString(err));

        }
    }

    /**
     * Used to handle incoming requests to register new users for the application.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();

        try {

            AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class);
            userService.register(newUser);
            System.out.println(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            respWriter.write(newUserJSON);
            resp.setStatus(201); // 201 = CREATED

        } catch (MismatchedInputException mie) {

            resp.setStatus(400); // 400 = BAD REQUEST
            ErrorResponse err = new ErrorResponse(400, "Bad Request: Malformed user object found in request body");
            String errJSON = mapper.writeValueAsString(err);
            respWriter.write(errJSON);

        } catch (Exception e) {

            e.printStackTrace();
            resp.setStatus(500); // 500 = INTERNAL SERVER ERROR
            ErrorResponse err = new ErrorResponse(500, "It's not you, it's us. Our bad...");
            respWriter.write(mapper.writeValueAsString(err));

        }

    }
}