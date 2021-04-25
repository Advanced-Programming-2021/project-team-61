import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileMenu {

    private static ProfileMenu p = null;
    private String command;
    private ProfileView view;

    private ProfileMenu(ProfileView view) {
        this.view = view;

    }

    public static ProfileMenu getInstance() {
        if (p == null) {
            ProfileView view = ProfileView.getInstance();
            p = new ProfileMenu(view);
        }
        return p;
    }

    public void run(String username) {
        while (true) {
            Matcher matcher;
            int changed = 0;
            command = view.scan();
            if (command.startsWith("profile change --nickname")) {
                changed = 1;
                String regex = "profile change --nickname ([^\\s]+)";
                if ((matcher = getCommandMatcher(command, regex)).find())
                    changeNickname(Player.getPlayerByUsername(username), matcher);
            }
            if (command.startsWith("profile change --password --current")) {
                changed = 1;
                String regex = "profile change --password --current ([^\\s]+) --new ([^\\s]+)";
                if ((matcher = getCommandMatcher(command, regex)).find())
                    changePassword(Player.getPlayerByUsername(username), matcher);
            }
            if (command.equals("menu exit"))
                break;
            if (command.equals("menu show--current")) {
                changed = 1;
                view.printMessage(ProfileView.Commands.SHOWMENU, "");
            }
            if (changed == 0)
                view.printMessage(ProfileView.Commands.INVALID, "");
        }
    }

    private void changePassword(Player player, Matcher matcher) {
        if (!player.getPassword().equals(matcher.group(1)))
            view.printMessage(ProfileView.Commands.INVALIDPASSWORD, "");
        else {
            if (player.getPassword().equals(matcher.group(2)))
                view.printMessage(ProfileView.Commands.ENTERNEWPASSWORD, "");
            else {
                player.setPassword(matcher.group(2));
                view.printMessage(ProfileView.Commands.PASSWORDSUCCESSFULL, "");
            }
        }
    }

    private void changeNickname(Player player, Matcher matcher) {
        if (Player.isNickNameExists(matcher.group(1))) {
            view.printMessage(ProfileView.Commands.NICKNAMEEXISTS, matcher.group(1));
        } else {
            player.setNickname(matcher.group(1));
            view.printMessage(ProfileView.Commands.NICKNAMESUCCESSFULL, "");
        }
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
