
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

    public void run(Board board) {
        while (true) {
            command = view.scan();
            if (command.equals("summon")) {
                ProcessSummon(board);
            }
            else if(command.equals("set")){
                ProcessSet(board);
            }



        }
    }
    private void ProcessSummon(Board board){
        if (!board.isACardSelected()) {
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        } else if (!board.isInHand() || !board.isMonsterCardInHand()) { //needs one more if
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
        MonsterCard monsterCard = (MonsterCard) board.getSelectedCardFromHand();
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
    private void ProcessSet(Board board){
        if(!board.isACardSelected()){
            view.printMessage(GameView.Command.NOTCARDSELECTED);
        }
        else if(!board.isInHand() || !board.isMonsterCardInHand()){
            view.printMessage(GameView.Command.NOTBESET);
        }
        else if(board.isMonsterZoneFull()){
            view.printMessage(GameView.Command.MONSTERZONEFULL);
        }
        else if(board.isSummonedInTurn()){
            view.printMessage(GameView.Command.ISSUMMONEDONCE);
        }
        else{
            board.set();
            view.printMessage(GameView.Command.SETSUCCESSFUL);
        }
    }

}

