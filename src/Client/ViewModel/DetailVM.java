package Client.ViewModel;

import Client.Model.Customer.CustomerModel;
import Server.PCS;
import Shared.Model.Movie;
import Shared.Model.Review;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailVM implements PCS{
    private CustomerModel customerModel;
    private StringProperty title;
    private StringProperty productionYear;
    private StringProperty productionCompany;
    private StringProperty averageReview;
    private StringProperty status;
    private StringProperty genre;
    private StringProperty like;
    private StringProperty dislike;
    private StringProperty textField;
    private PropertyChangeSupport support;

    public DetailVM(CustomerModel customerModel) throws RemoteException {
        this.customerModel=customerModel;
        title=new SimpleStringProperty();
        productionCompany=new SimpleStringProperty();
        productionYear=new SimpleStringProperty();
        averageReview=new SimpleStringProperty();
        status=new SimpleStringProperty();
        genre=new SimpleStringProperty();
        like=new SimpleStringProperty();
        dislike=new SimpleStringProperty();
        textField=new SimpleStringProperty();
        support=new PropertyChangeSupport(this);

    }


    public void setValue(Movie movie){
        title.setValue(movie.getTitle());
        productionYear.setValue("ProductionYear  : "+movie.getProductionYear());
        productionCompany.setValue("ProductionCompany  : "+movie.getProductionCompany());
        averageReview.setValue("AverageReview  : "+movie.getAverageReview());
        status.setValue("Status  : "+movie.getStatus());
        genre.setValue("Genre  : "+movie.getGenre());
        like.setValue("Liked  :"+movie.getLikeNum());
        dislike.setValue("Disliked  :"+movie.getDislikeNum());

    }

    public void clear(){
        textField.setValue("");
    }

    public ArrayList<Review> getReviews(Movie movie) throws RemoteException, SQLException {
        return customerModel.getReviews(movie);
    }

    public void addReview(Movie movie) throws RemoteException, SQLException {
        Review review=new Review(customerModel.getClientName(),textField.getValue());
        customerModel.addReview(review,movie.getTitle());
    }

    public Movie getMovie(Movie movie) throws SQLException, RemoteException{
        return customerModel.getMovie(movie);
    }

    public void likeIncrease(Movie movie) throws SQLException, RemoteException {
        customerModel.likeIncrease(movie);
    }

    public void dislikeIncrease(Movie movie) throws SQLException,RemoteException{
        customerModel.dislikeIncrease(movie);
        support.firePropertyChange("dislikeNum",null,movie);
    }


    public void addLikeMovie(String movieName) throws RemoteException, SQLException {
        customerModel.addLikeMovie(customerModel.getClientName(),movieName);
        support.firePropertyChange("likeNum",null,movieName);
    }

    public void addWatchLater(Movie movie) throws RemoteException, SQLException {
        customerModel.addWatchLater(customerModel.getClientName(),movie);
    }


    @Override
    public void addPCL(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void removePCL(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }


    public StringProperty getTitle(){
        return title;
    }

    public StringProperty getGenre(){
        return genre;
    }

    public StringProperty getProductionYear(){
        return productionYear;
    }

    public StringProperty getProductionCompany(){
        return productionCompany;
    }

    public StringProperty getAverageReview(){
        return averageReview;
    }

    public StringProperty getStatus(){
        return status;
    }

    public StringProperty getLike(){
        return like;
    }

    public StringProperty getDislike(){
        return dislike;
    }

    public StringProperty getTextField(){
        return textField;
    }


}
