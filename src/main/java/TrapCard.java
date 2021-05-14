public class TrapCard extends Card{

    private String status;

    public TrapCard(String cardName, String cardType,String description,String status , int price){
        super(cardName,cardType,description,price);
        this.status = status;
        allCards.add(this);
    }

    public static void printACardComplete(TrapCard card){
        System.out.println("Name : " + card.cardName);
        System.out.println("Trap");
        System.out.println("Type : " + card.status);
        System.out.println("Description : " + card.description);
    }

}
