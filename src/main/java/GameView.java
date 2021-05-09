import java.util.Scanner;

public class GameView {

    enum Command{
        NOTCARDSELECTED,
        NOTBESUMMONED,
        MONSTERZONEFULL,
        ISSUMMONEDONCE,
        NOTENOUGHFORTRIBUTE,
        NOTMONSTERINADDRESS,
        SUMMONSUCCESSFUL,
        ENTERTHECARDNAME,
        INVALIDSELECTION,
        CARDSELECTED,
        CARDDESELECTED,
        NOCARDFOUNDINGIVENPOSITION,
        NOTBESET,
        NOTINMONSTERZONE,
        NOTFLIP,
        SETSUCCESSFUL

    }

    private Scanner scanner = RegisterView.scanner;
    private static GameView g = null;

    private GameView(){

    }
    public static GameView getInstance(){
        if(g == null)
            g = new GameView();
        return g;
    }
    public String scan(){
        String command = scanner.nextLine();
        return command;
    }
    public void printMessage(Command message){
        switch (message){
            case NOTCARDSELECTED:{
                System.out.println("no card is selected yet\n");
                break;
            }
            case NOTBESUMMONED: {
                System.out.println("you can't summon this card\n");
                break;
            }
            case MONSTERZONEFULL:{
                System.out.println("monster card zone is full\n");
                break;
            }
            case ISSUMMONEDONCE: {
                System.out.println("you already summoned/set on this turn\n");
                break;
            }
            case NOTENOUGHFORTRIBUTE:{
                System.out.println("there are not enough cards for tribute\n");
                break;
            }
            case NOTMONSTERINADDRESS:{
                System.out.println("there no monster one this address\n");
                break;
            }
            case SUMMONSUCCESSFUL:{
                System.out.println("summoned successfully\n");
                break;
            }
            case ENTERTHECARDNAME:{
                System.out.println("please enter the cardName which you guess your rival has:\n");
                break;
            }
            case INVALIDSELECTION:{
                System.out.println("invalid selection\n");
                break;
            }
            case CARDSELECTED:{
                System.out.println("card selected\n");
                break;
            }
            case CARDDESELECTED:{
                System.out.println("card deselected\n");
                break;
            }
            case NOCARDFOUNDINGIVENPOSITION:{
                System.out.println("no card found in the given position\n");
                break;
            }
            case NOTBESET: {
                System.out.println("you can't set this card");
            }
            case SETSUCCESSFUL:{
                System.out.println("set successfully");
            }
            case NOTINMONSTERZONE:{
                System.out.println("you can't change this card position");
            }
            case NOTFLIP:{
                System.out.println("you can't flip summon this card");
            }
        }

    }

}
