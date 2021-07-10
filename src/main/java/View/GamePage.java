package View;

import Model.Board;
import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Controller.DualMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import Controller.MainPhase1;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GamePage implements Initializable {
    private String currentPhase;
    private Player myTurn;
    private Player notMyTurn;
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
    private ImageView firstMonsterZone;

    @FXML
    private ImageView secondMonsterZone;

    @FXML
    private ImageView thirdMonsterZone;

    @FXML
    private ImageView forthMonsterZone;

    @FXML
    private ImageView fifthMonsterZone;

    @FXML
    private ImageView firstSpellTrapZone;

    @FXML
    private ImageView secondSpellTrapZone;

    @FXML
    private ImageView thirdSpellTrapZone;

    @FXML
    private ImageView forthSpellTrapZone;

    @FXML
    private ImageView fifthSpellTrapZone;

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
    @FXML
    private Label firstLabel;

    @FXML
    private Label secondLabel;

    @FXML
    private Label thirdLabel;

    @FXML
    private Label forthLabel;

    @FXML
    private Label fifthLabel;

    @FXML
    private Label sixthLabel;




    @FXML
    void handleFifth(MouseEvent event) {

    }

    @FXML
    void handleFirst(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(MainPhase1.getInstance().ProcessSummon(Board.getBoardByPlayer(myTurn),0)){
                firstLabel.setText("summon");
                firstInHand.setOnMouseClicked(event1 -> {
                    if(event1.getButton() == MouseButton.SECONDARY){
                        firstLabel.setText("set");
                    }
                    else{
                     String s = firstLabel.getText();
                     if(s.equals("summon")){
                      int x = MainPhase1.getInstance().summonMonster(Board.getBoardByPlayer(myTurn),0);
                        putMonsterInMonsterZone(x,firstInHand.getImage());
                     }
                     else if(s.equals("set")){
                         int x = MainPhase1.getInstance().setMonster(Board.getBoardByPlayer(myTurn),0);
                         putMonsterInMonsterZone(x,notShownImage.getImage());
                     }
                        firstInHand.setImage(null);
                        firstLabel.setText(null);

                    }
                });
            }
            else if(MainPhase1.getInstance().ProcessActivation(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),0)){
                firstLabel.setText("activate");
                firstLabel.setOnMouseClicked(event1 -> {
                    if(event1.getButton() == MouseButton.SECONDARY){
                        firstLabel.setText("set");
                    }
                    else{
                        String s = firstLabel.getText();
                        if(s.equals("activate")){
                          int x =  Board.getBoardByPlayer(myTurn).activateSpellCardFromHand(0);
                          putSpellTrapInField(x,firstInHand.getImage());
                        }
                        else if(s.equals("set")){
                            int x = MainPhase1.getInstance().setSpellTrap(Board.getBoardByPlayer(myTurn),0);
                            putSpellTrapInField(x,notShownImage.getImage());
                        }
                    }
                });
            }


        }


    }

    private void putSpellTrapInField(int x, Image image) {
        put(x, image, firstSpellTrapZone, secondSpellTrapZone, thirdSpellTrapZone, forthSpellTrapZone, fifthSpellTrapZone);
    }

    private void put(int x, Image image, ImageView firstSpellTrapZone, ImageView secondSpellTrapZone, ImageView thirdSpellTrapZone, ImageView forthSpellTrapZone, ImageView fifthSpellTrapZone) {
        switch (x){
            case 0 : {
              firstSpellTrapZone.setImage(image);
              break;
            }
            case 1 : {
                secondSpellTrapZone.setImage(image);
                break;
            }
            case 2 : {
                thirdSpellTrapZone.setImage(image);
                break;
            }
            case 3 : {
                forthSpellTrapZone.setImage(image);
                break;
            }
            case 4 : {
                fifthSpellTrapZone.setImage(image);
                break;
            }
        }
    }

    private void putMonsterInMonsterZone(int x, Image image) {
        put(x, image, firstMonsterZone, secondMonsterZone, thirdMonsterZone, forthMonsterZone, fifthMonsterZone);
    }

    @FXML
    void handleFourth(MouseEvent event) {

    }

    @FXML
    void handleSecond(MouseEvent event) {

    }

    @FXML
    void handleSixth(MouseEvent event) {

    }

    @FXML
    void handleThird(MouseEvent event) {

    }
    @FXML
    void disappearFifth(MouseEvent event) {
        fifthLabel.setText(null);

    }

    @FXML
    void disappearFirst(MouseEvent event) {
       firstLabel.setText(null);
    }

    @FXML
    void disappearFourth(MouseEvent event) {
      forthLabel.setText(null);
    }

    @FXML
    void disappearSecond(MouseEvent event) {
      secondLabel.setText(null);
    }

    @FXML
    void disappearSixth(MouseEvent event) {
       sixthLabel.setText(null);
    }

    @FXML
    void disappearThird(MouseEvent event) {
       thirdLabel.setText(null);
    }

    @FXML
    void runMainPhase1(MouseEvent event){
        currentPhase = "mainPhase1";

    }















































    private void paintCardsInHand(Player me, Player rival) {
        this.myTurn =me;
        this.notMyTurn = rival;

        Card[] myCards = Board.getBoardByPlayer(me).getHand();
        System.out.println("get cards");
        firstInHand.setImage(Card.getImageByCardName(myCards[0].getCardName()));
        secondInHand.setImage(Card.getImageByCardName(myCards[1].getCardName()));
        thirdInHand.setImage(Card.getImageByCardName(myCards[2].getCardName()));
        fourthInHand.setImage(Card.getImageByCardName(myCards[3].getCardName()));
        fifthInHand.setImage(Card.getImageByCardName(myCards[4].getCardName()));
        sixthInHand.setImage(Card.getImageByCardName(myCards[5].getCardName()));
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
