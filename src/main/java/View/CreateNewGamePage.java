package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Controller.DualMenu;

public class CreateNewGamePage {

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
        int num = Integer.parseInt(numOfRound.getText());
        num++;
        numOfRound.setText(String.valueOf(num));
    }

    public void negative(){
        int num = Integer.parseInt(numOfRound.getText());
        num--;
        numOfRound.setText(String.valueOf(num));
    }

    public void start(){
        DualMenu.getInstance().ProcessNewGame(Player.getLoggedPlayer().getUsername(),username.getText(),numOfRound.getText());
    }
}
