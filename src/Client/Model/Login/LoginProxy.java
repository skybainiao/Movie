package Client.Model.Login;

import Client.Networking.Client;
import Shared.Model.User;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LoginProxy implements LoginModel{
    private LoginImpl login;
    private Client client;

    public LoginProxy(Client client){
        this.client=client;
    }

    @Override
    public void addUser(User user) throws RemoteException, NotBoundException {
        if (login == null){
            login=new LoginImpl(client);
        }
        login.addUser(user);
    }

    @Override
    public ArrayList<User> getUsers() throws Exception {
        if (login == null){
            login=new LoginImpl(client);
        }
        return login.getUsers();
    }

    @Override
    public void setClientName(String name) throws RemoteException, NotBoundException {
        if (login == null){
            login=new LoginImpl(client);
        }
        login.setClientName(name);
    }
}
