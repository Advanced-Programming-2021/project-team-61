package View;

import Controller.RegisterMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterView {
  public enum Commands {
        successful,
        userExistsWithNickname,
        userExistsWithUsername,
        invalid,
        showMenu,
        firstLogin,
        noMatch,
        LOGIN
    }

    private static RegisterView r = null;
    private RegisterMenu registerMenu;
    public static Scanner scanner = new Scanner(System.in);
    private String command;
    private Matcher matcher;

    private RegisterView() {

    }

    public static RegisterView getInstance() {
        if (r == null)
            r = new RegisterView();
        return r;
    }

    public void scan() {
        registerMenu = RegisterMenu.getInstance();
        while (true) {
            command = scanner.nextLine();
            if ((matcher = getCommandMatcher(command, "user create --u ([^\\s]+) --n ([^\\s]+) --p ([^\\s]+)")).find())
                registerMenu.userCreateProcess(matcher);
            else if ((matcher = getCommandMatcher(command, "user login --u ([^\\s]+) --p ([^\\s]+)")).find())
                registerMenu.loginProcess(matcher);
            else if (command.equals("msc")) {
                printMessage(Commands.showMenu, "");
            } else if (command.startsWith("menu enter")) {
                printMessage(Commands.firstLogin, "");
            } else if (command.equals("menu exit")) {
                break;
            } else
                printMessage(Commands.invalid, "");
        }
    }

    public void printMessage(Commands message, String s) {
        switch (message) {
            case successful: {
                System.out.println("user created successfully!");
                break;
            }
            case userExistsWithNickname: {
                System.out.println("user with nickname " + s + " already exists");
                break;
            }
            case userExistsWithUsername: {
                System.out.println("user with username " + s + " already exists");
                break;
            }
            case invalid: {
                System.out.println("invalid command");
            }
            case showMenu: {
                System.out.println("Login Menu");
                break;
            }
            case firstLogin: {
                System.out.println("please login first");
                break;
            }
            case noMatch: {
                System.out.println("Username and password didn't match!");
                break;
            }
            case LOGIN: {
                System.out.println("user logged in successfully!");
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
