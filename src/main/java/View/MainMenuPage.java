package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainMenuPage {

    @FXML
    private Button newGame;

    @FXML
    private Button profile;

    @FXML
    private Button deckMenu;

    @FXML
    private Button scoreboard;

    @FXML
    private Button shop;

    @FXML
    private Button logout;


    public void newGame() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/createNewGamePage.fxml");
    }

    public void profile() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/profilePage.fxml");
    }

    public void deckMenu() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/deckMenuPage.fxml");
    }

    public void scoreBoard() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/scoreboardPage.fxml");
    }

    public void shop() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/shopPage.fxml");
    }

    public void logout() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/startPage.fxml");
        Player.setLoggedPlayer(null);
    }
}
