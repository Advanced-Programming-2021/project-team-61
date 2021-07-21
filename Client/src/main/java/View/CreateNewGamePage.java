package View;

import Controller.AppController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import javax.swing.*;
import java.io.IOException;

public class CreateNewGamePage{

    @FXML
    private Text round;

    @FXML
    private Text numOfRound;

    @FXML
    private Button positive;

    @FXML
    private Button negative;

    @FXML
    private Button sendRequest;

    @FXML
    private Button back;

    @FXML
    private Button cancelRequest;

    public void positive(){
        // StartPage.click.play();
        int num = Integer.parseInt(numOfRound.getText());
        num++;
        numOfRound.setText(String.valueOf(num));
    }

    public void negative(){
        //  StartPage.click.play();
        int num = Integer.parseInt(numOfRound.getText());
        num--;
        numOfRound.setText(String.valueOf(num));
    }

    /*public void start() throws IOException {
      //  StartPage.click.play();
        if(DualMenu.getInstance().ProcessNewGame(Player.getLoggedPlayer().getUsername(),username.getText(),numOfRound.getText())){
           Logic.viewManager.changeScene("/sample/gamePage.fxml");
       }
    }*/

    public void sendRequest(){
        String result = AppController.getServerOutput("6.send " + numOfRound.getText() + " " + AppController.getUsername());
        checkResultSend(result);
    }

    public void cancelRequest(){
        String result = AppController.getServerOutput("6.cancel " + numOfRound.getText() + " " + AppController.getUsername());
        checkResultCancel(result);
    }

    public void back() throws IOException {
        // StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    public void checkResultSend(String st){
        if (st.equals("success"))
            JOptionPane.showConfirmDialog(null,"your request set successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else
            System.out.println(AppController.getUsername() + "VS" +  st);
        //make a new game between AppController.getUsername VS st

    }

    public void checkResultCancel(String st){
        if (st.equals("success"))
            JOptionPane.showConfirmDialog(null,"your request cancel successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showConfirmDialog(null,st,"Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }
}
