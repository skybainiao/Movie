package Shared.test;

import Shared.Model.Movie;
import Shared.Util.DBMovies;
import Shared.Util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class a {
    private DBUtil dbUtil;
    private DBMovies dbMovies;

    public a() throws SQLException {
        dbMovies=new DBMovies();
        dbUtil=new DBUtil();
    }

    public ArrayList<Movie> getMoviesFromDB(){
        Connection connection=null;

        try {
            connection= dbUtil.getConnection();
            ResultSet rs= dbMovies.getMovies(connection);
            ArrayList<Movie> allMovies=new ArrayList<>();

            while (rs.next()){
                String title=rs.getString("title");
                int id=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");

                Movie movie = new Movie(id,title,productionYear,productionCompany,averageReview,status);
                allMovies.add(movie);
            }
            return allMovies;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class test1{
    public static void main(String[] args) throws SQLException {
        a a=new a();
        System.out.println(a.getMoviesFromDB());
    }
}
