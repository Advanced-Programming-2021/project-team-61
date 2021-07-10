package View;

import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Controller.DualMenu;

import java.io.IOException;

public class CreateNewGamePage{

    @FXML
    private Button back;

    @FXML
    private Text round;

    @FXML
    private Text numOfRound;

    @FXML
    private Button positive;

    @FXML
    private Button negative;

    @FXML
    private TextField username;

    @FXML
    private Button start;


    public void positive(){
        StartPage.click.play();
        int num = Integer.parseInt(numOfRound.getText());
        num++;
        numOfRound.setText(String.valueOf(num));
    }

    public void negative(){
        StartPage.click.play();
        int num = Integer.parseInt(numOfRound.getText());
        num--;
        numOfRound.setText(String.valueOf(num));
    }

    public void start() throws IOException {
        StartPage.click.play();
        if(DualMenu.getInstance().ProcessNewGame(Player.getLoggedPlayer().getUsername(),username.getText(),numOfRound.getText())){
           Logic.viewManager.changeScene("/sample/gamePage.fxml");
       }
    }

    public void back() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }
}
