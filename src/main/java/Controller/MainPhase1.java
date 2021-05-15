package Controller;

import Model.*;
import View.GameView;
import View.MainPhaseView;
import java.util.Scanner;
import java.util.regex.Matcher;

public class MainPhase1 {

    private static MainPhase1 m = null;
    private MainPhaseView view;
    private GameView gameView;

    private MainPhase1() {
    }

    public static MainPhase1 getInstance() {
        if (m == null)
            m = new MainPhase1();
        return m;
    }

    public void ProcessSummon(Board board) {
        view = MainPhaseView.getInstance();
        gameView = GameView.getInstance();
        if (!isACardSelected()) {
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        } else if (!isSelectedCardInHand() || !isCardInHandMonsterCard(board)) { //needs one more if
            view.printMessage(MainPhaseView.Commands.CannotBeSummoned);
        } else if (isMonsterZoneFull(board)) {
            view.printMessage(MainPhaseView.Commands.MonsterZoneFull);
        } else if (gameView.isSummonedInTurn()) {
            view.printMessage(MainPhaseView.Commands.SummonIsDoneOnce);
        } else {
            ProcessTribute(board);
        }
    }

    private void ProcessTribute(Board board) {
        MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(Select.getInstance().getPosition() - 1);
        if (monsterCard.getLevel() <= 4) {
            summonMonster(board, monsterCard);
        } else {
            if (!IsMonsterEnoughForTribute(board, monsterCard))
                view.printMessage(MainPhaseView.Commands.NotEnoughCardsForTribute);
            else
                Tribute(board, monsterCard);
        }
    }

    public void ProcessSet(Board board) {
        if (!isACardSelected())
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        else if (!isSelectedCardInHand())
            view.printMessage(MainPhaseView.Commands.CannotSetMonsterCard);
        else if (isCardInHandMonsterCard(board)) {
            if (isMonsterZoneFull(board))
                view.printMessage(MainPhaseView.Commands.MonsterZoneFull);
            else if (gameView.isSummonedInTurn())
                view.printMessage(MainPhaseView.Commands.SummonIsDoneOnce);
            else {
                MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(Select.getInstance().getPosition() - 1);
                setMonster(board, monsterCard);
                view.printMessage(MainPhaseView.Commands.SetSuccessful);
            }
        } else if (isCardInHandSpellTrap(board)) {
            if (isSpellTrapZoneFull(board))
                view.printMessage(MainPhaseView.Commands.SpellZoneFull);
            else
                setSpellTrap(board);
        }
    }

    public void ProcessFlipSummon(Board board, Board rivalBoard) {
        if (isACardSelected())
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        else if (!isSelectedCardInMonsterZone())
            view.printMessage(MainPhaseView.Commands.CannotChangePosition);
        else if (!isMonsterCardDefenseHidden(board)) {//needs one more if
            view.printMessage(MainPhaseView.Commands.CannotFlip);
        } else {
            flipSummonMonster(board);
            checkToActivateEffect(board.getMonsterCardByKey(Select.getInstance().getPosition()), rivalBoard);
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
                if (isMonsterCardInTheWantedPosition(board, "DO"))
                    view.printMessage(MainPhaseView.Commands.TheCardInWantedPosition);
                else
                    setAttackMonsterCard(board);
            } else {
                if (isMonsterCardInTheWantedPosition(board, "OO"))
                    view.printMessage(MainPhaseView.Commands.TheCardInWantedPosition);
                else
                    setDefenseMonsterCard(board);
            }
        }
    }

    public void checkToActivateEffect(MonsterCard monsterCard, Board rivalBoard) {
        if (monsterCard.getCardName().equals("Man-Eater Bug")) {
            Scanner scanner = new Scanner(System.in);
            rivalBoard.destroyCardInMonsterZone(scanner.nextInt());
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
                gameView.showCard_myMonster(myBoard, Select.getInstance().getPosition());
            } else if (isSelectedCardInSpellZone()) {
                gameView.showCard_mySpellTrap(myBoard, Select.getInstance().getPosition());
            } else if (isSelectedCardInMonsterOpponent()) {
                gameView.showCard_myMonster(rivalBoard, Select.getInstance().getPosition());
            } else if (isSelectedCardInSpellOpponent()) {
                gameView.showCard_mySpellTrap(rivalBoard, Select.getInstance().getPosition());
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

    public void ProcessActivation(Board board) {
        if (!isACardSelected())
            view.printMessage(MainPhaseView.Commands.NoCardSelected);
        else if (!isSelectedCardSpell())
            view.printMessage(MainPhaseView.Commands.NotSpellCard);
        else if (isSpellActivated(board))
            view.printMessage(MainPhaseView.Commands.isActivated);
        else if (isSelectedCardInHand() && isSpellTrapZoneFull(board)) {//needs one more if
            view.printMessage(MainPhaseView.Commands.SpellZoneFull);
        } else if (false) {//prepration??
            board.getSpellTrapByKey(1);
        } else
            board.activateEffect();
    }

    private boolean isACardSelected() {
        return Select.getInstance().getLocation() != null;
    }

    private boolean isSelectedCardInHand() {
        return Select.getInstance().getLocation() == Select.Location.HAND;
    }

    private boolean isCardInHandMonsterCard(Board board) {
        return board.getCardFromHand(Select.getInstance().getPosition() - 1) instanceof MonsterCard;

    }

    private boolean isMonsterZoneFull(Board board) {
        String[] monsterZone = board.getMonsterZone();
        for (int i = 0; i < monsterZone.length; i++) {
            if (monsterZone[i].equals("E"))
                return false;
        }
        return true;

    }

    private void summonMonster(Board board, MonsterCard monsterCard) {
        int emptyPlace = board.getEmptyPlaceInMonsterZone();
        board.setMonsterZone(emptyPlace, "OO");
        board.addMonsterCardToField(emptyPlace + 1, monsterCard);
        view.printMessage(MainPhaseView.Commands.SummonSuccessful);
    }

    private boolean IsMonsterEnoughForTribute(Board board, MonsterCard monsterCard) {
        int level = monsterCard.getLevel();
        if (level <= 6)
            return board.getMonsterCardsInField().size() >= 1;
        else
            return board.getMonsterCardsInField().size() >= 2;
    }

    private void Tribute(Board board, MonsterCard monsterCard) {
        Scanner scanner = new Scanner(System.in);
        int address;
        int address2;
        int level = monsterCard.getLevel();
        if (level <= 6) {
            address = scanner.nextInt();
            if (!board.isMonsterAvailableInMonsterZone(address - 1))
                view.printMessage(MainPhaseView.Commands.NoMonsterInAddress);
            else {
                board.setMonsterZone(address - 1, "E");
                board.removeMonsterCardFromZone(address);
                int emptyPlace = board.getEmptyPlaceInMonsterZone();
                board.addMonsterCardToField(emptyPlace, monsterCard);
            }
        } else {
            address = scanner.nextInt();
            address2 = scanner.nextInt();
            if (!board.isMonsterAvailableInMonsterZone(address) || !board.isMonsterAvailableInMonsterZone(address2))
                view.printMessage(MainPhaseView.Commands.NoMonsterInAddress);
            else {
                board.removeMonsterCardFromZone(address);
                board.removeMonsterCardFromZone(address2);
                int emptyPlace = board.getEmptyPlaceInMonsterZone();
                board.addMonsterCardToField(emptyPlace, monsterCard);
            }
        }

    }

    private void setMonster(Board board, MonsterCard monsterCard) {
        int emptyPlace = board.getEmptyPlaceInMonsterZone();
        board.setMonsterZone(emptyPlace, "DH");
        board.addMonsterCardToField(emptyPlace + 1, monsterCard);
        view.printMessage(MainPhaseView.Commands.SetSuccessful);
    }

    private boolean isSpellTrapZoneFull(Board board) {
        String[] spellTrapZone = board.getSpellTrapZone();
        for (String s : spellTrapZone) {
            if (s.equals("E"))
                return false;
        }
        return true;
    }

    private boolean isCardInHandSpellTrap(Board board) {
        return board.getCardFromHand(Select.getInstance().getPosition() - 1) instanceof SpellCard
                || board.getCardFromHand(Select.getInstance().getPosition() - 1) instanceof TrapCard;
    }

    private void setSpellTrap(Board board) {
        int emptyPlace = board.getEmptyPlaceInSpellTrapZone();
        board.setMonsterZone(emptyPlace, "H");
        board.addSpellTrapCardToField(emptyPlace + 1, board.getCardFromHand(Select.getInstance().getPosition()));
        view.printMessage(MainPhaseView.Commands.SetSuccessful);
    }

    private boolean isSelectedCardInMonsterZone() {
        return Select.getInstance().getLocation() == Select.Location.MONSTER;
    }

    private boolean isMonsterCardDefenseHidden(Board board) {
        return board.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals("DH");
    }

    private void flipSummonMonster(Board board) {
        board.setMonsterZone(Select.getInstance().getPosition() - 1, "OO");
    }

    private boolean isPositionChangedInTurn(Board board) {
        return board.getMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1) == 1;
    }

    private boolean isMonsterCardInTheWantedPosition(Board board, String position) {
        return !board.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals(position);
    }

    private void setAttackMonsterCard(Board board) {
        view.printMessage(MainPhaseView.Commands.MonsterChangedPositionSuccessful);
        board.setMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1, 1);
        board.setMonsterZone(Select.getInstance().getPosition() - 1, "OO");
    }

    private void setDefenseMonsterCard(Board board) {
        view.printMessage(MainPhaseView.Commands.MonsterChangedPositionSuccessful);
        board.setMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1, 1);
        board.setMonsterZone(Select.getInstance().getPosition() - 1, "DO");
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
    private boolean isSelectedCardSpell(){
       return Select.getInstance().getCard() instanceof SpellCard;
    }
    private boolean isSpellActivated(Board board){
        return board.getSpellTrapZoneByNumber(Select.getInstance().getPosition() - 1).equals("O");
    }
    private boolean isSpellTrapHidden(Board board){
        return board.getSpellTrapZoneByNumber(Select.getInstance().getPosition() - 1).equals("H");
    }
}





