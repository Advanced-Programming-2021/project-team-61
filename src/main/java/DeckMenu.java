import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
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
                addCardToMainDeck();
                addCardToSideDeck();
            }else if ((matcher = getCommandMatcher(command, "deck rm-card --card <card name> --deck ([^\\s]+) --side(optional)")).find()){
                removeCardFromMainDeck();
                removeCardFromSideDeck();
            }else if ((matcher = getCommandMatcher(command, "deck show --all")).find()){
                showAllDecksOfPlayer();
            }else if ((matcher = getCommandMatcher(command, "deck show --deck-name ([^\\s]+) --side(Opt)")).find()){
                showDeck();
            }else if ((matcher = getCommandMatcher(command, "deck show --cards")).find()){
                showAllCardsOfDeck();
            }else {
                view.printMessage(DeckView.Commands.INVALID,"","");
            }
        }
    }

    public void createDeck(String deckName){
        if (Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.EXISTDECKALREADY,deckName,"");
        }else {
            new Deck(deckName, name);
            view.printMessage(DeckView.Commands.CREATESUCCESSFULLY,"","");
        }
    }

    public void deleteDeck(String deckName){
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else {
            view.printMessage(DeckView.Commands.DELETEDECKSUCCESSFULLY,"","");
            Player.getPlayerByUsername(name).removeDeckId(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId()));
            //return cards for player after deleting deck...
        }
    }

    public void setActivateDeck(String deckName){
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else {
            view.printMessage(DeckView.Commands.ACTIVATESUCCESSFULLY,"","");
            Deck.activateDeck(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId()),Player.getPlayerByUsername(name).getDeckId());
        }
    }

    public void addCardToMainDeck(String cardName,String deckName){
        if (/*is card exist for player or not*/){
            view.printMessage(DeckView.Commands.DONTHAVETHISCARD,cardName,"");
        }else if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else if (Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isMainDeckFull()){
            view.printMessage(DeckView.Commands.FULLMAINDECK,"","");
        }else if (Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isTripletCard(cardName)){
            view.printMessage(DeckView.Commands.LIMIT3ERROR,cardName,deckName);
        }else {
            view.printMessage(DeckView.Commands.ADDCARDSUCCESSFULLY,"","");
            Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).addCardToMainDeck_Deck(cardName);
            //reduce the card from player..
        }
    }

    public void addCardToSideDeck(String cardName,String deckName){
        if (/*is card exist for player or not*/){
            view.printMessage(DeckView.Commands.DONTHAVETHISCARD,cardName,"");
        }else if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else if (Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isSideDeckFull()){
            view.printMessage(DeckView.Commands.FULLSIDEDECK,"","");
        }else if (Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isTripletCard(cardName)){
            view.printMessage(DeckView.Commands.LIMIT3ERROR,cardName,deckName);
        }else {
            view.printMessage(DeckView.Commands.ADDCARDSUCCESSFULLY,"","");
            Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).addCardToSideDeck_Deck(cardName);
            //reduce the card from player..
        }
    }

    public void removeCardFromMainDeck(String cardName,String deckName){
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else if (!Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isCardExistInMainDeck(cardName)){
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINMAINDECK,cardName,"");
        }else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY,"","");
            Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).removeCardFromMainDeck_Deck(cardName);
            //return card for player after remove from deck...
        }
    }

    public void removeCardFromSideDeck(String cardName,String deckName){
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName,Player.getPlayerByUsername(name).getDeckId())){
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        }else if (!Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).isCardExistInSideDeck(cardName)){
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINSIDEDECK,cardName,"");
        }else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY,"","");
            Deck.getDeckById(Deck.getDeckIdByDeckNameForSpecificPlayer(deckName,Player.getPlayerByUsername(name).getDeckId())).removeCardFromSideDeck_Deck(cardName);
            //return card for player after remove card
        }
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
