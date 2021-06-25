package Controller;

import Model.Board;
import Model.MonsterCard;
import View.GameView;

public class EffectController {
    private Board myBoard;
    private Board rivalBoard;
    private static EffectController e = null;
    private EffectController(){

    }
    public static EffectController getInstance(){
        if(e == null)
            e = new EffectController();
        return e;
    }
    public void setMyBoard(Board board){
        this.myBoard = board;
    }
    public void setRivalBoard(Board rivalBoard){
        this.rivalBoard = rivalBoard;
    }
    public void activateCallOfTheHauntedEffect(Board board) {  //trap
        GameView.getInstance().printGraveyard(myBoard.getGraveYard());
        GameView.getInstance().printMessage(GameView.Command.pleaseEnterTheCardNumber);
        int cardNumber ;//= Integer.parseInt(GameView.getInstance().scan());
        while (true){
            cardNumber = Integer.parseInt(GameView.getInstance().scan());
            if (!(myBoard.getGraveYard().get(cardNumber - 1) instanceof MonsterCard)) {
                GameView.getInstance().printMessage(GameView.Command.NOTBESUMMONED);
                GameView.getInstance().printMessage(GameView.Command.pleaseEnterTheCardNumber);
            }
            else
                break;
        }
        MainPhase1.getInstance().summonMonster(myBoard,(MonsterCard) myBoard.getGraveYard().get(cardNumber - 1));
        GameView.getInstance().printMessage(GameView.Command.SUMMONSUCCESSFUL);
    }
    public void activateTimeSealEffect() {  //trap
        rivalBoard.setCanGetCardFromDeck(false);
    }
    public void activateMirrorForceEffect() { //trap
        rivalBoard.destroyAllMonsterInAttack();
    }
    public void activateMindCrushEffect() {  //trap
        GameView.getInstance().printMessage(GameView.Command.ENTERTHECARDNAME);
        String cardNameToDestroy = GameView.getInstance().scan();
        if (rivalBoard.isThisCardInHand_ByName(cardNameToDestroy)) {
            rivalBoard.destroyAllSpecialCardForPlayer(cardNameToDestroy);
        } else {
            int a = (int) (Math.random() * (myBoard.getHand().size() + 1));//create random number to remove card from hand
            myBoard.destroyCard(myBoard.getHand().get(a));
        }
    }
    public void activateTorrentialTributeEffect() {  //trap
        rivalBoard.destroyAllMonster();
    }
    public boolean isNegateAttackAvailable(){
        for(int i = 0 ; i < 5; i++){
            if(rivalBoard.getSpellTrapByIndex(i).getCard().getCardName().equals("Negate Attack"))
                return true;
        }
        return false;
    }
}
