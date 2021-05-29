package Client.View;

import Client.ViewModel.homepageVM;
import Shared.Model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class HomepageController {
    private homepageVM homepageVM;
    private ViewHandler viewHandler;

    @FXML
    private ImageView picture;
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
    private TableColumn<Movie,String> genre;
    @FXML
    private Label logout;
    @FXML
    private Label username;
    @FXML
    private TextField search;
    @FXML
    private Label searchLabel;



    public void init(homepageVM homepageVM, ViewHandler viewHandler) throws RemoteException, SQLException {
        this.homepageVM = homepageVM;
        this.viewHandler=viewHandler;

        logout.textProperty().bindBidirectional(homepageVM.getLogout());
        username.textProperty().bindBidirectional(homepageVM.getUsername());
        search.textProperty().bindBidirectional(homepageVM.getSearch());
        searchLabel.textProperty().bindBidirectional(homepageVM.getSearchLabel());

        title.setCellValueFactory(new PropertyValueFactory("title"));
        id.setCellValueFactory(new PropertyValueFactory("id"));
        productionYear.setCellValueFactory(new PropertyValueFactory("productionYear"));
        productionCompany.setCellValueFactory(new PropertyValueFactory("productionCompany"));
        averageReview.setCellValueFactory(new PropertyValueFactory("averageReview"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        genre.setCellValueFactory(new PropertyValueFactory("genre"));

        if (getUrl()!=null){
            picture.setImage(new Image(getUrl()));
        }

        movieTableView.setRowFactory( tableView -> {
            TableRow<Movie> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Movie movie = row.getItem();
                    viewHandler.openDetailView(movie);
                }
            });
            return row ;
        });

        getAllMovies();
        getLikedMovies();
        getWatchLater();
        getName();
    }

    public void getSearchMovies() throws SQLException, RemoteException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(homepageVM.getSearchMovies());
        movieTableView.setItems(movieObservableList);
    }

    public void getAllMovies() throws RemoteException, SQLException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(homepageVM.allMovies());
        movieTableView.setItems(movieObservableList);
    }

    public void getLikedMovies() throws SQLException, RemoteException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(homepageVM.allLikedMovies());
        movieTableView.setItems(movieObservableList);
    }

    public void getWatchLater() throws SQLException, RemoteException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(homepageVM.getWatchLater());
        movieTableView.setItems(movieObservableList);
    }

    public void addUrl() throws SQLException, RemoteException {
        FileChooser fileChooser = new FileChooser();
        File tmp = fileChooser.showOpenDialog(new Stage());
        Image image = new Image("file:" + tmp.getAbsolutePath());
        String url = "file:" + tmp.getAbsolutePath();
        picture.setImage(image);
        homepageVM.addUrl(url);
    }

    public void getName() throws RemoteException {
        homepageVM.setUsername();
    }

    public String getUrl() throws SQLException, RemoteException {
        return homepageVM.getUrl();
    }

    public void logout(){
        viewHandler.openLoginView();
    }




}
