package Client.View;

import Client.ViewModel.DetailVM;
import Shared.Model.Movie;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.rmi.RemoteException;
import java.sql.SQLException;

public class DetailController {
    private ViewHandler viewHandler;
    private DetailVM detailVM;
    private Movie movie;

    @FXML
    private ListView reviewList;
    @FXML
    private TextField enterReview;
    @FXML
    private Label title;
    @FXML
    private Label productionYear;
    @FXML
    private Label productionCompany;
    @FXML
    private Label averageReview;
    @FXML
    private Label status;
    @FXML
    private Label genre;
    @FXML
    private Label liked;
    @FXML
    private Label disliked;


    public void init(ViewHandler viewHandler,DetailVM detailVM){
        this.viewHandler=viewHandler;
        this.detailVM=detailVM;

        title.textProperty().bindBidirectional(detailVM.getTitle());
        productionYear.textProperty().bindBidirectional(detailVM.getProductionYear());
        productionCompany.textProperty().bindBidirectional(detailVM.getProductionCompany());
        averageReview.textProperty().bindBidirectional(detailVM.getAverageReview());
        status.textProperty().bindBidirectional(detailVM.getStatus());
        genre.textProperty().bindBidirectional(detailVM.getGenre());
        liked.textProperty().bindBidirectional(detailVM.getLike());
        disliked.textProperty().bindBidirectional(detailVM.getDislike());

    }

    public void setValue(Movie movie){
        this.movie=movie;
        detailVM.setValue(movie);
    }

    public void addLikedMovie() throws SQLException, RemoteException {
        likeIncrease();
        detailVM.addLikeMovie(movie.getTitle());
        Platform.runLater(()->{
            try {
                liked.textProperty().setValue("Liked  :"+getMovie().getLikeNum());
                System.out.println(getMovie().getLikeNum());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void likeIncrease() throws SQLException, RemoteException {
        detailVM.likeIncrease(movie);
    }


    public Movie getMovie() throws SQLException, RemoteException{
       return detailVM.getMovie(movie);
    }












}
