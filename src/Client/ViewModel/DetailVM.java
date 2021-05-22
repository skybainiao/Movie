package Client.ViewModel;

import Client.Model.Customer.CustomerModel;
import Shared.Model.Movie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class DetailVM {
    private CustomerModel customerModel;
    private StringProperty title;
    private StringProperty productionYear;
    private StringProperty productionCompany;
    private StringProperty averageReview;
    private StringProperty status;
    private StringProperty genre;
    private StringProperty like;
    private StringProperty dislike;

    public DetailVM(CustomerModel customerModel){
        this.customerModel=customerModel;
        title=new SimpleStringProperty();
        productionCompany=new SimpleStringProperty();
        productionYear=new SimpleStringProperty();
        averageReview=new SimpleStringProperty();
        status=new SimpleStringProperty();
        genre=new SimpleStringProperty();
        like=new SimpleStringProperty();
        dislike=new SimpleStringProperty();
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

    public Movie getMovie(Movie movie) throws SQLException, RemoteException{
        return customerModel.getMovie(movie);
    }

    public void likeIncrease(Movie movie) throws SQLException, RemoteException {
        customerModel.likeIncrease(movie);
    }


    public void addLikeMovie(String movieName) throws RemoteException, SQLException {
        customerModel.addLikeMovie(customerModel.getClientName(),movieName);
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
}
