package View;

import Model.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import Controller.GameController;
import javafx.scene.text.Text;
import Controller.DualMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePausePage implements Initializable {
    @FXML
    private Button backToMainMenu;

    @FXML
    private Button continueGame;

    @FXML
    private Button surrender;

    @FXML
    private ImageView soundON;

    @FXML
    private ImageView soundOFF;

    @FXML
    private ImageView sound;

    @FXML
    private Text now;


    public void backToMainMenu() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    public void changeSound(){
        StartPage.click.play();

        //need some change after add background music
        if (sound.equals(soundON))
            sound = soundOFF;
        else
            sound = soundON;
    }

    public void continueGame(){
        StartPage.click.play();
        //back to gamePage
    }

    public void surrender(){
        StartPage.click.play();
        GameController.getInstance().setSurrendered(true);
        //GameController.getInstance().playGame();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        now.setText(DualMenu.getInstance().getMe().getNickname() + "*" + Board.getBoardByPlayer(DualMenu.getInstance().getMe()).getLifePoint()
        + "***" + Board.getBoardByPlayer(DualMenu.getInstance().getRival()).getLifePoint() + "*" + DualMenu.getInstance().getRival().getNickname());
    }
}
