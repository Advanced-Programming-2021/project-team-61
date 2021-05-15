import java.util.Scanner;

public class GameView {

    enum Command{
        NOTCARDSELECTED,
        NOTBESUMMONED,
        MONSTERZONEFULL,
        ISSUMMONEDONCE,
        NOTENOUGHFORTRIBUTE,
        NOTMONSTERINADDRESS,
        SUMMONSUCCESSFUL

    }

    private Scanner scanner = RegisterView.scanner;
    private static GameView g = null;
    private boolean isSummonedInTurn = false;

    private GameView(){

    }
    public static GameView getInstance(){
        if(g == null)
            g = new GameView();
        return g;
    }

    public boolean isSummonedInTurn() {
        return isSummonedInTurn;
    }

    public void setSummonedInTurn(boolean summonedInTurn) {
        isSummonedInTurn = summonedInTurn;
    }

    public String scan(){
        String command = scanner.nextLine();
        return command;
    }
    public void printMessage(Command message){
        switch (message){
            case NOTCARDSELECTED:{
                System.out.println("no card is selected yet");
                break;
            }
            case NOTBESUMMONED: {
                System.out.println("you can't summon this card");
                break;
            }
            case MONSTERZONEFULL:{
                System.out.println("monster card zone is full");
                break;
            }
            case ISSUMMONEDONCE: {
                System.out.println("you already summoned/set on this turn");
                break;
            }
            case NOTENOUGHFORTRIBUTE:{
                System.out.println("there are not enough cards for tribute");
                break;
            }
            case NOTMONSTERINADDRESS:{
                System.out.println("there no monster one this address");
                break;
            }
            case SUMMONSUCCESSFUL:{
                System.out.println("summoned successfully");
                break;
            }
        }

    }

}
