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
import java.util.ResourceBundle;
import Controller.DrawPhase;
import java.util.concurrent.atomic.AtomicInteger;

import Controller.GameController;
import Controller.BattlePhase;

public class GamePage implements Initializable {
    private String currentPhase;
    private Player myTurn;
    private Player notMyTurn;
    private Player temp;

    @FXML
    private ImageView endPhase;
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
    private ImageView battlePhase;
    @FXML
    private ImageView fifthRivalMonsterZone;

    @FXML
    private ImageView forthRivalMonsterZone;

    @FXML
    private ImageView thirdRivalMonsterZone;

    @FXML
    private ImageView secondRivalMonsterZone;

    @FXML
    private ImageView firstRivalMonsterZone;

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
    private Label battlePhaseLabel;

    @FXML
    private Label rivalLifePoint;

    @FXML
    private Label myLifePoint;





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
                        putSpellTrapInField(x,getImageViewInHandByIndex(index).getImage());
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
                        putMonsterInMonsterZone(x,getImageViewInHandByIndex(index).getImage(),index);
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
    void handleBattlePhase(MouseEvent event) {
        if(GameController.getInstance().isFirstTurn()){
          //  GameController.getInstance().setFirstTurn(false);
            battlePhaseLabel.setText("is not allowed");
        }
        else{
            battlePhase.setOnMouseClicked(event1 -> {
                currentPhase = "BattlePhase";
            });


        }

    }

    @FXML
    void handleFirstInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(handleSetPosition(0)){

            }
            else if(handleFlipSummon(0)){

            }


        }
        else if(currentPhase.equals("BattlePhase")){
            if(handleDirectAttack(0)){

            }
            else if(handleAttackToAMonster(0)){

            }



    }}

    private boolean handleAttackToAMonster(int index) {
        if(BattlePhase.getInstance().ProcessAttack(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),index)){
            getImageViewInMonsterZoneByIndex(index).setOnMouseClicked(event1 -> {
                handleAttack(getImageViewInMonsterZoneByIndex(index));


            });
            return true;

    }
        return false;
    }

    private boolean handleDirectAttack(int index) {
        if(BattlePhase.getInstance().ProcessDirectAttack(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),index)){
            getLabelInMonsterZoneByIndex(index).setText("attack");
            getImageViewInMonsterZoneByIndex(index).setOnMouseClicked(event1 -> {
                int x = BattlePhase.getInstance().directAttack(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),index);
                int y = Integer.parseInt(rivalLifePoint.getText());
                rivalLifePoint.setText(String.valueOf(y - x));

            });
            return true;
        }
        return false;

    }

    private void handleAttack(ImageView myMonster) {
        String x = Board.getBoardByPlayer(myTurn).getMonsterByIndex(0).getStatus();
        firstRivalMonsterZone.setOnMouseClicked(event -> {
            switch (x){
                case "OO" : {
                   int y = BattlePhase.getInstance().attackOO(0,0,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                   setGamePage(y,myMonster,firstRivalMonsterZone);
                }
                case "DO" : {
                    int y = BattlePhase.getInstance().attackDO(0,0,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,firstRivalMonsterZone);
                }
                case "DH" : {
                    int y = BattlePhase.getInstance().attackDH(0,0,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,firstRivalMonsterZone);
                }
            }
            return;
        });
        secondRivalMonsterZone.setOnMouseClicked(event -> {
            switch (x){
                case "OO" : {
                    int y = BattlePhase.getInstance().attackOO(0,1,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,secondRivalMonsterZone);
                }
                case "DO" : {
                    int y = BattlePhase.getInstance().attackDO(0,1,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,secondRivalMonsterZone);
                }
                case "DH" : {
                    int y = BattlePhase.getInstance().attackDH(0,1,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,secondRivalMonsterZone);
                }
            }
        });
        thirdRivalMonsterZone.setOnMouseClicked(event -> {
            switch (x){
                case "OO" : {
                    int y = BattlePhase.getInstance().attackOO(0,2,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,thirdRivalMonsterZone);
                }
                case "DO" : {
                    int y = BattlePhase.getInstance().attackDO(0,2,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,thirdRivalMonsterZone);
                }
                case "DH" : {
                    int y = BattlePhase.getInstance().attackDH(0,2,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,thirdRivalMonsterZone);
                }
            }
        });
        forthRivalMonsterZone.setOnMouseClicked(event -> {
            switch (x){
                case "OO" : {
                    int y = BattlePhase.getInstance().attackOO(0,3,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,forthRivalMonsterZone);
                }
                case "DO" : {
                    int y = BattlePhase.getInstance().attackDO(0,3,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,forthRivalMonsterZone);
                }
                case "DH" : {
                    int y = BattlePhase.getInstance().attackDH(0,3,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,forthRivalMonsterZone);
                }
            }
        });
        fifthRivalMonsterZone.setOnMouseClicked(event -> {
            switch (x){
                case "OO" : {
                    int y = BattlePhase.getInstance().attackOO(0,4,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,fifthRivalMonsterZone);
                }
                case "DO" : {
                    int y = BattlePhase.getInstance().attackDO(0,4,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,fifthRivalMonsterZone);
                }
                case "DH" : {
                    int y = BattlePhase.getInstance().attackDH(0,4,Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn));
                    setGamePage(y,myMonster,fifthRivalMonsterZone);
                }
            }
        });

    }

    private void setGamePage(int y, ImageView myMonster, ImageView rivalMonster) {
        if( y == 0 ){
            if( BattlePhase.getInstance().getDamageToShow() != -1){
             int x = Integer.parseInt(rivalLifePoint.getText());
             rivalLifePoint.setText(String.valueOf(x - BattlePhase.getInstance().getDamageToShow()));
            }
            rivalMonster.setImage(null);

        }
        if(y == 1){
            if(BattlePhase.getInstance().isDestroyed())
                rivalMonster.setImage(null);
        }
        else if( y == 2){
            int x = Integer.parseInt(myLifePoint.getText());
            myLifePoint.setText(String.valueOf(x - BattlePhase.getInstance().getDamageToShow()));
            if(BattlePhase.getInstance().isDestroyed())
                myMonster.setImage(null);

        }


    }


    private boolean handleFlipSummon(int index) {
        if(MainPhase1.getInstance().ProcessFlipSummon(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn),0)){

            getLabelInMonsterZoneByIndex(index).setText("Flip Summon");
            getImageViewInMonsterZoneByIndex(index).setOnMouseClicked(event1 -> {
                MainPhase1.getInstance().flipSummonMonster(Board.getBoardByPlayer(myTurn),0);
                getImageViewInMonsterZoneByIndex(index).setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getMonsterByIndex(0).getMonsterCard().getCardName()));
            });
            return true;
        }
        return false;
    }

    private boolean handleSetPosition(int index) {
        if(MainPhase1.getInstance().ProcessSetPosition(Board.getBoardByPlayer(myTurn),"attack",index)){
            getLabelInMonsterZoneByIndex(index).setText("Attack Change");

            getImageViewInMonsterZoneByIndex(index).setOnMouseClicked(event1 -> {
                MainPhase1.getInstance().setAttackMonsterCard(Board.getBoardByPlayer(myTurn),0);
                getImageViewInMonsterZoneByIndex(index).setRotate(90);
            });
        }
        else if(MainPhase1.getInstance().ProcessSetPosition(Board.getBoardByPlayer(myTurn),"Defense",0)){

            getLabelInMonsterZoneByIndex(index).setText("Defense Change");
            getImageViewInMonsterZoneByIndex(index).setOnMouseClicked(event1 -> {
                MainPhase1.getInstance().setDefenseMonsterCard(Board.getBoardByPlayer(myTurn),0);
                getImageViewInMonsterZoneByIndex(index).setRotate(90);
            });
           return true;
        }
        return false;

    }

    private ImageView getImageViewInMonsterZoneByIndex(int index) {
        switch (index){
            case 0 :{
                return firstMonsterZone;
            }
            case 1 :{
                return secondMonsterZone;
            }
            case 2 :{
                return thirdMonsterZone;
            }
            case 3 :{
                return forthMonsterZone;
            }
            case 4 :{
                return fifthMonsterZone;
            }

        }
        return null;
    }

    private Label getLabelInMonsterZoneByIndex(int index) {
        switch (index){
            case 0 :{
                return firstLabelInMonsterZone;
            }
            case 1 :{
                return secondLabelInMonsterZone;
            }
            case 2 :{
                return thirdLabelInMonsterZone;
            }
            case 3 :{
                return forthLabelInMonsterZone;
            }
            case 4 :{
                return fifthLabelInMonsterZone;
            }
        }
        return null;
    }

    @FXML
    void handleSecondInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(handleSetPosition(1)){

            }
            else if(handleFlipSummon(1)){

            }


        }
        else if(currentPhase.equals("BattlePhase")){
            if(handleDirectAttack(1)){

            }
            else if(handleAttackToAMonster(1)){

            }



        }


    }

    @FXML
    void handleThirdInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(handleSetPosition(2)){

            }
            else if(handleFlipSummon(2)){

            }


        }
        else if(currentPhase.equals("BattlePhase")){
            if(handleDirectAttack(2)){

            }
            else if(handleAttackToAMonster(2)){

            }



        }


    }
    @FXML
    void handleForthInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(handleSetPosition(3)){

            }
            else if(handleFlipSummon(3)){

            }


        }
        else if(currentPhase.equals("BattlePhase")){
            if(handleDirectAttack(3)){

            }
            else if(handleAttackToAMonster(3)){

            }



        }


    }
    @FXML
    void handleFifthInMonsterZone(MouseEvent event) {
        if(currentPhase.equals("mainPhase1")){
            if(handleSetPosition(4)){

            }
            else if(handleFlipSummon(4)){

            }


        }
        else if(currentPhase.equals("BattlePhase")){
            if(handleDirectAttack(4)){

            }
            else if(handleAttackToAMonster(4)){

            }



        }


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


    public void runEndPhase(MouseEvent event) {
        GameController.getInstance().reset(Board.getBoardByPlayer(myTurn).getMonstersInField());
        GameController.getInstance().setFirstTurn(false);
        changeTurn();
    }

    private void changeTurn() {
        temp = myTurn;
        myTurn = notMyTurn;
        notMyTurn = temp;
        changeBoard();
        runDrawPhase();
    }

    private void runDrawPhase() {
        int x = DrawPhase.getInstance().run(Board.getBoardByPlayer(myTurn));
        if(x != -1)
            putCardInHand(x);
    }

    private void putCardInHand(int x) {
        switch (x){
            case 0 : {
                firstInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }
            case 1 : {
                secondInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }
            case 2 : {
                thirdInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }
            case 3 : {
                fourthInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }
            case 4 : {
                fifthInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }
            case 5 : {
                sixthInHand.setImage(Card.getImageByCardName(Board.getBoardByPlayer(myTurn).getCardFromHand(x).getCardName()));
            }

        }
    }

    private void changeBoard() {
        if(firstRival == null){
            firstInHand.setImage(null);
        }
        if(firstRival != null){
            firstInHand.setImage(firstRival.getImage());
        }
        if(secondRival == null){
            secondInHand.setImage(null);
        }
        if(secondRival != null){
            secondInHand.setImage(secondRival.getImage());
        }
        if(thirdRival == null){
            thirdInHand.setImage(null);
        }
        if(thirdRival != null){
            thirdInHand.setImage(firstRival.getImage());
        }
        if(forthRival == null){
            fourthInHand.setImage(null);
        }
        if(forthRival != null){
            fourthInHand.setImage(firstRival.getImage());
        }
        if(fifthRival == null){
            fifthInHand.setImage(null);
        }
        if(fifthRival != null){
            fifthInHand.setImage(firstRival.getImage());
        }
        if(sixthRival == null){
            sixthInHand.setImage(null);
        }
        if(sixthRival != null){
            sixthInHand.setImage(firstRival.getImage());
        }
        if(firstRivalMonsterZone == null){
            firstMonsterZone.setImage(null);
        }
        if(firstRivalMonsterZone != null){
            firstMonsterZone.setImage(firstRivalMonsterZone.getImage());
        }
        if(secondRivalMonsterZone == null){
            secondMonsterZone.setImage(null);
        }
        if(secondRivalMonsterZone != null){
            secondMonsterZone.setImage(firstRivalMonsterZone.getImage());
        }
        if(thirdRivalMonsterZone == null){
            thirdMonsterZone.setImage(null);
        }
        if(thirdRivalMonsterZone != null){
            thirdMonsterZone.setImage(firstRivalMonsterZone.getImage());
        }
        if(forthRivalMonsterZone == null){
            forthMonsterZone.setImage(null);
        }
        if(forthRivalMonsterZone != null){
            forthMonsterZone.setImage(firstRivalMonsterZone.getImage());
        }
        if(fifthRivalMonsterZone == null){
            fifthMonsterZone.setImage(null);
        }
        if(fifthRivalMonsterZone != null){
            fifthMonsterZone.setImage(firstRivalMonsterZone.getImage());
        }
    }

    public void disappearBattlePhaseLabel(MouseEvent event) {
        battlePhaseLabel.setText(null);
    }
}
