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
    private ProfileMenu profileMenu;
    private String command;
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
            profileMenu = ProfileMenu.getInstance();
            command = RegisterView.scanner.nextLine();
            if ((matcher = getCommandMatcher(command, "profile change --nickname ([^\\s]+)")).find())
                profileMenu.changeNickname(Player.getPlayerByUsername(username), matcher);
            else if ((matcher = getCommandMatcher(command, "profile change --password --current ([^\\s]+) --new ([^\\s]+)")).find())
                profileMenu.changePassword(Player.getPlayerByUsername(username), matcher);
            else if (command.equals("menu exit"))
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
                System.out.println("user with nickname " + s + " already exists");
                break;
            }
            case NickNameSuccessful: {
                System.out.println("nickname changed successfully!");
                break;
            }
            case INVALIDPassword: {
                System.out.println("current password is invalid");
                break;
            }
            case EnterNewPassword: {
                System.out.println("please enter a new password");
                break;
            }
            case PasswordSuccessful: {
                System.out.println("password changed successfully!");
                break;
            }
            case INVALID: {
                System.out.println("invalid command");
                break;
            }
            case showMenu: {
                System.out.println("Profile Menu");
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
