package Server;

import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;
import Shared.Util.JDBC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerImpl implements Server{
    private Movie movie;
    private Review review;
    private ArrayList<Review> reviewList;
    private JDBC jdbc;
    public ServerImpl() throws Exception {
        UnicastRemoteObject.exportObject(this,6666);
        this.jdbc=new JDBC();
        reviewList=new ArrayList<>();
        movie=new Movie("",0,"","","","","");
        review=new Review("",0,"");
    }


    @Override
    public void addUser(User user) throws RemoteException {
        try {
            jdbc.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getUsers() throws RemoteException, SQLException {
        ResultSet rs = jdbc.getAllUsers();
        ArrayList<User> userList =new ArrayList<>();

        try{
            while(rs.next()){
                userList.add(new User(rs.getString("username"),rs.getString("password")));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addMovie(Movie movie) throws RemoteException {
        try {
            jdbc.addMovie(movie);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void removeMovie(int movieID) throws RemoteException, SQLException {
        jdbc.removeMovie(movieID);
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException, SQLException {
        ResultSet rs = jdbc.getAllMovies();
        ArrayList<Movie> allMovies = new ArrayList<>();

        try {
            while (rs.next()){
                String title=rs.getString("title");
                int movieID=rs.getInt("movieID");
                String productionYear=rs.getString("productionYear");
                String productionCompany=rs.getString("productionCompany");
                String averageReview=rs.getString("averageReview");
                String status=rs.getString("status");
                String genre=rs.getString("genre");

                Movie movie=new Movie(title,movieID,productionYear,productionCompany,averageReview,status,genre);
                allMovies.add(movie);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allMovies;
    }

    @Override
    public void addReview(Review review) throws RemoteException {
        reviewList.add(review);
    }

    @Override
    public void removeReview(Review review) throws RemoteException {
        reviewList.remove(review);
    }

    @Override
    public ArrayList<Review> getReviews() throws RemoteException {
        return reviewList;
    }

    @Override
    public void setAverageReview(String averageReview) throws RemoteException {
        movie.setAverageReview(averageReview);
    }

    @Override
    public void setProductionCompany(String productionCompany) throws RemoteException{
        movie.setProductionCompany(productionCompany);
    }

    @Override
    public void setProductionYear(String productionYear) throws RemoteException {
        movie.setProductionYear(productionYear);
    }

    @Override
    public void setStatus(String status) throws RemoteException {
        movie.setStatus(status);
    }

    @Override
    public void setTitle(String title) throws RemoteException {
        movie.setTitle(title);
    }

    @Override
    public int getId() throws RemoteException {
        return movie.getId();
    }

    @Override
    public String getTitle() throws RemoteException {
        return movie.getTitle();
    }

    @Override
    public String getAverageReview() throws RemoteException {
        return movie.getAverageReview();
    }

    @Override
    public String getProductionYear() throws RemoteException {
        return movie.getProductionYear();
    }

    @Override
    public String getProductionCompany() throws RemoteException {
        return movie.getProductionCompany();
    }

    @Override
    public String getStatus() throws RemoteException {
        return movie.getStatus();
    }

    @Override
    public void increase() throws RemoteException {
        movie.increase();
    }

    @Override
    public void setText(String text) throws RemoteException {
        review.setText(text);
    }

    @Override
    public void setStar(int star) throws RemoteException {
        review.setStar(star);
    }

    @Override
    public int getStar() throws RemoteException {
        return review.getStar();
    }

    @Override
    public String getText() throws RemoteException {
        return review.getText();
    }


}
