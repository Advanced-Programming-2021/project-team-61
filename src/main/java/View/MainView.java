package View;

import Controller.MainMenu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainView {
    enum Commands {
        LOGOUT,
        INVALID,
        menuName
    }

    private static MainView m = null;
    private MainMenu mainMenu = MainMenu.getInstance();
    private String command;
    private String username;
    private Matcher matcher;

    private MainView() {
    }

    public static MainView getInstance() {
        if (m == null) {
            m = new MainView();
        }
        return m;
    }

    public void scan(String username) {
        this.username = username;
        while (true) {
            command = RegisterView.scanner.nextLine();
            if (command.equals("user logout")) {
                printMessage(Commands.LOGOUT);
                break;
            } else if ((matcher = getCommandMatcher(command, "menu enter ([^\\s]+)")).find())
                mainMenu.menuEnter(matcher.group(1), username);
            else if (command.equals("msc"))
                printMessage(Commands.menuName);
            else
                printMessage(Commands.INVALID);

        }
    }

    public void printMessage(Commands message) {
        switch (message) {
            case LOGOUT: {
                System.out.println("user logged out successfully!");
                break;
            }
            case INVALID: {
                System.out.println("invalid command");
                break;
            }
            case menuName: {
                System.out.println("Main Menu");
                break;
            }
            default:
                break;
        }
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
