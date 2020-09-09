package com.revature.revabooks.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.revature.revabooks.dtos.ErrorResponse;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourceNotFoundException;
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
import java.util.Enumeration;
import java.util.Set;

//will respond to /users and anything else that may come after it,
@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        System.out.println(req.getRequestURI());
        System.out.println(req.getParameter("id"));

        Enumeration<String> paramNames = req.getHeaderNames();
        while (req.getParameterNames().hasMoreElements()){
            String paramValue = req.getParameter(paramNames.nextElement());
            System.out.println(paramValue);
        }

        try {
            String idParam = req.getParameter("id");
            if (idParam != null){

                int id = Integer.parseInt(idParam);
                AppUser user = userService.getUserById(id);
                String userJSON = mapper.writeValueAsString(user);
                writer.write(userJSON);
                resp.setStatus(200);

            } else {
                Set<AppUser> users = userService.getAllUsers();
                String usersJSON = mapper.writeValueAsString(users);
                writer.write(usersJSON);
                resp.setStatus(200); //not required will be 200 by default
            }

        } catch (ResourceNotFoundException rnfe){
            resp.setStatus(404);

            ErrorResponse err = new ErrorResponse(404,rnfe.getMessage());

            writer.write(mapper.writeValueAsString(err));

        } catch (NumberFormatException | InvalidRequestException nfe){

            resp.setStatus(400);
            ErrorResponse err = new ErrorResponse(404, "Malformed user id");

            writer.write(mapper.writeValueAsString(err));

        } catch (Exception e){
            e.printStackTrace();
            resp.setStatus(500); //500 = internal server error

            ErrorResponse err = new ErrorResponse(500,"server: my bad.");
            writer.write(mapper.writeValueAsString(err));

        }


    }

    /**
     * getting the do post method
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
            //read BODY OF REQUEST
            //create new appuser from the json request
            AppUser newUser = mapper.readValue(req.getInputStream(),AppUser.class);
            userService.register(newUser);
            System.out.println(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            respWriter.write(newUserJSON);
            resp.setStatus(201); // 201 = created

        }catch (MismatchedInputException upe) {
            upe.printStackTrace();
            resp.setStatus(400);

            ErrorResponse err = new ErrorResponse(400,"Bad Request: malformed user object found in request body");

            respWriter.write(mapper.writeValueAsString(err));

        }catch (Exception e){
            e.printStackTrace();
            resp.setStatus(500); //500 = internal server error

            ErrorResponse err = new ErrorResponse(500,"server: my bad.");
            respWriter.write(mapper.writeValueAsString(err));

        }
    }
}
