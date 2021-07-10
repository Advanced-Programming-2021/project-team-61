package View;

import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Controller.ShopMenu;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopPage implements Initializable {
    private ShopMenu shopMenu = ShopMenu.getInstance();
    private Player player = Player.getLoggedPlayer();

    @FXML
    private Button CommandKnightBuy;

    @FXML
    private Button alexandriteBuy;

    @FXML
    private Button axeRaiderBuy;

    @FXML
    private Button babyDragonBuy;

    @FXML
    private Button battleOxBuy;

    @FXML
    private Button battleWarriorBuy;

    @FXML
    private Button bitronBuy;

    @FXML
    private Button blueEyesBuy;

    @FXML
    private Button crawlingDragonBuy;

    @FXML
    private Button curtainBuy;

    @FXML
    private Button darkBladeBuy;

    @FXML
    private Button darkMagitionBuy;

    @FXML
    private Button exploderDragonBuy;

    @FXML
    private Button feralBuy;

    @FXML
    private Button fireYarouBuy;

    @FXML
    private Button flameBuy;

    @FXML
    private Button haniwaBuy;

    @FXML
    private Button heroOfTheEastBuy;

    @FXML
    private Button hornImpBuy;

    @FXML
    private Button leotronBuy;

    @FXML
    private Button manEaterBugBuy;

    @FXML
    private Button marshmallonBuy;

    @FXML
    private Button silverFangBuy;

    @FXML
    private Button slotMachineBuy;

    @FXML
    private Button spiralBuy;

    @FXML
    private Button theCalculatorBuy;

    @FXML
    private Button warriorBuy;

    @FXML
    private Button wattailBuy;

    @FXML
    private Button wattkidBuy;

    @FXML
    private Button yomiShipBuy;

    @FXML
    private Button timeSealBuy;

    @FXML
    private Button mindCrushBuy;

    @FXML
    private Button mirrorForceBuy;

    @FXML
    private Button callOfTheHauntedBuy;

    @FXML
    private Button torrentialTributeBuy;

    @FXML
    private Button negateAttackBuy;

    @FXML
    private Button darkHoleBuy;

    @FXML
    private Button forestBuy;

    @FXML
    private Button messengerBuy;

    @FXML
    private Button monsterRebornBuy;

    @FXML
    private Button mysticalBuy;

    @FXML
    private Button raigekiBuy;

    @FXML
    private Button spellAbsorptionBuy;

    @FXML
    private Button terraformingBuy;

    @FXML
    private Button twinBuy;

    @FXML
    private Button umirukaBuy;

    @FXML
    private Button yamiBuy;

    @FXML
    private Label commandNumbers;

    @FXML
    private Label alexNumbers;

    @FXML
    private Label axeNumbers;

    @FXML
    private Label babyNumbers;

    @FXML
    private Label battleOxNumbers;

    @FXML
    private Label battleWarriorNumbers;

    @FXML
    private Label bitronNumbers;

    @FXML
    private Label blueEyesNumbers;

    @FXML
    private Label crawlingNumbers;

    @FXML
    private Label curtainNumbers;

    @FXML
    private Label darkBladeNumbers;

    @FXML
    private Label darkMagitionNumber;

    @FXML
    private Label exploderNumbers;

    @FXML
    private Label feralNumbers;

    @FXML
    private Label fireYarouNumbers;

    @FXML
    private Label flameNUmbers;

    @FXML
    private Label haniwaNumbers;

    @FXML
    private Label heroNumbers;

    @FXML
    private Label hornNumbers;

    @FXML
    private Label leotronNumbers;

    @FXML
    private Label manEaterNumbers;

    @FXML
    private Label marshmallonNumbers;

    @FXML
    private Label silverNumbers;

    @FXML
    private Label slotNumbers;

    @FXML
    private Label spiralNumbers;

    @FXML
    private Label calculatorNumbers;

    @FXML
    private Label warriorNumbers;

    @FXML
    private Label wattiNumbers;

    @FXML
    private Label wattkidNumbers;

    @FXML
    private Label yomiNumbers;

    @FXML
    private Label timesealNumbers;

    @FXML
    private Label mindCrushNumbers;

    @FXML
    private Label mirrorNumbers;

    @FXML
    private Label callOfNumbers;

    @FXML
    private Label torrentialNumbers;

    @FXML
    private Label negateNumbers;

    @FXML
    private Label darkHoleNumbers;

    @FXML
    private Label forestNumbers;

    @FXML
    private Label messengerNumbers;

    @FXML
    private Label monsterRebornNumbers;

    @FXML
    private Label mysticalNumbers;

    @FXML
    private Label raigekiNumbers;

    @FXML
    private Label spellNumbers;

    @FXML
    private Label terraNumbers;

    @FXML
    private Label twinNumbers;

    @FXML
    private Label umirukaNumbers;

    @FXML
    private Label yamiNumbers;

    @FXML
    private TextField availableCoin;

    @FXML
    private Button back;


    @FXML
    void buyAlexCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Alexandrite Dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Alexandrite Dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            alexNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Alexandrite Dragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyAxeRaiderCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Axe Raider",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Axe Raider"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            axeNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Axe Raider")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyBabyDragonCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Baby dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Baby dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            babyNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Baby dragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyBattleOxCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Battle OX",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Battle OX"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            battleOxNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Battle OX")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyBattleWarriorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Battle warrior",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Battle warrior"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            battleWarriorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Battle warrior")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyBitronCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Bitron",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Bitron"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            bitronNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Bitron")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyBlueEyesCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Blue-Eyes white dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Blue-Eyes white dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            blueEyesNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Blue-Eyes white dragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyCalculatorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("The Calculator",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("The Calculator"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            calculatorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("The Calculator")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyCallOfHauntedCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Call of The Haunted",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Call of The Haunted"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            callOfNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Call of The Haunted")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyCommandKnightCard(MouseEvent event){
        if(!shopMenu.isMoneyEnough("Command Knight",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Command Knight"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            commandNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Command Knight")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyCrawlingCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Crawling dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Crawling dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            crawlingNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Crawling dragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyCurtainCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Curtain of the dark ones",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Curtain of the dark ones"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            curtainNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Curtain of the dark ones")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyDarkBladeCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark Blade",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Dark Blade"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            darkBladeNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark Blade")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyDarkHoleCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark Hole",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Dark Hole"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            darkHoleNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark Hole")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyDarkMagitionCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark magician",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Dark magician"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            darkMagitionNumber.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark magician")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyExploderCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Exploder Dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Exploder Dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            exploderNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Exploder Dragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyFeralCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Feral Imp",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Feral Imp"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            feralNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Feral Imp")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyFireYarouCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Fireyarou",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Fireyarou"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            fireYarouNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Fireyarou")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyFlameCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Flame manipulator",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Flame manipulator"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            flameNUmbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Flame manipulator")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyForestCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Forest",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Forest"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            forestNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Forest")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyHaniwaCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Haniwa",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Haniwa"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            haniwaNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Haniwa")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyHeroCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Hero of the east",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Hero of the east"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            heroNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Hero of the east")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyHornImpCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Horn Imp",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Horn Imp"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            hornNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Horn Imp")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyLeotronCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Leotron ",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Leotron "));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            leotronNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Leotron ")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyManEaterBugCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Man-Eater Bug",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Man-Eater Bug"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            manEaterNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Man-Eater Bug")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMarshmallonCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Marshmallon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Marshmallon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            marshmallonNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Marshmallon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMessengerCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Messenger of peace",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Messenger of peace"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            messengerNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Messenger of peace")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMindCrushCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mind Crush",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Mind Crush"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            mindCrushNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mind Crush")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMirrorForceCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mirror Force",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Mirror Force"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            mirrorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mirror Force")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMonsterRebornCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Monster Reborn",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Monster Reborn"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            monsterRebornNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Monster Reborn")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyMysticalCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mystical space typhoon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Mystical space typhoon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            mysticalNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mystical space typhoon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyNegateAttackCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Negate Attack",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Negate Attack"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            negateNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Negate Attack")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyRaigekiCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Raigeki",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Raigeki"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            raigekiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Raigeki")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buySilverCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Silver Fang",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Silver Fang"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            silverNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Silver Fang")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buySlotCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Slot Machine",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Slot Machine"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            slotNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Slot Machine")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buySpellAbsorptionCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Spell Absorption",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Spell Absorption"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            spellNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Spell Absorption")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buySpiralCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Spiral Serpent",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Spiral Serpent"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            spiralNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Spiral Serpent")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyTeraformingCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Terraforming",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Terraforming"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            terraNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Terraforming")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyTimeSealCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Time Seal",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Time Seal"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            timesealNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Time Seal")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyTorrentialCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Torrential Tribute",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Torrential Tribute"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            torrentialNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Torrential Tribute")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyTwinTwistersCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Twin Twisters",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Twin Twisters"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            twinNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Twin Twisters")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyUmirukaCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Umiiruka",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Umiiruka"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            umirukaNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Umiiruka")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyWarrirorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Warrior Dai Grepher",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Warrior Dai Grepher"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            warriorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Warrior Dai Grepher")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyWattailCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Wattaildragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Wattaildragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            wattiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Wattaildragon")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyWattkidCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Wattkid",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Wattkid"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            wattkidNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Wattkid")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyYamiCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Yami",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Yami"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            yamiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Yami")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }

    @FXML
    void buyYomiShipCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Yomi Ship",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.buyCard(Card.getCardByName("Yomi Ship"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            yomiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Yomi Ship")));
            availableCoin.setText(String.valueOf(player.getCoin()));
        }
        setButt();
    }
    private void addToAvailableCards(Label label){
        int x = Integer.parseInt(label.getText());
        label.setText(String.valueOf(x + 1));
        //label.setText(String.valueOf(player.numberOfCardsInAndOutDecks()));
    }

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //shopMenu = ShopMenu.getInstance();
        //player = Player.getLoggedPlayer();
        availableCoin.setText(String.valueOf(player.getCoin()));
        alexNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Alexandrite Dragon")));
        axeNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Axe Raider")));
        battleOxNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Battle OX")));
        babyNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Baby dragon")));
        battleWarriorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Battle warrior")));
        bitronNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Bitron")));
        blueEyesNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Blue-Eyes white dragon")));
        calculatorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("The Calculator")));
        callOfNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Call of The Haunted")));
        commandNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Command Knight")));
        crawlingNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Crawling dragon")));
        curtainNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Curtain of the dark ones")));
        darkBladeNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark Blade")));
        darkHoleNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark Hole")));
        darkMagitionNumber.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Dark magician")));
        exploderNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Exploder Dragon")));
        feralNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Feral Imp")));
        fireYarouNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Fireyarou")));
        flameNUmbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Flame manipulator")));
        forestNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Forest")));
        haniwaNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Haniwa")));
        heroNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Hero of the east")));
        hornNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Horn Imp")));
        leotronNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Leotron ")));
        manEaterNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Man-Eater Bug")));
        marshmallonNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Marshmallon")));
        messengerNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Messenger of peace")));
        mindCrushNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mind Crush")));
        mirrorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mirror Force")));
        monsterRebornNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Monster Reborn")));
        mysticalNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Mystical space typhoon")));
        negateNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Negate Attack")));
        raigekiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Raigeki")));
        silverNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Silver Fang")));
        slotNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Slot Machine")));
        spellNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Spell Absorption")));
        spiralNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Spiral Serpent")));
        terraNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Terraforming")));
        timesealNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Time Seal")));
        torrentialNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Torrential Tribute")));
        twinNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Twin Twisters")));
        umirukaNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Umiiruka")));
        warriorNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Warrior Dai Grepher")));
        wattiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Wattaildragon")));
        wattkidNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Wattkid")));
        yamiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Yami")));
        yomiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Yomi Ship")));
        setButt();
    }

    public void setButt(){

        if (player.getCoin()<Card.getCardByName("Command Knight").getPrice())
            CommandKnightBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Alexandrite Dragon").getPrice())
            alexandriteBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Axe Raider").getPrice())
            axeRaiderBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Baby dragon").getPrice())
            babyDragonBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Battle OX").getPrice())
            battleOxBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Battle warrior").getPrice())
            battleWarriorBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Bitron").getPrice())
            bitronBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Blue-Eyes white dragon").getPrice())
            blueEyesBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Crawling dragon").getPrice())
            crawlingDragonBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Curtain of the dark ones").getPrice())
            curtainBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Dark Blade").getPrice())
            darkBladeBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Dark magician").getPrice())
            darkMagitionBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Exploder Dragon").getPrice())
            exploderDragonBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Feral Imp").getPrice())
            feralBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Fireyarou").getPrice())
            fireYarouBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Flame manipulator").getPrice())
            flameBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Haniwa").getPrice())
            haniwaBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Hero of the east").getPrice())
            heroOfTheEastBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Horn Imp").getPrice())
            hornImpBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Leotron ").getPrice())
            leotronBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Man-Eater Bug").getPrice())
            manEaterBugBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Marshmallon").getPrice())
            marshmallonBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Silver Fang").getPrice())
            silverFangBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Slot Machine").getPrice())
            slotMachineBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Spiral Serpent").getPrice())
            spiralBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("The Calculator").getPrice())
            theCalculatorBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Warrior Dai Grepher").getPrice())
            warriorBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Wattaildragon").getPrice())
            wattailBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Wattkid").getPrice())
            wattkidBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Yomi Ship").getPrice())
            yomiShipBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Time Seal").getPrice())
            timeSealBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Mind Crush").getPrice())
            mindCrushBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Mirror Force").getPrice())
            mirrorForceBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Call of The Haunted").getPrice())
            callOfTheHauntedBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Torrential Tribute").getPrice())
            torrentialTributeBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Negate Attack").getPrice())
            negateAttackBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Dark Hole").getPrice())
            darkHoleBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Forest").getPrice())
            forestBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Messenger of peace").getPrice())
            messengerBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Monster Reborn").getPrice())
            monsterRebornBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Mystical space typhoon").getPrice())
            mysticalBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Raigeki").getPrice())
            raigekiBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Spell Absorption").getPrice())
            spellAbsorptionBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Terraforming").getPrice())
            terraformingBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Twin Twisters").getPrice())
            twinBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Umiiruka").getPrice())
            umirukaBuy.setDisable(true);
        if (player.getCoin()<Card.getCardByName("Yami").getPrice())
            yamiBuy.setDisable(true);
    }
}