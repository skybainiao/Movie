package Client.Model.Login;

import Client.Networking.Client;
import Shared.Model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AvailableState implements LoginState {
    private Client client;

    public AvailableState(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    @Override
    public void addUser(User user) throws RemoteException {
        client.addUser(user);
    }

    @Override
    public ArrayList<User> login() throws Exception {
        System.out.println("Successfully login");
        return client.getUsers();
    }

    @Override
    public void setClientName(String name) throws RemoteException {
        client.setClientName(name);
    }



}
