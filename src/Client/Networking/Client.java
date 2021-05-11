package Client.Networking;

import Shared.Model.User;
import Shared.Model.Movie;
import Shared.Model.Review;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface Client extends Remote {
    //client methods
    void addLikeMovies(Movie movie) throws RemoteException;
    void removeLikeMovies(Movie movie) throws RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException;
    void addBookMovies(Movie movie) throws RemoteException;
    void removeBookMovies(Movie movie) throws RemoteException;
    ArrayList<Movie> getBookMovies() throws RemoteException;
    void addWatchedMovie(Movie movie)throws RemoteException;
    void removeWatchedMovie(Movie movie) throws RemoteException;
    ArrayList<Movie> getWatchedMovies() throws RemoteException;
    void setUsername(String username) throws RemoteException;
    String getUsername() throws RemoteException;


    //server methods
    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws RemoteException;
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(Movie movie) throws RemoteException;
    ArrayList<Movie> getMovies() throws RemoteException;
    void addReview(Review review) throws RemoteException;
    void removeReview(Review review) throws RemoteException;
    ArrayList<Review> getReviews() throws RemoteException;
    void setAverageReview(String averageReview) throws RemoteException;
    void setProductionCompany(String productionCompany) throws RemoteException;
    void setProductionYear(String productionYear) throws RemoteException;
    void setStatus(String status) throws RemoteException;
    void setTitle(String title) throws RemoteException;
    int getId() throws RemoteException;
    String getTitle() throws RemoteException;
    String getAverageReview() throws RemoteException;
    String getProductionYear() throws RemoteException;
    String getProductionCompany() throws RemoteException;
    String getStatus() throws RemoteException;
    void increase() throws RemoteException;
    void setText(String text) throws RemoteException;
    void setStar(int star) throws RemoteException;
    int getStar() throws RemoteException;
    String getText() throws RemoteException;






}
