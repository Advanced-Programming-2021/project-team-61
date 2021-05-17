package Controller;

import Model.Board;
import Model.Player;

public class EndPhase {
    private static EndPhase e = null;




    private EndPhase(){

    }
    public static EndPhase getInstance(){
        if(e == null)
            e = new EndPhase();
        return e;
    }
    public void changeTurn(Player player){
        System.out.println("End Phase");
        System.out.println("its "+player.getNickname()+" 's turn");
    }
    public void changeTurn(Board notMyTurn){
        String username = notMyTurn.getPlayer().getUsername();
        //print next turn;
    }
}
