import Model.Card;
import View.Logic;
import javafx.application.Application;
import javafx.stage.Stage;
import View.Logic;
import java.io.File;
import Model.Database;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Logic logic = new Logic(primaryStage);
        File f = new File("src\\main\\resources\\Monster.csv");
        String absolute = f.getAbsolutePath();
        File f2 = new File("src\\main\\resources\\SpellTrap.csv");
        String absolute2 = f2.getAbsolutePath();
        Database.readDataLineByLine(absolute, absolute2);
        Database.AISetup();



    }



    public static void main(String[] args) {
        launch(args);
    }
}

