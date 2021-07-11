package View;

import Model.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import Controller.GameController;
import javafx.scene.text.Text;
import Controller.DualMenu;
import javafx.stage.Stage;

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
    private Text p1;

    @FXML
    private Text p2;

    public void backToMainMenu() throws IOException {
        // StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    public void continueGame(){

        // StartPage.click.play();
        //back to gamePage
    }

    public void surrender(){
        //StartPage.click.play();
        //GameController.getInstance().setSurrendered(true);
        //GameController.getInstance().playGame();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p1.setText(DualMenu.getInstance().getMe().getUsername() + "\n" + Board.getBoardByPlayer(DualMenu.getInstance().getMe()).getLifePoint());
        p2.setText(DualMenu.getInstance().getRival().getUsername() + "\n" + Board.getBoardByPlayer(DualMenu.getInstance().getRival()).getLifePoint());

    }
}
