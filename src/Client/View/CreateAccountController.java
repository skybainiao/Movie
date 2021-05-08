package Client.View;

import Client.ViewModel.CreateAccountVM;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.rmi.RemoteException;

public class CreateAccountController {
    private CreateAccountVM createAccountVM;
    private ViewHandler viewHandler;

    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordFieldAgain;


    public void init(CreateAccountVM createAccountVM,ViewHandler viewHandler){
        this.createAccountVM=createAccountVM;
        this.viewHandler=viewHandler;

        usernameText.textProperty().bindBidirectional(createAccountVM.getUsername());
        passwordField.textProperty().bindBidirectional(createAccountVM.getPassword());
        passwordFieldAgain.textProperty().bindBidirectional(createAccountVM.getPasswordAgain());
    }


    public void create() throws RemoteException {
        if (createAccountVM.validCreate()==true){
            switch (createAccountVM.validChar()){
                case "correct":
                    createAccountVM.addUser();
                    viewHandler.openLoginView();
                    break;
                case "too long username":
                    JOptionPane.showMessageDialog(null,"too long username");
                    break;
                case "too short username":
                    JOptionPane.showMessageDialog(null,"too short username");
                    break;
                case "too short password":
                    JOptionPane.showMessageDialog(null,"too short password");
                    break;
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"please enter the same password");
        }

    }

    public void cancel(){
        viewHandler.openLoginView();
    }





}
