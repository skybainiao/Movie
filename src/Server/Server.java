package Server;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Server extends Remote{
    //Manage User
    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws Exception;

    //Manage Movie
    String getUrlOfUser(String username) throws SQLException,RemoteException;
    void addUrl(String url,String username) throws SQLException,RemoteException;
    ArrayList<Movie> getSearchMovies(String searchText) throws SQLException,RemoteException;
    ArrayList<Movie> getWatchLater(String username) throws SQLException,RemoteException;
    void addWatchLater(String username,Movie movie) throws SQLException,RemoteException;
    Movie getMovie(Movie movie) throws SQLException,RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void dislikeIncrease(Movie movie) throws RemoteException, SQLException;
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(int movieID) throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    ArrayList<Movie> getLikedMovies(String username) throws RemoteException, SQLException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;

    //Manage Review
    void addReview(Review review,String title) throws RemoteException, SQLException;
    ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException;


    int getId() throws RemoteException;
    void increase() throws RemoteException;




}
