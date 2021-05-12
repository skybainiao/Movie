package Shared.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

        private static String driver = "org.postgresql.Driver";
        private static String url ="jdbc:postgresql://localhost:5432/postgres";
        private static String user = "postgres";
        private static String password = "cjj2468830035";

        static {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.err.println("Error");
                e.printStackTrace();
            }
        }

        public Connection getConnection() throws Exception{
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, user, password);
                System.out.println("connection succeeded");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            };

            return con;
        }


}
