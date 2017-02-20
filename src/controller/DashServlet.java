package controller;

import dao.DataBaseAccess;
import model.FileModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by trainees on 2/17/2017.
 */
public class DashServlet extends HttpServlet {

    private String email;

    @Override
    public void init() throws ServletException {
        email = null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();

        System.out.println("Fetching email...!!");

        try{

            BufferedReader br = request.getReader();
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line);
            }

            JSONParser jparser = new JSONParser();
            JSONObject jobj = null;

            jobj = (JSONObject) jparser.parse(sb.toString());

            email = (String) jobj.get("email");

            System.out.println("------>>>>>"+email);

            DataBaseAccess dataBaseAccess = new DataBaseAccess();
            ArrayList<FileModel> files = dataBaseAccess.fetchFiles(email);

            System.out.println(files.get(0).getFileName());

            JSONArray jsonArray = new JSONArray();

            for(FileModel fm: files){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("fileName",fm.getFileName());
                jsonObject.put("file",fm.getFileInputStream());
                jsonArray.add(jsonObject);
            }
            System.out.println("Data Fetched........!!!");
            response.getWriter().print(jsonArray);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
