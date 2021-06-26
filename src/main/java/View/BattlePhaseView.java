package View;

import Controller.BattlePhase;
import Controller.GameController;
import Model.Board;
import Model.Player;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BattlePhaseView {
    public enum Commands{
        noCardSelected,
        notAttack,
        hasAttacked,
        noCardToAttack,
        cannotBeAttacked,
        damageOpponent,
        bothDamage,
        damageMe,
        damageRivalMonster,
        noDamage,
        justLifePointDecrease,
        justLifePointDecreaseHidden,
        noDamageHidden,
        damageRivalMonsterHidden,
        directAttackSuccessful,
        actionNotAllowedHere







    }
    private static BattlePhaseView battlePhaseView = null;
    private BattlePhase battlePhase;
    private Scanner scanner = RegisterView.scanner;
    private String command;
    private Matcher matcher;
    private boolean isGameFinished = false;
    private boolean haveToBreak = false;

    private BattlePhaseView() {

    }
    public static BattlePhaseView getInstance(){
        if(battlePhaseView == null)
            battlePhaseView = new BattlePhaseView();
        return battlePhaseView;
    }
    public void scan(Player me , Player rival){
        printPhaseName();
        setController();
        Board myBoard = Board.getBoardByPlayer(me);
        Board rivalBoard = Board.getBoardByPlayer(rival);
        while (true){
            GameView.getInstance().showBoard(Board.getBoardByPlayer(me), Board.getBoardByPlayer(rival));
            command = scanner.nextLine();
            if(command.equals("next phase") || haveToBreak)
                break;
            else if((matcher = getCommandMatcher(command,"attack (\\d+)")).find()){
              battlePhase.ProcessAttack(myBoard,rivalBoard,Integer.parseInt(matcher.group(1)));
              if(isGameFinished){
                  break;
              }

            }
            else if (getCommandMatcher(command,"attack direct").find()){
               battlePhase.ProcessDirectAttack(myBoard,rivalBoard);
               if(isGameFinished)
                   break;
            }
            else if(command.equals("summon"))
                printMessage(Commands.actionNotAllowedHere,0,"");
            else if(command.equals("set"))
                printMessage(Commands.actionNotAllowedHere,0,"");
            else if(command.startsWith("set --position"))
                printMessage(Commands.actionNotAllowedHere,0,"");









        }
    }

    private void setController() {
        this.battlePhase = BattlePhase.getInstance();
    }

    private void printPhaseName() {
        System.out.println("phase : Battle Phase");
    }

    public void printMessage(Commands message,int damage,String name){
        switch (message){
            case noCardSelected:{
                System.out.println("no card is selected yet");
                break;
            }
            case notAttack:{
                System.out.println("you can't attack with this card");
                break;
            }
            case hasAttacked:{
                System.out.println("this card already attacked");
                break;
            }
            case noCardToAttack:{
                System.out.println("there is no card to attack here");
                break;
            }
            case cannotBeAttacked:{
                System.out.println("you can't attack this monster");
                break;
            }
            case damageOpponent:{
                System.out.println("your opponent's monster is destroyed and your opponent receives "+damage+" battle damage");
                break;
            }

            case bothDamage:{
                System.out.println("both you and your opponent monster cards are destroyed and no one receives damage");
                break;
            }
            case damageMe : {
                System.out.println("your monster card is destroyed and you received "+damage+" battle damage");
                break;
            }
            case damageRivalMonster:{
                System.out.println("the defense position monster is destroyed");
                break;
            }
            case noDamage:{
                System.out.println("no card is destroyed");
                break;
            }
            case justLifePointDecrease:{
                System.out.print("no card is destroyed and you received "+damage+" battle damage");
                break;
            }
            case justLifePointDecreaseHidden : {
                System.out.println("opponent's monster card was "+name+ " and "+"no card is destroyed and you received "+damage+" battle damage");
                break;
            }
            case noDamageHidden : {
                System.out.println("opponent's monster card was "+name+"no card is destroyed");
                break;
            }
            case damageRivalMonsterHidden : {
                System.out.println("opponent's monster card was "+name+"the defense position monster is destroyed");
                break;
            }
            case directAttackSuccessful:{
                System.out.println("you opponent receives "+ damage +" battle damage");
                break;
            }
            case actionNotAllowedHere:{
                System.out.println("action not allowed in this phase");
                break;
            }



        }









    }

    public void setHaveToBreak(boolean haveToBreak) {
        this.haveToBreak = haveToBreak;
    }

    public void setGameFinished(boolean gameFinished){
        isGameFinished = gameFinished;
    }
    private Matcher getCommandMatcher(String input, String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }


}
