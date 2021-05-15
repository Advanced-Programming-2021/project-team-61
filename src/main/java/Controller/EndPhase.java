package Controller;

import Model.Board;

public class EndPhase {
    private static EndPhase e = null;




    private EndPhase(){

    }
    public static EndPhase getInstance(){
        if(e == null)
            e = new EndPhase();
        return e;
    }
    public void changeTurn(Board notMyTurn){
        String username = notMyTurn.getPlayer().getUsername();
        //print next turn;
    }
}
