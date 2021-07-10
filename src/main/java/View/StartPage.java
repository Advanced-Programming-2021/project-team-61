package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartPage implements Initializable {
    public static AudioClip click = new AudioClip(StartPage.class.getResource("/sounds/click.mp3").toString());
    public static AudioClip menuBackground = new AudioClip(StartPage.class.getResource("/sounds/menuBackground.mp3").toString());
    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private Button exit;


    public void signup() throws IOException {
        //click.play();
        Logic.viewManager.changeScene("/sample/signupPage.fxml");
    }

    public void login() throws IOException {
        //click.play();
        Logic.viewManager.changeScene("/sample/loginPage.fxml");
    }

    public void exit(){
        //click.play();
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //menuBackground.play();
        //signup.setFont();

    }

}
