package Controller;

import Model.Board;
import Model.MonsterCard;
import View.MainPhaseView;

public class AIFunction {
    private Board myBoard;
    private Board rivalBoard;

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
        int rivalCounter=1;
	    for (int i = 1; i <= 5; i++) {
            if (!myBoard.isMonsterAvailableInMonsterZone(i)){
                break;
            }else{
                for (;rivalCounter<=5;rivalCounter++){
                    if (rivalBoard.isMonsterAvailableInMonsterZone(rivalCounter)){
                        BattlePhase.getInstance().attack(myBoard.getMonsterByIndex(i),rivalBoard.getMonsterByIndex(rivalCounter),myBoard,rivalBoard,rivalCounter-1);
                        break;
                    }
                }
                rivalCounter++;
                BattlePhase.getInstance().directAttackAI(myBoard.getMonsterByIndex(i).getMonsterCard(),rivalBoard);
            }
        }
    }
}
