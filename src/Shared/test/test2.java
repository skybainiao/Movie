package Shared.test;

import Shared.Model.User;
import Shared.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) throws Exception {
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getConnection();

       //User user=new User("CJJ","dsajiopp");

       //String sql="insert into system.SimpleUser(username,password)\n" +
       //        "values(?,?);";
       //PreparedStatement preparedStatement=connection.prepareStatement(sql);
       //preparedStatement.setString(1, user.getUsername());
       //preparedStatement.setString(2, user.getPassword());
       //preparedStatement.executeUpdate();

        String sql="select * from system.SimpleUser";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs= preparedStatement.executeQuery();
        ArrayList<User> users=new ArrayList<>();

        while (rs.next()){
            String username=rs.getString("username");
            String password=rs.getString("password");

            User user=new User(username,password);
            users.add(user);
        }

        System.out.println(users.size());
        System.out.println(users);




    }
}
