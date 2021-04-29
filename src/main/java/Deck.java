import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;

public class Deck {

    private int idCounter = 1;
    private static ArrayList<Deck> allDeck = new ArrayList<>();
    private String deckName;
    private int deckID;
    private ArrayList<String> mainDeck = new ArrayList<>();//should be change to <Card>
    private ArrayList<String> sideDeck = new ArrayList<>();//should be change to <Card>
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
        mainDeck.add(cardName);
    }

    public void addCardToSideDeck_Deck(String cardName){
        sideDeck.add(cardName);
    }

    public void removeCardFromMainDeck_Deck(String cardName){
        mainDeck.remove(cardName);
    }

    public void removeCardFromSideDeck_Deck(String cardName){
        sideDeck.remove(cardName);
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
        for (String a:mainDeck) {
            if (a.equals(cardName))
                number++;
        }
        for (String b:sideDeck) {
            if (b.equals(cardName))
                number++;
        }
        if (number==3)
            return true;
        return false;
    }

    public boolean isCardExistInMainDeck(String cardName){//true =>
        for (String a:mainDeck) {
            if (a.equals(cardName))
                return true;
        }
        return false;
    }

    public boolean isCardExistInSideDeck(String cardName){//
        for (String a:sideDeck) {
            if (a.equals(cardName))
                return true;
        }
        return false;
    }

    public boolean doesPlayerHaveActiveDeck(){


        return false;
    }

    public boolean isDeckValid(){


        return false;
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

    public ArrayList<String> getMainDeck() {
        return mainDeck;
    }

    public ArrayList<String> getSideDeck() {
        return sideDeck;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
