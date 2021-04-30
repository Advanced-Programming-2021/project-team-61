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
                System.out.println("deck with name " + st1 + " already exists\n");
                break;
            }
            case DELETEDECKSUCCESSFULLY:{
                System.out.println("deck deleted successfully\n");
                break;
            }
            case DONTHAVETHISDECK:{
                System.out.println("deck with name " + st1 + " does not exist\n");
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
                System.out.println("card with name " + st1 + " does not exist\n");
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

    public void printAllDecksOfPlayer(ArrayList<Integer> allDeckID){
        System.out.println("Decks:\n");
        System.out.println("Active Deck:\n");
        for (Integer Id:allDeckID) {
            if (Deck.getDeckById(Id).isActivated()){
                System.out.println(Deck.getDeckById(Id).getDeckName() + " : main deck " + Deck.getDeckById(Id).getMainDeck().size() + " , side deck " + Deck.getDeckById(Id).getSideDeck().size() /*valid/invalid*/ );
                allDeckID.remove(Id);
                break;
            }
        }
        System.out.println("Other Decks:\n");
        for (Integer Id:allDeckID) {
            System.out.println(Deck.getDeckById(Id).getDeckName() + " : main deck " + Deck.getDeckById(Id).getMainDeck().size() + " , side deck " + Deck.getDeckById(Id).getSideDeck().size() /*valid/invalid*/ );
        }
        //ye masale dige ham hast,dar morede in ke chegouri tartibe alefba bashe??
    }

    public void printOneDeck(Integer ID , String M_S){
        /*ArrayList<String> monsters = new ArrayList<>();
        ArrayList<String> spellTrap = new ArrayList<>();
        ArrayList<String> cards = new ArrayList<>();
        if (M_S.equals("M")){
            cards = Deck.getDeckById(ID).getMainDeck();
            for (String cardName:cards) {
                if (cardName.
            }
        }else {
            cards = Deck.getDeckById(ID).getSideDeck();
        }
     */
    }

    public void printAllCardsOfPlayer(){

    }
}
