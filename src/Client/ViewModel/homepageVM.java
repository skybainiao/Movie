package Client.ViewModel;

import Client.Model.Customer.CustomerModel;
import Shared.Model.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class homepageVM {
    private CustomerModel model;
    private StringProperty logout;
    private StringProperty username;
    private StringProperty search;
    private StringProperty searchLabel;

    public homepageVM(CustomerModel model){
        this.model=model;
        logout=new SimpleStringProperty("Logout");
        username=new SimpleStringProperty();
        search=new SimpleStringProperty();
        searchLabel=new SimpleStringProperty("Search");
    }

    public ArrayList<Movie> getSearchMovies() throws SQLException, RemoteException {
        return model.getSearchMovies(search.getValue());
    }

    public void setUsername() throws RemoteException {
        username.setValue(model.getClientName());
    }

    public ArrayList<Movie> getWatchLater() throws SQLException, RemoteException {
        return model.getWatchLater();
    }

    public ArrayList<Movie> allLikedMovies() throws RemoteException, SQLException {
        return model.getLikedMovies();
    }

    public ArrayList<Movie> allMovies() throws RemoteException, SQLException {
        return model.getMovies();
    }


    public StringProperty getLogout(){
        return logout;
    }

    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getSearch(){
        return search;
    }

    public StringProperty getSearchLabel(){
        return searchLabel;
    }
}
