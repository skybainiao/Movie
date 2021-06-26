package Client.Networking;

import Client.Model.ModelFactory;
import Client.View.ViewHandler;
import Client.ViewModel.ViewModelFactory;
import Shared.Model.SystemLog;
import javafx.application.Application;
import javafx.stage.Stage;
import java.rmi.RemoteException;

public class ClientStart extends Application {
    @Override
    public void start(Stage stage) throws Exception, RemoteException {
        Client client=new ClientImpl("Chen");
        SystemLog systemLog = SystemLog.getInstance();
        systemLog.SystemLog(client.getClientName()+" is online");
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
