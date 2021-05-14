package Shared.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMovies {

    public ResultSet getMovies(Connection connection) throws SQLException {
        String sql="select title from Movie";

        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet resultSet= ps.getResultSet();
        return resultSet;
    }


}
