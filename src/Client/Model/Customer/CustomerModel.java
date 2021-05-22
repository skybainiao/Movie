package Client.Model.Customer;

import Shared.Model.Movie;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerModel {
    void setLike(int like);
    int getLike();
    void increase();
    Movie getMovie(Movie movie) throws SQLException, RemoteException;
    void likeIncrease(Movie movie) throws SQLException, RemoteException;
    void addLikeMovie(String username,String movieName) throws SQLException,RemoteException;
    void removeLikeMovies(Movie movie) throws RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    String getUsername() throws RemoteException;
    String getClientName() throws RemoteException;
}
