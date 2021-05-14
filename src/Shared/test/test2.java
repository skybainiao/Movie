package Shared.test;

import Shared.Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class test2 {
    public static void main(String[] args) throws Exception {
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select version()";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString(1));
        }






    }
}
