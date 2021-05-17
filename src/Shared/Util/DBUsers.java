package Shared.Util;

import Shared.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUsers {

    public int addUser(Connection connection, User user) throws SQLException {
        String sql="insert into system.SimpleUser(username,password)\n" +
                "values(?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        return preparedStatement.executeUpdate();
    }

    public ResultSet getAllUsers(Connection connection) throws SQLException {
        String sql="select * from system.SimpleUser";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs= preparedStatement.executeQuery();

        return rs;

    }
}
