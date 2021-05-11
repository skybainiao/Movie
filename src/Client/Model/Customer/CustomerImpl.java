package Client.Model.Customer;

import Client.Networking.Client;
import Shared.Model.Movie;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CustomerImpl implements CustomerModel{
    private Client client;
    public CustomerImpl(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }


    @Override
    public void addLikeMovies(Movie movie) throws RemoteException {
        client.addLikeMovies(movie);
    }

    @Override
    public void removeLikeMovies(Movie movie) throws RemoteException {
        client.removeLikeMovies(movie);
    }

    @Override
    public ArrayList<Movie> getLikedMovies() throws RemoteException {
        return client.getLikedMovies();
    }

    @Override
    public void addBookMovies(Movie movie) throws RemoteException {
        client.addBookMovies(movie);
    }

    @Override
    public void removeBookMovies(Movie movie) throws RemoteException {
        client.removeBookMovies(movie);
    }

    @Override
    public ArrayList<Movie> getBookMovies() throws RemoteException {
        return client.getBookMovies();
    }

    @Override
    public void addWatchedMovie(Movie movie) throws RemoteException {
        client.addWatchedMovie(movie);
    }

    @Override
    public void removeWatchedMovie(Movie movie) throws RemoteException {
        client.removeWatchedMovie(movie);
    }

    @Override
    public ArrayList<Movie> getWatchedMovies() throws RemoteException {
        return client.getWatchedMovies();
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        return client.getMovies();
    }

    @Override
    public String getUsername() throws RemoteException {
        return client.getUsername();
    }
}
