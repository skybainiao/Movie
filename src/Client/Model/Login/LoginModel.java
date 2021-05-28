package Client.Model.Login;

import Shared.Model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LoginModel {
    void addUser(User user) throws RemoteException, NotBoundException;
    ArrayList<User> getUsers() throws Exception;
    void setClientName(String name) throws RemoteException, NotBoundException;
}
