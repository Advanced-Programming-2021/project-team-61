package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.View.Logic;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Logic logic = new Logic(primaryStage);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
