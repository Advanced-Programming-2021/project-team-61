package Model;

import java.util.ArrayList;

public class SpellTrapField {
    private Card card;
    private String status;
    private static ArrayList<SpellTrapField> spellTrapFields = new ArrayList<>();

    public SpellTrapField(Card card , String status){
        this.card = card;
        this.status = status;
        spellTrapFields.add(this);
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
    public void remove(){
        spellTrapFields.remove(this);

    }
}
