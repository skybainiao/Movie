package Client.Networking;

import Server.Server;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientImpl implements Client {
    private String name;
    private Server server;
    private User user;
    private PropertyChangeSupport support;

    public ClientImpl(String name) throws RemoteException, NotBoundException {
        this.name=name;
        support=new PropertyChangeSupport(this);
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 6666);
        server = (Server) registry.lookup("Server");
        user=new User("","");
    }

    @Override
    public void setClientName(String name) throws RemoteException{
        this.name = name;
    }

    @Override
    public void addLikeMovie(String username, String movieName) throws SQLException, RemoteException {
        server.addLikeMovie(username,movieName);
    }

    @Override
    public String getClientName() throws RemoteException {
        return name;
    }

    @Override
    public String getUrlOfUser() throws SQLException, RemoteException {
        return server.getUrlOfUser(getClientName());
    }

    @Override
    public void addUrl(String url) throws SQLException, RemoteException {
        server.addUrl(url,getClientName());
    }

    @Override
    public ArrayList<Movie> getSearchMovies(String searchText) throws SQLException, RemoteException {
        return server.getSearchMovies(searchText);
    }

    @Override
    public ArrayList<Movie> getWatchLater() throws SQLException, RemoteException {
        return server.getWatchLater(getClientName());
    }

    @Override
    public void addWatchLater(String username, Movie movie) throws SQLException, RemoteException {
        server.addWatchLater(username,movie);
    }

    @Override
    public void dislikeIncrease(Movie movie) throws RemoteException, SQLException {
        server.dislikeIncrease(movie);
    }

    @Override
    public Movie getMovie(Movie movie) throws SQLException, RemoteException {
        return server.getMovie(movie);
    }

    @Override
    public void likeIncrease(Movie movie) throws SQLException, RemoteException {
        server.likeIncrease(movie);
    }

    @Override
    public ArrayList<Movie> getLikedMovies() throws RemoteException, SQLException {
        return server.getLikedMovies(getClientName());
    }


    @Override
    public void addMovie(Movie movie) throws RemoteException {
        server.addMovie(movie);
    }

    @Override
    public void removeMovie(int movieID) throws RemoteException, SQLException {
        server.removeMovie(movieID);
    }

    @Override
    public ArrayList<Movie> getMovies() throws RemoteException, SQLException {
        return server.getMovies();
    }

    @Override
    public void addReview(Review review, String title) throws RemoteException, SQLException {
        server.addReview(review,title);
    }


    @Override
    public ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException {
        return server.getReviews(movie);
    }


    @Override
    public int getId() throws RemoteException {
        return server.getId();
    }

    @Override
    public void increase() throws RemoteException {
        server.increase();
    }


    @Override
    public void setUsername(String username) throws RemoteException {
        user.setUsername(username);
    }

    @Override
    public String getUsername() throws RemoteException {
        return user.getUsername();
    }

    @Override
    public void addUser(User user) throws RemoteException {
        server.addUser(user);
    }

    @Override
    public ArrayList<User> getUsers() throws Exception {
        return server.getUsers();
    }

    @Override
    public void addPCL(String name, PropertyChangeListener listener) throws RemoteException{
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removePCL(String name, PropertyChangeListener listener) throws RemoteException{
        support.removePropertyChangeListener(name, listener);
    }
}
