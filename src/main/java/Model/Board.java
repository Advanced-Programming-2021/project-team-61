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
   // private String[] monsterZone = new String[5];
    //private HashMap<Integer,MonsterCard> monsterCardsInField = new HashMap<>();
   // private String[] spellTrapZone = new String[5];
  //  private HashMap<Integer, Card> spellTrapCardsInField = new HashMap<>();
    private String fieldZoneCondition;
    private Card fieldZoneCard;
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();
    //private boolean isACardSelected = false;
    //private boolean isSummonedInTurn = false;
    //private int[] monsterZoneChange = new int[5];
    private int[] hasAttackInTurn = new int[5];
    private int[] extraAttack = new int[5];
    private int[] extraDefence = new int[5];
    private boolean canGetCardFromDeck = true;
    private boolean mirrorForceEffect = false;
    private static ArrayList<Board> boards = new ArrayList<>();
    private int lifePoint;
    private int numberOfWins = 0;
    private MonsterField[] monstersInField = new MonsterField[5];
    private SpellTrapField[] spellTrapsInField = new SpellTrapField[5];


    public Board(Player player) {
        this.player = player;
        this.mainDeck = Deck.getActivatedDeck(player).getMainDeck();
        this.sideDeck = Deck.getActivatedDeck(player).getSideDeck();
        this.initializeFieldZone();
        this.lifePoint = 8000;
        boards.add(this);
    }


    public void setNumberOfWins() {
        this.numberOfWins+=1;
    }

    public int getNumberOfWins() {
        return numberOfWins;
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
    public int getNumberOfMonstersInField(){
        int counter = 0;
        for(int i = 0; i < 5; i++){
            if(monstersInField[i] != null)
                counter++;
        }
        return counter;
    }

    public Player getPlayer() {
        return this.player;
    }
    public SpellTrapField[] getSpellTrapsInField(){
        return spellTrapsInField;
    }

    public void createHand() {
        Collections.shuffle(mainDeck);
        for (int i = 0; i < 6; i++)
            hand.add(mainDeck.get(i));
    }
    public SpellTrapField getSpellTrapByIndex(int index){
        return spellTrapsInField[index];
    }

    public String addCardToHand() {
        if (isCanGetCardFromDeck()) {
            String cardName = mainDeck.get(0).getCardName();
            hand.add(mainDeck.get(0));
            return cardName;
        }else {
            GameView.getInstance().printMessage(GameView.Command.cantGetCardFromDeck);
            setCanGetCardFromDeck(true);
            return null;
        }
    }




    public void addSpellTrapCardToField(int position, Card card,String status) {
        spellTrapsInField[position] = new SpellTrapField(card,status);
    }

    public void addMonsterCardToField(int number,MonsterCard monsterCard,String status) {
        monstersInField[number] = new MonsterField(monsterCard,status);
    }
    public void resetPutInThisTurn(){
        for(int i = 0; i < 5;i++){
            if(monstersInField[i]!= null)
                monstersInField[i].setPutInThisTurn(false);
        }
    }

    public void destroyCard(Card card) {
        graveYard.add(card);
    }

   /* public boolean isMonsterZoneFull() {
        for (int i = 0; i < 5; i++) {
            if (monsterZone[i].equals("E"))
                return false;
        }
        return true;
    }*/
    public void activateEffect(){
        if(Select.getInstance().getLocation()== Select.Location.HAND){
            int emptyPlace = getEmptyPlaceInSpellTrapZone();
           addSpellTrapCardToField(emptyPlace,getCardFromHand(Select.getInstance().getPosition() - 1),"O");
           hand.remove(Select.getInstance().getPosition()-1);
        }
       else if(Select.getInstance().getLocation() == Select.Location.SPELL){
            getSpellTrapByIndex(Select.getInstance().getPosition() -1) .setStatus("O");
        }

    }



    //this method needs to be put in MainPhase;





    private boolean isSpellTrapAvailableInSpellZone(int position) {
        return spellTrapsInField[position] != null;
    }

    public boolean isMonsterAvailableInMonsterZone(int position) {
        return monstersInField[position] != null;
    }




    private void initializeFieldZone(){
        fieldZoneCondition = "E";
    }

    public void destroyAllMonster(){
        for (int i = 0; i < 5; i++) {
            if(monstersInField[i] != null)
                destroyMonsterCardByIndex(i);
        }
    }

    public void destroyAllMonsterInAttack(){
        for (int i = 0; i < 5; i++) {
            if (monstersInField[i] != null && monstersInField[i].getStatus().equals("OO")) {
                destroyMonsterCardByIndex(i);
            }
        }
    }

    public void destroyMonsterCardByIndex(int index) {
        MonsterCard monsterCard = monstersInField[index].getMonsterCard();
        monstersInField[index].removeMonsterField();
        destroyCard(monsterCard);
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

    public MonsterField getMonsterByIndex(int index){
        return monstersInField[index];
    }
    public MonsterCard getMonsterCardByNumber(int number){
        return monstersInField[number].getMonsterCard();
    }
    public int getHasAttackInTurn(int index){
        return hasAttackInTurn[index];
    }
    public boolean isMonsterZoneEmpty(){
        for(int i = 0; i < 5; i++){
            if(monstersInField[i] == null)
                return true;
        }
        return false;

    }
    public MonsterField[] getMonstersInField(){
        return monstersInField;
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
    public void resetExtraAttackByNumber(int index){
        extraAttack[index] = 0;
    }
    public void resetExtraDefence(){
        for (int amount:extraDefence) {
            amount=0;
        }
    }
    public void setExtraAttackByIndex(int index, int amount){
        extraAttack[index - 1]+=amount;
    }
    public void setExtraDefenceByIndex(int index, int amount){
        extraDefence[index - 1]+=amount;
    }


    public int getEmptyPlaceInSpellTrapZone(){
        for(int i = 0; i < 5 ;i ++){
            if(spellTrapsInField[i] == null)
                return i;
        }
        return 0;
    }
    public int getEmptyPlaceInMonsterZone(){
        for(int i = 0; i < 5;i++){
            if(monstersInField[i] == null)
                return i;
        }
        return 0;

    }

    public int getCardIndex(String cardName){
        for(Map.Entry<Integer,MonsterCard> entry : monsterCardsInField.entrySet()){
            if(entry.getValue().getCardName().equals(cardName))
                return entry.getKey();
        }
        return 0;
        }
    public boolean canAttack(String cardName,int index){
        return !cardName.equals("Command knight") || (isMonsterZoneEmpty()) || (!monstersInField[index].getStatus().equals("OO") && !monstersInField[index].getStatus().equals("DO"));

    }



   /* public boolean isMonsterZoneEmpty(){
        for(int i = 0;i<5;i++){
            if(!monsterZone[i].equals("E"))
                return false;
        }
        return true;
    }*/


    public void showGraveyard(){
        if (graveYard.size()==0){
            GameView.getInstance().printMessage(GameView.Command.GRAVEYARDEMPTY);
        }else {
            GameView.getInstance().printGraveyard(graveYard);
        }
    }

    public void setFieldZoneCondition(String condition){
        fieldZoneCondition = condition;
    }

    public void setFieldZoneCard(Card card){
        fieldZoneCard = card;
    }


    public String getFieldZoneCondition(){
        return fieldZoneCondition;
    }

    public Card getFieldZoneCard(){
        return fieldZoneCard;
    }
   /* public String[] getMonsterZone(){
        return this.monsterZone;
    }*/


    public boolean isCanGetCardFromDeck() {
        return canGetCardFromDeck;
    }

    public void setCanGetCardFromDeck(boolean canGetCardFromDeck) {
        this.canGetCardFromDeck = canGetCardFromDeck;
    }

    public boolean isMirrorForceEffectActive() {
        return mirrorForceEffect;
    }

    public void setMirrorForceEffect(boolean mirrorForceEffect) {
        this.mirrorForceEffect = mirrorForceEffect;
    }
}

