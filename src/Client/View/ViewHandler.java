package Client.View;

import Client.ViewModel.ViewModelFactory;
import Shared.Model.Movie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage mainStage;


    public ViewHandler(ViewModelFactory viewModelFactory)  {
        this.viewModelFactory=viewModelFactory;
        this.mainStage=new Stage();
    }



    private Scene loginScene;
    public void openLoginView(){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("LoginController.fxml"));
            Parent root=loader.load();
            LoginController loginController=loader.getController();
            loginController.init(viewModelFactory.getLoginVM(),this);
            mainStage.setTitle("Login");
            loginScene=new Scene(root);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mainStage.setScene(loginScene);
        mainStage.show();
    }


    private Scene overViewScene;
    public void openOverView(){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("HomepageController.fxml"));
            Parent root=loader.load();
            HomepageController homepageController =loader.getController();
            homepageController.init(viewModelFactory.getOverViewVM(),this);
            mainStage.setTitle("OverView");
            overViewScene=new Scene(root);
        }
        catch (IOException | SQLException e){
            e.printStackTrace();
        }
        mainStage.setScene(overViewScene);
        mainStage.show();
    }


    private Scene adminViewScene;
    public void openAdminView(){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("AdminController.fxml"));
            Parent root=loader.load();
            AdminController adminController=loader.getController();
            adminController.init(viewModelFactory.getAdminVM(),this);
            mainStage.setTitle("Admin");
            adminViewScene=new Scene(root);
        }
        catch (IOException | SQLException e){
            e.printStackTrace();
        }
        mainStage.setScene(adminViewScene);
        mainStage.show();
    }


    private Scene createScene;
    public void openCreateView(){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("CreateAccountController.fxml"));
            Parent root=loader.load();
            CreateAccountController createAccountController=loader.getController();
            createAccountController.init(viewModelFactory.getCreateAccountVM(),this);
            mainStage.setTitle("CreateView");
            createScene=new Scene(root);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        mainStage.setScene(createScene);
        mainStage.show();
    }

    private Stage detailStage = new Stage();
    private Scene detailScene;
    private DetailController detailController;
    public void openDetailView(Movie movie){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("DetailController.fxml"));
            Parent root=loader.load();
            detailController=loader.getController();
            detailController.init(this, viewModelFactory.getDetailVM());
            detailStage.setTitle("MovieDetail");
            detailScene=new Scene(root);
            detailController.setValue(movie);
        }
        catch (IOException | SQLException e){
            e.printStackTrace();
        }
        detailStage.setScene(detailScene);
        detailStage.show();
    }
}
