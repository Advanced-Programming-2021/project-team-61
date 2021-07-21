package View;

import Controller.AppController;
import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import javax.swing.*;
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

    public void login() throws IOException {
        //  StartPage.click.play();
        //RegisterMenu.getInstance().loginProcess(username.getText(), password.getText());
        String s = "1.login " + username.getText() + " " + password.getText();
        String r = AppController.getServerOutput(s);
        checkResult(r,username.getText());

    }

    public void back() throws IOException {
        //  StartPage.click.play();
        Logic.viewManager.changeScene("/sample/startPage.fxml");
    }

    public void checkResult(String s,String username) throws IOException {
        if (s.contains("success")){
            JOptionPane.showConfirmDialog(null,"user logged in successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            String[] split = s.split("\\s");
            AppController.setToken(split[1]);
            //set as logged player
            Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
        }else
            JOptionPane.showConfirmDialog(null,s,"Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}