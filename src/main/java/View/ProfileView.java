package View;

import javax.swing.*;

public class ProfileView {
   public enum Commands {
        NickNameSuccessful,
        NicknameExists,
        INVALIDPassword,
        EnterNewPassword,
        PasswordSuccessful
    }

    private static ProfileView view = null;

    private ProfileView() {

    }

    public static ProfileView getInstance() {
        if (view == null)
            view = new ProfileView();
        return view;

    }

    public void printMessage(Commands message, String s) {
        switch (message) {
            case NicknameExists: {
                JOptionPane.showConfirmDialog(null,"user with nickname " + s + " already exists","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("user with nickname " + s + " already exists");
                break;
            }
            case NickNameSuccessful: {
                JOptionPane.showConfirmDialog(null,"nickname changed successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("nickname changed successfully!");
                break;
            }
            case INVALIDPassword: {
                JOptionPane.showConfirmDialog(null,"current password is invalid","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("current password is invalid");
                break;
            }
            case EnterNewPassword: {
                JOptionPane.showConfirmDialog(null,"please enter a new password","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("please enter a new password");
                break;
            }
            case PasswordSuccessful: {
                JOptionPane.showConfirmDialog(null,"password changed successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("password changed successfully!");
                break;
            }
            default:
                break;
        }
    }
}
