package Controller;

import Model.Board;
import Model.Deck;
import Model.Player;
import View.DeckView;
import View.DualView;

import java.util.regex.Matcher;


public class DualMenu {
    private static DualMenu d = null;
    private DualView view ;
    private Player me;
    private Player rival;
    private DualMenu(){

    }
    public static DualMenu getInstance(){
        if(d == null)
            d = new DualMenu();
        return d;
    }

    public boolean ProcessNewGame(String username,String rivalUsername,String numberOfRound){
        view = DualView.getInstance();
        if(!isPlayer2Exist(rivalUsername)){
            view.printMessage(DualView.Commands.playerTwoNotExist,"");
            return false;
        }
        else if(!isPlayerHaveActivatedDeck(Player.getPlayerByUsername(username))){
            view.printMessage(DualView.Commands.hasNoActiveDeck,username);
            return false;
        }
        else if(!isPlayerHaveActivatedDeck(Player.getPlayerByUsername(rivalUsername))){
            view.printMessage(DualView.Commands.hasNoActiveDeck,rivalUsername);
            return false;
        }
        else if(!isDeckValid(Player.getPlayerByUsername(username))){
            view.printMessage(DualView.Commands.deckInvalid,username);
            return false;

        }
        else if(!isDeckValid(Player.getPlayerByUsername(rivalUsername))){
            view.printMessage(DualView.Commands.deckInvalid,rivalUsername);
            return false;
        }
        else if(!isRoundValid(Integer.parseInt(numberOfRound))){
            view.printMessage(DualView.Commands.roundInvalid,"");
            return false;
        }
        else{
            createGame(Player.getPlayerByUsername(username), Player.getPlayerByUsername(rivalUsername));
         /*   for(int i = 1; i < Integer.parseInt(numberOfRound) ; i++){
                createGame(Player.getPlayerByUsername(username), Player.getPlayerByUsername(rivalUsername));
                GameController g = GameController.getInstance();
                g.run(Player.getPlayerByUsername(username), Player.getPlayerByUsername(rivalUsername));

            }
            printWinnerOfMatch(Player.getPlayerByUsername(username),Player.getPlayerByUsername(rivalUsername));*/
        return true;
        }


    }

    private void printWinnerOfMatch(Player me, Player rival) {
        if(Board.getBoardByPlayer(me).getNumberOfWins() > Board.getBoardByPlayer(rival).getNumberOfWins()){
            System.out.println(me.getUsername()+" 's won the whole match with score"+" "+me.getScore()+"-"+rival.getScore());
        }
        else
            System.out.println(rival.getUsername()+" 's won the whole match with score"+" "+rival.getScore()+"-"+me.getScore());


    }

    private boolean isDeckValid(Player player) {
        return Deck.getActivatedDeck(player).isDeckValid();

    }

    private boolean isRoundValid(int rounds){
        return rounds >= 0 && rounds <= 3;
    }
    private boolean isPlayer2Exist(String username){
        return Player.isUserNameExists(username);

    }
    private boolean isPlayerHaveActivatedDeck(Player player){
        return Deck.isPlayerHaveActivatedDeck(player);

    }
    private void createGame(Player playerOne, Player playerTwo){
        this.me = playerOne;
        this.rival = playerTwo;
        new Board(playerOne);
        new Board(playerTwo);
        setGame(playerOne,playerTwo);
    }
    public Player getMe(){
        return me;
    }
    public Player getRival(){
        return rival;
    }

    private void setGame(Player playerOne, Player playerTwo) {
        Board.getBoardByPlayer(playerOne).createHand();
        Board.getBoardByPlayer(playerTwo).createHand();
    }

}
