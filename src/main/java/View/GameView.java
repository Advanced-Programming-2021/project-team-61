package View;

import Controller.EffectController;
import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GameView {

    public enum Command{
        NOTCARDSELECTED,
        NOTBESUMMONED,
        MONSTERZONEFULL,
        ISSUMMONEDONCE,
        NOTENOUGHFORTRIBUTE,
        NOTMONSTERINADDRESS,
        SUMMONSUCCESSFUL,
        ENTERTHECARDNAME,
        INVALIDSELECTION,
        CARDSELECTED,
        CARDDESELECTED,
        NOCARDFOUNDINGIVENPOSITION,
        NOTBESET,
        NOTINMONSTERZONE,
        NOTFLIP,
        SETSUCCESSFUL,
        THISCARDALREADYINWANTEDPOSITION,
        THISCARDALREADYCHANGEDINTHISTURN,
        MONSTERCHANGEDPOSITIONSUCCES,
        NOTATTACK,
        HASATTACKED,
        NOCARDTOATTACK,
        CANTDIRECTATTACK,
        DIRECTATTACKSUCCESSFULLY,
        SPELLZONEFULL,
        GRAVEYARDEMPTY,
        CARDISNOTVISIBLE,
        damageOpponent,
        bothDamage,
        damageMe,
        damageRivalDOMonster,
        noDamage,
        justLifePointDecrease,
        cardName,
        cannotBeAttacked,
        notSpellCard,
        isActivated,
        spellZoneFull,
        playerWins,
        pleaseEnterTheCardNumber,
        cantGetCardFromDeck,
        cantAttackInThisTurn,
        invalidCommand,
        newCardAddedToHand,
        askToChooseMonsterFromGraveYard,
        preprationNotPrepared

    }

    private Scanner scanner = new Scanner(System.in);
    private static GameView g = null;

    private GameView(){

    }
    public static GameView getInstance(){
        if(g == null)
            g = new GameView();
        return g;
    }



    public String scan(){
        return scanner.nextLine();
    }
    public void printMessage(Command message){
        switch (message){
            case NOTCARDSELECTED:{
                System.out.println("no card is selected yet");
                break;
            }
            case NOTBESUMMONED: {
                System.out.println("you can't summon this card");
                break;
            }
            case MONSTERZONEFULL:{
                System.out.println("monster card zone is full");
                break;
            }
            case ISSUMMONEDONCE: {
                System.out.println("you already summoned/set on this turn");
                break;
            }
            case NOTENOUGHFORTRIBUTE:{
                System.out.println("there are not enough cards for tribute");
                break;
            }
            case NOTMONSTERINADDRESS:{
                System.out.println("there no monster one this address");
                break;
            }
            case SUMMONSUCCESSFUL:{
                System.out.println("summoned successfully");
                break;
            }
            case ENTERTHECARDNAME:{
                System.out.println("please enter the cardName which you guess your rival has:");
                break;
            }
            case INVALIDSELECTION:{
                System.out.println("invalid selection");
                break;
            }
            case CARDSELECTED:{
                System.out.println("card selected");
                break;
            }
            case CARDDESELECTED:{
                System.out.println("card deselected");
                break;
            }
            case NOCARDFOUNDINGIVENPOSITION:{
                System.out.println("no card found in the given position");
                break;
            }
            case NOTBESET: {
                System.out.println("you can't set this card");
                break;
            }
            case SETSUCCESSFUL:{
                System.out.println("set successfully");
                break;
            }
            case NOTINMONSTERZONE:{
                System.out.println("you can't change this card position");
                break;
            }
            case NOTFLIP:{
                System.out.println("you can't flip summon this card");
                break;
            }
            case THISCARDALREADYINWANTEDPOSITION:{
                System.out.println("this card is already in the wanted position");
                break;
            }
            case THISCARDALREADYCHANGEDINTHISTURN:{
                System.out.println("you already changed this card position in this turn");
                break;
            }
            case MONSTERCHANGEDPOSITIONSUCCES:{
                System.out.println("monster card position changed successfully");
                break;
            }
            case NOTATTACK:{
                System.out.println("you can't attack with this card");
                break;
            }
            case HASATTACKED:{
                System.out.println("this card already attacked");
                break;
            }
            case NOCARDTOATTACK:{
                System.out.println("there is no card to attack here");
                break;
            }
            case CANTDIRECTATTACK:{
                System.out.println("you can’t attack the opponent directly");
                break;
            }
            case bothDamage:{
                System.out.println("both you and your opponent monster cards are destroyed and no one receives damage");
                break;
            }
            case damageRivalDOMonster:{
                System.out.println("the defense position monster is destroyed");
                break;
            }
            case noDamage:{
                System.out.println("no card is destroyed");
                break;
            }
            case SPELLZONEFULL:{
                System.out.println("spell card zone is full\n");
                break;
            }
            case cannotBeAttacked:{
                System.out.println("you can't attack this monster");
                break;
            }
            case GRAVEYARDEMPTY:{
                System.out.println("graveyard empty");
                break;
            }
            case CARDISNOTVISIBLE:{
                System.out.println("card is not visible");
                break;
            }
            case notSpellCard:{
                System.out.println("activate effect is only for spell cards");
                break;
            }
            case isActivated:{
                System.out.println("you have already activated this card");
                break;
            }
            case spellZoneFull:{
                System.out.println("spell card zone is full");
                break;
            }
            case pleaseEnterTheCardNumber:{
                System.out.println("please enter the number which you want summon:");
                break;
            }
            case cantGetCardFromDeck:{
                System.out.println("you can't get a card from deck in this turn");
                break;
            }
            case cantAttackInThisTurn:{
                System.out.println("you can't attack in this turn");
                break;
            }
            case askToChooseMonsterFromGraveYard:{
                System.out.println("please choose a monster Card from the graveyard");
                break;
            }
            case preprationNotPrepared:{
                System.out.println("preparations of this spell card are not done yet");
                break;
            }
            case invalidCommand:{
                System.out.println("invalid command!");
                break;
            }

        }

    }
    public void printMessageByAddingString(Command message, int s1){
        switch (message){
            case DIRECTATTACKSUCCESSFULLY:{
                System.out.println("you opponent receives "+ s1 +" battale damage");
                break;
            }
            case damageOpponent:{
                System.out.println("your opponent's monster is destroyed and your opponent receives "+s1+" battle damage");
                break;
            }
            case damageMe:{
                System.out.println("your monster card is destroyed and you received "+s1+" battle damage");
                break;
            }
            case justLifePointDecrease:{
                System.out.print("no card is destroyed and you received "+s1+" battle damage");
                break;
            }
        }
    }
    public void printMessageByString(Command message, String s1){
        switch (message){
            case damageRivalDOMonster:{
                System.out.println("opponent's monster card was "+s1+" and the defense position monster is destroyed");
            }
            case cardName: {
                System.out.print("opponent's monster card was "+s1+ " and ");
            }
            case playerWins:{
                System.out.println(s1+" won the game and the score is 0-0");
            }
            case newCardAddedToHand:{
                System.out.println("new card added to the hand :"+" "+ s1);
            }
        }
    }
    public void printWinner(Player winner,Player loser){
        System.out.println(winner.getUsername() + " won the game and the score is: "+Board.getBoardByPlayer(winner).getLifePoint()+"-"+Board.getBoardByPlayer(loser).getLifePoint());
    }
    public boolean printToActivateCardInRivalTurn(Player player){
        System.out.println("now it will be "+player.getUsername()+" 's turn");
        System.out.println("do you want to activate your trap card?");
        String s = scanner.nextLine();
        if(s.equals("yes")){
            System.out.println("spell/trap activated");
            EffectController.getInstance().activateMirrorForceEffect();
            return true;
        }
        else{
            System.out.println("OK!");
            return false;

        }

    }
    public void printGraveyard(ArrayList<Card> graveyard){
        for (int i = 1; i <= graveyard.size(); i++) {
            System.out.println(i + ". " + graveyard.get(i-1).getCardName() + " : " + graveyard.get(i-1).getDescription());
        }
    }
    public void showBoard(Board myBoard, Board rivalBoard){
        System.out.println(rivalBoard.getPlayer().getNickname() + ":" +rivalBoard.getLifePoint());
        int numberOfCard = rivalBoard.getHand().size();
        int numberOfTab = 6;
        System.out.print("\t");
        for (int i = 0; i < numberOfCard; i++) {
            for (int j = 0; j < numberOfTab; j++) {
                System.out.print("\t");
            }
            System.out.print("C");
            numberOfTab = 1;
        }
        System.out.println();
        System.out.println(rivalBoard.getMainDeck().size());
        System.out.println("\t" + rivalBoard.getSpellTrapByIndex(3).getStatus() + "\t" + rivalBoard.getSpellTrapByIndex(1).getStatus() + "\t" + rivalBoard.getSpellTrapByIndex(0).getStatus() + "\t" + rivalBoard.getSpellTrapByIndex(2).getStatus() + "\t" + rivalBoard.getSpellTrapByIndex(4).getStatus() );
        System.out.println("\t" + rivalBoard.getMonsterByIndex(3).getStatus() + "\t" + rivalBoard.getMonsterByIndex(1).getStatus() + "\t" + rivalBoard.getMonsterByIndex(0).getStatus() + "\t" + rivalBoard.getMonsterByIndex(2).getStatus() + "\t" + rivalBoard.getMonsterByIndex(4).getStatus() );
        System.out.println(rivalBoard.getGraveYard().size() + "\t \t \t \t \t \t" + rivalBoard.getFieldZoneCondition());
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println(myBoard.getFieldZoneCondition() + "\t \t \t \t \t \t" + myBoard.getGraveYard().size());
        System.out.println("\t" + myBoard.getMonsterByIndex(4).getStatus() + "\t" + myBoard.getMonsterByIndex(2).getStatus() + "\t" + myBoard.getMonsterByIndex(0).getStatus() + "\t" + myBoard.getMonsterByIndex(1).getStatus() + "\t" + myBoard.getMonsterByIndex(3).getStatus() );
        System.out.println("\t" + myBoard.getSpellTrapByIndex(4).getStatus() + "\t" + myBoard.getSpellTrapByIndex(2).getStatus() + "\t" + myBoard.getSpellTrapByIndex(0).getStatus() + "\t" + myBoard.getSpellTrapByIndex(1).getStatus() + "\t" + myBoard.getSpellTrapByIndex(3).getStatus());
        System.out.println(" \t \t \t \t \t \t" + myBoard.getMainDeck().size());
        for (int i = 0; i < myBoard.getHand().size(); i++) {
            System.out.print("C\t");
        }
        System.out.println();
        System.out.println(myBoard.getPlayer().getNickname() + ":" + myBoard.getLifePoint());
    }

    public void showCard_hand(Board myBoard, int index){
        Card card = myBoard.getCardFromHand(index);
        if (card instanceof MonsterCard)
            MonsterCard.printACardComplete((MonsterCard) card);
        else if (card instanceof SpellCard)
            SpellCard.printACardComplete((SpellCard) card);
        else if (card instanceof TrapCard)
            TrapCard.printACardComplete((TrapCard) card);
    }

    public void showCard_myMonster(Board myBoard, int index){
        MonsterCard card = myBoard.getMonsterByIndex(index).getMonsterCard();
        MonsterCard.printACardComplete(card);
    }

    public void showCard_mySpellTrap(Board myBoard, int index){
        Card card = myBoard.getSpellTrapByIndex(index).getCard();
        if (card instanceof SpellCard)
            SpellCard.printACardComplete((SpellCard) card);
        else if (card instanceof TrapCard)
            TrapCard.printACardComplete((TrapCard) card);
    }





}
