package Controller;

import Model.Board;
import View.GameView;

public class DrawPhase {
    private static DrawPhase drawPhase = null;


    private DrawPhase(){

    }
    public static DrawPhase getInstance(){
        if(drawPhase == null)
            drawPhase = new DrawPhase();
        return drawPhase;
    }
    public void run(Board board){
        printPhaseName();
        if(board.isCanGetCardFromDeck()){
            String cardName =  board.addCardToHand();
            GameView.getInstance().printMessageByString(GameView.Command.newCardAddedToHand,cardName);
        }
        else{
            board.setCanGetCardFromDeck(true);
            GameView.getInstance().printMessage(GameView.Command.cantGetCardFromDeck);

        }

    }


    private void printPhaseName() {
        System.out.println("phase : draw phase");
    }
}
