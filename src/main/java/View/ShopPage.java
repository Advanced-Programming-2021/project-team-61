package View;

import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import Controller.ShopMenu;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopPage implements Initializable {
    private ShopMenu shopMenu;
    private Player player;

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
    void buyAlexCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Alexandrite Dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Alexandrite Dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(alexNumbers);
        }


    }

    @FXML
    void buyAxeRaiderCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Axe Raider",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Axe Raider"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(axeNumbers);
        }


    }

    @FXML
    void buyBabyDragonCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Baby dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Baby dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(babyNumbers);
        }

    }

    @FXML
    void buyBattleOxCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Battle OX",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Battle OX"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(battleOxNumbers);

        }


    }

    @FXML
    void buyBattleWarriorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Battle warrior",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Battle warrior"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(battleWarriorNumbers);
        }


    }

    @FXML
    void buyBitronCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Bitron",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Bitron"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(bitronNumbers);
        }

    }

    @FXML
    void buyBlueEyesCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Blue-Eyes white dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Blue-Eyes white dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(blueEyesNumbers);
        }

    }

    @FXML
    void buyCalculatorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("The Calculator",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("The Calculator"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(calculatorNumbers);
        }

    }

    @FXML
    void buyCallOfHauntedCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Call of The Haunted",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Call of The Haunted"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(callOfNumbers);
        }

    }

    @FXML
    void buyCommandKnightCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Command Knight",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Command Knight"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(commandNumbers);
        }

    }

    @FXML
    void buyCrawlingCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Crawling dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Crawling dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(crawlingNumbers);
        }

    }

    @FXML
    void buyCurtainCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Curtain of the dark ones",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Curtain of the dark ones"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(curtainNumbers);
        }

    }

    @FXML
    void buyDarkBladeCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark Blade",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Dark Blade"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(darkBladeNumbers);
        }

    }

    @FXML
    void buyDarkHoleCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark Hole",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Dark Hole"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(darkHoleNumbers);
        }

    }

    @FXML
    void buyDarkMagitionCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Dark magician",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Dark magician"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(darkMagitionNumber);
        }

    }

    @FXML
    void buyExploderCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Exploder Dragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Exploder Dragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(exploderNumbers);
        }

    }

    @FXML
    void buyFeralCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Feral Imp",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Feral Imp"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(feralNumbers);
        }

    }

    @FXML
    void buyFireYarouCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Fireyarou",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Fireyarou"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(fireYarouNumbers);
        }

    }

    @FXML
    void buyFlameCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Flame manipulator",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Flame manipulator"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(flameNUmbers);
        }

    }

    @FXML
    void buyForestCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Forest",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Forest"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(forestNumbers);
        }

    }

    @FXML
    void buyHaniwaCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Haniwa",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Haniwa"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(haniwaNumbers);
        }

    }

    @FXML
    void buyHeroCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Hero of the east",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Hero of the east"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(heroNumbers);
        }

    }

    @FXML
    void buyHornImpCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Horn Imp",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Horn Imp"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(hornNumbers);
        }

    }

    @FXML
    void buyLeotronCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Leotron ",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Leotron "));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(leotronNumbers);
        }

    }

    @FXML
    void buyManEaterBugCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Man-Eater Bug",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Man-Eater Bug"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(manEaterNumbers);
        }

    }

    @FXML
    void buyMarshmallonCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Marshmallon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Marshmallon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(marshmallonNumbers);
        }

    }

    @FXML
    void buyMessengerCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Messenger of peace",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Messenger of peace"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(messengerNumbers);
        }

    }

    @FXML
    void buyMindCrushCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mind Crush",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Mind Crush"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(mindCrushNumbers);
        }

    }

    @FXML
    void buyMirrorForceCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mirror Force",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Mirror Force"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(mirrorNumbers);
        }

    }

    @FXML
    void buyMonsterRebornCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Monster Reborn",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Monster Reborn"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(monsterRebornNumbers);
        }

    }

    @FXML
    void buyMysticalCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Mystical space typhoon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Mystical space typhoon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(mysticalNumbers);
        }

    }

    @FXML
    void buyNegateAttackCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Negate Attack",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Negate Attack"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(negateNumbers);
        }

    }

    @FXML
    void buyRaigekiCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Raigeki",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Raigeki"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(raigekiNumbers);
        }

    }

    @FXML
    void buySilverCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Silver Fang",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Silver Fang"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(silverNumbers);
        }

    }

    @FXML
    void buySlotCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Slot Machine",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Slot Machine"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(slotNumbers);
        }

    }

    @FXML
    void buySpellAbsorptionCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Spell Absorption",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Spell Absorption"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(spellNumbers);
        }

    }

    @FXML
    void buySpiralCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Spiral Serpent",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Spiral Serpent"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(spiralNumbers);
        }

    }

    @FXML
    void buyTeraformingCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Terraforming",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Terraforming"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(terraNumbers);
        }

    }

    @FXML
    void buyTimeSealCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Time Seal",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Time Seal"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(timesealNumbers);
        }

    }

    @FXML
    void buyTorrentialCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Torrential Tribute",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Torrential Tribute"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(torrentialNumbers);
        }

    }

    @FXML
    void buyTwinTwistersCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Twin Twisters",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Twin Twisters"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(twinNumbers);
        }

    }

    @FXML
    void buyUmirukaCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Umiiruka",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Umiiruka"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(umirukaNumbers);
        }

    }

    @FXML
    void buyWarrirorCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Warrior Dai Grepher",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Warrior Dai Grepher"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(warriorNumbers);
        }

    }

    @FXML
    void buyWattailCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Wattaildragon",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Wattaildragon"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(wattiNumbers);
        }

    }

    @FXML
    void buyWattkidCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Wattkid",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Wattkid"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(wattkidNumbers);
        }

    }

    @FXML
    void buyYamiCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Yami",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Yami"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(yamiNumbers);
        }

    }

    @FXML
    void buyYomiShipCard(MouseEvent event) {
        if(!shopMenu.isMoneyEnough("Yomi Ship",player)){
            JOptionPane.showConfirmDialog(null,"no enough money","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("no enough money");
        }
        else{
            player.addCard(Card.getCardByName("Yomi Ship"));
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
            addToAvailableCards(yomiNumbers);
        }

    }
    private void addToAvailableCards(Label label){
        int x = Integer.parseInt(label.getText());
        label.setText(String.valueOf(x + 1));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        shopMenu = ShopMenu.getInstance();
        player = Player.getLoggedPlayer();

    }
}