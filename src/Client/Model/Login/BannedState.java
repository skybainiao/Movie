package Client.Model.Login;

import Client.Networking.Client;
import Shared.Model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class BannedState implements LoginState {
    private Client client;

    public BannedState(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    @Override
    public void addUser(User user) throws RemoteException, NotBoundException {
        //nothing here
    }

    @Override
    public ArrayList<User> login() throws Exception {
        System.out.println("Login failed");
        return null;
    }

    @Override
    public void setClientName(String name) throws RemoteException, NotBoundException {

    }
}
