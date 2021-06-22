package Controller;

import Model.*;
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
            attack(myBoard.getMonsterByIndex(Select.getInstance().getPosition() - 1),rivalBoard.getMonsterByIndex(number),myBoard,rivalBoard,number);




        }






    }
    private void attack(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if (rivalBoard.isMirrorForceEffectActive()){
            myBoard.destroyAllMonsterInAttack();
            gameView.printMessage(GameView.Command.cantAttackInThisTurn);
            rivalBoard.setMirrorForceEffect(false);
        }else {
            checkSuspiousCardBeforeAttack(rivalMonster, myMonster, myBoard, rivalBoard, number);
            if (rivalMonster.getStatus().equals("OO"))
                attackOO(myMonster, rivalMonster, myBoard, rivalBoard, number);
            else if (rivalMonster.getStatus().equals("DO"))
                attackDO(myMonster, rivalMonster, myBoard, rivalBoard, number);
            else {
                attackDH(myMonster, rivalMonster, myBoard, rivalBoard, number);
            }
        }

    }
    private void attackOO(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(!rivalBoard.canAttack(rivalMonster.getMonsterCard().getCardName(),number - 1))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
        if(myMonster.getMonsterCard().getAttack() > rivalMonster.getMonsterCard().getAttack()){
            int damage = myMonster.getMonsterCard().getAttack() - rivalMonster.getMonsterCard().getAttack();
            checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
            rivalBoard.destroyMonsterCardByIndex(number - 1);
            if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard)){
            rivalBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.damageOpponent,damage,"");
            }



        }
        else if(myMonster.getMonsterCard().getAttack() == rivalMonster.getMonsterCard().getAttack()){
            myBoard.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
            rivalBoard.destroyMonsterCardByIndex(number);
            view.printMessage(BattlePhaseView.Commands.bothDamage,0,"");
        }
        else if(myMonster.getMonsterCard().getAttack() < rivalMonster.getMonsterCard().getAttack()){
            myBoard.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
            int damage = rivalMonster.getMonsterCard().getAttack() - myMonster.getMonsterCard().getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.damageMe,damage,"");
        }
        if(isGameFinished(myBoard,rivalBoard))
            CalculateScores(myBoard,rivalBoard);
        }
    }
    private void attackDO(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(rivalMonster.getMonsterCard().getCardName().equals("Command Knight") && !rivalBoard.isMonsterZoneEmpty() && rivalMonster.getStatus().equals("DH"))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
        if(rivalMonster.getMonsterCard().getDefense() < myMonster.getMonsterCard().getAttack()){
            checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
            rivalBoard.destroyMonsterCardByIndex(number);
            if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard))
              view.printMessage(BattlePhaseView.Commands.damageRivalMonster,0,"");

        }
        else if(rivalMonster.getMonsterCard().getDefense() == myMonster.getMonsterCard().getAttack()){
            view.printMessage(BattlePhaseView.Commands.noDamage,0,"");
        }
        else if(rivalMonster.getMonsterCard().getDefense() > myMonster.getMonsterCard().getAttack()){
            int damage = rivalMonster.getMonsterCard().getDefense() - myMonster.getMonsterCard().getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.justLifePointDecrease,damage,"");
        }
        }
    }
    private void attackDH(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(rivalMonster.getMonsterCard().getDefense() < myMonster.getMonsterCard().getAttack()){
            checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
            rivalBoard.destroyMonsterCardByIndex(number);
            if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard))
            view.printMessage(BattlePhaseView.Commands.damageRivalMonsterHidden,0,rivalMonster.getMonsterCard().getCardName());
        }
        else if(rivalMonster.getMonsterCard().getDefense() == myMonster.getMonsterCard().getAttack()){
            view.printMessage(BattlePhaseView.Commands.noDamageHidden,0,rivalMonster.getMonsterCard().getCardName());
        }
        else if(rivalMonster.getMonsterCard().getDefense() > myMonster.getMonsterCard().getAttack()){
            int damage = rivalMonster.getMonsterCard().getDefense() - myMonster.getMonsterCard().getAttack();
            myBoard.setLifePoint(damage);
            view.printMessage(BattlePhaseView.Commands.justLifePointDecreaseHidden,damage,rivalMonster.getMonsterCard().getCardName());
        }

    }

    public void ProcessDirectAttack(Board myBoard, Board rivalBoard) {
        if (rivalBoard.isMirrorForceEffectActive()){
            myBoard.destroyAllMonsterInAttack();
            gameView.printMessage(GameView.Command.cantAttackInThisTurn);
            rivalBoard.setMirrorForceEffect(false);
        }else {
            if (!isACardSelected()) {
                view.printMessage(BattlePhaseView.Commands.noCardSelected, 0, "");
            } else if (!isSelectedCardInMonsterZone()) {
                view.printMessage(BattlePhaseView.Commands.notAttack, 0, "");
            } else if (hasAttackedInTurn(myBoard)) {
                view.printMessage(BattlePhaseView.Commands.hasAttacked, 0, "");
            } else if (!rivalBoard.isMonsterZoneEmpty()) {//add condition that we can't have direct attack ?????
                view.printMessage(BattlePhaseView.Commands.noCardToAttack, 0, "");
            } else {
                int damage = myBoard.getMonsterByIndex(Select.getInstance().getPosition() - 1).getMonsterCard().getAttack() + myBoard.getExtraAttackByIndex(Select.getInstance().getPosition());
                view.printMessage(BattlePhaseView.Commands.directAttackSuccessful, damage, "");
                myBoard.setLifePoint(damage);
                if (isGameFinished(myBoard, rivalBoard)) {
                    CalculateScores(myBoard, rivalBoard);
                }
            }
        }
    }

    private void checkSuspiousCardBeforeAttack(MonsterField rivalMonster,MonsterField myMonster,Board myBoard,Board rivalBoard,int number){

        if(rivalMonster.getMonsterCard().getCardName().equals("Marshmallon") && rivalMonster.getStatus().equals("DH"))
            myBoard.setLifePoint(1000);
        else if(myMonster.getMonsterCard().getCardName().equals("The Calculator")){
            int attack = 0;
            for(int i = 0;i < 5;i++){
                if(myBoard.getMonsterByIndex(i)!= null && myBoard.getMonsterByIndex(i).getStatus().equals("OO"))
                  attack += myBoard.getMonsterByIndex(i).getMonsterCard().getLevel();
            }
            attack *=300;
            myBoard.resetExtraAttackByNumber(Select.getInstance().getPosition()-1);
            myBoard.setExtraAttackByIndex(Select.getInstance().getPosition()-1,attack);
        }

    }
    private boolean isExplorerCard(MonsterCard monsterCard,Board board){
        if(monsterCard.getCardName().equals("Explorer Dragon")){
            board.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
            return true;
        }
        else
            return false;

    }
    private void checkSuspiciousCardAfterAttack(MonsterCard monsterCard,Board myBoard){
        if(monsterCard.getCardName().equals("Yomi Ship"))
            myBoard.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
    }

    private boolean isACardSelected(){
        return Select.getInstance().getLocation()!=null;
    }
    private boolean isSelectedCardInMonsterZone() {
        return Select.getInstance().getLocation() == Select.Location.MONSTER;
    }
    private boolean hasAttackedInTurn(Board board){
      return board.getMonsterByIndex(Select.getInstance().getPosition() - 1).isHasAttackedInTurn();
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
