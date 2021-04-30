import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;

public class Deck {

    private int idCounter = 1;
    private static ArrayList<Deck> allDeck = new ArrayList<>();
    private String deckName;
    private int deckID;
    private ArrayList<Card> mainDeck = new ArrayList<>();
    private ArrayList<Card> sideDeck = new ArrayList<>();
    private boolean isActivated = false;

    public Deck(String deckName, String playerName){
        this.deckName = deckName;
        this.deckID = idCounter;
        allDeck.add(this);
        Player.getPlayerByUsername(playerName).addDeckId(idCounter);
        idCounter++;
    }

    public void deleteDeck(){

    }

    public static void activateDeck(Integer id, ArrayList<Integer> deckId){
        for (Integer integer:deckId) {
            Deck.getDeckById(integer).setActivated(false);
        }
        Deck.getDeckById(id).setActivated(true);
    }

    public Deck getDeckByName(String deckName){
        for (Deck deck:allDeck) {
            if (deck.deckName.equals(deckName))
                return deck;
        }
        return null;
    }

    public void addCardToMainDeck_Deck(String cardName){
        mainDeck.add(Card.getCardByName(cardName));
    }

    public void addCardToSideDeck_Deck(String cardName){
        sideDeck.add(Card.getCardByName(cardName));
    }

    public void removeCardFromMainDeck_Deck(String cardName){
        mainDeck.remove(Card.getCardByName(cardName));
    }

    public void removeCardFromSideDeck_Deck(String cardName){
        sideDeck.remove(Card.getCardByName(cardName));
    }

    public void deckShowAll(){

    }

    public void mainDeckShow(){

    }

    public void sideDeckShow(){

    }

    public boolean isMainDeckFull(){//true => full
        if (mainDeck.size()==60)
            return true;
        return false;
    }

    public boolean isSideDeckFull(){//true => full
        if (sideDeck.size()==15)
            return true;
        return false;
    }

    public boolean isTripletCard(String cardName){//true => has 3 cards from one type
        int number = 0;
        for (Card a:mainDeck) {
            if (a.cardName.equals(cardName))
                number++;
        }
        for (Card b:sideDeck) {
            if (b.cardName.equals(cardName))
                number++;
        }
        if (number==3)
            return true;
        return false;
    }

    public boolean isCardExistInMainDeck(String cardName){//true => exist
        for (Card a:mainDeck) {
            if (a.cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public boolean isCardExistInSideDeck(String cardName){//true => exist
        for (Card a:sideDeck) {
            if (a.cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public boolean doesPlayerHaveActiveDeck(){


        return false;
    }

    public boolean isDeckValid(){
        if (mainDeck.size()<40)
            return false;
        return true;
    }

    public static boolean doesPlayerHaveDeckWithThisName(String deckName, ArrayList<Integer> DeckId){
        for (Integer Id:DeckId) {
            if (getDeckById(Id).deckName.equals(deckName))
                return true;
        }
        return false;
    }

    ////////////////////////////////////////////

    public static Deck getDeckById(Integer Id){
        for (Deck deck:allDeck) {
            if (deck.deckID==Id)
                return deck;
        }
        return null;
    }

    public String getDeckNameById(Integer Id){
        for (Deck deck:allDeck) {
            if (deck.deckID==Id)
                return deck.deckName;
        }
        return null;
    }

    public static Integer getDeckIdByDeckNameForSpecificPlayer(String deckName, ArrayList<Integer> DeckId){
        for (Integer id:DeckId) {
            if (Deck.getDeckById(id).deckName.equals(deckName))
                return id;
        }
        return null;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public ArrayList<Card> getSideDeck() {
        return sideDeck;
    }

    public String getDeckName() {return deckName; }

    public int getDeckID() {
        return deckID;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isActivated() {
        return isActivated;
    }
}
