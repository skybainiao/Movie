package Client.View;

import Client.ViewModel.homepageVM;
import Shared.Model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;
import java.sql.SQLException;

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
    private TableColumn<Movie,String> genre;
    @FXML
    private Label logout;



    public void init(homepageVM homepageVM, ViewHandler viewHandler) throws RemoteException, SQLException {
        this.homepageVM = homepageVM;
        this.viewHandler=viewHandler;

        logout.textProperty().bindBidirectional(homepageVM.getLogout());

        title.setCellValueFactory(new PropertyValueFactory("title"));
        id.setCellValueFactory(new PropertyValueFactory("id"));
        productionYear.setCellValueFactory(new PropertyValueFactory("productionYear"));
        productionCompany.setCellValueFactory(new PropertyValueFactory("productionCompany"));
        averageReview.setCellValueFactory(new PropertyValueFactory("averageReview"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        genre.setCellValueFactory(new PropertyValueFactory("genre"));

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

    public void getWatchLater(){

    }

    public void logout(){
        viewHandler.openLoginView();
    }













}
