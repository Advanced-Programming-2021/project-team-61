package View;

import Model.Board;
import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Controller.DualMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import Controller.MainPhase1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import Controller.GameController;

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
    private ImageView bigShowCard;
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
    private Label firstLabelInMonsterZone;

    @FXML
    private Label secondLabelInMonsterZone;

    @FXML
    private Label thirdLabelInMonsterZone;

    @FXML
    private Label forthLabelInMonsterZone;

    @FXML
    private Label fifthLabelInMonsterZone;




    @FXML
    void handleFifth(MouseEvent event) {
        bigShowCard.setImage(fifthInHand.getImage());
        if(currentPhase.equals("mainPhase1")){
            if(handleSummonMonster(4)){
            }
            else if(handleActivationOfSpellTrap(4)){

            }
            else if(handleSetOfSpellTrap(4)){

            }
    }

    }

    @FXML
    void handleFirst(MouseEvent event) {
        bigShowCard.setImage(firstInHand.getImage());
        if(currentPhase.equals("mainPhase1")){
           if(handleSummonMonster(0)){
           }
           else if(handleActivationOfSpellTrap(0)){

           }
           else if(handleSetOfSpellTrap(0)){

           }




        }


    }

    private boolean handleSetOfSpellTrap(int index) {
        if(MainPhase1.getInstance().ProcessSet(Board.getBoardByPlayer(myTurn),index)){
            getLabelByIndex(index).setText("set");
            getImageViewInHandByIndex(index).setOnMouseClicked(event -> {
               int x =  MainPhase1.getInstance().setSpellTrap(Board.getBoardByPlayer(myTurn),index);
               putSpellTrapInField(x,notShownImage.getImage());
               getLabelByIndex(index).setText(null);
               getImageViewInHandByIndex(index).setImage(null);
            });
            return true;
        }
        return false;
    }

    private Label getLabelByIndex(int index) {
        switch (index){
            case 0 :{
                return firstLabel;
            }
            case 1 :{
                return secondLabel;
            }
            case 2 :{
                return thirdLabel;
            }
            case 3 :{
                return forthLabel;
            }
            case 4 :{
                return fifthLabel;
            }
            case 5 :{
                return sixthLabel;
            }
            default:break;

        }
        return null;
    }
    private ImageView getImageViewInHandByIndex(int index){
        switch (index){
            case 0: {
                return firstInHand;
            }
            case 1: {
                return secondInHand;
            }
            case 2: {
                return thirdInHand;
            }
            case 3: {
                return fourthInHand;
            }
            case 4: {
                return fifthInHand;
            }
            case 5 : {
                return sixthInHand;
            }
            default:break;
        }
        return null;
    }

    private boolean handleActivationOfSpellTrap(int index) {
        if(MainPhase1.getInstance().ProcessActivation(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),index)){
            getLabelByIndex(index).setText("activate");
            getImageViewInHandByIndex(index).setOnMouseClicked(event1 -> {
                if(event1.getButton() == MouseButton.SECONDARY){
                    getLabelByIndex(index).setText("set");
                }
                else{
                    String s = getLabelByIndex(index).getText();
                    if(s.equals("activate")){
                        int x =  Board.getBoardByPlayer(myTurn).activateSpellCardFromHand(0);
                        putSpellTrapInField(x,firstInHand.getImage());
                    }
                    else if(s.equals("set")){
                        int x = MainPhase1.getInstance().setSpellTrap(Board.getBoardByPlayer(myTurn),0);
                        putSpellTrapInField(x,notShownImage.getImage());
                    }
                    getLabelByIndex(index).setText(null);
                    getImageViewInHandByIndex(index).setImage(null);
                }
            });
            return true;
        }
        return false;

    }

    private boolean handleSummonMonster(int index) {
        if(MainPhase1.getInstance().ProcessSummon(Board.getBoardByPlayer(myTurn),index)){
            getLabelByIndex(index).setText("summon");
            getImageViewInHandByIndex(index).setOnMouseClicked(event1 -> {
                if(event1.getButton() == MouseButton.SECONDARY){
                    if(getLabelByIndex(index).getText().equals("set"))
                        getLabelByIndex(index).setText("summon");
                    else
                        getLabelByIndex(index).setText("set");
                }
                else{
                    String s = getLabelByIndex(index).getText();
                    if(s.equals("summon")){
                        int x = MainPhase1.getInstance().summonMonster(Board.getBoardByPlayer(myTurn),0);
                        GameController.getInstance().setSummonedInTurn(true);
                        putMonsterInMonsterZone(x,firstInHand.getImage(),index);
                    }
                    else if(s.equals("set")){
                        int x = MainPhase1.getInstance().setMonster(Board.getBoardByPlayer(myTurn),0);
                        GameController.getInstance().setSummonedInTurn(true);
                       // notShownImage.setRotate(90);
                        putMonsterInMonsterZone(x,notShownImage.getImage(),index);
                    }
                    getImageViewInHandByIndex(index).setImage(null);
                    getLabelByIndex(index).setText(null);

                }
            });
            return true;
        }
        return false;
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

    private void putMonsterInMonsterZone(int x, Image image,int index) {
        put(x, image, firstMonsterZone, secondMonsterZone, thirdMonsterZone, forthMonsterZone, fifthMonsterZone);
        if(getLabelByIndex(index).equals("set")){
            rotate90Degrees(x);
        }

    }

    private void rotate90Degrees(int x) {
        switch (x){
            case 0 : {
                firstMonsterZone.setRotate(90);
                break;
            }
            case 1 : {
                secondMonsterZone.setRotate(90);
                break;
            }
            case 2 : {
                thirdMonsterZone.setRotate(90);
                break;
            }
            case 3 : {
                forthMonsterZone.setRotate(90);
                break;
            }
            case 4 : {
                fifthMonsterZone.setRotate(90);
                break;
            }
        }
    }

    @FXML
    void handleFourth(MouseEvent event) {
        bigShowCard.setImage(fourthInHand.getImage());
        if(currentPhase.equals("mainPhase1")){
            if(handleSummonMonster(3)){
            }
            else if(handleActivationOfSpellTrap(3)){

            }
            else if(handleSetOfSpellTrap(3)){

            }

    }}

    @FXML
    void handleSecond(MouseEvent event) {
            bigShowCard.setImage(secondInHand.getImage());
            if(currentPhase.equals("mainPhase1")){
                if(handleSummonMonster(1)){
                }

                else if(handleActivationOfSpellTrap(1)){

                }
                else if(handleSetOfSpellTrap(1)){

                }
        }

    }

    @FXML
    void handleSixth(MouseEvent event) {
            bigShowCard.setImage(sixthInHand.getImage());
            if(currentPhase.equals("mainPhase1")){
                if(handleSummonMonster(5)){
                }
                else if(handleActivationOfSpellTrap(5)){

                }
                else if(handleSetOfSpellTrap(5)){

                }
        }

    }

    @FXML
    void handleThird(MouseEvent event) {
            bigShowCard.setImage(thirdInHand.getImage());
            if(currentPhase.equals("mainPhase1")){
                if(handleSummonMonster(2)){
                }
                else if(handleActivationOfSpellTrap(2)){

                }
                else if(handleSetOfSpellTrap(2)){

                }
        }

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

    @FXML
    void handleFirstInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
           if(MainPhase1.getInstance().ProcessSetPosition(Board.getBoardByPlayer(myTurn),"attack",0)){

               firstLabelInMonsterZone.setText("Attack Change");
               firstMonsterZone.setOnMouseClicked(event1 -> {
                   MainPhase1.getInstance().setAttackMonsterCard(Board.getBoardByPlayer(myTurn),0);
                   firstMonsterZone.setRotate(90);
               });
           }
           else if(MainPhase1.getInstance().ProcessSetPosition(Board.getBoardByPlayer(myTurn),"Defense",0)){

               firstLabelInMonsterZone.setText("Defense Change");
               firstMonsterZone.setOnMouseClicked(event1 -> {
                   MainPhase1.getInstance().setDefenseMonsterCard(Board.getBoardByPlayer(myTurn),0);
                   firstMonsterZone.setRotate(90);
               });

           }
           else if(MainPhase1.getInstance().ProcessFlipSummon(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),0)){
               firstLabelInMonsterZone.setText("Flip Summon");
               firstMonsterZone.setOnMouseClicked(event1 -> {
                   MainPhase1.getInstance().flipSummonMonster(Board.getBoardByPlayer(myTurn),0);
                   firstMonsterZone.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getMonsterByIndex(0).getMonsterCard().getCardName()));
               });
           }
        }

    }

    @FXML
    void handleSecondInMonsterZone(MouseEvent event) {

    }

    @FXML
    void handleThirdInMonsterZone(MouseEvent event) {

    }
    @FXML
    void handleForthInMonsterZone(MouseEvent event) {

    }
    @FXML
    void handleFifthInMonsterZone(MouseEvent event) {

    }
















































    private void paintCardsInHand(Player me, Player rival) {
        this.myTurn =me;
        this.notMyTurn = rival;

        Card[] myCards = Board.getBoardByPlayer(me).getHand();
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
