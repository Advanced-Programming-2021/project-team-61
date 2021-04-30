import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainMenu {

    private static MainMenu m = null;
    private String command;
    private MainView view;

    private MainMenu(MainView view) {
        this.view = view;

    }

    public static MainMenu getInstance() {
        if (m == null) {
            MainView view = MainView.getInstance();
            m = new MainMenu(view);
        }
        return m;
    }

    public void run(String username) {
        while (true) {
            command = view.scan();
            int changed = 0;
            if (command.equals("user logout")) {
                changed = 1;
                view.printMessage(MainView.Commands.LOGOUT);
                break;
            }
            if (command.startsWith("menu enter")) {
                String regex = "menu enter ([^\\s]+)";
                Matcher matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    changed = 1;
                    menuEnter(matcher.group(1), username);
                }

            }
            if(command.equals("menu show--current")){
                changed = 1;
                view.printMessage(MainView.Commands.MENUNAME);
            }
            if (changed == 0)
                view.printMessage(MainView.Commands.INVALID);

        }

    }

    private void menuEnter(String menuName, String username) {
        switch (menuName) {
            case "Duel": {
                break;

            }
            case "Deck": {
                break;

            }
            case "Scoreboard": {
                ScoreBoardMenu m = ScoreBoardMenu.getInstance();
                m.run();
                break;

            }
            case "Profile": {
                ProfileMenu p = ProfileMenu.getInstance();
                p.run(username);
                break;

            }
            case "Shop": {
                ShopMenu s = ShopMenu.getInstance();
                s.run(username);
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
