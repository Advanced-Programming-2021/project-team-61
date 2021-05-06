import java.util.Scanner;

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
                if (!board.isACardSelected()) {
                    view.printMessage(GameView.Command.NOTCARDSELECTED);
                } else if (!board.isInHand() || !board.isMonsterCardInHand()) { //needs one more if
                    view.printMessage(GameView.Command.NOTBESUMMONED);
                } else if (board.isMonsterZoneFull()) {
                    view.printMessage(GameView.Command.MONSTERZONEFULL);
                } else if (board.isSummonedInTurn()) {
                    view.printMessage(GameView.Command.ISSUMMONEDONCE);
                } else {
                    MonsterCard monsterCard = (MonsterCard) board.getSelectedCardFromHand();
                    //to be completed
                }


            }


        }
    }
}

