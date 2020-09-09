package com.revature.revabooks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.revabooks.dtos.Credentials;
import com.revature.revabooks.dtos.ErrorResponse;
import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.models.AppUser;
import com.revature.revabooks.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();
        resp.setContentType("application/json");

        try {
            //USE JACSON TO READ THE REQUEST BODY AND MAP TO POJO
            Credentials creds = mapper.readValue(req.getInputStream(),Credentials.class);

            AppUser authUser = userService.authenticate(creds.getUsername(),creds.getPassword());

            HttpSession session = req.getSession();

            session.setAttribute("auth-user",authUser);
            session.setAttribute("user-role",authUser.getRole());
            resp.setStatus(204);

        } catch (MismatchedInputException | InvalidRequestException upe) {
            upe.printStackTrace();
            resp.setStatus(400);

            ErrorResponse err = new ErrorResponse(400,"Bad Request: malformed credentials object provided");

            respWriter.write(mapper.writeValueAsString(err));

        } catch (AuthenticationException ae){
            ae.printStackTrace();
            resp.setStatus(401); //500 = internal server error

            ErrorResponse err = new ErrorResponse(401,ae.getMessage());
            respWriter.write(mapper.writeValueAsString(err));
        }
        catch (Exception e){
            e.printStackTrace();
            resp.setStatus(500); //500 = internal server error

            ErrorResponse err = new ErrorResponse(500,"server: my bad.");
            respWriter.write(mapper.writeValueAsString(err));

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getSession().getAttribute("auth-user"));
        req.getSession().invalidate();
        resp.setStatus(204);

    }
}
