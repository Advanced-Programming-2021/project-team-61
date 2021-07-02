package View;

import Controller.DualMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DualView {
    public enum Commands {
        playerTwoNotExist,
        hasNoActiveDeck,
        roundInvalid,
        inValid,
        deckInvalid
    }

    private static DualView view = null;
    private DualMenu dualMenu ;
    private String command;
    private String regex;
    private Matcher matcher;

    private DualView() {

    }

    public static DualView getInstance() {
        if (view == null)
            view = new DualView();
        return view;
    }

    public void scan(String username) {
        dualMenu = DualMenu.getInstance();
        while (true) {
            command = new Scanner(System.in).nextLine();
            if (command.startsWith("duel --new --second-player")) {
                regex = "duel --new --second-player ([^\\s]+) --rounds ([\\d]+)";
                matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    dualMenu.ProcessNewGame(matcher, username);
                }
            } else if (command.equals("menu exit"))
                break;
            else
                printMessage(Commands.inValid, "");
        }
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

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
