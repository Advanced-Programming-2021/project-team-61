import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPhase1 {
    private String command;
    private static MainPhase1 m = null;
    private GameView view;

    private MainPhase1(GameView view) {
        this.view = view;

    }

    public static MainPhase1 getInstance() {
        if (m == null) {
            m = new MainPhase1(GameView.getInstance());
        }
        return m;
    }

    public void run(Player me , Player rival) {
        while (true) {
            command = view.scan();
            Matcher matcher;
            if(command.startsWith("select")){
                Select.getInstance().run(me,rival,command);
            }
            else if ((command.equals("summon"))) {
                ProcessSummon(Board.getBoardByPlayer(me));
            }
            else if ((matcher = getCommandMatcher(command,"set -- position (attack|defense)")).find()) {
                ProcessSetPosition(Board.getBoardByPlayer(me),matcher);
            }
            else if(command.equals("set")){
                ProcessSet(Board.getBoardByPlayer(me));
            }
            else if(command.equals("flip-summon")){
                ProcessFlipSummon(Board.getBoardByPlayer(me),Board.getBoardByPlayer(rival));
            }else if (command.equals("card show --selected")){
                ProcessShowCard(Board.getBoardByPlayer(me), Board.getBoardByPlayer(rival));
               // ProcessFlipSummon(Board.getBoardByPlayer(me),Board.getBoardByPlayer(rival));
            }
            else if(command.equals("activate effect")){
               ProcessActivation(Board.getBoardByPlayer(me));
            }


        }
    }

    private void ProcessSummon(Board board){
        if (Select.getInstance().getLocation()==null) {
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        } else if (Select.getInstance().getLocation()!=Select.Location.HAND || !(board.getCardFromHand(Select.getInstance().getPosition()-1) instanceof MonsterCard)) { //needs one more if
            view.printMessage(GameView.Command.NOTBESUMMONED);
        } else if (board.isMonsterZoneFull()) {
            view.printMessage(GameView.Command.MONSTERZONEFULL);
        } else if (board.isSummonedInTurn()) {
            view.printMessage(GameView.Command.ISSUMMONEDONCE);
        } else {
            ProcessTribute(board);
        }
    }
    private void ProcessTribute(Board board){
        MonsterCard monsterCard = (MonsterCard) board.getCardFromHand(Select.getInstance().getPosition()-1);
        if (monsterCard.getLevel() <= 4) {
            board.summon();
            view.printMessage(GameView.Command.SUMMONSUCCESSFUL);
        } else if (monsterCard.getLevel() <= 6) {
            if (!board.isEnoughForTribute(5))
                view.printMessage(GameView.Command.NOTENOUGHFORTRIBUTE);
            else {
                int address = Integer.parseInt(view.scan());
                if (!board.isMonsterAvailableInMonsterZone(address))
                    view.printMessage(GameView.Command.NOTMONSTERINADDRESS);
                else {
                    board.tribute(address);
                    board.summon();
                    view.printMessage(GameView.Command.SUMMONSUCCESSFUL);
                }
            }
        } else {
            if (!board.isEnoughForTribute(7))
                view.printMessage(GameView.Command.NOTENOUGHFORTRIBUTE);
            else {
                int address1 = Integer.parseInt(view.scan());
                int address2 = Integer.parseInt(view.scan());
                if (!board.isMonsterAvailableInMonsterZone(address1) || !board.isMonsterAvailableInMonsterZone(address2))
                    view.printMessage(GameView.Command.NOTMONSTERINADDRESS);
                else {
                    board.tribute(address1);
                    board.tribute(address2);
                    board.summon();
                    view.printMessage(GameView.Command.SUMMONSUCCESSFUL);
                }
            }
        }
    }
    private void ProcessSet(Board board) {
        if (Select.getInstance().getLocation() == null) {
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        } else if (Select.getInstance().getLocation() != Select.Location.HAND) {
            view.printMessage(GameView.Command.NOTBESET);
        } else {
            if (board.getCardFromHand(Select.getInstance().getPosition()-1) instanceof MonsterCard){
                if (board.isMonsterZoneFull()) {
                    view.printMessage(GameView.Command.MONSTERZONEFULL);
                } else if (board.isSummonedInTurn()) {
                    view.printMessage(GameView.Command.ISSUMMONEDONCE);
                } else {
                    board.setMonster();
                    view.printMessage(GameView.Command.SETSUCCESSFUL);
                }
            }else if (board.getCardFromHand(Select.getInstance().getPosition()-1) instanceof SpellCard || board.getCardFromHand(Select.getInstance().getPosition()-1) instanceof TrapCard){
                if (board.isSpellTrapZoneFull()){
                    view.printMessage(GameView.Command.SPELLZONEFULL);
                }else {
                    board.setSpellTrap();
                    view.printMessage(GameView.Command.SETSUCCESSFUL);
                }
            }
        }
    }
    private void ProcessFlipSummon(Board board,Board rivalBoard){
        if(Select.getInstance().getLocation()==null){
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }
        else if(Select.getInstance().getLocation()!=Select.Location.MONSTER){
            view.printMessage(GameView.Command.NOTINMONSTERZONE);
        }
        else if(!board.getMonsterZoneByNumber(Select.getInstance().getPosition()-1).equals("DH")){//needs one more if
            view.printMessage(GameView.Command.NOTFLIP);
        }
        else{
            board.setMonsterZone(Select.getInstance().getPosition(),"OO");
            checktoActivateEffect(board.getMonsterCardByKey(Select.getInstance().getPosition()),rivalBoard);
        }
    }

    private void ProcessSetPosition(Board board, Matcher matcher){
        String newPosition = matcher.group(1);
        if (Select.getInstance().getLocation()==null){
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }else if (Select.getInstance().getLocation()!=Select.Location.MONSTER) {
            view.printMessage(GameView.Command.NOTINMONSTERZONE);
        }else if (board.getMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1)==1){
            view.printMessage(GameView.Command.THISCARDALREADYCHANGEDINTHISTURN);
        }else{
            if (newPosition.equals("attack")){
                if (!board.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals("DO")){
                    view.printMessage(GameView.Command.THISCARDALREADYINWANTEDPOSITION);
                }else {
                    view.printMessage(GameView.Command.MONSTERCHANGEDPOSITIONSUCCES);
                    board.setMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1,1);
                    board.setMonsterZone(Select.getInstance().getPosition() - 1,"OO");
                }
            }else{
                if (!board.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals("OO")){
                    view.printMessage(GameView.Command.THISCARDALREADYINWANTEDPOSITION);
                }else {
                    view.printMessage(GameView.Command.MONSTERCHANGEDPOSITIONSUCCES);
                    board.setMonsterZoneChangeByNumber(Select.getInstance().getPosition() - 1,1);
                    board.setMonsterZone(Select.getInstance().getPosition() - 1,"DO");
                }
            }
        }

    }
    public void checktoActivateEffect(MonsterCard monsterCard,Board rivalBoard){
        if(monsterCard.getCardName().equals("Man-Eater Bug")){
            rivalBoard.destroyCardInMonsterZone(Integer.parseInt(view.scan()));
        }
    }

    private void ProcessShowCard(Board myBoard, Board rivalBoard){
        if (Select.getInstance().getLocation()==null) {
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }else if (!canISeeSelectedCard(rivalBoard)){
            view.printMessage(GameView.Command.CARDISNOTVISIBLE);
        }else {
            //show card information...
            if (Select.getInstance().getLocation()== Select.Location.HAND){
                view.showCard_hand(myBoard, Select.getInstance().getPosition() - 1);
            }else if (Select.getInstance().getLocation()== Select.Location.MONSTER){
                view.showCard_myMonster(myBoard, Select.getInstance().getPosition());
            }else if (Select.getInstance().getLocation()== Select.Location.SPELL){
                view.showCard_mySpellTrap(myBoard, Select.getInstance().getPosition());
            }else if (Select.getInstance().getLocation()== Select.Location.MONSTEROPPONENT){
                view.showCard_myMonster(rivalBoard, Select.getInstance().getPosition());
            }else if (Select.getInstance().getLocation()== Select.Location.SPELLOPPONENT){
                view.showCard_mySpellTrap(rivalBoard, Select.getInstance().getPosition());
            }// Should I show the card in myField and opponentField?????

        }
    }



    private boolean canISeeSelectedCard(Board rivalBoard){
        if (Select.getInstance().getLocation()== Select.Location.MONSTEROPPONENT && rivalBoard.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals(/*attack hide*/)){
            return false;
        }else if (Select.getInstance().getLocation()== Select.Location.MONSTEROPPONENT && rivalBoard.getMonsterZoneByNumber(Select.getInstance().getPosition() - 1).equals(/*defence hide*/)) {
            return false;
        }else if (Select.getInstance().getLocation()== Select.Location.SPELLOPPONENT && rivalBoard.getSpellTrapZoneByNumber(Select.getInstance().getPosition() - 1).equals("H")){
            return false;
        }else if (Select.getInstance().getLocation()== Select.Location.FIELDOPPONENT){
            return false;
        }else {
            return true;
        }
    }
    private void ProcessActivation(Board board){
        if(Select.getInstance().getLocation()==null){
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }
        else if(!(Select.getInstance().getCard() instanceof SpellCard)){
            view.printMessage(GameView.Command.notSpellCard);
        }
        else if(board.getSpellTrapZoneByNumber(Select.getInstance().getPosition()-1).equals("O")){
            view.printMessage(GameView.Command.isActivated);
        }
        else if(Select.getInstance().getLocation()== Select.Location.HAND && board.isSpellTrapZoneFull()){//needs one more if
            view.printMessage(GameView.Command.spellZoneFull);
        }
        else if(false){//prepration??
            board.getSpellTrapByKey(1);
        }
        else{
            board.activateEffect();
        }
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }

}

