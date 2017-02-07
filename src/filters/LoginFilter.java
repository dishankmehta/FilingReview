package filters;

import dao.DataBaseAccess;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by trainees on 1/31/2017.
 */
public class LoginFilter implements Filter {

    private String userName;
    private String password;
    private Boolean isRegistered;

    public LoginFilter(){
        userName = null;
        password = null;
        isRegistered = false;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();

        System.out.println("Checking the User..!!");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        BufferedReader br = request.getReader();
        String line = null;

        try {


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
            System.out.println(isRegistered);

            HttpSession session = request.getSession();
            session.setAttribute("validity",isRegistered);
            if(isRegistered){
                chain.doFilter(req, resp);
            }else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.html");
                requestDispatcher.forward(request,response);
                System.out.println("Redirecting to index...!!!");
                return;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
