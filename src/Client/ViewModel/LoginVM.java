package Client.ViewModel;

import Client.Model.Login.LoginModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.RemoteException;

public class LoginVM {
    private LoginModel loginModel;
    private StringProperty username;
    private StringProperty password;
    private BooleanProperty isCustomer;
    private BooleanProperty isAdmin;

    public LoginVM(LoginModel loginModel){
        this.loginModel=loginModel;
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

    public String typeChoose(){
        if (isCustomer.getValue()==true && isAdmin.getValue()==false){
            return "customer";
        }
        else if (isCustomer.getValue()==false && isAdmin.getValue()==true){
            return "admin";
        }
        return "error";
    }

    public void setIUsername() throws RemoteException {
        loginModel.setUsername(username.getValue());
    }

    public String validLogin() throws RemoteException {
        for (int i = 0; i < loginModel.getUsers().size(); i++) {
            if (loginModel.getUsers().get(i).getUsername().equals(username.getValue()) && loginModel.getUsers().get(i).getPassword().equals(password.getValue())){
                return "true";
            }else if (loginModel.getUsers().get(i).getUsername().equals(username.getValue()) && !loginModel.getUsers().get(i).getPassword().equals(password.getValue())){
                return "invalid password";
            }
            else if (!loginModel.getUsers().get(i).getUsername().equals(username.getValue()) && loginModel.getUsers().get(i).getPassword().equals(password.getValue())){
                return "invalid username";
            }
            else if (!loginModel.getUsers().get(i).getUsername().equals(username.getValue()) && !loginModel.getUsers().get(i).getPassword().equals(password.getValue())){
                return "invalid username or password";
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
