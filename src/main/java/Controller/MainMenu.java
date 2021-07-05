package Controller;

import View.*;

public class MainMenu {

    private static MainMenu m = null;

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
                //dualView.scan(username);
                break;
            }
            case "Deck": {
                DeckView deckView = DeckView.getInstance();
                //deckView.scan(username);
                break;
            }
            case "Scoreboard": {
                ScoreBoardView scoreBoardView = ScoreBoardView.getInstance();
                //scoreBoardView.scan();
                break;

            }
            case "Profile": {
                ProfileView profileView = ProfileView.getInstance();
                //profileView.scan(username);
                break;

            }
            case "Shop": {
                ShopView shopView = ShopView.getInstance();
                //shopView.scan(username);
                break;

            }
            default: break;
        }
    }
}
