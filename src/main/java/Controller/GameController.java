package Controller;

import Model.Board;
import Model.MonsterField;
import Model.Player;
import View.BattlePhaseView;
import View.GameView;
import View.MainPhaseView;

public class GameController {

    private static GameController g = null;
    private Player myTurn;
    private Player notMyTurn;
    private Player temp;
    private boolean hasAttackedInBattlePhase = false;
    private boolean isFirstTurn = true;
    private boolean isSurrendered = false;
    private boolean isNormalSummonedInThisTurn = false;
    private boolean cheat = true;

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
    public void playGame(){
        while(true) {
            if (isFirstTurn) {
                enterMainPhase();
                enterEndPhase(notMyTurn);
                changeTurn();
                isFirstTurn = false;
            } else {
                if (myTurn.getUsername().equals("AI")) {
                    AIFunction.getInstance().run(Board.getBoardByPlayer(myTurn), Board.getBoardByPlayer(notMyTurn));
                    changeTurn();
                } else {
                    if (isSurrendered) {
                        GameView.getInstance().printWinner(notMyTurn, myTurn);
                        giveScores();
                        break;
                    }
                    enterDrawPhase();
                    if (isGameFinished(Board.getBoardByPlayer(myTurn), Board.getBoardByPlayer(notMyTurn))) {
                        findWinner();
                        giveScores();
                        break;
                    }
                    enterMainPhase();
                    enterStandByPhase();
                    if (isGameFinished(Board.getBoardByPlayer(myTurn), Board.getBoardByPlayer(notMyTurn))) {
                        findWinner();
                        giveScores();
                        break;
                    }
                    if (cheat) {
                        giveScores();
                        break;
                    }
                    enterBattlePhase();
                    if (isGameFinished(Board.getBoardByPlayer(myTurn), Board.getBoardByPlayer(notMyTurn))) {
                        findWinner();
                        giveScores();
                        break;
                    }
                    if (hasAttackedInBattlePhase) {
                        enterMainPhase();
                        findWinner();
                        giveScores();

                    }

                    enterEndPhase(notMyTurn);
                    changeTurn();
                }
            }
        }


    }
    public void setCheat(boolean cheat){
        this.cheat = cheat;
    }
    public boolean isSummonedInTurn() {
        return isNormalSummonedInThisTurn;
    }

    public void setSummonedInTurn(boolean summonedInTurn) {
        isNormalSummonedInThisTurn = summonedInTurn;
    }

    private void enterStandByPhase() {
        StandByPhase standByPhase = StandByPhase.getInstance();
        standByPhase.run(Board.getBoardByPlayer(myTurn));
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
        isNormalSummonedInThisTurn = false;
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

    public void setSurrendered(boolean surrendered) {
        isSurrendered = surrendered;
    }

    private boolean isGameFinished(Board myBoard, Board rivalBoard){
        return (myBoard.getLifePoint()<=0 || rivalBoard.getLifePoint()<=0);
    }
    private void giveScores(){
        myTurn.setCoin(1000 + Board.getBoardByPlayer(myTurn).getLifePoint());
        myTurn.setScore(Board.getBoardByPlayer(myTurn).getLifePoint());
        notMyTurn.setCoin(1000 + Board.getBoardByPlayer(notMyTurn).getLifePoint());
        notMyTurn.setScore(Board.getBoardByPlayer(notMyTurn).getLifePoint());
    }
    private void findWinner(){
        if(Board.getBoardByPlayer(myTurn).getLifePoint()<=0){
            GameView.getInstance().printWinner(notMyTurn,myTurn);
            Board.getBoardByPlayer(notMyTurn).increaseNumberOfWins();
        }
        else{
            GameView.getInstance().printWinner(myTurn,notMyTurn);
            Board.getBoardByPlayer(myTurn).increaseNumberOfWins();
        }
    }
}
