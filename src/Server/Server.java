package Server;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Server extends Remote {
    //Manage User
    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws Exception;

    //Manage Movie
    Movie getMovie(Movie movie) throws SQLException,RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void dislikeIncrease() throws RemoteException;
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(int movieID) throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    ArrayList<Movie> getLikedMovies(String username) throws RemoteException, SQLException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;

    //Manage Review
    void addReview(Review review) throws RemoteException;
    void removeReview(Review review) throws RemoteException;
    ArrayList<Review> getReviews() throws RemoteException;


    int getId() throws RemoteException;
    void increase() throws RemoteException;




}
