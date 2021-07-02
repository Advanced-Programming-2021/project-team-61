package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Controller.RegisterMenu;


import java.io.IOException;

public class LoginPage {


    @FXML
    private TextField username ;

    @FXML
    private TextField password;

    @FXML
    private Button back;

    @FXML
    private Button login;

    public void login(){
        RegisterMenu.getInstance().loginProcess(username.getText(), password.getText());
    }

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/startPage.fxml");
    }
}
