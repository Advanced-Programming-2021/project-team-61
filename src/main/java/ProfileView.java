public class ProfileView {
    enum Commands {
        INVALID,
        NICKNAMESUCCESSFULL,
        NICKNAMEEXISTS,
        INVALIDPASSWORD,
        ENTERNEWPASSWORD,
        PASSWORDSUCCESSFULL,
        SHOWMENU
    }

    private static ProfileView view = null;

    private ProfileView() {

    }

    public static ProfileView getInstance() {
        if (view == null)
            view = new ProfileView();
        return view;

    }

    public String scan() {
        return RegisterView.scanner.nextLine();
    }

    public void printMessage(Commands message, String s) {
        switch (message) {
            case NICKNAMEEXISTS: {
                System.out.println("user with nickname " + s + " already exists");
                break;
            }
            case NICKNAMESUCCESSFULL: {
                System.out.println("nickname changed successfully!");
                break;
            }
            case INVALIDPASSWORD: {
                System.out.println("current password is invalid");
                break;
            }
            case ENTERNEWPASSWORD: {
                System.out.println("please enter a new password");
                break;
            }
            case PASSWORDSUCCESSFULL: {
                System.out.println("password changed successfully!");
                break;
            }
            case INVALID: {
                System.out.println("invalid command");
                break;
            }
            case SHOWMENU: {
                System.out.println("Profile Menu");
                break;
            }
            default:
                break;
        }
    }
}
