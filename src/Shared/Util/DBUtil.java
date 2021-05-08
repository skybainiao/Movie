package Shared.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
    private String dbUrl="jdbc:postgresql://localhost:5432/company";
    //?user=postgres&password=cjj2468830035&ssl=true
    Properties props = new Properties();
    private String dbUserName="postgres";
    private String dbPassword="stq20000409";

    public Connection getCon()throws Exception{
        props.setProperty("user","postgres");
        props.setProperty("password","cjj2468830035");
        props.setProperty("ssl","true");
        Connection coon = DriverManager.getConnection(dbUrl,props);
       // Connection con= DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        return coon;
    }

    public void closeCon(Connection con)throws Exception{
        if(con!=null) {
            con.close();
        }
    }
}
