package Client.ViewModel;

import Client.Model.Customer.CustomerModel;
import Shared.Model.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class homepageVM {
    private CustomerModel model;
    private StringProperty logout;

    public homepageVM(CustomerModel model){
        this.model=model;
        logout=new SimpleStringProperty("Logout");
    }

    public void addLikeMovies(Movie movie) throws RemoteException {
        model.addLikeMovies(movie);
    }

    public void addBookMovies(Movie movie) throws RemoteException {
        model.addBookMovies(movie);
    }

    public void addWatchedMovie(Movie movie) throws RemoteException {
        model.addWatchedMovie(movie);
    }

    public ArrayList<Movie> allLikedMovies() throws RemoteException {
        return model.getLikedMovies();
    }

    public ArrayList<Movie> allBookedMovies() throws RemoteException {
        return model.getBookMovies();
    }

    public ArrayList<Movie> allWatchedMovies() throws RemoteException {
        return model.getWatchedMovies();
    }

    public ArrayList<Movie> allMovies() throws RemoteException {
        return model.getMovies();
    }




    public StringProperty getLogout(){
        return logout;
    }
}
