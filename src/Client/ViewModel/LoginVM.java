package Client.ViewModel;

import Client.Model.Login.LoginState;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class LoginVM {
    private LoginState loginState;
    private StringProperty username;
    private StringProperty password;
    private BooleanProperty isCustomer;
    private BooleanProperty isAdmin;

    public LoginVM(LoginState loginState){
        this.loginState = loginState;
        username=new SimpleStringProperty();
        password=new SimpleStringProperty();
        isCustomer=new SimpleBooleanProperty();
        isAdmin=new SimpleBooleanProperty();
    }

    public void clearFields() {
        username.setValue("");
        password.setValue("");
        isCustomer.setValue(false);
        isAdmin.setValue(false);
    }

    public void setClientName() throws RemoteException, NotBoundException {
        loginState.setClientName(username.getValue());
    }

    public String ret(){
        return username.getValue();
    }

    public String typeChoose(){
        if (isCustomer.getValue()==true && isAdmin.getValue()==false){
            return "customer";
        }
        else if (isCustomer.getValue()==false && isAdmin.getValue()==true){
            return "admin";
        }
        return "error";
    }


    public String validLogin() throws Exception {
        for(int i = 0; i< loginState.login().size(); i++){
            if(loginState.login().get(i).getUsername().equals(username.getValue()) && loginState.login().get(i).getPassword().equals(password.getValue())){
                System.out.println("true");
                return "true";
            }
            else if(loginState.login().get(i).getUsername().equals(username.getValue()) && !(loginState.login().get(i).getPassword().equals(password.getValue()))){
                System.out.println("invalid password");
                return "invalid password";
            }
            else if (username.getValue()==null || password.getValue()==null){
                System.out.println("empty");
                return "empty";
            }

        }
        return "error";

    }


    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getPassword(){
        return password;
    }

    public BooleanProperty getIsCustomer(){
        return isCustomer;
    }

    public BooleanProperty getIsAdmin(){
        return isAdmin;
    }
}
