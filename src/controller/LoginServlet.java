package controller;

import dao.DataBaseAccess;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by trainees on 1/31/2017.
 */
public class LoginServlet extends HttpServlet {

    private String userName;
    private String password;
    private Boolean isRegistered;

    @Override
    public void init() throws ServletException {
        userName = null;
        password = null;
        isRegistered = false;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();

        System.out.println("Checking the User..!!");

        try {

            BufferedReader br = request.getReader();
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }

            JSONParser jparser = new JSONParser();
            JSONObject jobj = null;

            jobj = (JSONObject) jparser.parse(sb.toString());

            userName = (String) jobj.get("userName");
            password = (String) jobj.get("password");

            System.out.println(userName+"<---------->"+password);

            DataBaseAccess dataBaseAccess = new DataBaseAccess();

            isRegistered = dataBaseAccess.checkUser(userName,password);

            if(isRegistered){
                response.sendRedirect("mainPanel.html");
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.html");
                rd.include(request,response);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
