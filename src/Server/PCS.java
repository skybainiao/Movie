package Server;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PCS extends Remote {
    void addPCL(String name, PropertyChangeListener listener) throws RemoteException;
    void removePCL(String name,PropertyChangeListener listener) throws RemoteException;
}
