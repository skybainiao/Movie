package Client.View;

import Client.ViewModel.DetailVM;
import Shared.Model.Movie;
import Shared.Model.Review;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailController implements PropertyChangeListener {
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


    public void init(ViewHandler viewHandler,DetailVM detailVM) throws SQLException, RemoteException {
        this.viewHandler=viewHandler;
        this.detailVM=detailVM;

        reviewList.setEditable(true);

        title.textProperty().bindBidirectional(detailVM.getTitle());
        productionYear.textProperty().bindBidirectional(detailVM.getProductionYear());
        productionCompany.textProperty().bindBidirectional(detailVM.getProductionCompany());
        averageReview.textProperty().bindBidirectional(detailVM.getAverageReview());
        status.textProperty().bindBidirectional(detailVM.getStatus());
        genre.textProperty().bindBidirectional(detailVM.getGenre());
        liked.textProperty().bindBidirectional(detailVM.getLike());
        disliked.textProperty().bindBidirectional(detailVM.getDislike());
        enterReview.textProperty().bindBidirectional(detailVM.getTextField());

        detailVM.addPCL("likeNum",this);
        detailVM.addPCL("dislikeNum",this);

        Platform.runLater(()->{
            try {
                getReviewList();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void addWatchLater() throws SQLException, RemoteException {
        detailVM.addWatchLater(movie);
    }

    public void setValue(Movie movie){
        this.movie=movie;
        detailVM.setValue(movie);
    }

    public ArrayList<Review> getReviews() throws RemoteException, SQLException {
        return detailVM.getReviews(movie);
    }

    public void getReviewList() throws SQLException, RemoteException {
        ObservableList<Review> reviews= FXCollections.observableArrayList();
        reviews.addAll(getReviews());
        reviewList.setItems(reviews);
    }

    public void addReview() throws SQLException, RemoteException {
        detailVM.addReview(movie);
        detailVM.clear();
        getReviewList();
    }

    public void addLikedMovie() throws SQLException, RemoteException {
        likeIncrease();
        detailVM.addLikeMovie(movie.getTitle());
    }

    public void likeIncrease() throws SQLException, RemoteException {
        detailVM.likeIncrease(movie);
    }

    public void dislikeIncrease() throws SQLException,RemoteException{
        detailVM.dislikeIncrease(movie);
    }


    public Movie getMovie() throws SQLException, RemoteException{
       return detailVM.getMovie(movie);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue().equals(movie.getTitle())){
            Platform.runLater(()->{
                try {
                    liked.textProperty().setValue("Liked  :"+getMovie().getLikeNum());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        else if (evt.getNewValue().equals(movie)){
            Platform.runLater(()->{
                try {
                    disliked.textProperty().setValue("Disliked  :"+getMovie().getDislikeNum());
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

    }
}
