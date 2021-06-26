package Controller;

import Model.Board;

import java.util.Scanner;

public class StandByPhase {
    private static StandByPhase s = null;
    private Scanner scanner = new Scanner(System.in);
    private int i;
    private StandByPhase(){

    }
    public static StandByPhase getInstance(){
        if(s == null)
            s = new StandByPhase();
        return s;
    }
    public void run(Board myBoard){
        printPhase();
        if(( i = isMessengerCardAvailable(myBoard)) != -1){
            System.out.println("you can give 100 LP to destroy Messenger of peace card in standByPhase");
            if(scanner.nextLine().equals("yes")){
                myBoard.decreaseLifePoint(100);
                myBoard.destroySpellTrapCardByIndex(i);
                myBoard.setIsMessengerEffectActivated(false);
                EffectController.getInstance().deactivateMessengerEffect();
            }
            else
                System.out.println("OK!");

        }
    }

    private void printPhase() {
        System.out.println("Phase : StandByPhase");
    }

    private int isMessengerCardAvailable(Board myBoard) {
       for(int i = 0 ; i < 5; i++){
       if(myBoard.getMonsterByIndex(i)!= null && myBoard.getSpellTrapByIndex(i).getCard().getCardName().equals("Messenger Of peace") && myBoard.getSpellTrapByIndex(i).getStatus().equals("O"))
           return i;
       }
       return -1;
    }

}

