package Client.View;

import Client.ViewModel.LoginVM;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javax.swing.*;

public class LoginController {
    private LoginVM loginVM;
    private ViewHandler viewHandler;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private RadioButton isCustomer;
    @FXML
    private RadioButton isAdministrator;


    public void init(LoginVM loginVM,ViewHandler viewHandler){
        this.loginVM=loginVM;
        this.viewHandler=viewHandler;
        usernameTextField.textProperty().bindBidirectional(loginVM.getUsername());
        passwordTextField.textProperty().bindBidirectional(loginVM.getPassword());
        isCustomer.selectedProperty().bindBidirectional(loginVM.getIsCustomer());
        isAdministrator.selectedProperty().bindBidirectional(loginVM.getIsAdmin());

        ToggleGroup toggleGroup=new ToggleGroup();
        isCustomer.setToggleGroup(toggleGroup);
        isAdministrator.setToggleGroup(toggleGroup);
    }


    public void login() throws Exception {
        if (loginVM.typeChoose().equals("customer")){
            switch (loginVM.validLogin()){
                case "true":
                    loginVM.setClientName();
                    loginVM.clearFields();
                    viewHandler.openOverView();
                    break;
                case "empty":
                    JOptionPane.showMessageDialog(null,"pls enter your username or password");
                    break;
                case "invalid password":
                    JOptionPane.showMessageDialog(null,"invalid password");
                    break;
                case "error":
                    JOptionPane.showMessageDialog(null,"invalid username and invalid password");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"enter your valid username and password");
                    break;
            }
        }
        else if (loginVM.typeChoose().equals("admin")){
            if (usernameTextField.getText().equals("admin") && passwordTextField.getText().equals("123456")){
                viewHandler.openAdminView();
                loginVM.clearFields();
            }
            else {
                JOptionPane.showMessageDialog(null,"Please enter your correct username and password");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please choose login type");
        }
    }


    public void create(){
        viewHandler.openCreateView();
    }








}
