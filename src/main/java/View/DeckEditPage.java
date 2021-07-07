package View;

import Model.Deck;
import Model.Player;
import Controller.DeckMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DeckEditPage {

    private String deckName;
    private String currentCardName;
    Player loggedPlayer = Player.getLoggedPlayer();
    private static DeckEditPage d = null;

    private DeckEditPage() {

    }

    public static DeckEditPage getInstance() {
        if (d == null)
            d = new DeckEditPage();
        return d;
    }

    @FXML
    private ImageView AlexandriteDragon;

    @FXML
    private ImageView AxeRaider;

    @FXML
    private ImageView BabyDragon;

    @FXML
    private ImageView BattleOX;

    @FXML
    private ImageView BattleWarrior;

    @FXML
    private ImageView Bitron;

    @FXML
    private ImageView BlueEyesWhiteDragon;

    @FXML
    private ImageView CommandKnight;

    @FXML
    private ImageView CrawlingDragon;

    @FXML
    private ImageView CurtainOfTheDarkOnes;

    @FXML
    private ImageView DarkBlade;

    @FXML
    private ImageView DarkMagician;

    @FXML
    private ImageView ExploderDragon;

    @FXML
    private ImageView FeralImp;

    @FXML
    private ImageView Fireyarou;

    @FXML
    private ImageView FlameManipulator;

    @FXML
    private ImageView Haniwa;

    @FXML
    private ImageView HeroOfTheEast;

    @FXML
    private ImageView HornImp;

    @FXML
    private ImageView Leotron;

    @FXML
    private ImageView ManEaterBug;

    @FXML
    private ImageView Marshmallon;

    @FXML
    private ImageView SilverFang;

    @FXML
    private ImageView SlotMachine;

    @FXML
    private ImageView SpiralSerpent;

    @FXML
    private ImageView TheCalculator;

    @FXML
    private ImageView WarriorDaiGrepher;

    @FXML
    private ImageView WattailDragon;

    @FXML
    private ImageView Wattkid;

    @FXML
    private ImageView YomiShip;

    @FXML
    private ImageView CallOfTheHaunted;

    @FXML
    private ImageView DarkHole;

    @FXML
    private ImageView Forest;

    @FXML
    private ImageView MessengerOfPeace;

    @FXML
    private ImageView MindCrush;

    @FXML
    private ImageView MirrorForce;

    @FXML
    private ImageView MonsterReborn;

    @FXML
    private ImageView MysticalSpaceTyphoon;

    @FXML
    private ImageView NegateAttack;

    @FXML
    private ImageView Raigeki;

    @FXML
    private ImageView SpellAbsorption;

    @FXML
    private ImageView Terraforming;

    @FXML
    private ImageView TimeSeal;

    @FXML
    private ImageView TorrentialTribute;

    @FXML
    private ImageView TwinTwisters;

    @FXML
    private ImageView Umiiruka;

    @FXML
    private ImageView Yami;

    @FXML
    private ImageView card;

    @FXML
    private Text available;

    @FXML
    private Text mainDeck;

    @FXML
    private Text sideDeck;

    @FXML
    private Button addMainDeck;

    @FXML
    private Button removeMainDeck;

    @FXML
    private Button addSideDeck;

    @FXML
    private Button removeSideDeck;

    //setImage
    //setText available
    //setText mainDeck
    //setText sideDeck
    public void AlexandriteDragon() {
        card.setImage(AlexandriteDragon.getImage());
        setTexts("Alexandrite Dragon");
        setCurrentCardName("Alexandrite Dragon");
    }

    public void AxeRaider() {
        card.setImage(AxeRaider.getImage());
        setTexts("Axe Raider");
        setCurrentCardName("Axe Raider");
    }

    public void BabyDragon() {
        card.setImage(BabyDragon.getImage());
        setTexts("Baby dragon");
        setCurrentCardName("Baby dragon");
    }

    public void BattleOX() {
        card.setImage(BattleOX.getImage());
        setTexts("Battle OX");
        setCurrentCardName("Battle OX");
    }

    public void BattleWarrior() {
        card.setImage(BattleWarrior.getImage());
        setTexts("Battle warrior");
        setCurrentCardName("Battle warrior");
    }

    public void Bitron() {
        card.setImage(Bitron.getImage());
        setTexts("Bitron");
        setCurrentCardName("Bitron");
    }

    public void BlueEyesWhiteDragon() {
        card.setImage(BlueEyesWhiteDragon.getImage());
        setTexts("Blue-Eyes white dragon");
        setCurrentCardName("Blue-Eyes white dragon");
    }

    public void CommandKnight() {
        card.setImage(CommandKnight.getImage());
        setTexts("Command Knight");
        setCurrentCardName("Command Knight");
    }

    public void CrawlingDragon() {
        card.setImage(CrawlingDragon.getImage());
        setTexts("Crawling dragon");
        setCurrentCardName("Crawling dragon");
    }

    public void CurtainOfTheDarkOnes() {
        card.setImage(CurtainOfTheDarkOnes.getImage());
        setTexts("Curtain of the dark ones");
        setCurrentCardName("Curtain of the dark ones");
    }

    public void DarkBlade() {
        card.setImage(DarkBlade.getImage());
        setTexts("Dark Blade");
        setCurrentCardName("Dark Blade");

    }

    public void DarkMagician() {
        card.setImage(DarkMagician.getImage());
        setTexts("Dark magician");
        setCurrentCardName("Dark magician");
    }

    public void ExploderDragon() {
        card.setImage(ExploderDragon.getImage());
        setTexts("Exploder Dragon");
        setCurrentCardName("Exploder Dragon");
    }

    public void FeralImp() {
        card.setImage(FeralImp.getImage());
        setTexts("Feral Imp");
        setCurrentCardName("Feral Imp");
    }

    public void Fireyarou() {
        card.setImage(Fireyarou.getImage());
        setTexts("Fireyarou");
        setCurrentCardName("Fireyarou");
    }

    public void FlameManipulator() {
        card.setImage(FlameManipulator.getImage());
        setTexts("Flame manipulator");
        setCurrentCardName("Flame manipulator");
    }

    public void Haniwa() {
        card.setImage(Haniwa.getImage());
        setTexts("Haniwa");
        setCurrentCardName("Haniwa");
    }

    public void HeroOfTheEast() {
        card.setImage(HeroOfTheEast.getImage());
        setTexts("Hero of the east");
        setCurrentCardName("Hero of the east");
    }

    public void HornImp() {
        card.setImage(HornImp.getImage());
        setTexts("Horn Imp");
        setCurrentCardName("Horn Imp");
    }

    public void Leotron() {
        card.setImage(Leotron.getImage());
        setTexts("Leotron");
        setCurrentCardName("Leotron");
    }

    public void ManEaterBug() {
        card.setImage(ManEaterBug.getImage());
        setTexts("Man-Eater Bug");
        setCurrentCardName("Man-Eater Bug");
    }

    public void Marshmallon() {
        card.setImage(Marshmallon.getImage());
        setTexts("Marshmallon");
        setCurrentCardName("Marshmallon");
    }

    public void SilverFang() {
        card.setImage(SilverFang.getImage());
        setTexts("Silver Fang");
        setCurrentCardName("Silver Fang");
    }

    public void SlotMachine() {
        card.setImage(SlotMachine.getImage());
        setTexts("Slot Machine");
        setCurrentCardName("Slot Machine");
    }

    public void SpiralSerpent() {
        card.setImage(SpiralSerpent.getImage());
        setTexts("Spiral Serpent");
        setCurrentCardName("Spiral Serpent");
    }

    public void TheCalculator() {
        card.setImage(TheCalculator.getImage());
        setTexts("The Calculator");
        setCurrentCardName("The Calculator");
    }

    public void WarriorDaiGrepher() {
        card.setImage(WarriorDaiGrepher.getImage());
        setTexts("Warrior Dai Grepher");
        setCurrentCardName("Warrior Dai Grepher");

    }

    public void WattailDragon() {
        card.setImage(WattailDragon.getImage());
        setTexts("Wattaildragon");
        setCurrentCardName("Wattaildragon");

    }

    public void Wattkid() {
        card.setImage(Wattkid.getImage());
        setTexts("Wattkid");
        setCurrentCardName("Wattkid");
    }

    public void YomiShip() {
        card.setImage(YomiShip.getImage());
        setTexts("Yomi Ship");
        setCurrentCardName("Yomi Ship");
    }

    public void CallOfTheHaunted() {
        card.setImage(CallOfTheHaunted.getImage());
        setTexts("Call of The Haunted");
        setCurrentCardName("Call of The Haunted");
    }

    public void DarkHole() {
        card.setImage(DarkHole.getImage());
        setTexts("Dark Hole");
        setCurrentCardName("Dark Hole");
    }

    public void Forest() {
        card.setImage(Forest.getImage());
        setTexts("Forest");
        setCurrentCardName("Forest");
    }

    public void MessengerOfPeace() {
        card.setImage(MessengerOfPeace.getImage());
        setTexts("Messenger of peace");
        setCurrentCardName("Messenger of peace");
    }

    public void MindCrush() {
        card.setImage(MindCrush.getImage());
        setTexts("Mind Crush");
        setCurrentCardName("Mind Crush");
    }

    public void MirrorForce() {
        card.setImage(MirrorForce.getImage());
        setTexts("Mirror Force");
        setCurrentCardName("Mirror Force");
    }

    public void MonsterReborn() {
        card.setImage(MonsterReborn.getImage());
        setTexts("Monster Reborn");
        setCurrentCardName("Monster Reborn");
    }

    public void MysticalSpaceTyphoon() {
        card.setImage(MysticalSpaceTyphoon.getImage());
        setTexts("Mystical space typhoon");
        setCurrentCardName("Mystical space typhoon");
    }

    public void NegateAttack() {
        card.setImage(NegateAttack.getImage());
        setTexts("Negate Attack");
        setCurrentCardName("Negate Attack");
    }

    public void Raigeki() {
        card.setImage(Raigeki.getImage());
        setTexts("Raigeki");
        setCurrentCardName("Raigeki");
    }

    public void SpellAbsorption() {
        card.setImage(SpellAbsorption.getImage());
        setTexts("Spell Absorption");
        setCurrentCardName("Spell Absorption");
    }

    public void Terraforming() {
        card.setImage(Terraforming.getImage());
        setTexts("Terraforming");
        setCurrentCardName("Terraforming");
    }

    public void TimeSeal() {
        card.setImage(TimeSeal.getImage());
        setTexts("Time Seal");
        setCurrentCardName("Time Seal");
    }

    public void TorrentialTribute() {
        card.setImage(TorrentialTribute.getImage());
        setTexts("Torrential Tribute");
        setCurrentCardName("Torrential Tribute");
    }

    public void TwinTwisters() {
        card.setImage(TwinTwisters.getImage());
        setTexts("Twin Twisters");
        setCurrentCardName("Twin Twisters");
    }

    public void Yami() {
        card.setImage(Yami.getImage());
        setTexts("Yami");
        setCurrentCardName("Yami");
    }

    public void Umiiruka() {
        card.setImage(Umiiruka.getImage());
        setTexts("Umiiruka");
        setCurrentCardName("Umiiruka");
    }

    public void setTexts(String cardName){
        available.setText("available : " + loggedPlayer.numberOfSpecialCard(cardName));
        sideDeck.setText("sideDeck : " + Deck.getDeckByName(deckName,loggedPlayer).numberOfSpecialCardInSideDeck(cardName));
        mainDeck.setText("mainDeck : " + Deck.getDeckByName(deckName,loggedPlayer).numberOfSpecialCardInMainDeck(cardName));

    }

    public void addMainDeck(){
        DeckMenu.getInstance().addCardToMainDeck(getCurrentCardName(),getDeckName(),loggedPlayer);
    }

    public void addSideDeck(){
        DeckMenu.getInstance().addCardToSideDeck(getCurrentCardName(),getDeckName(),loggedPlayer);
    }

    public void removeMainDeck(){
        DeckMenu.getInstance().removeCardFromMainDeck(getCurrentCardName(),getDeckName(),loggedPlayer);
    }

    public void removeSideDeck(){
        DeckMenu.getInstance().removeCardFromSideDeck(getCurrentCardName(),getDeckName(),loggedPlayer);
    }

    public  void setDeckName(String deckname){
        this.deckName = deckname;
    }

    public String getDeckName(){
        return deckName;
    }

    public void setCurrentCardName(String cardName){
        this.currentCardName = cardName;
    }

    public String getCurrentCardName(){
        return currentCardName;
    }

}