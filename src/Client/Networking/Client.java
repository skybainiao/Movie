package Client.Networking;

import Shared.Model.User;
import Shared.Model.Movie;
import Shared.Model.Review;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


public interface Client extends Remote {
    //client methods
    void setClientName(String name) throws RemoteException;
    String getClientName() throws RemoteException;

    Movie getMovie(Movie movie) throws SQLException, RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException;
    void addLikeMovies(Movie movie) throws RemoteException;
    void removeLikeMovies(Movie movie) throws RemoteException;
    void setUsername(String username) throws RemoteException;
    String getUsername() throws RemoteException;

    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws Exception;
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(int movieID) throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    void addReview(Review review) throws RemoteException;
    void removeReview(Review review) throws RemoteException;
    ArrayList<Review> getReviews() throws RemoteException;
    int getId() throws RemoteException;
    void increase() throws RemoteException;


}
