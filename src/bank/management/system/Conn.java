package bank.management.system;
import java.sql.*;

public class Conn {
    
    Connection c ;
    Statement s;
    //create connection
    public Conn(){
        try{
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Abhishek@37");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
