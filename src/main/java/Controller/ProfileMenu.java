package Controller;

import Model.Player;
import View.ProfileView;

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

    public void changePassword(Player player, String oldPassword, String newPassword) {
        view = ProfileView.getInstance();
        if (!player.getPassword().equals(oldPassword))
            view.printMessage(ProfileView.Commands.INVALIDPassword, "");
        else {
            if (player.getPassword().equals(newPassword))
                view.printMessage(ProfileView.Commands.EnterNewPassword, "");
            else {
                player.setPassword(newPassword);
                view.printMessage(ProfileView.Commands.PasswordSuccessful, "");
            }
        }
    }

    public void changeNickname(Player player, String nickName) {
        view = ProfileView.getInstance();
        if (Player.isNickNameExists(nickName)) {
            view.printMessage(ProfileView.Commands.NicknameExists, nickName);
        } else {
            player.setNickname(nickName);
            view.printMessage(ProfileView.Commands.NickNameSuccessful, "");
        }
    }

}
