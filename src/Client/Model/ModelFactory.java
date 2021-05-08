package Client.Model;

import Client.Model.Admin.AdminImpl;
import Client.Model.Admin.AdminModel;
import Client.Model.Customer.CustomerImpl;
import Client.Model.Customer.CustomerModel;
import Client.Model.Login.LoginImpl;
import Client.Model.Login.LoginModel;
import Client.Networking.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory {
    private AdminModel adminModel;
    private CustomerModel customerModel;
    private LoginModel loginModel;
    private Client client;

    public ModelFactory(Client client){
        this.client=client;
    }

    public AdminModel getAdminModel() throws RemoteException, NotBoundException {
        if (adminModel==null){
            adminModel=new AdminImpl(client);
        }
        return adminModel;
    }

    public CustomerModel getCustomerModel() throws RemoteException, NotBoundException {
        if (customerModel==null){
            customerModel=new CustomerImpl(client);
        }
        return customerModel;
    }

    public LoginModel getLoginModel() throws RemoteException, NotBoundException {
        if (loginModel==null){
            loginModel=new LoginImpl(client);
        }
        return loginModel;
    }
}
