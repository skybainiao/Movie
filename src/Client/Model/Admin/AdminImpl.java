package Client.Model.Admin;

import Client.Networking.Client;
import Shared.Model.Movie;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AdminImpl implements AdminModel{
    private Client client;
    public AdminImpl(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    @Override
    public void addMovie(Movie movie) throws RemoteException {
        client.addMovie(movie);
    }

    @Override
    public void removeMovie(Movie movie) throws RemoteException {
        client.removeMovie(movie);
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException {
        return client.getMovies();
    }

    @Override
    public void increase() throws RemoteException {
        client.increase();
    }

    @Override
    public int getId() throws RemoteException {
        return client.getId();
    }

}
