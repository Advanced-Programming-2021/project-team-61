package View;

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


    public void newGame(){

    }

    public void profile() throws IOException {

    }

    public void deckMenu() throws IOException {
        Logic.viewManager.changeScene("/sample/deckMenuPage.fxml");
    }

    public void scoreBoard() throws IOException {
        Logic.viewManager.changeScene("/sample/scoreboardPage.fxml");
    }

    public void shop() throws IOException {
        Logic.viewManager.changeScene("/sample/shopPage.fxml");
    }

    public void logout() throws IOException {
        Logic.viewManager.changeScene("/sample/startPage.fxml");
        //set the current
    }
}
