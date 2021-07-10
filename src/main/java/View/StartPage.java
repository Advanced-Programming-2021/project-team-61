package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

import java.io.IOException;

public class StartPage {
   // public static AudioClip click = new AudioClip(StartPage.class.getResource("/sounds/click.mp3").toString());

    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private Button exit;


    public void signup() throws IOException {
      //  click.play();
        Logic.viewManager.changeScene("/sample/signupPage.fxml");
    }

    public void login() throws IOException {
      //  click.play();
        Logic.viewManager.changeScene("/sample/loginPage.fxml");
    }

    public void exit(){
        System.exit(0);
    }


}
