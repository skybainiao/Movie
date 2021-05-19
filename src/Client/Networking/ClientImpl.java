package Client.Networking;

import Server.Server;
import Shared.Model.Movie;
import Shared.Model.Review;
import Shared.Model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientImpl implements Client{
    private Server server;
    private User user;
    private ArrayList<Movie> likedMovies;
    private ArrayList<Movie> bookMovies;
    private ArrayList<Movie> watchedMovies;

    public ClientImpl() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 6666);
        server = (Server) registry.lookup("Server");
        user=new User("","");
        likedMovies=new ArrayList<>();
        bookMovies=new ArrayList<>();
        watchedMovies=new ArrayList<>();
    }

    @Override
    public void addLikeMovies(Movie movie) throws RemoteException {
        likedMovies.add(movie);
    }

    @Override
    public void removeLikeMovies(Movie movie) throws RemoteException {
        likedMovies.remove(movie);
    }

    @Override
    public ArrayList<Movie> getLikedMovies() throws RemoteException {
        return likedMovies;
    }

    @Override
    public void addBookMovies(Movie movie) throws RemoteException {
        bookMovies.add(movie);
    }

    @Override
    public void removeBookMovies(Movie movie) throws RemoteException {
        bookMovies.remove(movie);
    }

    @Override
    public ArrayList<Movie> getBookMovies() throws RemoteException {
        return bookMovies;
    }

    @Override
    public void addWatchedMovie(Movie movie) throws RemoteException {
        watchedMovies.add(movie);
    }

    @Override
    public void removeWatchedMovie(Movie movie) throws RemoteException {
        watchedMovies.remove(movie);
    }

    @Override
    public ArrayList<Movie> getWatchedMovies() throws RemoteException {
        return watchedMovies;
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
    public void addReview(Review review) throws RemoteException {
        server.addReview(review);
    }

    @Override
    public void removeReview(Review review) throws RemoteException {
        server.removeReview(review);
    }

    @Override
    public ArrayList<Review> getReviews() throws RemoteException {
        return server.getReviews();
    }

    @Override
    public void setAverageReview(String averageReview) throws RemoteException {
        server.setAverageReview(averageReview);
    }

    @Override
    public void setProductionCompany(String productionCompany) throws RemoteException {
        server.setProductionCompany(productionCompany);
    }

    @Override
    public void setProductionYear(String productionYear) throws RemoteException {
        server.setProductionYear(productionYear);
    }

    @Override
    public void setStatus(String status) throws RemoteException {
        server.setStatus(status);
    }

    @Override
    public void setTitle(String title) throws RemoteException {
        server.setTitle(title);
    }

    @Override
    public int getId() throws RemoteException {
        return server.getId();
    }

    @Override
    public String getTitle() throws RemoteException {
        return server.getTitle();
    }

    @Override
    public String getAverageReview() throws RemoteException {
        return server.getAverageReview();
    }

    @Override
    public String getProductionYear() throws RemoteException {
        return server.getProductionYear();
    }

    @Override
    public String getProductionCompany() throws RemoteException {
        return server.getProductionCompany();
    }

    @Override
    public String getStatus() throws RemoteException {
        return server.getStatus();
    }

    @Override
    public void increase() throws RemoteException {
        server.increase();
    }

    @Override
    public void setText(String text) throws RemoteException {
        server.setText(text);
    }

    @Override
    public void setStar(int star) throws RemoteException {
        server.setStar(star);
    }

    @Override
    public int getStar() throws RemoteException {
        return server.getStar();
    }

    @Override
    public String getText() throws RemoteException {
        return server.getText();
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
        System.out.println(server.getUsers());
        return server.getUsers();
    }
}
