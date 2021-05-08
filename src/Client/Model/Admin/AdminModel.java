package Client.Model.Admin;

import Shared.Movie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AdminModel extends Remote {
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(Movie movie) throws RemoteException;
    ArrayList<Movie> getMovies() throws RemoteException;
    void increase() throws RemoteException;
    int getId() throws RemoteException;
}
