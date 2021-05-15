package View;

import Model.Card;

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
        spellZoneFull

    }

    private Scanner scanner = RegisterView.scanner;
    private static GameView g = null;

    private GameView(){

    }
    public static GameView getInstance(){
        if(g == null)
            g = new GameView();
        return g;
    }
    public String scan(){
        String command = scanner.nextLine();
        return command;
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
                System.out.println("please enter the cardName which you guess your rival has:\n");
                break;
            }
            case INVALIDSELECTION:{
                System.out.println("invalid selection\n");
                break;
            }
            case CARDSELECTED:{
                System.out.println("card selected\n");
                break;
            }
            case CARDDESELECTED:{
                System.out.println("card deselected\n");
                break;
            }
            case NOCARDFOUNDINGIVENPOSITION:{
                System.out.println("no card found in the given position\n");
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
                System.out.println("you can't attack with this card\n");
                break;
            }
            case HASATTACKED:{
                System.out.println("this card already attacked\n");
                break;
            }
            case NOCARDTOATTACK:{
                System.out.println("there is no card to attack here\n");
                break;
            }
            case CANTDIRECTATTACK:{
                System.out.println("you can’t attack the opponent directly\n");
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
                System.out.println("graveyard empty\n");
                break;
            }
            case CARDISNOTVISIBLE:{
                System.out.println("card is not visible\n");
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

        }

    }
    public void printMessageByAddingString(Command message, int s1){
        switch (message){
            case DIRECTATTACKSUCCESSFULLY:{
                System.out.println("you opponent receives "+ s1 +" battale damage\n");
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
                System.out.print("no card is destroyed and you received "+s1+" battle damage\n");
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
        }
    }
    public void printGraveyard(ArrayList<Card> graveyard){
        for (int i = 1; i <= graveyard.size(); i++) {
            System.out.println(i + ". " + graveyard.get(i-1).getCardName() + " : " + graveyard.get(i-1).getDescription() + "\n");
        }
    }

}
