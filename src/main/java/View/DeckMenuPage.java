package View;

import Model.Deck;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Controller.DeckMenu;
import javafx.scene.text.Text;

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

    @FXML
    private Text decks;

    public void createDeck(){
        StartPage.click.play();
        DeckMenu.getInstance().createDeck(deckName.getText(), Player.getLoggedPlayer());
        deckName.clear();
        setNames();
    }

    public void removeDeck(){
        StartPage.click.play();
        DeckMenu.getInstance().deleteDeck(deckName.getText(), Player.getLoggedPlayer());
        deckName.clear();
        setNames();
    }

    public void edit() throws IOException {
        StartPage.click.play();
        Deck.setDeckInEdit(deckName.getText());
        Logic.viewManager.changeScene("/sample/deckEditPage.fxml");
        deckName.clear();
    }

    public void activate(){
        StartPage.click.play();
        DeckMenu.getInstance().setActivateDeck(deckName.getText(), Player.getLoggedPlayer());
        deckName.clear();
        setNames();
    }

    public void back() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        decks.setText(DeckView.getInstance().printAllDecksOfPlayer(Player.getLoggedPlayer().getAllDecks()));
    }

    public void setNames(){
        decks.setText(DeckView.getInstance().printAllDecksOfPlayer(Player.getLoggedPlayer().getAllDecks()));
    }
}
