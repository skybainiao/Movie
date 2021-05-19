package Client.Model.Admin;

import Shared.Model.Movie;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AdminModel extends Remote {
    void addMovie(Movie movie) throws RemoteException;
    void removeMovie(int movieID) throws RemoteException, SQLException;
    ArrayList<Movie> getMovies() throws RemoteException, SQLException;
    void increase() throws RemoteException;
    int getId() throws RemoteException;
}
