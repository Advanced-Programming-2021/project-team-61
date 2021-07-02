package View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartPage {

    @FXML
    private Button signup;

    @FXML
    private Button login;

    @FXML
    private Button exit;


    public void signup() throws IOException {
        Logic.viewManager.changeScene("/sample/signupPage.fxml");
    }

    public void login() throws IOException {
        Logic.viewManager.changeScene("/sample/loginPage.fxml");
    }

    public void exit(){
        System.exit(0);
    }


}
