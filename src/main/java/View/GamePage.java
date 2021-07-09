package View;

import Model.Board;
import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Controller.DualMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GamePage implements Initializable {
    @FXML
    private ImageView firstInHand;

    @FXML
    private ImageView secondInHand;

    @FXML
    private ImageView thirdInHand;

    @FXML
    private ImageView fourthInHand;

    @FXML
    private ImageView fifthInHand;

    @FXML
    private ImageView sixthInHand;

    @FXML
    private ImageView sixthRival;

    @FXML
    private ImageView fifthRival;

    @FXML
    private ImageView forthRival;

    @FXML
    private ImageView thirdRival;

    @FXML
    private ImageView secondRival;

    @FXML
    private ImageView firstRival;
    @FXML
    private ImageView notShownImage;














































    private void paintCardsInHand(Player me, Player rival) {
        ArrayList<Card> myCards = (Board.getBoardByPlayer(me)).getHand();
        //firstInHand.setImage(Card.getImageByCardName("Alexandrite Dragon"));
        firstInHand.setImage(Card.getImageByCardName(myCards.get(0).getCardName()));
        secondInHand.setImage(Card.getImageByCardName(myCards.get(1).getCardName()));
        thirdInHand.setImage(Card.getImageByCardName(myCards.get(2).getCardName()));
        fourthInHand.setImage(Card.getImageByCardName(myCards.get(3).getCardName()));
        fifthInHand.setImage(Card.getImageByCardName(myCards.get(4).getCardName()));
        sixthInHand.setImage(Card.getImageByCardName(myCards.get(5).getCardName()));
        firstRival.setImage(notShownImage.getImage());
        secondRival.setImage(notShownImage.getImage());
        thirdRival.setImage(notShownImage.getImage());
        forthRival.setImage(notShownImage.getImage());
        fifthRival.setImage(notShownImage.getImage());
        sixthRival.setImage(notShownImage.getImage());


    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Player me = DualMenu.getInstance().getMe();
        Player rival = DualMenu.getInstance().getRival();
        paintCardsInHand(me,rival);

    }


}
