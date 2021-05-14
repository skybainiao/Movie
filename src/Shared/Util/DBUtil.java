package Shared.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

        private static String driver = "org.postgresql.Driver";
        private static String url ="jdbc:postgresql://localhost:5432/Company";
        private static String user = "postgres";
        private static String password = "cjj2468830035";

    public Connection getConnection()throws Exception{
        Class.forName(driver);
        Connection con= DriverManager.getConnection(url,user,password);
        System.out.println("connection succeeded "+con);
        return con;
    }


    public void closeConnection(Connection connection) throws SQLException {
        if (connection!=null){
            connection.close();
        }
    }


}
