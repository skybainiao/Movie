package Client.ViewModel;

import Client.Model.Login.LoginState;
import Shared.Model.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CreateAccountVM {
    private LoginState loginState;
    private StringProperty username;
    private StringProperty password;
    private StringProperty passwordAgain;

    public CreateAccountVM(LoginState loginState){
        this.loginState = loginState;
        username=new SimpleStringProperty();
        password=new SimpleStringProperty();
        passwordAgain=new SimpleStringProperty();
    }

    public void addUser() throws RemoteException, NotBoundException {
        User user = new User(username.getValue(),password.getValue());
        loginState.addUser(user);
    }

    public boolean validCreate(){
        if (password.getValue().equals(passwordAgain.getValue())){
            return true;
        }
        else return false;
    }

    public String validChar(){
        if (username.getValue().length()>16){
            return "too long username";
        }
        else if (username.getValue().length()<4){
            return "too short username";
        }
        else if (password.getValue().length()<6){
            return "too short password";
        }
        else if (username.getValue()==null || password.getValue()==null){
            return "pls enter";
        }
        return "correct";
    }

    public void clear(){
        username.setValue("");
        password.setValue("");
        passwordAgain.setValue("");
    }

    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getPassword(){
        return password;
    }

    public StringProperty getPasswordAgain(){
        return passwordAgain;
    }




}
