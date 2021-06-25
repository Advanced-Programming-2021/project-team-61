package Controller;

import Model.Board;
import Model.MonsterCard;
import View.GameView;

import java.util.Scanner;

public class EffectController {
    private Board myBoard;
    private Board rivalBoard;
    private static EffectController e = null;
    private Scanner scanner = new Scanner(System.in);
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
   public void activateMonsterRebornEffect(){
        System.out.println("please choose which graveYard");
        System.out.println("yours");
        System.out.println("rival");
        String choose = scanner.nextLine();
        if(choose.equals("yours")){
            System.out.println("My graveYard: ");
            GameView.getInstance().printGraveyard(myBoard.getGraveYard());
        }
        else{
          System.out.println("Rival graveYard: ");
          GameView.getInstance().printGraveyard(rivalBoard.getGraveYard());
        }
       GameView.getInstance().printMessage(GameView.Command.askToChooseMonsterFromGraveYard);
       System.out.println("please enter the number of a monster card");
       int x = scanner.nextInt();
       if(choose.equals("yours")){
           myBoard.addMonsterCardToField(x,(MonsterCard) myBoard.getGraveYard().get(x - 1),"OO");
           myBoard.getGraveYard().remove(myBoard.getGraveYard().get(x -1));
       }
        else{
           myBoard.addMonsterCardToField(x,(MonsterCard) rivalBoard.getGraveYard().get(x - 1),"OO");
           rivalBoard.getGraveYard().remove(rivalBoard.getGraveYard().get(x - 1));
       }

   }
   public void activateTerraformingEffect(){
       System.out.println("please choose a field spell card from your deck by name");
       String cardName = scanner.nextLine();
       for(int i = 0 ;i < myBoard.getMainDeck().size();i++){
           if(myBoard.getMainDeck().get(i).getCardName().equals(cardName)){
               myBoard.getMainDeck().remove(i);
               myBoard.getHand().add(myBoard.getMainDeck().get(i));
               break;
           }
       }


   }
   public void activateRaigekiEffect(){
        rivalBoard.destroyAllMonster();
   }
   public void activateDarkHoleEffect(){
        rivalBoard.destroyAllMonster();
        myBoard.destroyAllMonster();
   }
   public void activateSpellAbsorptionEffect(){
        myBoard.increaseLifePoint(500);
   }
   public void activateTwinTwisters(){
       System.out.println("choose a number in hand card to remove it");
       int x = scanner.nextInt();
       myBoard.getHand().remove(x);
       System.out.println("choose a card to destroy");
       x = scanner.nextInt();
       rivalBoard.destroySpellTrapCardByIndex(x - 1);
       System.out.println("Please enter another card to destroy");
       x = scanner.nextInt();
       if(rivalBoard.getNumberOfSpellTrapsInField() == 0)
           System.out.println("no more spell traps available");
       else
           rivalBoard.destroySpellTrapCardByIndex(x - 1);

   }
   public void activateMysticalSpaceTyphoon(){
       System.out.println("choose a number to destroy card");
       int x = scanner.nextInt();
       rivalBoard.destroySpellTrapCardByIndex(x - 1);
   }
   public void activateYamiEffect(){
        for(int i = 0 ; i < 5 ;i++){
            if(myBoard.getMonsterByIndex(i) != null &&(myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Fiend") || myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Spellcaster"))){
                myBoard.getMonsterByIndex(i).increaseExtraDefense(200);
                myBoard.getMonsterByIndex(i).increaseExtraAttackPoint(200);
            }
            else  if(myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Fairy")){
                myBoard.getMonsterByIndex(i).decreaseAttackPoint(200);
                myBoard.getMonsterByIndex(i).decreaseAttackPoint(200);
            }

        }
   }
   public void activateForestEffect(){
       for(int i = 0 ; i < 5 ;i++){
           if(myBoard.getMonsterByIndex(i) != null &&(myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Insect") || myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Warrior")) || myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Beast-Warrior")){
               myBoard.getMonsterByIndex(i).increaseExtraDefense(100);
               myBoard.getMonsterByIndex(i).increaseExtraAttackPoint(100);
           }

   }
}
  public void activateUmirukaEffect(){
        for(int i = 0; i < 5; i++){
            if(myBoard.getMonsterByIndex(i).getMonsterCard().getMonsterType().equals("Aqua")){
                myBoard.getMonsterByIndex(i).increaseExtraAttackPoint(500);
                myBoard.getMonsterByIndex(i).decreaseDefensePoint(400);
            }
        }

}
}
