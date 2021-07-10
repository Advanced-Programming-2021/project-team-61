package View;

import Controller.ProfileMenu;
import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangePassword {

    @FXML
    private TextField oldPass;

    @FXML
    private TextField newPass;

    @FXML
    private Button check;

    @FXML
    private Button back;

    public void check(){
      //  StartPage.click.play();
        ProfileMenu.getInstance().changePassword(Player.getLoggedPlayer(), oldPass.getText(), newPass.getText());
    }

    public void back() throws IOException {
     //   StartPage.click.play();
        Logic.viewManager.changeScene("/sample/profilePage.fxml");
    }
}
