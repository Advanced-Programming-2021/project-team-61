import java.util.regex.Matcher;

public class ProfileMenu {

    private static ProfileMenu p = null;
    private ProfileView view;

    private ProfileMenu() {
        //please be modified in main

    }

    public static ProfileMenu getInstance() {
        if (p == null)
            p = new ProfileMenu();
        return p;
    }

    public void changePassword(Player player, Matcher matcher) {
        view = ProfileView.getInstance();
        if (!player.getPassword().equals(matcher.group(1)))
            view.printMessage(ProfileView.Commands.INVALIDPassword, "");
        else {
            if (player.getPassword().equals(matcher.group(2)))
                view.printMessage(ProfileView.Commands.EnterNewPassword, "");
            else {
                player.setPassword(matcher.group(2));
                view.printMessage(ProfileView.Commands.PasswordSuccessful, "");
            }
        }
    }

    public void changeNickname(Player player, Matcher matcher) {
        view = ProfileView.getInstance();
        if (Player.isNickNameExists(matcher.group(1))) {
            view.printMessage(ProfileView.Commands.NicknameExists, matcher.group(1));
        } else {
            player.setNickname(matcher.group(1));
            view.printMessage(ProfileView.Commands.NickNameSuccessful, "");
        }
    }

}
