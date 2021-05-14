package Shared.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMovies {

    public ResultSet getMovies(Connection connection) throws SQLException {
        String sql="select productionCompany from Movie where title='Jason Bourne';";

        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet resultSet= ps.getResultSet();
        return resultSet;
    }


}
