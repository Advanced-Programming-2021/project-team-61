public class SpellCard extends Card{

    private String status;

    public SpellCard(String cardName,String cardType,String description,String status,int price){
        super(cardName,cardType,description,price);
        this.status = status;
        allCards.add(this);

    }

    public void printACardComplete(SpellCard card){
        System.out.println("Name : " + card.cardName);
        System.out.println("Spell");
        System.out.println("Type : " + card.status);
        System.out.println("Description : " + card.description);
    }
}
