package Client.Model.Login;

import Client.Networking.Client;
import Client.Networking.ClientImpl;
import Server.Server;
import Server.ServerImpl;
import Shared.Model.User;
import org.junit.jupiter.api.Test;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AvailableStateTest {
    private Server server;
    private Client client;
    private LoginState loginState;

    AvailableStateTest() throws Exception {
        server=new ServerImpl();
        client=new ClientImpl("chen");
    }

    @Test
    void addUser() throws Exception {
        User user=new User("chen","dsajio");
        server=new ServerImpl();
        client=new ClientImpl("chen");
        client.addUser(user);
        assertNotNull(client.getUsers());

    }

    @Test
    void getUsers() {

    }

    @Test
    void setClientName() throws Exception {
        server=new ServerImpl();
        Registry registry= LocateRegistry.createRegistry(6666);
        registry.bind("Server",server);
        client=new ClientImpl("");
        client.setClientName("Chen");
        //assertNotNull(client.getClientName());
    }
}