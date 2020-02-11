
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAC04
 */
public class Validate {
      public static boolean checkUser(String user,String pass){
        
        String url = "jdbc:oracle:thin:@10.1.67.153:1521:ORCL";
        boolean result = false;
        try{
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection conn = DriverManager.getConnection(url,"msc17pw13","msc17pw");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Users");
            
            while(rs.next()){
                if(user.equals(rs.getString("username")) && pass.equals(rs.getString("password"))){
                    result = true;
                }
            }
        } catch (SQLException ex) { 
              Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
          }
        return result;
    } 
}
