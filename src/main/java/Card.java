import java.util.ArrayList;

public class Card {

    protected String cardName;
    protected String cardType;
    protected String description;
    protected int price;
    protected boolean isSelected = false;
    protected static ArrayList<Card> allCards = new ArrayList<>();

    protected Card(String cardName,String cardType,String description,int price){
        this.cardName = cardName;
        this.cardType = cardType;
        this.description = description;
        this.price = price;
    }
    public static boolean isCardAvailable(String cardName){
        for(int i = 0;i<allCards.size();i++){
            if(allCards.get(i).cardName.equals(cardName))
                return true;
        }
        return false;
    }


    public int getPrice() {
        return price;
    }

    public String getCardName() {
        return cardName;
    }

    public static Card getCardByName(String cardName){
        for(int i = 0;i<allCards.size();i++){
            if(allCards.get(i).cardName.equals(cardName))
                return allCards.get(i);
        }
        return null;
    }
    public static ArrayList<Card> getAllCards(){
        return allCards;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDescription() {
        return description;
    }

}
