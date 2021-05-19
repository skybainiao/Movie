package Shared.Util;

import Shared.Model.Movie;
import Shared.Model.User;

import java.sql.*;

public class JDBC {
    private static String driver = "org.postgresql.Driver";
    private static String url ="jdbc:postgresql://localhost:5432/Company";
    private static String user = "postgres";
    private static String password = "cjj2468830035";
    private Connection connection;

    public JDBC()throws Exception{
        Class.forName(driver);
        connection = DriverManager.getConnection(url,user,password);
        System.out.println("already connected to "+connection);
    }


    public void closeConnection() throws SQLException {
        if (connection!=null){
            connection.close();
        }
    }


    public int addUser(User user) throws SQLException {
        String sql="insert into system.SimpleUser(username,password)\n" + "values(?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        return preparedStatement.executeUpdate();
    }


    public ResultSet getAllUsers() throws SQLException {
        String sql="select username,password from system.SimpleUser";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        return preparedStatement.executeQuery();
    }

    public int addMovie(Movie movie) throws SQLException {
        String sql="insert into system.Movie(title, movieID, productionYear, productionCompany, averageReview, status,genre)\n" + "values(?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1, movie.getTitle());
        preparedStatement.setInt(2,movie.getId());
        preparedStatement.setString(3, movie.getProductionYear());
        preparedStatement.setString(4,movie.getProductionCompany());
        preparedStatement.setString(5,movie.getAverageReview());
        preparedStatement.setString(6, movie.getStatus());
        preparedStatement.setString(7, movie.getGenre());

        return preparedStatement.executeUpdate();
    }

    public void removeMovie(int movieID) throws SQLException {
        String sql="delete from system.Movie where movieID=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,movieID);
        preparedStatement.executeUpdate();
    }

    public ResultSet getAllMovies() throws SQLException {
        String sql="select * from system.Movie";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        return preparedStatement.executeQuery();
    }


}
