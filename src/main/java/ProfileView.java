import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileView {
    enum Commands {
        INVALID,
        NickNameSuccessful,
        NicknameExists,
        INVALIDPassword,
        EnterNewPassword,
        PasswordSuccessful,
        showMenu
    }

    private static ProfileView view = null;
    private ProfileMenu profileMenu = ProfileMenu.getInstance();
    private String command;
    private String regex;
    private Matcher matcher;

    private ProfileView() {

    }

    public static ProfileView getInstance() {
        if (view == null)
            view = new ProfileView();
        return view;

    }

    public void scan(String username) {
        while (true) {
            command = RegisterView.scanner.nextLine();
            if (command.startsWith("profile change --nickname")) {
                regex = "profile change --nickname ([^\\s]+)";
                matcher = getCommandMatcher(command, regex);
                if (matcher.find())
                    profileMenu.changeNickname(Player.getPlayerByUsername(username), matcher);
            } else if (command.startsWith("profile change --password --current")) {
                regex = "profile change --password --current ([^\\s]+) --new ([^\\s]+)";
                matcher = getCommandMatcher(command, regex);
                if (matcher.find())
                    profileMenu.changePassword(Player.getPlayerByUsername(username), matcher);
            } else if (command.equals("menu exit"))
                break;
            else if (command.equals("menu show--current"))
                printMessage(Commands.showMenu, "");
            else
                printMessage(ProfileView.Commands.INVALID, "");


        }
    }

    public void printMessage(Commands message, String s) {
        switch (message) {
            case NicknameExists: {
                System.out.println("user with nickname " + s + " already exists\n");
                break;
            }
            case NickNameSuccessful: {
                System.out.println("nickname changed successfully!\n");
                break;
            }
            case INVALIDPassword: {
                System.out.println("current password is invalid\n");
                break;
            }
            case EnterNewPassword: {
                System.out.println("please enter a new password\n");
                break;
            }
            case PasswordSuccessful: {
                System.out.println("password changed successfully!\n");
                break;
            }
            case INVALID: {
                System.out.println("invalid command\n");
                break;
            }
            case showMenu: {
                System.out.println("Profile Menu\n");
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
