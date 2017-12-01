package conie;

import java.sql.*;

public class conDB {
     Connection con;
        Statement st;
    public conDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3307/proyecto","root","usbw");
            st= con.createStatement();
        }catch (Exception error) {
            System.out.println("Error "+error);
        }
    }
    public void ModificaBD(String sql){
        try{
            st.executeUpdate(sql);
        } catch (Exception error) {
            System.out.println("Error "+error);
        }
    }
     public ResultSet consultaBD(String sql){
         ResultSet rs= null;
    try{
        rs=st.executeQuery(sql);
    
    } catch (Exception error) {
            System.out.println("Error "+error);
        }
        return rs;
    }
}