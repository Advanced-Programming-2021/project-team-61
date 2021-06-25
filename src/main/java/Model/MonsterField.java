package Model;

import java.util.ArrayList;

public class MonsterField {
    private MonsterCard monsterCard;
    private String status;
    private boolean isStatusChangedInTurn;
    private boolean isPutInThisTurn;
    private boolean hasAttackedInTurn;
    private boolean isEffectActivated;
    private int extraAttackPoint;
    private int extraDefensePoint;
    private static ArrayList<MonsterField> monsterFields = new ArrayList<>();
    public MonsterField(MonsterCard monsterCard,String status){
        this.monsterCard = monsterCard;
        this.status = status;
        this.isPutInThisTurn = true;
        this.isStatusChangedInTurn = false;
        this.hasAttackedInTurn = false;
        this.isEffectActivated = false;
        this.extraAttackPoint = 0;
        this.extraDefensePoint = 0;
        monsterFields.add(this);

    }
    public void increaseExtraDefense(int extraDefensePoint){
        this.extraDefensePoint += extraDefensePoint;
    }
    public int getExtraDefensePoint(){
        return extraDefensePoint;
    }
    public void decreaseDefensePoint(int extraDefensePoint){
        this.extraDefensePoint -= extraDefensePoint;
    }
    public void decreaseAttackPoint(int extraAttackPoint){
        this.extraAttackPoint-=extraAttackPoint;
    }

    public void increaseExtraAttackPoint(int extraAttackPoint) {
        this.extraAttackPoint += extraAttackPoint;
    }

    public int getExtraAttackPoint() {
        return extraAttackPoint;
    }

    public boolean isEffectActivated() {
        return isEffectActivated;
    }

    public void setEffectActivated(boolean effectActivated) {
        isEffectActivated = effectActivated;
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
