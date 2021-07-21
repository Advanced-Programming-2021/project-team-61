package View;

//import Model.Card;
import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import Controller.AppController;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopPage implements Initializable {
    public Label commandNumbers;
    public Label alexNumbers;
    public Label axeNumbers;
    public Label babyNumbers;
    public Label battleOxNumbers;
    public Label battleWarriorNumbers;
    public Label bitronNumbers;
    public Label blueEyesNumbers;
    public Label crawlingNumbers;
    public Label curtainNumbers;
    public Label darkBladeNumbers;
    public Label darkMagitionNumber;
    public Label exploderNumbers;
    public Label feralNumbers;
    public Label fireYarouNumbers;
    public Label flameNUmbers;
    public Label haniwaNumbers;
    public Label heroNumbers;
    public Label hornNumbers;
    public Label leotronNumbers;
    public Label manEaterNumbers;
    public Label marshmallonNumbers;
    public Label silverNumbers;
    public Label slotNumbers;
    public Label spiralNumbers;
    public Label calculatorNumbers;
    public Label warriorNumbers;
    public Label wattiNumbers;
    public Label wattkidNumbers;
    public Label yomiNumbers;
    public Label timesealNumbers;
    public Label mindCrushNumbers;
    public Label mirrorNumbers;
    public Label callOfNumbers;
    public Label torrentialNumbers;
    public Label negateNumbers;
    public Label darkHoleNumbers;
    public Label forestNumbers;
    public Label messengerNumbers;
    public Label monsterRebornNumbers;
    public Label mysticalNumbers;
    public Label raigekiNumbers;
    public Label spellNumbers;
    public Label terraNumbers;
    public Label twinNumbers;
    public Label umirukaNumbers;
    public Label yamiNumbers;
    public TextField availableCoin;
    private Player player = Player.getLoggedPlayer();

    private ShopClientController shopClientController;
    private static Socket shopSocket;
    JFrame f;

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

   /* @FXML
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
    private Label yamiNumbers;*/

  /*  @FXML
    private TextField availableCoin;*/

    @FXML
    private Button back;

    @FXML
    private Button adminPanel;


    @FXML
    void buyAlexCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Alexandrite Dragon#"+AppController.getToken());

        //   StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyAxeRaiderCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Axe Raider#"+AppController.getToken());
        //  StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyBabyDragonCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Baby dragon#"+AppController.getToken());
        // StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyBattleOxCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Battle OX#"+AppController.getToken());
        //  StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyBattleWarriorCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Battle warrior#"+AppController.getToken());
        //   StartPage.click.play();



            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyBitronCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Bitron#"+AppController.getToken());
        //  StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");

        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyBlueEyesCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Blue-Eyes white dragon#"+AppController.getToken());
        // StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyCalculatorCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #The Calculator#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyCallOfHauntedCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Call of The Haunted#"+AppController.getToken());
        //  StartPage.click.play();



            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyCommandKnightCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Command Knight#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");


        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyCrawlingCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Crawling dragon#"+AppController.getToken());
        //  StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyCurtainCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Curtain of the dark ones#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyDarkBladeCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Dark Blade#"+AppController.getToken());
        // StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");

        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyDarkHoleCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Dark Hole#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyDarkMagitionCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Dark magician#"+AppController.getToken());
        //StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyExploderCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Exploder Dragon#"+AppController.getToken());
        //StartPage.click.play();



            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyFeralCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Feral Imp#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyFireYarouCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Fireyarou#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyFlameCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Flame manipulator#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyForestCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Forest#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyHaniwaCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Haniwa#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyHeroCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Hero of the east#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyHornImpCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Horn Imp#"+AppController.getToken());
        //StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyLeotronCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Leotron#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyManEaterBugCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Man-Eater Bug#"+AppController.getToken());
        //  StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMarshmallonCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Marshmallon#"+AppController.getToken());
        //   StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMessengerCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Messenger of peace#"+AppController.getToken());
        // StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMindCrushCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Mind Crush#"+AppController.getToken());
        //StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMirrorForceCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Mirror Force#"+AppController.getToken());
        //StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMonsterRebornCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Monster Reborn#"+AppController.getToken());
        // StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyMysticalCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Mystical space typhoon#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyNegateAttackCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Negate Attack#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyRaigekiCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Raigeki#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buySilverCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Silver Fang#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buySlotCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Slot Machine#"+AppController.getToken());
        // StartPage.click.play();
            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");

        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buySpellAbsorptionCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Spell Absorption#"+AppController.getToken());
        // StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buySpiralCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Spiral Serpent#"+AppController.getToken());
        //StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyTeraformingCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Terraforming#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyTimeSealCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Time Seal#"+AppController.getToken());
        //StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyTorrentialCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Torrential Tribute#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyTwinTwistersCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Twin Twisters#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyUmirukaCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Umiiruka#"+AppController.getToken());
        //  StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyWarrirorCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Warrior Dai Grepher#"+AppController.getToken());
        // StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyWattailCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Wattaildragon#"+AppController.getToken());
        // StartPage.click.play();


            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyWattkidCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Wattkid#"+AppController.getToken());
        // StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyYamiCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Yami#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }

    @FXML
    void buyYomiShipCard(MouseEvent event) throws IOException {
        shopClientController.sendMessage("buy card #Yomi Ship#"+AppController.getToken());
        //  StartPage.click.play();

            JOptionPane.showConfirmDialog(null,"Card added successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Card added successfully");
        int coins = shopClientController.getCoins("give coins#"+AppController.getToken());
        setButt(coins);
    }
    private void addToAvailableCards(Label label){
        int x = Integer.parseInt(label.getText());
        label.setText(String.valueOf(x + 1));
        //label.setText(String.valueOf(player.numberOfCardsInAndOutDecks()));
    }

    public void back() throws IOException {
        // StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    public void adminPanel() throws IOException {
        OptionPaneExample();
    }

    private void OptionPaneExample() throws IOException {
        f=new JFrame();
        String name=JOptionPane.showInputDialog(f,"Enter Password:");
        if (name.equals("9999")) {
            JOptionPane.showConfirmDialog(null, "password is correct...", "Message", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            Logic.viewManager.changeScene("sample/shopAdminPage.fxml");
        }
        else
            JOptionPane.showConfirmDialog(null,"password is wrong...","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            shopSocket = new Socket("localhost", 7778);
            shopClientController = new ShopClientController(shopSocket);
            Thread thread = new Thread(shopClientController);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //shopMenu = ShopMenu.getInstance();
        //player = Player.getLoggedPlayer();
        availableCoin.setText(String.valueOf(player.getCoin()));
       /* alexNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Alexandrite Dragon")));
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
        leotronNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Leotron")));
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
        yomiNumbers.setText(String.valueOf(player.numberOfCardsInAndOutDecks("Yomi Ship")));*/
        int coins = 0;
        try {
            coins = shopClientController.getCoins("give coins#"+ AppController.getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setButt(coins);
    }

    public void setButt(int coins){
      //if(coins < Card.getCardByName(.....).getPrice
        if (coins < Card.getCardByName("Command Knight").getPrice())
            CommandKnightBuy.setDisable(true);
        if (coins < Card.getCardByName("Alexandrite Dragon").getPrice())
            alexandriteBuy.setDisable(true);
        if (coins < Card.getCardByName("Axe Raider").getPrice())
            axeRaiderBuy.setDisable(true);
        if (coins < Card.getCardByName("Baby dragon").getPrice())
            babyDragonBuy.setDisable(true);
        if (coins < Card.getCardByName("Battle OX").getPrice())
            battleOxBuy.setDisable(true);
        if (coins < Card.getCardByName("Battle warrior").getPrice())
            battleWarriorBuy.setDisable(true);
        if (coins < Card.getCardByName("Bitron").getPrice())
            bitronBuy.setDisable(true);
        if (coins < Card.getCardByName("Blue-Eyes white dragon").getPrice())
            blueEyesBuy.setDisable(true);
        if (coins < Card.getCardByName("Crawling dragon").getPrice())
            crawlingDragonBuy.setDisable(true);
        if (coins < Card.getCardByName("Curtain of the dark ones").getPrice())
            curtainBuy.setDisable(true);
        if (coins < Card.getCardByName("Dark Blade").getPrice())
            darkBladeBuy.setDisable(true);
        if (coins < Card.getCardByName("Dark magician").getPrice())
            darkMagitionBuy.setDisable(true);
        if (coins < Card.getCardByName("Exploder Dragon").getPrice())
            exploderDragonBuy.setDisable(true);
        if (coins < Card.getCardByName("Feral Imp").getPrice())
            feralBuy.setDisable(true);
        if (coins < Card.getCardByName("Fireyarou").getPrice())
            fireYarouBuy.setDisable(true);
        if (coins < Card.getCardByName("Flame manipulator").getPrice())
            flameBuy.setDisable(true);
        if (coins < Card.getCardByName("Haniwa").getPrice())
            haniwaBuy.setDisable(true);
        if (coins < Card.getCardByName("Hero of the east").getPrice())
            heroOfTheEastBuy.setDisable(true);
        if (coins < Card.getCardByName("Horn Imp").getPrice())
            hornImpBuy.setDisable(true);
        if (coins < Card.getCardByName("Leotron").getPrice())
            leotronBuy.setDisable(true);
        if (coins < Card.getCardByName("Man-Eater Bug").getPrice())
            manEaterBugBuy.setDisable(true);
        if (coins < Card.getCardByName("Marshmallon").getPrice())
            marshmallonBuy.setDisable(true);
        if (coins < Card.getCardByName("Silver Fang").getPrice())
            silverFangBuy.setDisable(true);
        if (coins < Card.getCardByName("Slot Machine").getPrice())
            slotMachineBuy.setDisable(true);
        if (coins < Card.getCardByName("Spiral Serpent").getPrice())
            spiralBuy.setDisable(true);
        if (coins < Card.getCardByName("The Calculator").getPrice())
            theCalculatorBuy.setDisable(true);
        if (coins < Card.getCardByName("Warrior Dai Grepher").getPrice())
            warriorBuy.setDisable(true);
        if (coins < Card.getCardByName("Wattaildragon").getPrice())
            wattailBuy.setDisable(true);
        if (coins < Card.getCardByName("Wattkid").getPrice())
            wattkidBuy.setDisable(true);
        if (coins < Card.getCardByName("Yomi Ship").getPrice())
            yomiShipBuy.setDisable(true);
        if (coins < Card.getCardByName("Time Seal").getPrice())
            timeSealBuy.setDisable(true);
        if (coins < Card.getCardByName("Mind Crush").getPrice())
            mindCrushBuy.setDisable(true);
        if (coins < Card.getCardByName("Mirror Force").getPrice())
            mirrorForceBuy.setDisable(true);
        if (coins < Card.getCardByName("Call of The Haunted").getPrice())
            callOfTheHauntedBuy.setDisable(true);
        if (coins < Card.getCardByName("Torrential Tribute").getPrice())
            torrentialTributeBuy.setDisable(true);
        if (coins < Card.getCardByName("Negate Attack").getPrice())
            negateAttackBuy.setDisable(true);
        if (coins < Card.getCardByName("Dark Hole").getPrice())
            darkHoleBuy.setDisable(true);
        if (coins < Card.getCardByName("Forest").getPrice())
            forestBuy.setDisable(true);
        if (coins < Card.getCardByName("Messenger of peace").getPrice())
            messengerBuy.setDisable(true);
        if (coins < Card.getCardByName("Monster Reborn").getPrice())
            monsterRebornBuy.setDisable(true);
        if (coins < Card.getCardByName("Mystical space typhoon").getPrice())
            mysticalBuy.setDisable(true);
        if (coins < Card.getCardByName("Raigeki").getPrice())
            raigekiBuy.setDisable(true);
        if (coins < Card.getCardByName("Spell Absorption").getPrice())
            spellAbsorptionBuy.setDisable(true);
        if (coins < Card.getCardByName("Terraforming").getPrice())
            terraformingBuy.setDisable(true);
        if (coins < Card.getCardByName("Twin Twisters").getPrice())
            twinBuy.setDisable(true);
        if (coins < Card.getCardByName("Umiiruka").getPrice())
            umirukaBuy.setDisable(true);
        if (coins < Card.getCardByName("Yami").getPrice())
            yamiBuy.setDisable(true);
    }
    public Label getLabelByCardName(String cardName){
        switch (cardName){
            case "Command Knight" : {
                return commandNumbers;
            }
            case "Alexandrite Dragon":{
                return alexNumbers;
            }
            case "Axe Raider" : {
                return axeNumbers;
            }
            case "Baby dragon" : {
                return babyNumbers;
            }
            case "Battle OX" : {
                return battleOxNumbers;
            }
            case "Battle warrior" : {
                return battleWarriorNumbers;
            }
            case "Bitron" : {
                return bitronNumbers;
            }
            case "Blue-Eyes white dragon" : {
                return blueEyesNumbers;
            }
            case "Crawling dragon" : {
                return crawlingNumbers;
            }
            case "Curtain of the dark ones" : {
                return curtainNumbers;
            }
            case "Dark Blade" : {
                return darkBladeNumbers;
            }
            case "Dark magician" : {
                return darkMagitionNumber;
            }
            case "Exploder Dragon" : {
                return exploderNumbers;
            }
            case "Feral Imp" : {
                return feralNumbers;
            }
            case "Fireyarou" : {
                return fireYarouNumbers;
            }
            case "Flame manipulator" : {
                return flameNUmbers;
            }
            case "Haniwa" : {
                return haniwaNumbers;
            }
            case "Hero of the east" : {
                return heroNumbers;
            }
            case "Horn Imp" : {
                return hornNumbers;
            }
            case "Leotron" : {
                return leotronNumbers;
            }
            case "Man-Eater Bug" : {
                return manEaterNumbers;
            }
            case "Marshmallon" : {
                return marshmallonNumbers;
            }
            case "Silver Fang" : {
                return silverNumbers;
            }
            case "Slot Machine" : {
                return slotNumbers;
            }
            case "Spiral Serpent" : {
                return spiralNumbers;
            }
            case "The Calculator" : {
                return calculatorNumbers;
            }
            case "Warrior Dai Grepher" : {
                return warriorNumbers;
            }
            case "Wattaildragon" : {
                return wattiNumbers;
            }
            case "Wattkid" : {
                return wattkidNumbers;
            }
            case "Yomi Ship" : {
                return yomiNumbers;
            }
            case "Time Seal" : {
                return timesealNumbers;
            }
            case "Mind Crush" : {
                return mindCrushNumbers;
            }
            case "Mirror Force" : {
                return mirrorNumbers;
            }
            case "Call of The Haunted" : {
                return callOfNumbers;
            }
            case "Torrential Tribute" : {
                return torrentialNumbers;
            }
            case "Negate Attack" : {
                return negateNumbers;
            }
            case "Dark Hole" : {
                return darkHoleNumbers;
            }
            case "Forest" : {
                return forestNumbers;
            }
            case "Messenger of peace" : {
                return messengerNumbers;
            }
            case "Monster Reborn" : {
                return monsterRebornNumbers;
            }
            case "Mystical space typhoon" : {
                return mysticalNumbers;
            }
            case "Raigeki" : {
                return raigekiNumbers;
            }
            case "Spell Absorption" : {
                return spellNumbers;
            }
            case "Terraforming" : {
                return terraNumbers;
            }
            case "Twin Twisters" : {
                return twinNumbers;
            }
            case "Umiiruka" : {
                return umirukaNumbers;
            }
            case "Yami" : {
                return yamiNumbers;
            }
            default:
                return null;
        }
    }
    public ShopClientController getShopClientController(){
        return shopClientController;
    }
}