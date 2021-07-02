package View;

import Controller.RegisterMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.text.View;
import java.io.IOException;

public class SignupPage {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField nickname;

    @FXML
    private Button sign;

    @FXML
    private Button back;

    public void signup(){
        RegisterMenu.getInstance().userCreateProcess(username.getText(), nickname.getText(), password.getText());
    }

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/startPage.fxml");
    }

}
