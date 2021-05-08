package Client.Model.Customer;

import Shared.Movie;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CustomerModel {
    void addLikeMovies(Movie movie) throws RemoteException;
    void removeLikeMovies(Movie movie) throws RemoteException;
    ArrayList<Movie> getLikedMovies() throws RemoteException;
    void addBookMovies(Movie movie) throws RemoteException;
    void removeBookMovies(Movie movie) throws RemoteException;
    ArrayList<Movie> getBookMovies() throws RemoteException;
    void addWatchedMovie(Movie movie)throws RemoteException;
    void removeWatchedMovie(Movie movie) throws RemoteException;
    ArrayList<Movie> getWatchedMovies() throws RemoteException;
    ArrayList<Movie> getMovies() throws RemoteException;
    String getUsername() throws RemoteException;
}
