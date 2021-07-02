package View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controller.EffectController;
import Controller.GameController;
import Model.Board;
import Model.Player;
import Model.Select;

public class MainPhaseView {

    public enum Commands{
        NoCardSelected,
        CannotBeSummoned,
        MonsterZoneFull,
        SummonIsDoneOnce,
        SummonSuccessful,
        NotEnoughCardsForTribute,
        NoMonsterInAddress,
        CannotSetMonsterCard,
        SetSuccessful,
        CannotChangePosition,
        TheCardInWantedPosition,
        AlreadyChangedPositionInTurn,
        MonsterChangedPositionSuccessful,
        CannotFlip,
        FlipSuccessful,
        Invalid,
        SpellZoneFull,
        CardIsNotVisible,
        NotSpellCard,
        isActivated,
        noPreparatipn
    }

    private static MainPhaseView m = null;
    private String command;
    private Scanner scanner = RegisterView.scanner;
    private MainPhase1 mainPhase1;
    private Matcher matcher;
    private GameController gameController;
    private EffectController effectController;

    private MainPhaseView(){

    }
    public static MainPhaseView getInstance(){
        if(m==null)
            m = new MainPhaseView();
        return m;
    }
    public void scan(Player me , Player rival){
        printPhaseName();
        effectController = EffectController.getInstance();
        effectController.setMyBoard(Board.getBoardByPlayer(me));
        effectController.setRivalBoard(Board.getBoardByPlayer(rival));
        mainPhase1 = MainPhase1.getInstance();
        gameController = GameController.getInstance();
        while (true){
            GameView.getInstance().showBoard(Board.getBoardByPlayer(me), Board.getBoardByPlayer(rival));
            command = scanner.nextLine();
            if ((command.equals("summon"))) {
                mainPhase1.ProcessSummon(Board.getBoardByPlayer(me));
            }
            else if ((matcher = getCommandMatcher(command,"set -- position (attack|defense)")).find()) {
                mainPhase1.ProcessSetPosition(Board.getBoardByPlayer(me),matcher);
            }
            else if(command.equals("set")){
                mainPhase1.ProcessSet(Board.getBoardByPlayer(me));
            }
            else if(command.equals("flip-summon")){
                mainPhase1.ProcessFlipSummon(Board.getBoardByPlayer(me), Board.getBoardByPlayer(rival));
            }
            else if (command.equals("card show --selected")){
                mainPhase1.ProcessShowCard(Board.getBoardByPlayer(me),Board.getBoardByPlayer(rival));
            }
            else if(command.equals("activate effect")){
                mainPhase1.ProcessActivation(Board.getBoardByPlayer(me), Board.getBoardByPlayer(rival));
            }
            else if(command.startsWith("select")){
                Select.getInstance().run(me,rival,command);
            }
            else if(command.equals("activate Call Of the Haunted")){
                EffectController.getInstance().activateCallOfTheHauntedEffect();
            }
            else if(command.equals("activate Time Seal")){
                EffectController.getInstance().activateTimeSealEffect();
            }
            else if(command.equals("activate Mind Crush")){
                EffectController.getInstance().activateMindCrushEffect();
            }
            else if(command.equals("activate torrential tribute")){
                EffectController.getInstance().activateTorrentialTributeEffect();
            }
            else if(command.equals("surrender")){
                gameController.setSurrendered(true);
                break;
            }
            else if(command.equals("next phase")){
                break;
            }
            else if ((matcher = getCommandMatcher(command,"increase --LP (\\d+)")).find()) {
                Board.getBoardByPlayer(me).increaseLIfePoint(Integer.parseInt(matcher.group(1)));
            }
            else if ((matcher = getCommandMatcher(command,"duel set-winner ([^\\s]+)")).find()){
                GameView.getInstance().printWinner(me,rival);
                Board.getBoardByPlayer(me).increaseNumberOfWins();
                gameController.setCheat(true);
                //win the game...
            }
            else if(command.equals("show graveyard")){
                Board.getBoardByPlayer(me).showGraveyard();
            }








        }
    }

    private void printPhaseName() {
        System.out.println("phase : main Phase");
    }

    public void printMessage(Commands message){
        switch (message){
            case NoCardSelected:{
                System.out.println("no card is selected yet");
                break;
            }
            case CannotBeSummoned:{
                System.out.println("you can't summon this card");
                break;
            }
            case MonsterZoneFull:{
                System.out.println("monster card zone is full");
                break;
            }
            case SummonIsDoneOnce:{
                System.out.println("you already summoned/set on this turn");
                break;
            }
            case SummonSuccessful:{
                System.out.println("summoned successfully");
                break;
            }
            case NotEnoughCardsForTribute:{
                System.out.println("there are not enough cards for tribute");
                break;
            }
            case NoMonsterInAddress:{
                System.out.println("there no monster one this address");
                break;

            }
            case CannotSetMonsterCard:{
                System.out.println("you can't set this card");
                break;
            }
            case SetSuccessful:{
                System.out.println("set successfully");
                break;
            }
            case CannotChangePosition:{
                System.out.println("you can't change this card position");
                break;
            }
            case TheCardInWantedPosition:{
                System.out.println("this card is already in the wanted position");
                break;
            }
            case AlreadyChangedPositionInTurn:{
                System.out.println("you already changed this card position in this turn");
                break;
            }
            case MonsterChangedPositionSuccessful:{
                System.out.println("monster card position changed successfully");
                break;
            }
            case CannotFlip:{
                System.out.println("you can't flip summon this card");
                break;
            }
            case FlipSuccessful:{
                System.out.println("flip summoned successfully");
                break;
            }
            case Invalid:{
                System.out.println("invalid command");
                break;
            }
            case SpellZoneFull:{
                System.out.println("spell card zone is full");
                break;
            }
            case CardIsNotVisible:{
                System.out.println("card is not visible");
                break;
            }
            case NotSpellCard:{
                System.out.println("activate effect is only for spell cards");
                break;
            }
            case isActivated:{
                System.out.println("you have already activated this card");
                break;
            }
            case noPreparatipn:{
                System.out.println("preparations of this spell are not done yet");
                break;
            }















        }
    }
    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
