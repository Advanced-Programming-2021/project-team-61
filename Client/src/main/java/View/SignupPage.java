package View;

import Controller.AppController;
import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;

import javax.swing.*;
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

    public void signup() throws IOException {
        //  StartPage.click.play();
        //RegisterMenu.getInstance().userCreateProcess(username.getText(), nickname.getText(), password.getText());
        //"user create --u ([^\\s]+) --n ([^\\s]+) --p ([^\\s]+)"
        String s = "1.sign " + username.getText() + " " + nickname.getText() + " " + password.getText();
        String r = AppController.getServerOutput(s);
        checkResult(r);
    }

    public void back() throws IOException {
        // StartPage.click.play();
        Logic.viewManager.changeScene("/sample/startPage.fxml");
    }

    public void checkResult(String s) throws IOException {
        if (s.equals("success")){
            JOptionPane.showConfirmDialog(null,"user created successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //to be changed
            AppController.setUsername(username.getText());
            Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
        }else
            JOptionPane.showConfirmDialog(null,s,"Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

}