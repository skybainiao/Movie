package Client.Networking;

import javafx.application.Application;
import javafx.stage.Stage;

public class WindowsLaunch extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.launch(ClientStart.class);
    }
}
