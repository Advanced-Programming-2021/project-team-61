
/*

    IMPORTANT NOTE:
    Clean code practices are not important for "client" code in Question #2
    They are only important for "server" code in Question #2 and also inside "runQ3" in Question #3

 */

import Controller.AppController;
import View.Logic;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Logic logic = new Logic(primaryStage);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AppController.setupConnection();
        launch(args);


    }
}
