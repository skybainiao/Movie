package Client.View;

import Client.ViewModel.homepageVM;
import Shared.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class HomepageController {
    private homepageVM homepageVM;
    private ViewHandler viewHandler;

    @FXML
    private TableView<Movie> movieTableView;
    @FXML
    private TableColumn<Movie,String> title;
    @FXML
    private TableColumn<Movie,Integer> id;
    @FXML
    private TableColumn<Movie,Integer> productionYear;
    @FXML
    private TableColumn<Movie,String> productionCompany;
    @FXML
    private TableColumn<Movie,Integer> averageReview;
    @FXML
    private TableColumn<Movie,String> status;
    @FXML
    private Button getAllMovies;
    @FXML
    private Button getLikedMovies;
    @FXML
    private Button getBookedMovies;
    @FXML
    private Button getWatchedMovies;



    public void init(homepageVM homepageVM, ViewHandler viewHandler) throws RemoteException {
        this.homepageVM = homepageVM;
        this.viewHandler=viewHandler;

        getAllMovies.textProperty().bindBidirectional(homepageVM.getAllMovies());
        getBookedMovies.textProperty().bindBidirectional(homepageVM.getBookedMovies());
        getLikedMovies.textProperty().bindBidirectional(homepageVM.getLikedMovies());
        getWatchedMovies.textProperty().bindBidirectional(homepageVM.getWatchedMovies());

        title.setCellValueFactory(new PropertyValueFactory("title"));
        id.setCellValueFactory(new PropertyValueFactory("id"));
        productionYear.setCellValueFactory(new PropertyValueFactory("productionYear"));
        productionCompany.setCellValueFactory(new PropertyValueFactory("productionCompany"));
        averageReview.setCellValueFactory(new PropertyValueFactory("averageReview"));
        status.setCellValueFactory(new PropertyValueFactory("status"));

        getAllMovies();
    }


    public void getAllMovies() throws RemoteException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(homepageVM.allMovies());
        movieTableView.setItems(movieObservableList);
    }













}
