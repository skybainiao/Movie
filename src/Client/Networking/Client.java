package Client.Networking;

import Server.PCS;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface Client extends Remote, PCS {
    //client methods
    void setClientName(String name) throws RemoteException;
    String getClientName() throws RemoteException;

    ArrayList<Movie> getSearchMovies(String searchText) throws SQLException,RemoteException;
    ArrayList<Movie> getWatchLater() throws SQLException, RemoteException;
    void addWatchLater(String username,Movie movie) throws SQLException, RemoteException;
    void dislikeIncrease(Movie movie) throws RemoteException, SQLException;
    Movie getMovie(Movie movie) throws SQLException, RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException;
    void setUsername(String username) throws RemoteException;
    String getUsername() throws RemoteException;

    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws Exception;
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(int movieID) throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    void addReview(Review review,String title) throws RemoteException, SQLException;
    ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException;
    int getId() throws RemoteException;
    void increase() throws RemoteException;


}
