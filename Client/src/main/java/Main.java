
/*

    IMPORTANT NOTE:
    Clean code practices are not important for "client" code in Question #2
    They are only important for "server" code in Question #2 and also inside "runQ3" in Question #3

 */

import Controller.AppController;
import Model.Database;
import View.Logic;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Logic logic = new Logic(primaryStage);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        File f = new File("src\\main\\resources\\Monster.csv");
        String absolute = f.getAbsolutePath();
        File f2 = new File("src\\main\\resources\\SpellTrap.csv");
        String absolute2 = f2.getAbsolutePath();
        Database.readDataLineByLine(absolute, absolute2);
        AppController.setupConnection();
        launch(args);


    }
}
