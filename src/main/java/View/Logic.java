package View;

import javafx.stage.Stage;
//import ViewManager;

import java.io.IOException;

public class Logic {

    public static ViewManager viewManager;

    public Logic(Stage stage) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Hello World");
        viewManager = new ViewManager(stage);
        viewManager.changeScene("/sample/startPage.fxml");
        stage.show();

    }
}
