package Controller;

import Model.Board;
import Model.MonsterCard;
import Model.Player;
import Model.Select;
import View.BattlePhaseView;
import View.GameView;

import java.nio.charset.MalformedInputException;
import java.util.Scanner;


public class BattlePhase {

    private static BattlePhase b = null;
    private BattlePhaseView view;
    private GameView gameView;

    private BattlePhase(){
    }

    public static BattlePhase getInstance(){
        if(b == null){
            b = new BattlePhase();
        }
        return b;
    }

    public void ProcessAttack(Board myBoard, Board rivalBoard, int number){
        if(!isACardSelected())
            view.printMessage(BattlePhaseView.Commands.noCardSelected,0,"");
        else if(!isSelectedCardInMonsterZone()){
            view.printMessage(BattlePhaseView.Commands.notAttack,0,"");
        }
        else if(hasAttackedInTurn(myBoard)){
           view.printMessage(BattlePhaseView.Commands.hasAttacked,0,"");
        }
        else if(!isMonsterAvailable(rivalBoard,number))
            view.printMessage(BattlePhaseView.Commands.noCardToAttack,0,"");
        else{
            attack(myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);




        }






    }
    private void attack(MonsterCard myMonster, MonsterCard rivalMonster, Board myBoard, Board rivalBoard, int number){
        checkSuspiousCardBeforeAttack(rivalMonster,myMonster,myBoard,rivalBoard,number);
        String status = rivalBoard.getMonsterZoneByNumber(number-1);
        if(status.equals("OO"))
            attackOO(myMonster,rivalMonster,myBoard,rivalBoard,number);
        else if(status.equals("DO"))
            attackDO(myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);
        else{
            attackDH(myBoard.getMonsterCardByKey(Select.getInstance().getPosition()),rivalBoard.getMonsterCardByKey(number),myBoard,rivalBoard,number);
        }

    }
    private void attackOO(MonsterCard myMonster, MonsterCard rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(!rivalBoard.canAttack(rivalMonster.getCardName(),number-1))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
        if(myMonster.getAttack() > rivalMonster.getAttack()){
            int damage = myMonster.getAttack() - rivalMonster.getAttack();
            checkSuspiciousCardAfterAttack(rivalMonster,myBoard);
            rivalBoard.destroyCardInMonsterZone(number);
            if(!isExplorerCard(rivalMonster,myMonster,myBoard)){
            rivalBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.damageOpponent,damage,"");
            }



        }
        else if(myMonster.getAttack() == rivalMonster.getAttack()){
            myBoard.destroyCardInMonsterZone(Select.getInstance().getPosition());
            rivalBoard.destroyCardInMonsterZone(number);
            view.printMessage(BattlePhaseView.Commands.bothDamage,0,"");
        }
        else if(myMonster.getAttack() < rivalMonster.getAttack()){
            myBoard.destroyCardInMonsterZone(Select.getInstance().getPosition());
            int damage = rivalMonster.getAttack() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.damageMe,damage,"");
        }
        if(isGameFinished(myBoard,rivalBoard))
            CalculateScores(myBoard,rivalBoard);
        }
    }
    private void attackDO(MonsterCard myMonster, MonsterCard rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(rivalMonster.getCardName().equals("Command Knight") && !rivalBoard.isMonsterZoneEmpty() && !rivalBoard.getMonsterZoneByNumber(number-1).equals("DH"))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
        if(rivalMonster.getDefense() < myMonster.getAttack()){
            checkSuspiciousCardAfterAttack(rivalMonster,myBoard);
            rivalBoard.destroyCardInMonsterZone(number);
            if(!isExplorerCard(rivalMonster,myMonster,myBoard))
              view.printMessage(BattlePhaseView.Commands.damageRivalMonster,0,"");

        }
        else if(rivalMonster.getDefense() == myMonster.getAttack()){
            view.printMessage(BattlePhaseView.Commands.noDamage,0,"");
        }
        else if(rivalMonster.getDefense() > myMonster.getAttack()){
            int damage = rivalMonster.getDefense() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.justLifePointDecrease,damage,"");
        }
        }
    }
    private void attackDH(MonsterCard myMonster, MonsterCard rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(rivalMonster.getDefense() < myMonster.getAttack()){
            checkSuspiciousCardAfterAttack(rivalMonster,myBoard);
            rivalBoard.destroyCardInMonsterZone(number);
            if(!isExplorerCard(rivalMonster,myMonster,myBoard))
            view.printMessage(BattlePhaseView.Commands.damageRivalMonsterHidden,0,rivalMonster.getCardName());
        }
        else if(rivalMonster.getDefense() == myMonster.getAttack()){
            view.printMessage(BattlePhaseView.Commands.noDamageHidden,0,rivalMonster.getCardName());
        }
        else if(rivalMonster.getDefense() > myMonster.getAttack()){
            int damage = rivalMonster.getDefense() - myMonster.getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.justLifePointDecreaseHidden,damage,rivalMonster.getCardName());
        }

    }

    public void ProcessDirectAttack(Board myBoard, Board rivalBoard){
        if(!isACardSelected()) {
            view.printMessage(BattlePhaseView.Commands.noCardSelected,0,"");
        }else if(!isSelectedCardInMonsterZone()){
            view.printMessage(BattlePhaseView.Commands.notAttack,0,"");
        }else if(hasAttackedInTurn(myBoard)){
            view.printMessage(BattlePhaseView.Commands.hasAttacked,0,"");
        }else if (!rivalBoard.isMonsterZoneEmpty()){//add condition that we can't have direct attack ?????
            view.printMessage(BattlePhaseView.Commands.noCardToAttack,0,"");
        }else {
            int damage = myBoard.getMonsterCardByKey(Select.getInstance().getPosition()).getAttack() + myBoard.getExtraAttackByIndex(Select.getInstance().getPosition());
            view.printMessage(BattlePhaseView.Commands.directAttackSuccessful, damage,"");
            myBoard.setLifePoint(damage);
            if(isGameFinished(myBoard,rivalBoard)){
                CalculateScores(myBoard,rivalBoard);
            }
        }
    }

    private void checkSuspiousCardBeforeAttack(MonsterCard monsterCard,MonsterCard myMonster,Board myBoard,Board rivalBoard,int number){

        if(monsterCard.getCardName().equals("Marshmallon") && rivalBoard.getMonsterZoneByNumber(number-1).equals("DH"))
            myBoard.setLifePoint(1000);
        else if(myMonster.getCardName().equals("The Calculator")){
            int attack = 0;
            for(int i = 0;i<myBoard.getMonsterZone().length;i++){
                if(myBoard.getMonsterZone()[i].equals("OO"))
                  attack += myBoard.getMonsterCardByKey(i+1).getLevel();
            }
            attack *=300;
            myBoard.resetExtraAttackByNumber(Select.getInstance().getPosition()-1);
            myBoard.setExtraAttackByIndex(Select.getInstance().getPosition()-1,attack );
        }

    }
    private boolean isExplorerCard(MonsterCard monsterCard,MonsterCard myMonster,Board board){
        if(monsterCard.getCardName().equals("Explorer Dragon")){
            board.destroyCardInMonsterZone(Select.getInstance().getPosition());
            return true;
        }
        else
            return false;

    }
    private void checkSuspiciousCardAfterAttack(MonsterCard monsterCard,Board myBoard){
        if(monsterCard.getCardName().equals("Yomi Ship")){
            myBoard.destroyCardInMonsterZone(Select.getInstance().getPosition());
            myBoard.setMonsterZone(Select.getInstance().getPosition() -1,"E" );
        }


    }

    private boolean isACardSelected(){
        return Select.getInstance().getLocation()!=null;
    }
    private boolean isSelectedCardInMonsterZone() {
        return Select.getInstance().getLocation() == Select.Location.MONSTER;
    }
    private boolean hasAttackedInTurn(Board board){
      int x = board.getHasAttackInTurn(Select.getInstance().getPosition() - 1);
        return x !=0;
    }
    private boolean isMonsterAvailable(Board board,int number){
        return !board.getMonsterZoneByNumber(number -1).equals("E");
    }
    private boolean isGameFinished(Board myBoard,Board rivalBoard){
        return (myBoard.getLifePoint()<=0 || rivalBoard.getLifePoint()<=0);
    }
    private void CalculateScores(Board myBoard,Board rivalBoard){
        gameView = GameView.getInstance();
        if(myBoard.getLifePoint()<=0){
            rivalBoard.setNumberOfWins();
            gameView.printMessageByString(GameView.Command.playerWins,rivalBoard.getPlayer().getUsername());
        }
        else{
            myBoard.setNumberOfWins();
            gameView.printMessageByString(GameView.Command.playerWins,myBoard.getPlayer().getUsername());
        }
        view.setGameFinished(true);
        GameController.getInstance().setGameFinished(true);

    }
}
