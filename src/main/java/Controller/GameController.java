package Controller;

import Model.Board;
import Model.MonsterField;
import Model.Player;
import View.BattlePhaseView;
import View.MainPhaseView;

public class GameController {

    private static GameController g = null;
    private Player myTurn;
    private Player notMyTurn;
    private Player temp;
    private boolean hasAttackedInBattlePhase = false;
    private boolean isFirstTurn = true;

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
        setGame();
        playGame();
        //print mainPhase
       //going to main phase to get commands
       //going to end phase




    }
    private void playGame(){
        while(true){
            if(isFirstTurn){
                enterMainPhase();
                enterEndPhase(notMyTurn);
                changeTurn();
                isFirstTurn = false;
            }
            else{
            enterDrawPhase();
            if(isGameFinished(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn)))
                break;
            enterMainPhase();
            if(isGameFinished(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn)))
                break;
            enterBattlePhase();
                if(isGameFinished(Board.getBoardByPlayer(myTurn),Board.getBoardByPlayer(notMyTurn)))
                    break;
            if(hasAttackedInBattlePhase)
             enterMainPhase();
            enterEndPhase(notMyTurn);
            changeTurn();
            }
        }


    }

    private void changeTurn() {
       MonsterField[] monsterFields =  Board.getBoardByPlayer(myTurn).getMonstersInField();
       reset(monsterFields);
        temp = myTurn;
        myTurn = notMyTurn;
        notMyTurn = temp;
    }

    private void reset(MonsterField[] monsterFields) {
        for(int i = 0 ; i < 5; i++){
            if(monsterFields[i] != null){
                monsterFields[i].setStatusChangedInTurn(false);
                monsterFields[i].setPutInThisTurn(false);
                monsterFields[i].setHasAttackedInTurn(false);
            }
        }
    }
    private void enterDrawPhase(){
        DrawPhase drawPhase = DrawPhase.getInstance();
        drawPhase.run(Board.getBoardByPlayer(myTurn));
    }
    private void enterMainPhase(){
        MainPhaseView mainPhaseView = MainPhaseView.getInstance();
        mainPhaseView.scan(myTurn,notMyTurn);
    }
    private void enterBattlePhase(){
        BattlePhaseView battlePhaseView = BattlePhaseView.getInstance();
        battlePhaseView.scan(myTurn,notMyTurn);
    }
    private void enterEndPhase(Player notMyTurn){
        EndPhase endPhase = EndPhase.getInstance();
        endPhase.changeTurn(notMyTurn);
    }
    private void setGame(){
        Board.getBoardByPlayer(myTurn).createHand();
        Board.getBoardByPlayer(notMyTurn).createHand();
    }

    public void setHasAttackedInBattlePhase(boolean hasAttackedInBattlePhase) {
        this.hasAttackedInBattlePhase = hasAttackedInBattlePhase;
    }

    private boolean isGameFinished(Board myBoard, Board rivalBoard){
        return (myBoard.getLifePoint()<=0 || rivalBoard.getLifePoint()<=0);
    }
}
