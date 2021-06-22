package Model;

public class SpellTrapField {
    private Card card;
    private String status;

    public SpellTrapField(Card card , String status){
        this.card = card;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Card getCard() {
        return card;
    }
}
