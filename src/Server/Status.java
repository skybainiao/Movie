package Server;

import java.rmi.RemoteException;

public class Status implements Runnable {
    private int onlineUsers;
    private Server server;

    public Status(Server server) throws RemoteException {
        this.server=server;
        System.out.println("Thread Running");
    }

    @Override
    public void run() {
        while (true){
            try {
                server.addPCL("client",evt -> onlineUsers++);
                server.addPCL("user",evt -> System.out.println("New User :"+evt.getNewValue()+" is added"));
                System.out.println("OnlineUsers :"+onlineUsers);
                Thread.sleep(3000);
            } catch (RemoteException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
