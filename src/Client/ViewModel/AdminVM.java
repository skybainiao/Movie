package Client.ViewModel;

import Client.Model.Admin.AdminModel;
import Shared.Model.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminVM {
    private AdminModel adminModel;
    private StringProperty titleText;
    private StringProperty productionYearText;
    private StringProperty productionCompanyText;
    private StringProperty averageReviewText;
    private StringProperty statusText;
    private StringProperty genre;
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
        genre=new SimpleStringProperty();
        addBt=new SimpleStringProperty("Add");
        removeBt=new SimpleStringProperty("Remove");
        editBt=new SimpleStringProperty("Edit");
    }

    public void addMovie() throws RemoteException {
        Movie movie=new Movie(titleText.getValue(),adminModel.getId(),productionYearText.getValue(),productionCompanyText.getValue(),averageReviewText.getValue(),statusText.getValue(),genre.getValue());
        adminModel.addMovie(movie);
    }

    public void removeMovie(int movieID) throws RemoteException, SQLException {
        adminModel.removeMovie(movieID);
    }

    public ArrayList<Movie> getAllMovies() throws RemoteException, SQLException {
        return adminModel.getMovies();
    }

    public void increase() throws RemoteException {
        adminModel.increase();
    }

    public void clearField(){
        titleText.setValue("");
        productionCompanyText.setValue("");
        productionYearText.setValue("");
        averageReviewText.setValue("");
        statusText.setValue("");
        genre.setValue("");
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

    public StringProperty getGenre(){
        return genre;
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
