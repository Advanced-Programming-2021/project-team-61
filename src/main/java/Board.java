import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board {

    private Player player;
    private ArrayList <Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private String[] monsterZone = new String[5];
    private HashMap<Integer,Card> monsterCardsInField = new HashMap<>();
    private String[] spellTrapZone = new String[5];
    private HashMap<Integer,Card> spellTrapCardsInField = new HashMap<>();
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList <Card> hand = new ArrayList<>();
    private static ArrayList<Board> boards = new ArrayList<>();





    public Board(Player player){
        this.player = player;
        this.mainDeck = Deck.getActivatedDeck(player).getMainDeck();
        this.sideDeck = Deck.getActivatedDeck(player).getSideDeck();
        boards.add(this);
    }
    public static Board getBoardByPlayer(Player player){
        for(Board board : boards){
            if(board.player.getUsername().equals(player.getUsername()))
                return board;
        }
        return null;


    }
    public void createHand(){
        Collections.shuffle(mainDeck);
        for(int i = 0; i < 6; i++)
            hand.add(mainDeck.get(i));
    }
    public void addCardToHand(){
        hand.add(mainDeck.get(0));
    }
    public void setMonsterZone(int index,String manner){
        monsterZone[index]  = manner;
    }

    public void setSpellTrapZone(int index,String manner) {
        spellTrapZone[index] = manner;
    }
    public void addSpellTrapCardToField(int position,Card card){
        spellTrapCardsInField.put(position,card);
    }

    public void addMonsterCardToField(int position, MonsterCard card){
        monsterCardsInField.put(position,card);
    }
    public void destroyCard(Card card){
        graveYard.add(card);
    }
    private void initializeMonsterZone(){
        for(int i = 0;i < 5;i++)
            monsterZone[i] = "E";
    }
    private void initializeSpellTrapZone(){
        for(int i = 0;i < 5;i++)
            spellTrapZone[i] = "E";
    }


}
