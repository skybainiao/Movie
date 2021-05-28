package Client.Networking;

import Client.Model.ModelFactory;
import Client.View.ViewHandler;
import Client.ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class ClientStart extends Application {
    @Override
    public void start(Stage stage) throws Exception, RemoteException {
        Client client=new ClientImpl("");
        ModelFactory modelFactory=new ModelFactory(client);
        ViewModelFactory viewModelFactory=new ViewModelFactory(modelFactory);
        ViewHandler viewHandler=new ViewHandler(viewModelFactory);
        viewHandler.openLoginView();
    }


    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
