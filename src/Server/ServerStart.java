package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerStart {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Server server=new ServerImpl();
        Registry registry=LocateRegistry.createRegistry(6666);
        registry.bind("Server",server);
        System.out.println("Server Start");
    }
}
