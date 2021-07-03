package View;

public class DualView {
    public enum Commands {
        playerTwoNotExist,
        hasNoActiveDeck,
        roundInvalid,
        inValid,
        deckInvalid
    }

    private static DualView view = null;

    private DualView() {

    }

    public static DualView getInstance() {
        if (view == null)
            view = new DualView();
        return view;
    }


    public void printMessage(Commands message, String s) {
        switch (message) {
            case playerTwoNotExist: {
                System.out.println("there is no player with this username");
                break;
            }
            case hasNoActiveDeck: {
                System.out.println(s + " has no active deck");
                break;
            }
            case roundInvalid: {
                System.out.println("number of rounds is not supported");
                break;
            }
            case inValid: {
                System.out.println("invalid command");
                break;
            }
            case deckInvalid:{
                System.out.println(s+ " 's deck is invalid");
                break;
            }
        }
    }
}
