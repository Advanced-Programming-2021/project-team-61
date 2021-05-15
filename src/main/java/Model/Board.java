package Model;

import View.GameView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Board {

    private Player player;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private String[] monsterZone = new String[5];
    private HashMap<Integer,MonsterCard> monsterCardsInField = new HashMap<>();
    private String[] spellTrapZone = new String[5];
    private HashMap<Integer, Card> spellTrapCardsInField = new HashMap<>();
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();
    private boolean isACardSelected = false;
    private boolean isSummonedInTurn = false;
    private int[] monsterZoneChange = new int[5];
    private int[] hasAttackInTurn = new int[5];
    private int[] extraAttack = new int[5];
    private int[] extraDefence = new int[5];
    private static ArrayList<Board> boards = new ArrayList<>();
    private int lifePoint;


    public Board(Player player) {
        this.player = player;
        this.mainDeck = Deck.getActivatedDeck(player).getMainDeck();
        this.sideDeck = Deck.getActivatedDeck(player).getSideDeck();
        this.initializeMonsterZone();
        this.initializeSpellTrapZone();
        this.lifePoint = 8000;
        boards.add(this);
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint -= lifePoint;
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
        monsterCardsInField.put(position, (MonsterCard)card);
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
    public void activateEffect(){
        if(Select.getInstance().getLocation()== Select.Location.HAND){
            int emptyPlace = getEmptyPlaceInSpellTrapZone();
           spellTrapZone[emptyPlace] = "O";
           addSpellTrapCardToField(emptyPlace,getCardFromHand(Select.getInstance().getPosition()));
           hand.remove(Select.getInstance().getPosition()-1);
        }
       else if(Select.getInstance().getLocation() == Select.Location.SPELL){
            spellTrapZone[Select.getInstance().getPosition()-1] = "O";
        }

    }



    //this method needs to be put in MainPhase;




    public void summon() {
        int position = getEmptyPlaceInMonsterZone();
        setMonsterZone(position-1,"OO");
        addMonsterCardToField(position ,getCardFromHand(Select.getInstance().getPosition()));
        hand.remove(getCardFromHand(Select.getInstance().getPosition()));
        this.setSummonedInTurn(true);
    }
    public void setMonster(){
        int position = getEmptyPlaceInMonsterZone();
        setMonsterZone(position-1,"DH");
        addMonsterCardToField(position,getCardFromHand(Select.getInstance().getPosition()));
        hand.remove(getCardFromHand(Select.getInstance().getPosition()));
        this.setSummonedInTurn(true);
    }
    public void setSpellTrap(){
        int position = getEmptyPlaceInSpellTrapZone();
        setSpellTrapZone(position-1,"H");
        addSpellTrapCardToField(position,getCardFromHand(Select.getInstance().getPosition()));
        hand.remove(getCardFromHand(Select.getInstance().getPosition()));
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
    public String getSpellTrapZoneByNumber(int index){return spellTrapZone[index];}
    public Card getSpellTrapByKey(int key){return spellTrapCardsInField.get(key);}

    public String[] getSpellTrapZone() {
        return spellTrapZone;
    }

    public HashMap<Integer, MonsterCard> getMonsterCardsInField() {
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
    public MonsterCard getMonsterCardByKey(int key){
        return monsterCardsInField.get(key);
    }
    public int getHasAttackInTurn(int index){
        return hasAttackInTurn[index];
    }
    public void destroyCardInMonsterZone(int number){
       graveYard.add(monsterCardsInField.get(number));
        monsterCardsInField.remove(number);
        monsterZone[number-1] = "E";
    }
    public boolean isMonsterZoneEmpty(){
        int count = 0;
        for (String pos:monsterZone) {
            if (pos.equals("E"))
                count++;
        }
        if (count==5)
            return true;
        return false;
    }

    //set,get,reset => extraAttack & extraDefence
    public int getExtraAttackByIndex(int index){
        return extraAttack[index - 1];
    }
    public int getExtraDefenceByIndex(int index){
        return extraDefence[index - 1];
    }
    public void resetExtraAttack(){
        for (int amount:extraAttack) {
            amount=0;
        }
    }
    public void resetExtraDefence(){
        for (int amount:extraDefence) {
            amount=0;
        }
    }
    public void setExtraAttackByIndex(int index, int amount){
        extraAttack[index - 1]=amount;
    }
    public void setExtraDefenceByIndex(int index, int amount){
        extraDefence[index - 1]=amount;
    }

    public boolean isSpellTrapZoneFull() {
        for (int i = 0; i < 5; i++) {
            if (spellTrapZone[i].equals("E"))
                return false;
        }
        return true;
    }
    private int getEmptyPlaceInSpellTrapZone(){
        for(int i = 0;i<spellTrapZone.length;i++){
            if(spellTrapZone[i].equals("E"))
                return i;
        }
        return 10;
    }
    private int getEmptyPlaceInMonsterZone(){
        return handleGetEmptyPlace(monsterZone);
    }

    private int handleGetEmptyPlace(String[] spellTrapZone) {
        if(spellTrapZone[0].equals("E"))
            return 1;
        if(spellTrapZone[1].equals("E"))
            return 2;
        if(spellTrapZone[2].equals("E"))
            return 3;
        if(spellTrapZone[3].equals("E"))
            return 4;
        if(spellTrapZone[4].equals("E"))
            return 5;
        return 10;
    }
    public int getCardIndex(String cardName){
        for(Map.Entry<Integer,MonsterCard> entry : monsterCardsInField.entrySet()){
            if(entry.getValue().getCardName().equals(cardName))
                return entry.getKey();
        }
        return 0;
        }
    public boolean canAttack(String cardName,int index){
        if(cardName.equals("Command knight") && (!isMonsterZoneEmpty()) && (monsterZone[index].equals("OO") || monsterZone[index].equals("DO")))
            return false;
        else
            return true;

    }



   /* public boolean isMonsterZoneEmpty(){
        for(int i = 0;i<5;i++){
            if(!monsterZone[i].equals("E"))
                return false;
        }
        return true;
    }*/

}
