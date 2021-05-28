package Client.Model.Customer;

import Shared.Model.Movie;
import Shared.Model.Review;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerModel{
    String getUrlOfUser() throws SQLException, RemoteException;
    void addUrl(String url) throws SQLException,RemoteException;
    ArrayList<Movie> getSearchMovies(String searchText) throws SQLException,RemoteException;
    ArrayList<Movie> getWatchLater() throws SQLException, RemoteException;
    void addWatchLater(String username,Movie movie) throws SQLException, RemoteException;
    ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException;
    void addReview(Review review, String title) throws RemoteException, SQLException;
    void dislikeIncrease(Movie movie) throws RemoteException, SQLException;
    Movie getMovie(Movie movie) throws SQLException, RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    String getUsername() throws RemoteException;
    String getClientName() throws RemoteException;
}
