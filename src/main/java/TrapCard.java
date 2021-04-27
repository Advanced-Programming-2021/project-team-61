public class TrapCard extends Card{

    private String status;

    public TrapCard(String cardName, String cardType,String description,String status , int price){
        super(cardName,cardType,description,price);
        this.status = status;
    }

}
