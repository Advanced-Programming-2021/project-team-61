package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Controller.DeckMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeckMenuPage implements Initializable {

    @FXML
    private TextField deckName;

    @FXML
    private Button removeDeck;

    @FXML
    private Button createDeck;

    @FXML
    private Button activate;

    @FXML
    private Button edit;

    @FXML
    private Button back;

    public void createDeck(){
        DeckMenu.getInstance().createDeck(deckName.getText(), Player.getLoggedPlayer());
    }

    public void removeDeck(){
        DeckMenu.getInstance().deleteDeck(deckName.getText(), Player.getLoggedPlayer());
    }

    public void edit() throws IOException {
        DeckEditPage.getInstance().setDeckName(deckName.getText());
        Logic.viewManager.changeScene("/sample/deckEditPage.fxml");
    }

    public void activate(){
        DeckMenu.getInstance().setActivateDeck(deckName.getText(), Player.getLoggedPlayer());
    }

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
