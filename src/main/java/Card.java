public class Card {

    protected String cardName;
    protected String cardType;
    protected String description;
    protected int price;

    protected Card(String cardName,String cardType,String description,int price){
        this.cardName = cardName;
        this.cardType = cardType;
        this.description = description;
        this.price = price;
    }

}
