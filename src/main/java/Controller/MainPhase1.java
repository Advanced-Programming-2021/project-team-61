package Controller;

import Model.*;
import View.GameView;
import View.MainPhaseView;
import View.RegisterView;
import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainPhase1 {

    private static MainPhase1 m = null;
    private MainPhaseView view;
    private GameView gameView;
    private EffectController effectController;

    private MainPhase1() {
    }

    public static MainPhase1 getInstance() {
        if (m == null)
            m = new MainPhase1();
        return m;
    }

    public boolean ProcessSummon(Board board,int index) {
        view = MainPhaseView.getInstance();
        gameView = GameView.getInstance();
      //  if (!isACardSelected()) {
          //  view.printMessage(MainPhaseView.Commands.NoCardSelected);
       /* } else*/ if (!isCardInHandMonsterCard(board,index)) {
          //  view.printMessage(MainPhaseView.Commands.CannotBeSummoned);
            return false;
        } else if (isMonsterZoneFull(board)) {
           // view.printMessage(MainPhaseView.Commands.MonsterZoneFull);
            return false;
        } else if (GameController.getInstance().isSummonedInTurn()) {
            //view.printMessage(MainPhaseView.Commands.SummonIsDoneOnce);
            return false;
        } else {
            MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(index);
            if(monsterCard.getLevel() <= 4){
                return true;
            }
            else return IsMonsterEnoughForTribute(board, monsterCard);
        }
    }

   /* private void ProcessTribute(Board board) {
        MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(Select.getInstance().getPosition() - 1);
        if (monsterCard.getLevel() <= 4) {
            summonMonster(board, monsterCard);
            GameController.getInstance().setSummonedInTurn(true);
            Select.getInstance().deSelect();
            processTerratiger(monsterCard,board);
        } else {
            if (!IsMonsterEnoughForTribute(board, monsterCard))
                view.printMessage(MainPhaseView.Commands.NotEnoughCardsForTribute);
            else {
                if(Tribute(board,monsterCard)){
                    summonMonster(board,monsterCard);
                    Select.getInstance().deSelect();
                }
            }
        }
    }*/


    public boolean ProcessSet(Board board,int index) {
      //  if (!isACardSelected())
          //  view.printMessage(MainPhaseView.Commands.NoCardSelected);
       // else if (!isSelectedCardInHand())
        //    view.printMessage(MainPhaseView.Commands.CannotSetMonsterCard);
       // else if (isCardInHandMonsterCard(board)) {
          //  if (isMonsterZoneFull(board))
           //     view.printMessage(MainPhaseView.Commands.MonsterZoneFull);
          //  else if (GameController.getInstance().isSummonedInTurn())
          //      view.printMessage(MainPhaseView.Commands.SummonIsDoneOnce);
          //  else {
              //  MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(Select.getInstance().getPosition() - 1);
             //   setMonster(board, monsterCard);
             //   Select.getInstance().deSelect();
             //   view.printMessage(MainPhaseView.Commands.SetSuccessful);
             //   GameController.getInstance().setSummonedInTurn(true);
           // }
       /* } else*/
        return isCardInHandSpellTrap(board, index) && !isSpellTrapZoneFull(board);
              //  view.printMessage(MainPhaseView.Commands.SpellZoneFull);

    }

    public void ProcessFlipSummon(Board board, Board rivalBoard) {
        if (!isACardSelected())
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        else if (!isSelectedCardInMonsterZone())
            view.printMessage(MainPhaseView.Commands.CannotChangePosition);
        else if (!isMonsterCardDefenseHidden(board) ) {//needs one more if
            view.printMessage(MainPhaseView.Commands.CannotFlip);
        } else {
            flipSummonMonster(board);
            Select.getInstance().deSelect();
            checkToActivateEffect(board.getMonsterByIndex(Select.getInstance().getPosition()), rivalBoard);
        }
    }

    public void ProcessSetPosition(Board board, Matcher matcher) {
        String newPosition = matcher.group(1);
        if (!isACardSelected())
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        else if (!isSelectedCardInMonsterZone())
            view.printMessage(MainPhaseView.Commands.CannotChangePosition);
        else if (isPositionChangedInTurn(board))
            view.printMessage(MainPhaseView.Commands.AlreadyChangedPositionInTurn);
        else {
            if (newPosition.equals("attack")) {
                if (isMonsterCardInTheWantedPosition(board, "OO"))
                    view.printMessage(MainPhaseView.Commands.TheCardInWantedPosition);
                else
                    setAttackMonsterCard(board);

            } else {
                if (isMonsterCardInTheWantedPosition(board, "DO"))
                    view.printMessage(MainPhaseView.Commands.TheCardInWantedPosition);
                else
                    setDefenseMonsterCard(board);
            }
        }
    }

    public void checkToActivateEffect(MonsterField monsterField, Board rivalBoard) {
        if (monsterField.getMonsterCard().getCardName().equals("Man-Eater Bug")) {
            System.out.println("you can destroy a monster card of your rival Do you want to do that?");
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextLine().equals("Yes!"))
                rivalBoard.destroyMonsterCardByIndex(scanner.nextInt() - 1);
            else
                System.out.println("OK!");
        }
    }

    public void ProcessShowCard(Board myBoard, Board rivalBoard) {
        gameView = GameView.getInstance();
        if (!isACardSelected()) {
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        } else if (!canISeeSelectedCard(rivalBoard)) {
            view.printMessage(MainPhaseView.Commands.CardIsNotVisible);
        } else {
            //show card information...
            if (isSelectedCardInHand()) {
                gameView.showCard_hand(myBoard, Select.getInstance().getPosition() - 1);
            } else if (isSelectedCardInMonsterZone()) {
                gameView.showCard_myMonster(myBoard, Select.getInstance().getPosition() - 1);
            } else if (isSelectedCardInSpellZone()) {
                gameView.showCard_mySpellTrap(myBoard, Select.getInstance().getPosition() - 1);
            } else if (isSelectedCardInMonsterOpponent()) {
                gameView.showCard_myMonster(rivalBoard, Select.getInstance().getPosition() - 1);
            } else if (isSelectedCardInSpellOpponent()) {
                gameView.showCard_mySpellTrap(rivalBoard, Select.getInstance().getPosition() - 1);
            }// Should I show the card in myField and opponentField?????

        }
    }


    private boolean canISeeSelectedCard(Board rivalBoard) {
        if (isSelectedCardInMonsterOpponent() && isMonsterCardDefenseHidden(rivalBoard))
            return false;
        else if (isSelectedCardInSpellOpponent() && isSpellTrapHidden(rivalBoard))
            return false;
        else return Select.getInstance().getLocation() != Select.Location.FIELDOPPONENT;
    }

    public boolean ProcessActivation(Board board,Board rival,int index) {
        setEffectController(board,rival);
       // if (!isACardSelected())
         //   view.printMessage(MainPhaseView.Commands.NoCardSelected);
       /* else*/ if (!isSelectedCardSpell())
           return false;
           // view.printMessage(MainPhaseView.Commands.NotSpellCard);
        else if (isSpellActivated(board))
            return false;
          //  view.printMessage(MainPhaseView.Commands.isActivated);
        else //   view.printMessage(MainPhaseView.Commands.noPreparatipn);
            if (isSelectedCardInHand() && isSpellTrapZoneFull(board)) {
            return false;
          //  view.printMessage(MainPhaseView.Commands.SpellZoneFull);
        } else return isPreprationPreparedForSpecialCards(rival, board);
        //    board.activateEffect();
    }

    private void setEffectController(Board me,Board rival) {
        effectController = EffectController.getInstance();
        effectController.setMyBoard(me);
        effectController.setRivalBoard(rival);
    }

    public void activateEffectOfCard(Card card) {
        String cardName = card.getCardName();
        switch (cardName){
            case "Monster Reborn" :{
                effectController.activateMonsterRebornEffect();
                break;
            }
            case "Terraforming" :{
                effectController.activateTerraformingEffect();
                break;
            }
            case "Raigeki" : {
                effectController.activateRaigekiEffect();
                break;
            }
            case "Dark Hole" : {
                effectController.activateDarkHoleEffect();
                break;
            }
            case "Spell Absorption" : {
                effectController.activateSpellAbsorptionEffect();
                break;
            }
            case "Messenger of peace" : {
                effectController.activateMessengerEffect();
                break;
            }
            case "Twin Twisters" : {
                effectController.activateTwinTwisters();
                break;
            }
            case "Yami" : {
                effectController.activateYamiEffect();
                break;
            }
            case "Forest" : {
                effectController.activateForestEffect();
                break;
            }
            case "UMIRUKA" : {
                effectController.activateUmirukaEffect();
                break;
            }
            case "Mystical space typhoon": {
                effectController.activateMysticalSpaceTyphoon();
                break;
            }
        }
    }

    private boolean isPreprationPreparedForSpecialCards(Board rival,Board my) {
        if(Select.getInstance().getCard().getCardName().equals("Twin Twisters")){
            return !rival.isSpellTrapFieldEmpty();
        }
        if(Select.getInstance().getCard().getCardName().equals("Mystical space typhoon")){
            return !rival.isSpellTrapFieldEmpty();
        }
        if(Select.getInstance().getCard().getCardName().equals("Monster Reborn")){
            return my.isGraveYardHaveMonsterCard()  && !my.isMonsterZoneEmpty() && rival.isGraveYardHaveMonsterCard();
        }
        if(Select.getInstance().getCard().getCardName().equals("Terraforming")){
            return my.isMainDeckHaveFieldSpellCard();
        }
        if(Select.getInstance().getCard().getCardName().equals("Raigeki")){
            return !rival.isMonsterZoneEmpty();
        }
        if(Select.getInstance().getCard().getCardName().equals("Dark Hole")){
           return  !rival.isMonsterZoneEmpty() || !my.isMonsterZoneEmpty();

        }
        return true;
    }

    private void processTerratiger(MonsterCard monsterCard,Board board){
        if(monsterCard.getCardName().equals("Terratiger, the Empowered Warrior")){
            System.out.println("Do you want to activate your effect?");
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextLine().equals("yes")){
                System.out.println("please choose a monster in your hand which its level is lower than 4");
                if( !board.isThisCardInHand_ByName(scanner.nextLine()))
                    System.out.println("no monster card there!");
                else{
                    System.out.println("please type the number of that card");
                    int x = scanner.nextInt();
                    MonsterCard monsterCard1 = (MonsterCard) board.getCardFromHand(x-1);
                    if(monsterCard1.getLevel()>4)
                        System.out.println("cannot summon this");
                    else
                        //alaki
                        x = 1;
                      //  summonMonster(board,(MonsterCard) board.getCardFromHand(x-1));
                }
            }


        }

    }

    private boolean isACardSelected() {
        return Select.getInstance().getLocation() != null;
    }

    private boolean isSelectedCardInHand() {
        return Select.getInstance().getLocation() == Select.Location.HAND;
    }

    private boolean isCardInHandMonsterCard(Board board,int index) {
        return board.getCardFromHand(index) instanceof MonsterCard;

    }

    private boolean isMonsterZoneFull(Board board) {
        MonsterField[] monsterFields = board.getMonstersInField();
        for(int i = 0; i < 5; i++){
            if(monsterFields[i] == null)
                return false;
        }
        return true;
    }

     public int summonMonster(Board board,int index) {
        MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(index);
        int emptyPlace = board.getEmptyPlaceInMonsterZone();
        board.addMonsterCardToField(emptyPlace, monsterCard,"OO");
        if(monsterCard.getCardName().equals("Command Knight")){
            board.getMonsterByIndex(emptyPlace).setEffectActivated(true);
            Card.activateCommandKnightEffect(board);
        }
        board.getHand()[index] = null;
        return emptyPlace;

     //   view.printMessage(MainPhaseView.Commands.SummonSuccessful);
    }

    private boolean IsMonsterEnoughForTribute(Board board, MonsterCard monsterCard) {
        int level = monsterCard.getLevel();
        if (level <= 6)
            return board.getNumberOfMonstersInField() >= 1;
        else
            return board.getNumberOfMonstersInField() >= 2;
    }

    private boolean Tribute(Board board, MonsterCard monsterCard) {
        Scanner scanner = new Scanner(System.in);
        int address;
        int address2;
        int level = monsterCard.getLevel();
        if (level <= 6) {
            address = scanner.nextInt();
            if (!board.isMonsterAvailableInMonsterZone(address - 1)){
                view.printMessage(MainPhaseView.Commands.NoMonsterInAddress);
                return false;
            }
            else{
                board.destroyMonsterCardByIndex(address - 1);
                return true;
            }
        }
        else {
            address = scanner.nextInt();
            address2 = scanner.nextInt();
            if (!board.isMonsterAvailableInMonsterZone(address -1) || !board.isMonsterAvailableInMonsterZone(address2 -1)){
                view.printMessage(MainPhaseView.Commands.NoMonsterInAddress);
                return false;
            }
            else{
                board.destroyMonsterCardByIndex(address - 1);
                board.destroyMonsterCardByIndex(address2 - 1);
                return true;
            }
        }
    }

    public int setMonster(Board board, int index) {
        MonsterCard monsterCard =(MonsterCard) board.getCardFromHand(index);
        int emptyPlace = board.getEmptyPlaceInMonsterZone();
        board.addMonsterCardToField(emptyPlace, monsterCard,"DH");
       // view.printMessage(MainPhaseView.Commands.SetSuccessful);
        return emptyPlace;
    }

    private boolean isSpellTrapZoneFull(Board board) {
        SpellTrapField[] spellTrapFields = board.getSpellTrapsInField();
        for (int i = 0; i < 5; i++) {
            if (spellTrapFields[i] == null)
                return false;
        }
        return true;
    }

    private boolean isCardInHandSpellTrap(Board board,int index) {
        return board.getCardFromHand(index) instanceof SpellCard
                || board.getCardFromHand(index) instanceof TrapCard;
    }

    public int setSpellTrap(Board board,int index) {
        int emptyPlace = board.getEmptyPlaceInSpellTrapZone();
        board.addSpellTrapCardToField(emptyPlace, board.getCardFromHand(index),"H");
        return emptyPlace;
     //   view.printMessage(MainPhaseView.Commands.SetSuccessful);
     //   Select.getInstance().deSelect();
    }

    private boolean isSelectedCardInMonsterZone() {
        return Select.getInstance().getLocation() == Select.Location.MONSTER;
    }

    private boolean isMonsterCardDefenseHidden(Board board) {
        return board.getMonsterByIndex(Select.getInstance().getPosition() - 1).getStatus().equals("DH");
    }

    private void flipSummonMonster(Board board) {
        board.getMonsterByIndex(Select.getInstance().getPosition() - 1).setStatus("OO");
    }

    private boolean isPositionChangedInTurn(Board board) {
        return board.getMonsterByIndex(Select.getInstance().getPosition() - 1).isStatusChangedInTurn();
    }

    private boolean isMonsterCardInTheWantedPosition(Board board, String position) {
        return board.getMonsterByIndex(Select.getInstance().getPosition() - 1).getStatus().equals(position);
    }

    private void setAttackMonsterCard(Board board) {
        view.printMessage(MainPhaseView.Commands.MonsterChangedPositionSuccessful);
        board.getMonsterByIndex(Select.getInstance().getPosition() - 1).setStatus("OO");
        board.getMonsterByIndex(Select.getInstance().getPosition() - 1).setStatusChangedInTurn(true);
    }

    private void setDefenseMonsterCard(Board board) {
        view.printMessage(MainPhaseView.Commands.MonsterChangedPositionSuccessful);
        board.getMonsterByIndex(Select.getInstance().getPosition() - 1).setStatus("DO");
        board.getMonsterByIndex(Select.getInstance().getPosition() - 1).setStatusChangedInTurn(true);
    }

    private boolean isSelectedCardInSpellZone() {
        return Select.getInstance().getLocation() == Select.Location.SPELL;
    }

    private boolean isSelectedCardInMonsterOpponent() {
        return Select.getInstance().getLocation() == Select.Location.MONSTEROPPONENT;
    }

    private boolean isSelectedCardInSpellOpponent() {
        return Select.getInstance().getLocation() == Select.Location.SPELLOPPONENT;
    }

    private boolean isSelectedCardSpell() {
        return Select.getInstance().getCard() instanceof SpellCard;
    }

    private boolean isSpellActivated(Board board) {
        return board.getSpellTrapByIndex(Select.getInstance().getPosition() - 1).getStatus().equals("O");
    }

    private boolean isSpellTrapHidden(Board board) {
        return board.getSpellTrapByIndex(Select.getInstance().getPosition() - 1).getStatus().equals("H");
    }
    private boolean isGameFinished(Board myBoard,Board rivalBoard){
        return myBoard.getLifePoint() <= 0 || rivalBoard.getLifePoint() <= 0;


    }
}





