package Client.View;

import Client.ViewModel.AdminVM;
import Shared.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class AdminController {
    private AdminVM adminVM;
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
    private TextField titleText;
    @FXML
    private TextField productionYearText;
    @FXML
    private TextField productionCompanyText;
    @FXML
    private TextField averageReviewText;
    @FXML
    private TextField statusText;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private Button edit;



    public void init(AdminVM adminVM,ViewHandler viewHandler) throws RemoteException {
        this.adminVM=adminVM;
        this.viewHandler=viewHandler;

        titleText.textProperty().bindBidirectional(adminVM.getTitleText());
        productionYearText.textProperty().bindBidirectional(adminVM.getProductionYearText());
        productionCompanyText.textProperty().bindBidirectional(adminVM.getProductionCompanyText());
        averageReviewText.textProperty().bindBidirectional(adminVM.getAverageReviewText());
        statusText.textProperty().bindBidirectional(adminVM.getStatusText());
        add.textProperty().bindBidirectional(adminVM.getAddBt());
        remove.textProperty().bindBidirectional(adminVM.getRemoveBt());
        edit.textProperty().bindBidirectional(adminVM.getEditBt());

        title.setCellValueFactory(new PropertyValueFactory("title"));
        id.setCellValueFactory(new PropertyValueFactory("id"));
        productionYear.setCellValueFactory(new PropertyValueFactory("productionYear"));
        productionCompany.setCellValueFactory(new PropertyValueFactory("productionCompany"));
        averageReview.setCellValueFactory(new PropertyValueFactory("averageReview"));
        status.setCellValueFactory(new PropertyValueFactory("status"));

        movieTableView.setEditable(true);

        getAllMovies();
    }


    public void addMovie() throws RemoteException {
        adminVM.increase();
        Movie movie = new Movie(adminVM.getId(),titleText.getText(),productionYearText.getText(),productionCompanyText.getText(),averageReviewText.getText(),statusText.getText());
        adminVM.addMovie(movie);
        adminVM.clearField();
        getAllMovies();
    }


    public void removeMovie() throws RemoteException {
        Movie movieSelected = movieTableView.getSelectionModel().getSelectedItem();
        adminVM.removeMovie(movieSelected);
        movieTableView.refresh();
        getAllMovies();
    }


    public void editMovie() throws RemoteException {
        Movie movie = movieTableView.getSelectionModel().getSelectedItem();
        adminVM.removeMovie(movie);
        titleText.setText(movie.getTitle());
        productionYearText.setText(movie.getProductionYear());
        productionCompanyText.setText(movie.getProductionCompany());
        averageReviewText.setText(movie.getAverageReview());
        statusText.setText(movie.getStatus());

    }

    public void getAllMovies() throws RemoteException {
        ObservableList<Movie> movieObservableList = FXCollections.observableArrayList();
        movieObservableList.addAll(adminVM.getAllMovies());
        movieTableView.setItems(movieObservableList);
    }




















}
