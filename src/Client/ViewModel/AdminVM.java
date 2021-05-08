package Client.ViewModel;

import Client.Model.Admin.AdminModel;
import Shared.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class AdminVM {
    private AdminModel adminModel;
    private StringProperty titleText;
    private StringProperty productionYearText;
    private StringProperty productionCompanyText;
    private StringProperty averageReviewText;
    private StringProperty statusText;
    private StringProperty addBt;
    private StringProperty removeBt;
    private StringProperty editBt;


    public AdminVM(AdminModel adminModel){
        this.adminModel=adminModel;
        titleText=new SimpleStringProperty();
        productionYearText=new SimpleStringProperty();
        productionCompanyText=new SimpleStringProperty();
        averageReviewText=new SimpleStringProperty();
        statusText=new SimpleStringProperty();
        addBt=new SimpleStringProperty("Add");
        removeBt=new SimpleStringProperty("Remove");
        editBt=new SimpleStringProperty("Edit");
    }

    public void addMovie(Movie movie) throws RemoteException {
        adminModel.addMovie(movie);
    }

    public void removeMovie(Movie movie) throws RemoteException {
        adminModel.removeMovie(movie);
    }

    public ArrayList<Movie> getAllMovies() throws RemoteException {
        return adminModel.getMovies();
    }

    public void increase() throws RemoteException {
        adminModel.increase();
    }

    public int getId() throws RemoteException {
        return adminModel.getId();
    }

    public void clearField(){
        titleText.setValue("");
        productionCompanyText.setValue("");
        productionYearText.setValue("");
        averageReviewText.setValue("");
        statusText.setValue("");
    }


    public StringProperty getTitleText(){
        return titleText;
    }

    public StringProperty getProductionYearText(){
        return productionYearText;
    }

    public StringProperty getProductionCompanyText(){
        return productionCompanyText;
    }

    public StringProperty getAverageReviewText(){
        return averageReviewText;
    }

    public StringProperty getStatusText(){
        return statusText;
    }

    public StringProperty getAddBt(){
        return addBt;
    }

    public StringProperty getRemoveBt(){
        return removeBt;
    }

    public StringProperty getEditBt(){
        return editBt;
    }
}
