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

    public homepageVM(CustomerModel model){
        this.model=model;
        logout=new SimpleStringProperty("Logout");
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
}
