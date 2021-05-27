package Client.Model.Customer;

import Client.Networking.Client;
import Shared.Model.Movie;
import Shared.Model.Review;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerImpl implements CustomerModel{
    private Client client;


    public CustomerImpl(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    @Override
    public ArrayList<Movie> getSearchMovies(String searchText) throws SQLException, RemoteException {
        return client.getSearchMovies(searchText);
    }

    @Override
    public ArrayList<Movie> getWatchLater() throws SQLException, RemoteException {
        return client.getWatchLater();
    }

    @Override
    public void addWatchLater(String username, Movie movie) throws SQLException, RemoteException {
        client.addWatchLater(username,movie);
    }

    @Override
    public ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException {
        return client.getReviews(movie);
    }

    @Override
    public void addReview(Review review, String title) throws RemoteException, SQLException {
        client.addReview(review,title);
    }

    @Override
    public void dislikeIncrease(Movie movie) throws RemoteException, SQLException {
        client.dislikeIncrease(movie);
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
