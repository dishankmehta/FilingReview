package controller;

import dao.DataBaseAccess;
import model.UserRegister;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by trainees on 1/31/2017.
 */
public class RegisterServlet extends HttpServlet {

    private String firstName;
    private String lastName;
    private String gender;
    private String contact;
    private String userName;
    private String email;
    private String password;


    @Override
    public void init() throws ServletException {
        firstName = null;
        lastName = null;
        gender = null;
        contact = null;
        userName = null;
        email = null;
        password = null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();

        System.out.println("Entering Data...!!!");

        try{
            BufferedReader br = request.getReader();
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }

            JSONParser jparser = new JSONParser();
            JSONObject jobj = null;

            jobj = (JSONObject) jparser.parse(sb.toString());

            firstName = (String) jobj.get("firstName");
            lastName = (String) jobj.get("lastName");
            gender = (String) jobj.get("gender");
            contact = (String) jobj.get("contact");
            userName = (String) jobj.get("userName");
            email = (String) jobj.get("email");
            password = (String) jobj.get("password");

            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(gender);
            System.out.println(contact);
            System.out.println(userName);
            System.out.println(email);
            System.out.println(password);

            UserRegister ur = new UserRegister();
            ur.setFirstName(firstName);
            ur.setLastName(lastName);
            ur.setGender(gender);
            ur.setContact(contact);
            ur.setUserName(userName);
            ur.setEmail(email);
            ur.setPassword(password);

            DataBaseAccess dataBaseAccess = new DataBaseAccess();
            dataBaseAccess.insertData(ur);
            System.out.println("Data inserted...!!!");

        }catch(Exception e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
