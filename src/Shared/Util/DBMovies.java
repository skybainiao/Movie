package Shared.Util;

import Shared.Model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBMovies {
    public int sendMessage(Connection connection, Movie movie) throws SQLException {
        String sql="insert into message value(null,?,?,?,?)";

        PreparedStatement pstmt=connection.prepareStatement(sql);
        pstmt.setInt(1, movie.getId());
        pstmt.setString(2, movie.getTitle());
        pstmt.setString(3, movie.getProductionYear());
        pstmt.setString(4, movie.getProductionCompany());
        pstmt.setString(5, movie.getAverageReview());
        pstmt.setString(6, movie.getStatus());

        return pstmt.executeUpdate();
    }
}
