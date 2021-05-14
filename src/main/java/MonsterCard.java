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

    public static void printACardComplete(MonsterCard card){
        System.out.println("Name : " + card.cardName);
        System.out.println("Level : " + card.level);
        System.out.println("Type : " + card.cardType);
        System.out.println("ATK : " + card.attack);
        System.out.println("DEF : " + card.defense);
        System.out.println("Description : " + card.description);
    }
}
