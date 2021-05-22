package Shared.test;

import Shared.Model.Movie;
import Shared.Model.User;
import Shared.Util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;

public class test2 {
    public static void main(String[] args) throws Exception {
        JDBC jdbc = new JDBC();
        //Movie movie=new Movie("title",0,"pdy","prdc","2.2","released","good");
        //jdbc.addMovie(movie);


        jdbc.getAllMovies();
        ResultSet rs= jdbc.getAllMovies();
        ArrayList<Movie> allMovies=new ArrayList<>();
        while (rs.next()){
            String title=rs.getString("title");
            int movieID=rs.getInt("movieID");
            String productionYear=rs.getString("productionYear");
            String productionCompany=rs.getString("productionCompany");
            String averageReview=rs.getString("averageReview");
            String status=rs.getString("status");
            String genre=rs.getString("genre");

            Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre,0,0);
            allMovies.add(movie);
        }

        for (int i = 0; i < allMovies.size(); i++) {
            System.out.println(allMovies.get(i).getTitle());
        }
    }
}

class test{
    public static void main(String[] args) {
        User user=new User("a","b");
        user.setUsername("chen");
        user.setPassword("dsajio");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
