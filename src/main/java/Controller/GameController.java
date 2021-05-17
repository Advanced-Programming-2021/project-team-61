package Controller;

import Model.Board;
import Model.Player;
import View.BattlePhaseView;
import View.MainPhaseView;

public class GameController {

    private static GameController g = null;
    private Player myTurn;
    private Player notMyTurn;
    private Player temp;
    private boolean hasAttackedInBattlePhase = false;
    private boolean isGameFinished = false;

    private GameController(){
    }
    public static GameController getInstance(){
        if(g ==null)
            g = new GameController();
        return g;
    }
    public void run(Player player1, Player player2){
        myTurn = player1;
        notMyTurn = player2;
        setGame(myTurn,notMyTurn);
        playGame(myTurn,notMyTurn);
        //print mainPhase
       //going to main phase to get commands
       //going to end phase




    }
    private void playGame(Player myTurn,Player notMyTurn){
        startGame(myTurn,notMyTurn);
        while(true){
            enterDrawPhase(myTurn);
            enterMainPhase(myTurn, notMyTurn);
            enterBattlePhase(myTurn, notMyTurn);
            if(isGameFinished)
                break;
            if(hasAttackedInBattlePhase)
                enterMainPhase(myTurn,notMyTurn);
            enterEndPhase(notMyTurn);
            temp = myTurn;
            myTurn = notMyTurn;
            notMyTurn = temp;
        }


    }
    private void startGame(Player myTurn,Player notMyTurn){
        enterMainPhase(myTurn,notMyTurn);
        enterEndPhase(notMyTurn);
        temp = myTurn;
        myTurn = notMyTurn;
        notMyTurn = temp;
        enterMainPhase(myTurn,notMyTurn);
        enterBattlePhase(myTurn,notMyTurn);
        enterEndPhase(notMyTurn);
    }
    private void enterDrawPhase(Player myTurn){
        DrawPhase drawPhase = DrawPhase.getInstance();
        drawPhase.run(Board.getBoardByPlayer(myTurn));
    }
    private void enterMainPhase(Player myTurn,Player notMyTurn){
        MainPhaseView mainPhaseView = MainPhaseView.getInstance();
        mainPhaseView.scan(myTurn,notMyTurn);
    }
    private void enterBattlePhase(Player myTurn,Player notMyTurn){
        BattlePhaseView battlePhaseView = BattlePhaseView.getInstance();
        battlePhaseView.scan(myTurn,notMyTurn);
    }
    private void enterEndPhase(Player notMyTurn){
        EndPhase endPhase = EndPhase.getInstance();
        endPhase.changeTurn(notMyTurn);
    }
    private void setGame(Player player1, Player player2){
        Board.getBoardByPlayer(myTurn).createHand();
        Board.getBoardByPlayer(notMyTurn).createHand();
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }
}
