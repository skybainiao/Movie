package Client.Model.Customer;

import Client.Networking.Client;
import Shared.Model.Movie;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerImpl implements CustomerModel{
    private Client client;
    private int like;
    public CustomerImpl(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getLike() {
        return like;
    }

    public void increase(){
        like++;
    }

    @Override
    public Movie getMovie(Movie movie) throws SQLException, RemoteException {
        return client.getMovie(movie);
    }

    @Override
    public void likeIncrease(Movie movie) throws SQLException, RemoteException {
        client.likeIncrease(movie);
    }

    @Override
    public void addLikeMovie(String username, String movieName) throws SQLException, RemoteException {
        client.addLikeMovie(username, movieName);
    }

    @Override
    public void removeLikeMovies(Movie movie) throws RemoteException {
        client.removeLikeMovies(movie);
    }

    @Override
    public ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException {
        return client.getLikedMovies();
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException, SQLException {
        return client.getMovies();
    }

    @Override
    public String getUsername() throws RemoteException {
        return client.getUsername();
    }

    @Override
    public String getClientName() throws RemoteException {
        return client.getClientName();
    }
}
