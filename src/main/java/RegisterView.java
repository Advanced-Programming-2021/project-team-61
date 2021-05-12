import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterView {
    enum Commands {
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
    private String regex;
    private Matcher matcher;

    private RegisterView(RegisterMenu registerMenu) {
        this.registerMenu = registerMenu;
    }

    public static RegisterView getInstance() {
        if (r == null) {
            RegisterMenu m = RegisterMenu.getInstance();
            r = new RegisterView(m);
        }
        return r;
    }

    public void scan() {
        while (true) {
            command = scanner.nextLine();
            if (command.startsWith("user create ")) {
                regex = "user create --username ([^\\s]+) --nickname ([^\\s]+) --password ([^\\s]+)";
                matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    registerMenu.userCreateProcess(matcher);
                }
            } else if (command.startsWith("user login")) {
                regex = "user login --username ([^\\s]+) --password ([^\\s]+)";
                matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    registerMenu.loginProcess(matcher);
                }
            } else if (command.equals("menu show-current")) {
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
                System.out.println("user created successfully!\n");
                break;
            }
            case userExistsWithNickname: {
                System.out.println("user with nickname " + s + " already exists\n");
                break;
            }
            case userExistsWithUsername: {
                System.out.println("user with username " + s + " already exists\n");
                break;
            }
            case invalid: {
                System.out.println("invalid command\n");
            }
            case showMenu: {
                System.out.println("Login Menu\n");
                break;
            }
            case firstLogin: {
                System.out.println("please login first\n");
                break;
            }
            case noMatch: {
                System.out.println("Username and password didn't match!\n");
                break;
            }
            case LOGIN: {
                System.out.println("user logged in successfully!\n");
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
