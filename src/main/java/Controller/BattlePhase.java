package Controller;

import Model.*;
import View.BattlePhaseView;
import View.GameView;


public class BattlePhase {

    private static BattlePhase b = null;
    private BattlePhaseView view;
    private GameView gameView;
    private GameController gameController;

    private BattlePhase(){
    }

    public static BattlePhase getInstance(){
        if(b == null){
            b = new BattlePhase();
        }
        return b;
    }

    public void ProcessAttack(Board myBoard, Board rivalBoard, int number){
        setView();
        setController();
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

    private void setView() {
        this.view = BattlePhaseView.getInstance();
    }

    public void attack(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if (rivalBoard.checkMirrorForceAvailable()){
            gameView.printMessage(GameView.Command.cantAttackInThisTurn);
            rivalBoard.setMirrorForceEffect(false);
        }
        else{
            if(rivalBoard.isNegateAttackAvailable()){
                view.setHaveToBreak(true);
            }

            else {
                checkSuspiousCardBeforeAttack(rivalMonster, myMonster, myBoard);
                if (rivalMonster.getStatus().equals("OO"))
                    attackOO(myMonster, rivalMonster, myBoard, rivalBoard, number);
                else if (rivalMonster.getStatus().equals("DO"))
                    attackDO(myMonster, rivalMonster, myBoard, rivalBoard, number);
                else {
                    attackDH(myMonster, rivalMonster, myBoard, rivalBoard, number);
                }
            }
        }

    }
    private void attackOO(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(!rivalBoard.canAttack(rivalMonster))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
            if(myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint() > rivalMonster.getMonsterCard().getAttack() + rivalMonster.getExtraAttackPoint()){
                int damage = myMonster.getMonsterCard().getAttack()+myMonster.getExtraAttackPoint() - rivalMonster.getMonsterCard().getAttack() - rivalMonster.getExtraAttackPoint();
                checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
                rivalBoard.destroyMonsterCardByIndex(number - 1);
                myMonster.setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);
                if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard)){
                    rivalBoard.decreaseLifePoint(damage);
                    view.printMessage(BattlePhaseView.Commands.damageOpponent,damage,"");
                }
                Select.getInstance().deSelect();



            }
            else if(myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint() == rivalMonster.getMonsterCard().getAttack() + rivalMonster.getExtraAttackPoint()){
                myBoard.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
                rivalBoard.destroyMonsterCardByIndex(number);
                myMonster.setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);
                view.printMessage(BattlePhaseView.Commands.bothDamage,0,"");
                Select.getInstance().deSelect();

            }
            else if(myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint() < rivalMonster.getMonsterCard().getAttack() + rivalMonster.getExtraAttackPoint()){
                myBoard.destroyMonsterCardByIndex(Select.getInstance().getPosition() - 1);
                int damage = rivalMonster.getMonsterCard().getAttack() - myMonster.getMonsterCard().getAttack();
                myBoard.decreaseLifePoint(damage);
                myMonster.setHasAttackedInTurn(true);
                view.printMessage(BattlePhaseView.Commands.damageMe,damage,"");
                Select.getInstance().deSelect();
            }
        }
    }
    private void attackDO(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(!rivalBoard.canAttack(rivalMonster))
            view.printMessage(BattlePhaseView.Commands.cannotBeAttacked,0,"");
        else{
            if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() < myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
                checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
                rivalBoard.destroyMonsterCardByIndex(number);
                myMonster.setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);
                if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard))
                    view.printMessage(BattlePhaseView.Commands.damageRivalMonster,0,"");
                Select.getInstance().deSelect();

            }
            else if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() == myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
                myMonster.setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);
                view.printMessage(BattlePhaseView.Commands.noDamage,0,"");
                Select.getInstance().deSelect();
            }
            else if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() > myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
                int damage = rivalMonster.getMonsterCard().getDefense() - myMonster.getMonsterCard().getAttack();
                myBoard.decreaseLifePoint(damage);
                myMonster.setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);
                view.printMessage(BattlePhaseView.Commands.justLifePointDecrease,damage,"");
                Select.getInstance().deSelect();
            }
        }
    }
    private void attackDH(MonsterField myMonster, MonsterField rivalMonster, Board myBoard, Board rivalBoard, int number){
        if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() < myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
            checkSuspiciousCardAfterAttack(rivalMonster.getMonsterCard(),myBoard);
            rivalBoard.destroyMonsterCardByIndex(number);
            myMonster.setHasAttackedInTurn(true);
            gameController.setHasAttackedInBattlePhase(true);
            if(!isExplorerCard(rivalMonster.getMonsterCard(),myBoard))
                view.printMessage(BattlePhaseView.Commands.damageRivalMonsterHidden,0,rivalMonster.getMonsterCard().getCardName());
            Select.getInstance().deSelect();
        }
        else if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() == myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
            myMonster.setHasAttackedInTurn(true);
            gameController.setHasAttackedInBattlePhase(true);
            view.printMessage(BattlePhaseView.Commands.noDamageHidden,0,rivalMonster.getMonsterCard().getCardName());
            Select.getInstance().deSelect();
        }
        else if(rivalMonster.getMonsterCard().getDefense() + rivalMonster.getExtraDefensePoint() > myMonster.getMonsterCard().getAttack() + myMonster.getExtraAttackPoint()){
            int damage = rivalMonster.getMonsterCard().getDefense() - myMonster.getMonsterCard().getAttack();
            myBoard.decreaseLifePoint(damage);
            myMonster.setHasAttackedInTurn(true);
            gameController.setHasAttackedInBattlePhase(true);
            view.printMessage(BattlePhaseView.Commands.justLifePointDecreaseHidden,damage,rivalMonster.getMonsterCard().getCardName());
            Select.getInstance().deSelect();
        }

    }

    public void ProcessDirectAttack(Board myBoard, Board rivalBoard) {
        setView();
        setController();
        if (rivalBoard.checkMirrorForceAvailable()){
            myBoard.destroyAllMonsterInAttack();
            gameView.printMessage(GameView.Command.cantAttackInThisTurn);
            rivalBoard.setMirrorForceEffect(false);
        }
        else {
            if (!isACardSelected()) {
                view.printMessage(BattlePhaseView.Commands.noCardSelected, 0, "");
            } else if (!isSelectedCardInMonsterZone()) {
                view.printMessage(BattlePhaseView.Commands.notAttack, 0, "");
            } else if (hasAttackedInTurn(myBoard)) {
                view.printMessage(BattlePhaseView.Commands.hasAttacked, 0, "");
            } else if (!rivalBoard.isMonsterZoneEmpty()) {//add condition that we can't have direct attack ?????
                view.printMessage(BattlePhaseView.Commands.noCardToAttack, 0, "");
            } else {
                int damage = myBoard.getMonsterByIndex(Select.getInstance().getPosition() - 1).getMonsterCard().getAttack() + myBoard.getMonsterByIndex(Select.getInstance().getPosition() -1).getExtraAttackPoint();
                view.printMessage(BattlePhaseView.Commands.directAttackSuccessful, damage, "");
                rivalBoard.decreaseLifePoint(damage);
                myBoard.getMonsterByIndex(Select.getInstance().getPosition() - 1).setHasAttackedInTurn(true);
                gameController.setHasAttackedInBattlePhase(true);

            }
        }
    }
    private void setController(){
        this.gameController = GameController.getInstance();
    }



    private void checkSuspiousCardBeforeAttack(MonsterField rivalMonster,MonsterField myMonster,Board myBoard){

        if(rivalMonster.getMonsterCard().getCardName().equals("Marshmallon") && rivalMonster.getStatus().equals("DH"))
            myBoard.decreaseLifePoint(1000);
        else if(myMonster.getMonsterCard().getCardName().equals("The Calculator")){
            int attack = 0;
            for(int i = 0;i < 5;i++){
                if(myBoard.getMonsterByIndex(i)!= null && myBoard.getMonsterByIndex(i).getStatus().equals("OO"))
                    attack += myBoard.getMonsterByIndex(i).getMonsterCard().getLevel();
            }
            attack *=300;
            myMonster.increaseExtraAttackPoint(attack);
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
        return board.getMonsterByIndex(number) != null;
    }



    public void directAttackAI(MonsterCard myMonster,Board rivalBoard){
        int damage = myMonster.getAttack();
        view.printMessage(BattlePhaseView.Commands.directAttackSuccessful, damage, "");
        rivalBoard.decreaseLifePoint(damage);
    }
}
