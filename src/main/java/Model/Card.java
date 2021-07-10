package Model;


import javafx.scene.image.Image;

import java.util.ArrayList;

public class Card {

    private static Player player;
    private static Player rivalPlayer;
    protected String cardName;
    protected String cardType;
    protected String description;
    protected int price;
    protected boolean isSelected = false;
    protected static ArrayList<Card> allCards = new ArrayList<>();


    protected Card(String cardName, String cardType, String description, int price) {
        this.cardName = cardName;
        this.cardType = cardType;
        this.description = description;
        this.price = price;
    }
    public static Image getImageByCardName(String cardName){
        String path = "file:" + System.getProperty("user.dir") + "/src/main/resources/";
        if(Card.getCardByName(cardName) instanceof MonsterCard){
            //String m = "/monsterCards/"+cardName+".jpg";
            path += "monsterCards/" + cardName + ".jpg";
        }
        else{
            //String s = "/spellCards/"+cardName+".jpg";
            path += "spellCards/" + cardName + ".jpg";
        }
        System.out.println(cardName);
        return new Image(path);
    }

    public static boolean isCardAvailable(String cardName) {
        for (int i = 0; i < allCards.size(); i++) {
            if (allCards.get(i).cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getPrice() {
        return price;
    }

    public String getCardName() {
        return cardName;
    }

    public static Card getCardByName(String cardName) {
        for (int i = 0; i < allCards.size(); i++) {
            if (allCards.get(i).cardName.equals(cardName))
                return allCards.get(i);
        }
        return null;
    }

    public static ArrayList<Card> getAllCards() {
        return allCards;
    }

    public String getCardType() {
        return cardType;
    }

    public String getDescription() {
        return description;
    }
    public static void activateCommandKnightEffect(Board board) {  //monster
        //  Board board = Board.getBoardByPlayer(player);
        for(int i = 0 ; i < 5; i++){
            if(board.isMonsterAvailableInMonsterZone(i)){
                board.getMonsterByIndex(i).increaseExtraAttackPoint(400);
            }
        }
    }
}

