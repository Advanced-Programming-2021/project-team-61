package Model;

public class MonsterCard extends Card{

    private int level;
    private int attack;
    private int defense;
    private String attribute;
    private String MonsterType;
    private boolean isEffectActivated = false;

    public MonsterCard(String cardName,int level,String attribute,String MonsterType,String type,int attack,int defense,String description,int price ){
        super(cardName,type,description,price);
        this.attack = attack;
        this.attribute = attribute;
        this.MonsterType = MonsterType;
        this.defense = defense;
        this.level = level;
        allCards.add(this);
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isEffectActivated() {
        return isEffectActivated;
    }

    public String getMonsterType() {
        return MonsterType;
    }

    public void setEffectActivated(boolean effectActivated) {
        isEffectActivated = effectActivated;
    }
}
