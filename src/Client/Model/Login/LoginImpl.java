package Client.Model.Login;

import Client.Networking.Client;
import Shared.Model.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginImpl implements LoginModel{
    private Client client;

    public LoginImpl(Client client) throws RemoteException, NotBoundException {
        this.client=client;
    }

    @Override
    public void setUsername(String username) throws RemoteException {
        client.setUsername(username);
    }

    @Override
    public void addUser(User user) throws RemoteException {
        client.addUser(user);
    }

    @Override
    public ArrayList<User> getUsers() throws Exception {
        return client.getUsers();
    }

}
