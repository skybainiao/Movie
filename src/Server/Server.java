package Server;
import Shared.Model.User;
import Shared.Movie;
import Shared.Model.Review;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Server extends Remote {
    //Manage User
    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws RemoteException;

    //Manage Movie
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(Movie movie) throws RemoteException;
    ArrayList<Movie> getMovies() throws RemoteException;

    //Manage Review
    void addReview(Review review) throws RemoteException;
    void removeReview(Review review) throws RemoteException;
    ArrayList<Review> getReviews() throws RemoteException;

    //Methods of Movie
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

    //Methods of Review
    void setText(String text) throws RemoteException;
    void setStar(int star) throws RemoteException;
    int getStar() throws RemoteException;
    String getText() throws RemoteException;

}
