public class SpellCard extends Card{

    private String status;

    public SpellCard(String cardName,String cardType,String description,String status,int price){
        super(cardName,cardType,description,price);
        this.status = status;

    }
}
