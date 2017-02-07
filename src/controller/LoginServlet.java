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



    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isUserValid = (boolean)session.getAttribute("validity");
        if (isUserValid){
            System.out.println("--------->"+isUserValid);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mainPanel.html");
            requestDispatcher.forward(request,response);
            System.out.println("--------->>>After dispatch");
            /*response.sendRedirect("mainPanel.html");
            return;*/
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
