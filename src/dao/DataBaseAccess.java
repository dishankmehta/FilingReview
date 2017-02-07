package dao;

import model.UserRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by trainees on 1/31/2017.
 */
public class DataBaseAccess {

    public DataBaseAccess(){

    }

    private Connection makeConnection(){
        Connection conn = null;
        System.out.println("Making Database Connection...!!!");
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filing_review","root","");

            if (conn != null){
                System.out.println("DataBase Connected...!!!");
            }else {
                System.out.println("Failed to make Connection...!!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public boolean checkUser(String userName, String password){

        Connection conn = makeConnection();

        PreparedStatement ps;

        System.out.println("Going into database..!!");

        String stmt = "SELECT * FROM `user_data` WHERE (email=? OR userName=?) AND password=?";

        try {

            ps = conn.prepareStatement(stmt);

            ps.setString(1,userName);
            ps.setString(2,userName);
            ps.setString(3,password);

            ResultSet rs = ps.executeQuery();

            //System.out.println(rs.getString(0)+"<---------->"+rs.getString(1));
            if(rs.next()){
                return true;
            }


        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void insertData(UserRegister ur){
        Connection conn = makeConnection();

        PreparedStatement ps;

        String stmt = "INSERT INTO `user_data`(`firstName`, `lastName`, `gender`, `contact`, `userName`, `email`, `password`) VALUES (?,?,?,?,?,?,?)";

        try {

            ps = conn.prepareStatement(stmt);
            ps.setString(1, ur.getFirstName());
            ps.setString(2, ur.getLastName());
            ps.setString(3, ur.getGender());
            ps.setString(4, ur.getContact());
            ps.setString(5, ur.getUserName());
            ps.setString(6, ur.getEmail());
            ps.setString(7, ur.getPassword());

            ps.executeUpdate();

            conn.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
