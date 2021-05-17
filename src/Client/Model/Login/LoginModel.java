package Client.Model.Login;

import Shared.Model.User;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LoginModel {
    void setUsername(String username) throws RemoteException;
    void addUser(User user) throws RemoteException;
    ArrayList<User> getUsers() throws Exception;
}
