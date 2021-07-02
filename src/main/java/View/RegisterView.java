package View;

import javax.swing.*;

public class RegisterView {
  public enum Commands {
        successful,
        userExistsWithNickname,
        userExistsWithUsername,
        noMatch,
        LOGIN
    }

    private static RegisterView r = null;

    private RegisterView() {

    }

    public static RegisterView getInstance() {
        if (r == null)
            r = new RegisterView();
        return r;
    }

    public void printMessage(Commands message, String s) {
        switch (message) {
            case successful: {
                JOptionPane.showConfirmDialog(null,"user created successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("user created successfully!");
                break;
            }
            case userExistsWithNickname: {
                JOptionPane.showConfirmDialog(null,"user with nickname " + s + " already exists","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("user with nickname " + s + " already exists");
                break;
            }
            case userExistsWithUsername: {
                JOptionPane.showConfirmDialog(null,"user with username " + s + " already exists","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("user with username " + s + " already exists");
                break;
            }
            case noMatch: {
                JOptionPane.showConfirmDialog(null,"Username and password didn't match!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("Username and password didn't match!");
                break;
            }
            case LOGIN: {
                JOptionPane.showConfirmDialog(null,"user logged in successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("user logged in successfully!");
            }
            default:
                break;
        }
    }
}
