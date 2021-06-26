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
    private DualMenu(){

    }
    public static DualMenu getInstance(){
        if(d == null)
            d = new DualMenu();
        return d;
    }

    public void ProcessNewGame(Matcher matcher,String username){
        view = DualView.getInstance();
        if(!isPlayer2Exist(matcher.group(1))){
            view.printMessage(DualView.Commands.playerTwoNotExist,"");
        }
        else if(!isPlayerHaveActivatedDeck(Player.getPlayerByUsername(username))){
           view.printMessage(DualView.Commands.hasNoActiveDeck,username);
        }
        else if(!isPlayerHaveActivatedDeck(Player.getPlayerByUsername(matcher.group(1)))){
           view.printMessage(DualView.Commands.hasNoActiveDeck,matcher.group(1));
        }
        else if(!isDeckValid(Player.getPlayerByUsername(username))){
            view.printMessage(DualView.Commands.deckInvalid,username);

        }
        else if(!isDeckValid(Player.getPlayerByUsername(matcher.group(1)))){
            view.printMessage(DualView.Commands.deckInvalid,matcher.group(1));

        }
        else if(!isRoundValid(Integer.parseInt(matcher.group(2)))){
         view.printMessage(DualView.Commands.roundInvalid,"");
        }
        else{
            for(int i = 1; i < Integer.parseInt(matcher.group(2)) ; i++){
                createGame(Player.getPlayerByUsername(username), Player.getPlayerByUsername(matcher.group(1)));
                GameController g = GameController.getInstance();
                g.run(Player.getPlayerByUsername(username), Player.getPlayerByUsername(matcher.group(1)));

            }

        }


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
        new Board(playerOne);
        new Board(playerTwo);
    }

}
