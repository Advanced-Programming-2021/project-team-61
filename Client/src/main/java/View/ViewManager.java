package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {

    Stage stage;
   private static ChatRoomPage chatRoomPage;

    public ViewManager(Stage stage) {
        this.stage = stage;
    }

    public void changeScene(String url) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader();
     //   Parent root = FXMLLoader.load(getClass().getResource(url));
      //  Scene scene = new Scene(root);
      //  stage.setScene(scene);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(url));
        Parent firstPage = loader.load();
        Scene scene = new Scene(firstPage);
        if(loader.getController() instanceof ChatRoomPage)
           chatRoomPage = loader.getController();
        stage.setTitle("Hello World");
        stage.setScene(scene);
    }
    public void createStage(String url) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public static ChatRoomPage getChatRoomPage(){
        return chatRoomPage;
    }



}