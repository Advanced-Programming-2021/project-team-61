package View;

import Controller.ProfileMenu;
import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangeNickName {
    @FXML
    private TextField nickName;

    @FXML
    private Button set;

    @FXML
    private Button back;

    public void set(){
      //  StartPage.click.play();
        ProfileMenu.getInstance().changeNickname(Player.getLoggedPlayer(),nickName.getText());
    }

    public void back() throws IOException {
      //  StartPage.click.play();
        Logic.viewManager.changeScene("/sample/profilePage.fxml");
    }
}
