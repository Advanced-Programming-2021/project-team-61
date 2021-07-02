package Model;

import Controller.MainPhase1;
import View.GameView;


import java.util.ArrayList;

public class Card {

    private static Player player;
    private static Player rivalPlayer;
    protected String cardName;
    protected String cardType;
    protected String description;
    protected int price;
    protected boolean isSelected = false;
    protected static ArrayList<Card> allCards = new ArrayList<>();


    protected Card(String cardName, String cardType, String description, int price) {
        this.cardName = cardName;
        this.cardType = cardType;
        this.description = description;
        this.price = price;
    }

    public static boolean isCardAvailable(String cardName) {
        for (int i = 0; i < allCards.size(); i++) {
            if (allCards.get(i).cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getPrice() {
        return price;
    }

    public String getCardName() {
        return cardName;
    }

    public static Card getCardByName(String cardName) {
        for (int i = 0; i < allCards.size(); i++) {
            if (allCards.get(i).cardName.equals(cardName))
                return allCards.get(i);
        }
        return null;
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDescription() {
        return description;
    }

    public static void doDescription(String cardName, Player player1, Player player2) {
        player = player1;
        rivalPlayer = player2;
        switch (cardName) {
            case "Battle OX":
            case "Horn Imp":
            case "Silver Fang":
            case "Fireyarou":
            case "Curtain of the dark ones":
            case "Feral Imp":
            case "Dark magician":
            case "Wattkid":
            case "Baby dragon":
            case "Hero of the east":
            case "Battle warrior":
            case "Crawling dragon":
            case "Flame manipulator":
            case "Blue-Eyes white dragon":
            case "Slot Machine":
            case "Haniwa":
            case "Bitron":
            case "Leotron":
            case "Alexandrite Dragon":
            case "Warrior Dai Grepher":
            case "Dark Blade":
            case "Wattaildragon":
            case "Spiral Serpent":
            case "Axe Raider": {//***
                break;
            }
            case "Yomi Ship": {
                yomiShip(player);
                break;
            }
            case "Suijin": {
                suijin();
                break;
            }
            case "Crab Turtle": {
                crabTurtle();
                break;
            }
            case "Skull Guardian": {
                skullGuardian();
                break;
            }
            case "Man-Eater Bug": {
                man_EaterBug();
                break;
            }
            case "Gate Guardian": {
                gateGuardian();
                break;
            }
            case "Scanner": {
                scanner();
                break;
            }
            case "Marshmallon": {
                marshmallon();
                break;
            }
            case "Beast King Barbaros": {
                beastKingBarbaros();
                break;
            }
            case "Texchanger": {
                texchanger();
                break;
            }
            case "The Calculator": {
                theCalculator();
                break;
            }
            case "Mirage Dragon": {
                mirageDragon();
                break;
            }
            case "Herald of Creation": {
                heraldofCreation();
                break;
            }
            case "Exploder Dragon": {
                exploderDragon();
                break;
            }
            case "Terratiger, the Empowered Warrior": {
                terratigeTheEmpoweredWarrior();
                break;
            }
            case "The Tricky": {
                theTricky();
                break;
            }
            case "Command Knight": {
              //  commandKnight(player);
                break;
            }
            case "Trap Hole": {
                break;
            }
            case "Mirror Force": {
                break;
            }
            case "Magic Cylinder": {
                magicCylinder();
                break;
            }
            case "Mind Crush": {
                mindCrush();
                break;
            }
            case "Torrential Tribute": {
                torrentialTribute();
                break;
            }
            case "Time Seal": {
                break;
            }
            case "Negate Attack": {
                negateAttack();
                break;
            }
            case "Solemn Warning": {
                solemnWarning();
                break;
            }
            case "Magic Jamamer": {
                magicJamamer();
                break;
            }
            case "Call of The Haunted": {
                break;
            }
            case "Vanity's Emptiness": {
                vanityEmptiness();
                break;
            }
            case "Wall of Revealing Light": {
                wallofRevealingLight();
                break;
            }
            case "Monster Reborn": {
                monsterReborn();
                break;
            }
            case "Terraforming": {
                terraforming();
                break;
            }
            case "Pot of Greed": {
                potOfGreed();
                break;
            }
            case "Raigeki": {
                raigeki();
                break;
            }
            case "Change of Heart": {
                changeOfHeart();
                break;
            }
            case "Swords of Revealing Light": {
                swordsOfRevealingLight();
                break;
            }
            case "Harpie's Feather Duster": {
                harpieFeatherDuster();
                break;
            }
            case "Dark Hole": {
                darkHole();
                break;
            }
            case "Supply Squad": {
                supplySquad();
                break;
            }
            case "Spell Absorption": {
                spellAbsorption();
                break;
            }
            case "Messenger of peace": {
                messengerOfPeace();
                break;
            }
            case "Twin Twisters": {
                twinTwisters();
                break;
            }
            case "Mystical space typhoon": {
                mysticalSpaceTyphoon();
                break;
            }
            case "Ring of defense": {
                ringOfDefense();
                break;
            }
            case "Yami": {
                yami();
                break;
            }
            case "Forest": {
                forest();
                break;
            }
            case "Closed Forest": {
                closedForest();
                break;
            }
            case "Umiiruka": {
                umiiruka();
                break;
            }
            case "Sword of dark destruction": {
                swordOfDarkDestruction();
                break;
            }
            case "Black Pendant": {
                blackPendant();
                break;
            }
            case "United We Stand": {
                unitedWeStand();
                break;
            }
            case "Magnum Shield": {
                magnumShield();
                break;
            }
            case "Advanced Ritual Art": {
                advancedRitualArt();
                break;
            }
            default:
                break;
        }
    }


    public static void yomiShip(Player player) {


    }

    private static void suijin() {

    }

    private static void crabTurtle() {

    }

    private static void skullGuardian() {

    }

    private static void man_EaterBug() {

    }

    private static void gateGuardian() {

    }

    private static void scanner() {

    }

    private static void marshmallon() {

    }

    private static void beastKingBarbaros() {

    }

    private static void texchanger() {

    }

    private static void theCalculator() {

    }

    private static void mirageDragon() {

    }

    private static void heraldofCreation() {

    }

    private static void exploderDragon() {

    }

    private static void terratigeTheEmpoweredWarrior() {

    }

    private static void theTricky() {

    }

    public static void activateCommandKnightEffect(Board board) {  //monster
      //  Board board = Board.getBoardByPlayer(player);
        for(int i = 0 ; i < 5; i++){
            if(board.isMonsterAvailableInMonsterZone(i)){
                board.getMonsterByIndex(i).increaseExtraAttackPoint(400);
            }
        }
    }

    private static void trapHole(Board rivalBoard, MonsterField monsterField) {
        monsterField.removeMonsterField();


    }

    public static void activateMirrorForceEffect(Board myBoard) { //trap
        myBoard.destroyAllMonsterInAttack();
    }

    private static void magicCylinder() {

    }

    private static void mindCrush() {  //trap
        GameView.getInstance().printMessage(GameView.Command.ENTERTHECARDNAME);
        String cardNameToDestroy = GameView.getInstance().scan();
        if (Board.getBoardByPlayer(rivalPlayer).isThisCardInHand_ByName(cardNameToDestroy)) {
            Board.getBoardByPlayer(rivalPlayer).destroyAllSpecialCardForPlayer(cardNameToDestroy);
        } else {
            int a = (int) (Math.random() * (Board.getBoardByPlayer(player).getHand().size() + 1));//create random number to remove card from hand
            Board.getBoardByPlayer(player).destroyCard(Board.getBoardByPlayer(player).getHand().get(a));
        }
    }

    private static void torrentialTribute() {  //trap
        Board.getBoardByPlayer(rivalPlayer).destroyAllMonster();
    }

    public static void activateTimeSealEffect(Board rivalBoard) {  //trap
        rivalBoard.setCanGetCardFromDeck(false);
    }

    private static void negateAttack() {

    }

    private static void solemnWarning() {

    }

    private static void magicJamamer() {

    }

    public static void activateCallOfTheHauntedEffect(Board board) {  //trap
        GameView.getInstance().printGraveyard(Board.getBoardByPlayer(player).getGraveYard());
        GameView.getInstance().printMessage(GameView.Command.pleaseEnterTheCardNumber);
        int cardNumber ;//= Integer.parseInt(GameView.getInstance().scan());
        while (true){
            cardNumber = Integer.parseInt(GameView.getInstance().scan());
            if (!(Board.getBoardByPlayer(player).getGraveYard().get(cardNumber - 1) instanceof MonsterCard)) {
                GameView.getInstance().printMessage(GameView.Command.NOTBESUMMONED);
                GameView.getInstance().printMessage(GameView.Command.pleaseEnterTheCardNumber);
            }
            else
                break;
        }
        MainPhase1.getInstance().summonMonster(Board.getBoardByPlayer(player),(MonsterCard) Board.getBoardByPlayer(player).getGraveYard().get(cardNumber - 1));
        GameView.getInstance().printMessage(GameView.Command.SUMMONSUCCESSFUL);
    }


    private static void vanityEmptiness() {

    }

    private static void wallofRevealingLight() {

    }

    private static void monsterReborn() {

    }

    private static void terraforming() {

    }

    private static void potOfGreed() {

    }

    private static void raigeki() {  //spell
        Board.getBoardByPlayer(rivalPlayer).destroyAllMonster();
    }

    private static void changeOfHeart() {

    }

    private static void swordsOfRevealingLight() {

    }

    private static void harpieFeatherDuster() {  //spell
        Board.getBoardByPlayer(rivalPlayer).destroyAllSpell();
        Board.getBoardByPlayer(rivalPlayer).destroyAllTrap();
    }

    private static void darkHole() { //spell
        Board.getBoardByPlayer(player).destroyAllMonster();
        Board.getBoardByPlayer(rivalPlayer).destroyAllMonster();
    }

    private static void supplySquad() {

    }

    private static void spellAbsorption() {

    }

    private static void messengerOfPeace() {

    }

    private static void twinTwisters() {

    }

    private static void mysticalSpaceTyphoon() {

    }

    private static void ringOfDefense() {

    }

    private static void yami() {

    }

    private static void forest() {

    }

    private static void closedForest() {

    }

    private static void umiiruka() {

    }

    private static void swordOfDarkDestruction() {

    }

    private static void blackPendant() {

    }

    private static void unitedWeStand() {

    }

    private static void magnumShield() {

    }

    private static void advancedRitualArt() {

    }
}
