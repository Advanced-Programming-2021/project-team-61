package Controller;

import Model.Board;
import Model.MonsterCard;
import View.MainPhaseView;

public class AIFunction {
    private Board myBoard;
    private Board rivalBoard;
    private static AIFunction A = null;

    private AIFunction(){
    }
    public static AIFunction getInstance(){
        if(A ==null)
            A = new AIFunction();
        return A;
    }
    public void run(Board me, Board rival){
        myBoard = me;
        rivalBoard = rival;
        summonMonster((MonsterCard) myBoard.getHand().get(0));
        processAttack();
    }

    private void summonMonster(MonsterCard monsterCard) {
        int emptyPlace = myBoard.getEmptyPlaceInMonsterZone();
        myBoard.addMonsterCardToField(emptyPlace,monsterCard,"OO");
        MainPhaseView.getInstance().printMessage(MainPhaseView.Commands.SummonSuccessful);
    }

    public void processAttack(){
        int rivalCounter=0;
        int i=0;
        while (i<=4){
            if (myBoard.isMonsterAvailableInMonsterZone(i) && rivalCounter<=4){
                for (;rivalCounter<=4;rivalCounter++){
                    if (rivalBoard.isMonsterAvailableInMonsterZone(rivalCounter)){
                        BattlePhase.getInstance().attack(myBoard.getMonsterByIndex(i),rivalBoard.getMonsterByIndex(rivalCounter),myBoard,rivalBoard,rivalCounter-1);
                        i++;
                        break;
                    }
                }
                rivalCounter++;
            }else if (myBoard.isMonsterAvailableInMonsterZone(i)){
                BattlePhase.getInstance().directAttackAI(myBoard.getMonsterByIndex(i).getMonsterCard(),rivalBoard);
                i++;
            }else {
                i++;
            }
        }
    }
}
