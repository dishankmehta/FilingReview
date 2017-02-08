package controller;

import dao.DataBaseAccess;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by trainees on 1/31/2017.
 */
public class LoginServlet extends HttpServlet {

    private boolean isUserValid;

    public LoginServlet(){
        isUserValid = false;
    }

    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        isUserValid = (boolean)request.getAttribute("validity");
        System.out.println(isUserValid);
        response.getWriter().print(isUserValid);
        System.out.println(""+request.getRequestURL());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
