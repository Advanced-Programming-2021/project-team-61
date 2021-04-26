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
        FULLMAINSIDEDECK,
        LIMIT3ERROR,
        NOTEXISTTHISCARDINDECK,
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
                System.out.println("deck with name " + st + " already exists\n");
                break;
            }
            case DELETEDECKSUCCESSFULLY:{
                System.out.println("deck deleted successfully\n");
                break;
            }
            case DONTHAVETHISDECK:{
                System.out.println("deck with name " + st + " does not exist\n");
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
                System.out.println("card with name " + st + " does not exist\n");
                break;
            }
            case FULLMAINSIDEDECK:{
                System.out.println(st1 + " deck is full\n");
                break;
            }
            case LIMIT3ERROR:{
                System.out.println("there are already three cards with name " + st1 + " in deck "+ st2 + "\n");
                break;
            }
            case NOTEXISTTHISCARDINDECK:{
                System.out.println("card with name " + st1 + " does not exist in " + st2 + " deck\n");
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

    public void printAllDecksOfPlayer(){

    }

    public void printOneDeck(){

    }

    public void printAllCardsOfPlayer(){

    }
}
