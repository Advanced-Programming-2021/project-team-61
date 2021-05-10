import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Board {

    private Player player;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private String[] monsterZone = new String[5];
    private HashMap<Integer, Card> monsterCardsInField = new HashMap<>();
    private String[] spellTrapZone = new String[5];
    private HashMap<Integer, Card> spellTrapCardsInField = new HashMap<>();
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();
    private boolean isACardSelected = false;
    private boolean isSummonedInTurn = false;
    private int[] monsterZoneChange = new int[5];
    private int[] hasAttackInTurn = new int[5];
    private static ArrayList<Board> boards = new ArrayList<>();


    public Board(Player player) {
        this.player = player;
        this.mainDeck = Deck.getActivatedDeck(player).getMainDeck();
        this.sideDeck = Deck.getActivatedDeck(player).getSideDeck();
        this.initializeMonsterZone();
        this.initializeSpellTrapZone();
        boards.add(this);
    }

    public static Board getBoardByPlayer(Player player) {
        for (Board board : boards) {
            if (board.player.getUsername().equals(player.getUsername()))
                return board;
        }
        return null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setSummonedInTurn(boolean summonedInTurn) {
        isSummonedInTurn = summonedInTurn;
    }

    public boolean isSummonedInTurn() {
        return isSummonedInTurn;
    }

    public void createHand() {
        Collections.shuffle(mainDeck);
        for (int i = 0; i < 6; i++)
            hand.add(mainDeck.get(i));
    }

    public void addCardToHand() {
        hand.add(mainDeck.get(0));
    }

    public void setMonsterZone(int index, String manner) {
        monsterZone[index] = manner;
    }

    public void setSpellTrapZone(int index, String manner) {
        spellTrapZone[index] = manner;
    }

    public void addSpellTrapCardToField(int position, Card card) {
        spellTrapCardsInField.put(position, card);
    }

    public void addMonsterCardToField(int position, Card card) {
        monsterCardsInField.put(position, card);
    }

    public void destroyCard(Card card) {
        graveYard.add(card);
    }

    public boolean isMonsterZoneFull() {
        for (int i = 0; i < 5; i++) {
            if (monsterZone[i].equals("E"))
                return false;
        }
        return true;
    }



    //this method needs to be put in MainPhase;




    public void summon() {
        int position = getEmptyPlaceInMonsterZone();
        setMonsterZone(position-1,"OO");
        addMonsterCardToField(position ,getCardFromHand(Select.getInstance().getPosition()));
        hand.remove(getCardFromHand(Select.getInstance().getPosition()));
        this.setSummonedInTurn(true);
    }
    public void set(){
        int position = getEmptyPlaceInMonsterZone();
        setMonsterZone(position-1,"DH");
        addMonsterCardToField(position,getCardFromHand(Select.getInstance().getPosition()));
        hand.remove(getCardFromHand(Select.getInstance().getPosition()));
        this.setSummonedInTurn(true);
    }

    private boolean isSpellTrapAvailableInSpellZone(int position) {
        switch (position) {
            case 1: {
                return !spellTrapZone[2].equals("E");
            }
            case 2: {
                return !spellTrapZone[1].equals("E");
            }
            case 3: {
                return !spellTrapZone[3].equals("E");
            }
            case 4: {
                return !spellTrapZone[0].equals("E");
            }
            case 5: {
                return !spellTrapZone[4].equals("E");
            }
            default: {
                return false;
            }
        }


    }

    public boolean isMonsterAvailableInMonsterZone(int position) {
        return !monsterZone[position-1].equals("E");
    }

    private boolean isNumberValid(String address, int number) {
        switch (address) {
            case "--hand": {
                return (number <= hand.size() && number >= 1);
            }
            //fieldZone needs to be added
            default: {
                return (number <= 5 && number >= 1);
            }
        }
    }

    private int getEmptyPlaceInMonsterZone(){
        if(monsterZone[0].equals("E"))
            return 1;
        if(monsterZone[1].equals("E"))
            return 2;
        if(monsterZone[2].equals("E"))
            return 3;
        if(monsterZone[3].equals("E"))
            return 4;
        if(monsterZone[4].equals("E"))
            return 5;
        return 10;

    }
    public boolean isEnoughForTribute(int level){
        switch (level){
            case 5 : {
                return monsterCardsInField.size()>=1;
            }
            case 7 : {
                return monsterCardsInField.size()>=2;
            }
            default: return false;
        }
    }


    public void tribute(int position){
        monsterZone[position-1] = "E";
        graveYard.add(monsterCardsInField.get(position));
        monsterCardsInField.remove(position);
    }

    private void initializeMonsterZone() {
        for (int i = 0; i < 5; i++)
            monsterZone[i] = "E";
    }

    private void initializeSpellTrapZone() {
        for (int i = 0; i < 5; i++)
            spellTrapZone[i] = "E";
    }

    public void destroyAllMonster(){
        for (String cardName:monsterZone) {
            destroyCard(Card.getCardByName(cardName));
        }
    }

    public void destroyAllSpell(){
        for (String cardName:spellTrapZone) {
            if (Card.getCardByName(cardName) instanceof SpellCard)
                destroyCard(Card.getCardByName(cardName));
        }
    }

    public void destroyAllTrap(){
        for (String cardName:spellTrapZone) {
            if (Card.getCardByName(cardName) instanceof TrapCard)
                destroyCard(Card.getCardByName(cardName));
        }
    }

    public boolean isThisCardInHand_ByName(String cardName){
        for (Card card:hand) {
            if (card.cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public void destroyAllSpecialCardForPlayer(String cardName){
        for (Card card:mainDeck) {
            if (card.cardName.equals(cardName)) {
                mainDeck.remove(card);
                graveYard.add(card);
            }
        }
        for (Card card:sideDeck) {
            if (card.cardName.equals(cardName)){
                sideDeck.remove(card);
                graveYard.add(card);
            }
        }
        for (String name:monsterZone) {
            if (name.equals(cardName))
                destroyCard(Card.getCardByName(name));
        }
        for (String name:spellTrapZone) {
            if (name.equals(cardName))
                destroyCard(Card.getCardByName(name));
        }
        for (Card card:hand) {
            if (card.cardName.equals(cardName))
                destroyCard(card);
        }
    }

    //getters...


    public ArrayList<Card> getGraveYard() {
        return graveYard;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getMonsterZoneByNumber(int index) {
        return monsterZone[index];
    }

    public String[] getSpellTrapZone() {
        return spellTrapZone;
    }

    public HashMap<Integer, Card> getMonsterCardsInField() {
        return monsterCardsInField;
    }

    public HashMap<Integer, Card> getSpellTrapCardsInField() {
        return spellTrapCardsInField;
    }
    public Card getCardFromHand(int index){
        return hand.get(index);
    }

    ////////////////


    public void setMonsterZoneChangeToDefault() {
        for (int i = 0; i < 5; i++) {
            this.monsterZoneChange[i] = 0;
        }
    }
    private void resetAttackInTurn(){
        for (int i = 0; i < 5; i++) {
            this.hasAttackInTurn[i] = 0;
        }
    }

    public void setMonsterZoneChangeByNumber(int index, int amount){
        this.monsterZoneChange[index]=amount;
    }

    public int getMonsterZoneChangeByNumber(int index){
        return monsterZoneChange[index];
    }
    public void setHasAttackInTurn(int index){
        hasAttackInTurn[index] = 1;
    }
    public Card getMonsterCardByKey(int key){
        return monsterCardsInField.get(key);
    }
    public boolean hasAttackInTurn(int index){
        return hasAttackInTurn[index]!=0;
    }
}
