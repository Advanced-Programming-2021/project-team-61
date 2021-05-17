package Controller;

import Model.Board;

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
        board.addCardToHand();
    }
}
