package View;

import Controller.EffectController;
import Model.*;

import javax.swing.*;
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
                JOptionPane.showConfirmDialog(null,"no card is selected yet","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("no card is selected yet");
                break;
            }
            case NOTBESUMMONED: {
                JOptionPane.showConfirmDialog(null,"you can't summon this card","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't summon this card");
                break;
            }
            case MONSTERZONEFULL:{
                JOptionPane.showConfirmDialog(null,"monster card zone is full","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("monster card zone is full");
                break;
            }
            case ISSUMMONEDONCE: {
                JOptionPane.showConfirmDialog(null,"you already summoned/set on this turn","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you already summoned/set on this turn");
                break;
            }
            case NOTENOUGHFORTRIBUTE:{
                JOptionPane.showConfirmDialog(null,"there are not enough cards for tribute","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("there are not enough cards for tribute");
                break;
            }
            case NOTMONSTERINADDRESS:{
                JOptionPane.showConfirmDialog(null,"there no monster one this address","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("there no monster one this address");
                break;
            }
            case SUMMONSUCCESSFUL:{
                JOptionPane.showConfirmDialog(null,"summoned successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("summoned successfully");
                break;
            }
            case ENTERTHECARDNAME:{
                JOptionPane.showConfirmDialog(null,"please enter the cardName which you guess your rival has:","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("please enter the cardName which you guess your rival has:");
                break;
            }
            case INVALIDSELECTION:{
                JOptionPane.showConfirmDialog(null,"invalid selection","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("invalid selection");
                break;
            }
            case CARDSELECTED:{
                JOptionPane.showConfirmDialog(null,"card selected","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card selected");
                break;
            }
            case CARDDESELECTED:{
                JOptionPane.showConfirmDialog(null,"card deselected","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card deselected");
                break;
            }
            case NOCARDFOUNDINGIVENPOSITION:{
                JOptionPane.showConfirmDialog(null,"no card found in the given position","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("no card found in the given position");
                break;
            }
            case NOTBESET: {
                JOptionPane.showConfirmDialog(null,"you can't set this card","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't set this card");
                break;
            }
            case SETSUCCESSFUL:{
                JOptionPane.showConfirmDialog(null,"set successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("set successfully");
                break;
            }
            case NOTINMONSTERZONE:{
                JOptionPane.showConfirmDialog(null,"you can't change this card position","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't change this card position");
                break;
            }
            case NOTFLIP:{
                JOptionPane.showConfirmDialog(null,"you can't flip summon this card","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't flip summon this card");
                break;
            }
            case THISCARDALREADYINWANTEDPOSITION:{
                JOptionPane.showConfirmDialog(null,"this card is already in the wanted position","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("this card is already in the wanted position");
                break;
            }
            case THISCARDALREADYCHANGEDINTHISTURN:{
                JOptionPane.showConfirmDialog(null,"you already changed this card position in this turn","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you already changed this card position in this turn");
                break;
            }
            case MONSTERCHANGEDPOSITIONSUCCES:{
                JOptionPane.showConfirmDialog(null,"monster card position changed successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("monster card position changed successfully");
                break;
            }
            case NOTATTACK:{
                JOptionPane.showConfirmDialog(null,"you can't attack with this card","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't attack with this card");
                break;
            }
            case HASATTACKED:{
                JOptionPane.showConfirmDialog(null,"this card already attacked","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("this card already attacked");
                break;
            }
            case NOCARDTOATTACK:{
                JOptionPane.showConfirmDialog(null,"there is no card to attack here","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("there is no card to attack here");
                break;
            }
            case CANTDIRECTATTACK:{
                JOptionPane.showConfirmDialog(null,"you can’t attack the opponent directly","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can’t attack the opponent directly");
                break;
            }
            case bothDamage:{
                JOptionPane.showConfirmDialog(null,"both you and your opponent monster cards are destroyed and no one receives damage","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("both you and your opponent monster cards are destroyed and no one receives damage");
                break;
            }
            case damageRivalDOMonster:{
                JOptionPane.showConfirmDialog(null,"the defense position monster is destroyed","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("the defense position monster is destroyed");
                break;
            }
            case noDamage:{
                JOptionPane.showConfirmDialog(null,"no card is destroyed","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("no card is destroyed");
                break;
            }
            case SPELLZONEFULL:{
                JOptionPane.showConfirmDialog(null,"spell card zone is full","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("spell card zone is full");
                break;
            }
            case cannotBeAttacked:{
                JOptionPane.showConfirmDialog(null,"you can't attack this monster","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't attack this monster");
                break;
            }
            case GRAVEYARDEMPTY:{
                JOptionPane.showConfirmDialog(null,"graveyard empty","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("graveyard empty");
                break;
            }
            case CARDISNOTVISIBLE:{
                JOptionPane.showConfirmDialog(null,"card is not visible","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card is not visible");
                break;
            }
            case notSpellCard:{
                JOptionPane.showConfirmDialog(null,"activate effect is only for spell cards","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("activate effect is only for spell cards");
                break;
            }
            case isActivated:{
                JOptionPane.showConfirmDialog(null,"you have already activated this card","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you have already activated this card");
                break;
            }
            case spellZoneFull:{
                JOptionPane.showConfirmDialog(null,"spell card zone is full","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("spell card zone is full");
                break;
            }
            case pleaseEnterTheCardNumber:{
                JOptionPane.showConfirmDialog(null,"please enter the number which you want summon:","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("please enter the number which you want summon:");
                break;
            }
            case cantGetCardFromDeck:{
                JOptionPane.showConfirmDialog(null,"you can't get a card from deck in this turn","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't get a card from deck in this turn");
                break;
            }
            case cantAttackInThisTurn:{
                JOptionPane.showConfirmDialog(null,"you can't attack in this turn","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you can't attack in this turn");
                break;
            }
            case askToChooseMonsterFromGraveYard:{
                JOptionPane.showConfirmDialog(null,"please choose a monster Card from the graveyard","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("please choose a monster Card from the graveyard");
                break;
            }
            case preprationNotPrepared:{
                JOptionPane.showConfirmDialog(null,"preparations of this spell card are not done yet","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("preparations of this spell card are not done yet");
                break;
            }
        }
    }
    public void printMessageByAddingString(Command message, int s1){
        switch (message){
            case DIRECTATTACKSUCCESSFULLY:{
                JOptionPane.showConfirmDialog(null,"you opponent receives "+ s1 +" battale damage","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("you opponent receives "+ s1 +" battale damage");
                break;
            }
            case damageOpponent:{
                JOptionPane.showConfirmDialog(null,"your opponent's monster is destroyed and your opponent receives "+s1+" battle damage","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("your opponent's monster is destroyed and your opponent receives "+s1+" battle damage");
                break;
            }
            case damageMe:{
                JOptionPane.showConfirmDialog(null,"your monster card is destroyed and you received "+s1+" battle damage","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("your monster card is destroyed and you received "+s1+" battle damage");
                break;
            }
            case justLifePointDecrease:{
                JOptionPane.showConfirmDialog(null,"no card is destroyed and you received "+s1+" battle damage","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.print("no card is destroyed and you received "+s1+" battle damage");
                break;
            }
        }
    }
    public void printMessageByString(Command message, String s1){
        switch (message){
            case damageRivalDOMonster:{
                JOptionPane.showConfirmDialog(null,"opponent's monster card was "+s1+" and the defense position monster is destroyed","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("opponent's monster card was "+s1+" and the defense position monster is destroyed");
            }
            case cardName: {
                JOptionPane.showConfirmDialog(null,"opponent's monster card was "+s1+ " and ","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.print("opponent's monster card was "+s1+ " and ");
            }
            case playerWins:{
                JOptionPane.showConfirmDialog(null,s1+" won the game and the score is 0-0","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println(s1+" won the game and the score is 0-0");
            }
            case newCardAddedToHand:{
                JOptionPane.showConfirmDialog(null,"new card added to the hand :"+" "+ s1,"Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("new card added to the hand :"+" "+ s1);
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
        int numberOfCard = rivalBoard.getHand().length;
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
        for (int i = 0; i < myBoard.getHand().length; i++) {
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
