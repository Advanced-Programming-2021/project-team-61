import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeckView {

    enum Commands {
        CURRENTMENU,
        CREATESUCCESSFULLY,
        EXISTDECKALREADY,
        DELETEDECKSUCCESSFULLY,
        DONTHAVETHISDECK,
        ACTIVATESUCCESSFULLY,
        ADDCARDSUCCESSFULLY,
        DONTHAVETHISCARD,
        FULLMAINDECK,
        FULLSIDEDECK,
        LIMIT3ERROR,
        NOTEXISTTHISCARDINMAINDECK,
        NOTEXISTTHISCARDINSIDEDECK,
        REMOVECARDSUCCESSFULLY,
        INVALID
    }

    private static DeckView s = null;
    public static Scanner scanner = new Scanner(System.in);

    private DeckView() {
    }

    public static DeckView getInstance() {
        if (s == null)
            s = new DeckView();
        return s;
    }

    public String scan() {
        String command = scanner.nextLine();
        return command;
    }

    public void printMessage(DeckView.Commands message, String st1, String st2) {
        switch (message) {
            case CURRENTMENU:{
                System.out.println("deck menu\n");
                break;
            }
            case CREATESUCCESSFULLY:{
                System.out.println("deck created successfully!\n");
                break;
            }
            case EXISTDECKALREADY:{
              //  System.out.println("deck with name " + st + " already exists\n");
                break;
            }
            case DELETEDECKSUCCESSFULLY:{
                System.out.println("deck deleted successfully\n");
                break;
            }
            case DONTHAVETHISDECK:{
              //  System.out.println("deck with name " + st + " does not exist\n");
                break;
            }
            case ACTIVATESUCCESSFULLY:{
                System.out.println("deck activated successfully\n");
                break;
            }
            case ADDCARDSUCCESSFULLY:{
                System.out.println("card added to deck successfully\n");
                break;
            }
            case DONTHAVETHISCARD:{
             //   System.out.println("card with name " + st + " does not exist\n");
                break;
            }
            case FULLMAINDECK:{
                System.out.println("main deck is full\n");
                break;
            }
            case FULLSIDEDECK:{
                System.out.println("side deck is full\n");
                break;
            }
            case LIMIT3ERROR:{
                System.out.println("there are already three cards with name " + st1 + " in deck "+ st2 + "\n");
                break;
            }
            case NOTEXISTTHISCARDINMAINDECK:{
                System.out.println("card with name " + st1 + " does not exist in main deck\n");
                break;
            }
            case NOTEXISTTHISCARDINSIDEDECK:{
                System.out.println("card with name " + st1 + " does not exist in side deck\n");
                break;
            }
            case REMOVECARDSUCCESSFULLY:{
                System.out.println("card removed form deck successfully\n");
                break;
            }
            case INVALID:{
                System.out.println("invalid command\n");
                break;
            }
            default:
                break;
        }
    }

    public void printAllDecksOfPlayer(ArrayList<Deck> allDecks){
        System.out.println("Decks:\n");
        System.out.println("Active Deck:\n");
        for (Deck deck:allDecks) {
            if (deck.isActivated()){
                System.out.println(deck.getDeckName() + " : main deck " + deck.getMainDeck().size() + " , side deck " + deck.getSideDeck().size() /*valid/invalid*/ );
                break;
            }
        }
        System.out.println("Other Decks:\n");
        sortDeck(allDecks);
        for (Deck deck : allDecks) {
            if(!deck.isActivated())
            System.out.println(deck.getDeckName() + " : main deck " + deck.getMainDeck().size() + " , side deck " + deck.getSideDeck().size() /*valid/invalid*/ );
        }
        //ye masale dige ham hast,dar morede in ke chegouri tartibe alefba bashe??
    }

    public void printOneDeck(String deckName,ArrayList<Card> cards , String M_S){
        ArrayList<Card> monsters = new ArrayList<>();
        ArrayList<Card> spellTrap = new ArrayList<>();
        for(Card card : cards){
            if(card instanceof MonsterCard)
                monsters.add(card);
            else
                spellTrap.add(card);
        }
        System.out.println("Deck: "+deckName);
        if (M_S.equals("M")){
            System.out.println("Main deck:");
            }
        else {
        System.out.println("Side deck:");
        }
        sortCards(monsters);
        sortCards(spellTrap);
        System.out.println("Monsters:");
        for(Card monster : monsters)
            System.out.println(monster.getCardName()+":"+monster.getDescription());
        System.out.println("Spell and Traps:");
        for(Card spell : spellTrap)
            System.out.println(spell.getCardName()+":"+spell.getDescription());

    }
    private void sortDeck(ArrayList<Deck> allDecks){
        for(int i = 0;i<allDecks.size()-1;i++){
            for(int j = i; j<allDecks.size();j++){
                if(allDecks.get(i).getDeckName().compareTo( allDecks.get(j).getDeckName())>0)
                    Collections.swap(allDecks,i,j);
            }
        }
    }
    private void sortCards(ArrayList<Card> cards){
        for(int i = 0;i<cards.size()-1;i++){
            for(int j = i; j<cards.size();j++){
                if(cards.get(i).getCardName().compareTo(cards.get(j).getCardName())>0)
                    Collections.swap(cards,i,j);
            }
        }

    }

    public void printAllCardsOfPlayer(){

    }
}
