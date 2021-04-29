import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckMenu {

    private static DeckMenu s = null;
    private DeckView view;
    private String command;
    private String name;

    private DeckMenu(DeckView view) {
        this.view = view;
    }

    public static DeckMenu getInstance() {
        if (s == null) {
            DeckView view = DeckView.getInstance();
            s = new DeckMenu(view);
        }
        return s;
    }

    public void run(String username){
        name = username;
        Matcher matcher;
        while (true){
            command = view.scan();
            if ((matcher = getCommandMatcher(command,"menu exit")).find()) {
                break;
            }else if ((matcher =  getCommandMatcher(command,"menu show-current")).find()){
                view.printMessage(DeckView.Commands.CURRENTMENU,"","");
            }else if ((matcher = getCommandMatcher(command,"deck create ([^\\s]+)")).find()){
                createDeck(matcher.group(1));
            }else if ((matcher = getCommandMatcher(command, "deck delete ([^\\s]+)")).find()){
                deleteDeck(matcher.group(1));
            }else if ((matcher = getCommandMatcher(command, "deck set-activate ([^\\s]+)")).find()){
                setActivateDeck(matcher.group(1));
            }else if ((matcher = getCommandMatcher(command, "deck add-card --card <card name> --deck ([^\\s]+) --side(optional)")).find()){
                //addCardToDeck();
            }else if ((matcher = getCommandMatcher(command, "deck rm-card --card <card name> --deck ([^\\s]+) --side(optional)")).find()){
               // removeCardFromDeck();
            }else if ((matcher = getCommandMatcher(command, "deck show --all")).find()){
                showAllDecksOfPlayer();
            }else if ((matcher = getCommandMatcher(command, "deck show --deck-name ([^\\s]+) --side(Opt)")).find()){
                //showDeck();
            }else if ((matcher = getCommandMatcher(command, "deck show --cards")).find()){
                showAllCardsOfDeck();
            }else {
                view.printMessage(DeckView.Commands.INVALID,"","");
            }
        }
    }

    public void createDeck(String deckName){

    }

    public void deleteDeck(String deckName){

    }

    public void setActivateDeck(String deckName){

    }

    public void addCardToDeck(Matcher matcher){

    }

    public void removeCardFromDeck(Matcher matcher){

    }

    public void showAllDecksOfPlayer(){

    }

    public void showDeck(Matcher matcher){

    }

    public void showAllCardsOfDeck(){

    }



    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
