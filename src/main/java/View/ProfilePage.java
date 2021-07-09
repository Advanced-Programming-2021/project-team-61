package View;


import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.lang.management.PlatformLoggingMXBean;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfilePage implements Initializable {


    @FXML
    private Button changeNickName;

    @FXML
    private Button changePassword;

    @FXML
    private Button back;

    @FXML
    private Text username;

    @FXML
    private Text nickname;

    public void changeNickName() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/changeNickName.fxml");
    }

    public void changePassword() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/changePassword.fxml");
    }

    public void back() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText("username : " + Player.getLoggedPlayer().getUsername());
        nickname.setText("nickname : " + Player.getLoggedPlayer().getNickname());
    }


}
