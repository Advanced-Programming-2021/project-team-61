
public class MainMenu {

    private static MainMenu m = null;
    private MainView view = MainView.getInstance();

    private MainMenu() {

    }

    public static MainMenu getInstance() {
        if (m == null) {
            m = new MainMenu();
        }
        return m;
    }


    public void menuEnter(String menuName, String username) {
        switch (menuName) {
            case "Duel": {
                DualView dualView = DualView.getInstance();
                dualView.scan(username);
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
            default: break;
        }
    }
}
