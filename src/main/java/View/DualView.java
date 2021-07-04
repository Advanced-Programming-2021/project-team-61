package View;

import javax.swing.*;

public class DualView {
    public enum Commands {
        playerTwoNotExist,
        hasNoActiveDeck,
        roundInvalid,
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
                JOptionPane.showConfirmDialog(null,"there is no player with this username","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("there is no player with this username");
                break;
            }
            case hasNoActiveDeck: {
                JOptionPane.showConfirmDialog(null,s + " has no active deck","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println(s + " has no active deck");
                break;
            }
            case deckInvalid:{
                JOptionPane.showConfirmDialog(null,s+ " 's deck is invalid","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println(s+ " 's deck is invalid");
                break;
            }
        }
    }
}
