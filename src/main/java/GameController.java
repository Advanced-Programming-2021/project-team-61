public class GameController {

    private static GameController g = null;
    private Board myTurn;
    private Board notMyTurn;
    private String command;

    private GameController(){
    }
    public static GameController getInstance(){
        if(g ==null)
            g = new GameController();
        return g;
    }
    public void run(Board b1,Board b2){
       setGame(b1,b2);
       //initialized game



    }
    private void setGame(Board b1,Board b2){
        myTurn = b1;
        notMyTurn = b2;
        myTurn.createHand();
        notMyTurn.createHand();
    }
}
