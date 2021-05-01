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
        Player.getPlayerByUsername(playerName).addDeck(this);// Player.getPlayerByUsername(playerName).addDeck(this);
        idCounter++;
    }

    public static void activateDeck(String deckName,Player player){
        ArrayList<Deck> allDecks = player.getAllDecks();
        for (Deck deck : allDecks) {
            deck.setActivated(false);
        }
        Deck.getDeckByName(deckName,player).setActivated(true);
    }

    public static Deck getDeckByName(String deckName,Player player){
        ArrayList<Deck> allDecks = player.getAllDecks();
        for (Deck deck:allDecks) {
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

    public boolean doesPlayerHaveActiveDeck(ArrayList<Deck> Decks){
        for (Deck deck:Decks) {
            if (deck.isActivated)
                return true;
        }
        return false;
    }

    public boolean isDeckValid(){
        if (mainDeck.size()<40)
            return false;
        return true;
    }

    public static boolean doesPlayerHaveDeckWithThisName(String deckName, Player player){
         ArrayList <Deck> allDecks = player.getAllDecks();
         for( Deck deck : allDecks){
             if(deck.deckName.equals(deckName))
                return true;
        }
        return false;
    }
    public static boolean isPlayerHaveActivatedDeck(Player player){
       for( Deck deck : player.getAllDecks()){
           if(deck.isActivated)
               return true;
       }
       return false;

    }
    public static Deck getActivatedDeck(Player player){
        for(Deck deck : player.getAllDecks()){
            if(deck.isActivated)
                return deck;
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

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isActivated() {
        return isActivated;
    }
}
