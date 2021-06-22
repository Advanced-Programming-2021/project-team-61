package Model;

import java.util.ArrayList;

public class MonsterField {
    private MonsterCard monsterCard;
    private String status;
    private boolean isStatusChangedInTurn;
    private boolean isPutInThisTurn;
    private boolean hasAttackedInTurn;
    private static ArrayList<MonsterField> monsterFields = new ArrayList<>();
    public MonsterField(MonsterCard monsterCard,String status){
        this.monsterCard = monsterCard;
        this.status = status;
        this.isPutInThisTurn = true;
        this.isStatusChangedInTurn = false;
        this.hasAttackedInTurn = false;
        monsterFields.add(this);

    }

    public boolean isHasAttackedInTurn() {
        return hasAttackedInTurn;
    }

    public void setHasAttackedInTurn(boolean hasAttackedInTurn) {
        this.hasAttackedInTurn = hasAttackedInTurn;
    }

    public MonsterCard getMonsterCard() {
        return monsterCard;
    }

    public String getStatus() {
        return status;
    }

    public boolean isStatusChangedInTurn() {
        return isStatusChangedInTurn;
    }

    public boolean isPutInThisTurn() {
        return isPutInThisTurn;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPutInThisTurn(boolean putInThisTurn) {
        isPutInThisTurn = putInThisTurn;
    }

    public void setStatusChangedInTurn(boolean statusChangedInTurn) {
        isStatusChangedInTurn = statusChangedInTurn;
    }
    public void removeMonsterField(){
        monsterFields.remove(this);
    }
}
