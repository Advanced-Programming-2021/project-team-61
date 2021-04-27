public class MonsterCard extends Card{

    private int level;
    private int attack;
    private int defense;
    private String attribute;
    private String MonsterType;

    public MonsterCard(String cardName,int level,String attribute,String MonsterType,String type,int attack,int defense,String description,int price ){
        super(cardName,type,description,price);
        this.attack = attack;
        this.attribute = attribute;
        this.MonsterType = MonsterType;
        this.defense = defense;
        this.level = level;
    }

}
