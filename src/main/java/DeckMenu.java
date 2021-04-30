import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckMenu {

    private static DeckMenu s = null;
    private DeckView view;
    private String command;
    private Player player;

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

    public void run(String username) {
        player = Player.getPlayerByUsername(username);
        Matcher matcher;
        while (true) {
            command = view.scan();
            if ((getCommandMatcher(command, "menu exit")).find()) {
                break;
            } else if ((getCommandMatcher(command, "menu show-current")).find()) {
                view.printMessage(DeckView.Commands.CURRENTMENU, "", "");
            } else if ((matcher = getCommandMatcher(command, "^deck create ([a-zA-Z\\s]+)$")).find()) {
                createDeck(matcher.group(1));
            } else if ((matcher = getCommandMatcher(command, "^deck delete ([a-zA-Z\\s]+)$")).find()) {
                deleteDeck(matcher.group(1));
            } else if ((matcher = getCommandMatcher(command, "^deck set-activate ([a-zA-Z\\s]+)$")).find()) {
                setActivateDeck(matcher.group(1));
            } else if ((matcher = getCommandMatcher(command, "^deck add-card --card ([a-zA-Z\\s]+) --deck ([a-zA-Z\\s]+)( --side)?$")).find()) {
                if(matcher.group(3)==null)
                addCardToMainDeck(matcher.group(1),matcher.group(2));
                else
                    addCardToSideDeck(matcher.group(1),matcher.group(2));
            } else if ((matcher = getCommandMatcher(command, "^deck rm-card --card ([a-zA-Z\\s]+) --deck ([a-zA-Z\\s]+)( --side)?$")).find()) {
                if (matcher.group(3) != null)
                    removeCardFromSideDeck(matcher.group(1),matcher.group(2));
                else
                    removeCardFromMainDeck(matcher.group(1),matcher.group(2));
            } else if ((getCommandMatcher(command, "deck show --all")).find()) {
                view.printAllDecksOfPlayer(player.getAllDecks());
            } else if ((getCommandMatcher(command, "^deck show --deck-name ([a-zA-Z\\s]+)(--side)?$")).find()) {
                if(matcher.group(2)==null)
                    showMainDeck(matcher.group(1));
                else
                    showSideDeck(matcher.group(1));
            } else if ((getCommandMatcher(command, "deck show --cards")).find()) {
                //show all cards that are buyed
                showAllCardsOfDeck();
            } else {
                view.printMessage(DeckView.Commands.INVALID, "", "");
            }
        }
    }

    public void createDeck(String deckName) {
        if (Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.EXISTDECKALREADY, deckName, "");
        } else {
            new Deck(deckName, player.getUsername());
            view.printMessage(DeckView.Commands.CREATESUCCESSFULLY, "", "");
        }
    }

    public void deleteDeck(String deckName) {
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else {
            view.printMessage(DeckView.Commands.DELETEDECKSUCCESSFULLY, "", "");
            player.removeDeck(Deck.getDeckByName(deckName,player));
            //return cards for player after deleting deck...
        }
    }

    public void setActivateDeck(String deckName) {
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else {
            view.printMessage(DeckView.Commands.ACTIVATESUCCESSFULLY, "", "");
            Deck.activateDeck(deckName,player);
        }
    }

    public void addCardToMainDeck(String cardName, String deckName) {
        if (/*is card exist for player or not*/) {
            view.printMessage(DeckView.Commands.DONTHAVETHISCARD, cardName, "");
        } else if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (Deck.getDeckByName(deckName,player).isMainDeckFull()) {
            view.printMessage(DeckView.Commands.FULLMAINDECK, "", "");
        } else if (Deck.getDeckByName(deckName,player).isTripletCard(cardName)) {
            view.printMessage(DeckView.Commands.LIMIT3ERROR, cardName, deckName);
        } else {
            view.printMessage(DeckView.Commands.ADDCARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).addCardToMainDeck_Deck(cardName);
            //reduce the card from player..
        }
    }

    public void addCardToSideDeck(String cardName, String deckName) {
        if (/*is card exist for player or not*/) {
            view.printMessage(DeckView.Commands.DONTHAVETHISCARD, cardName, "");
        } else if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (Deck.getDeckByName(deckName,player).isSideDeckFull()) {
            view.printMessage(DeckView.Commands.FULLSIDEDECK, "", "");
        } else if (Deck.getDeckByName(deckName,player).isTripletCard(cardName)) {
            view.printMessage(DeckView.Commands.LIMIT3ERROR, cardName, deckName);
        } else {
            view.printMessage(DeckView.Commands.ADDCARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).addCardToSideDeck_Deck(cardName);
            //reduce the card from player..
        }
    }

    public void removeCardFromMainDeck(String cardName, String deckName) {
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (!Deck.getDeckByName(deckName,player).isCardExistInMainDeck(cardName)) {
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINMAINDECK, cardName, "");
        } else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).removeCardFromMainDeck_Deck(cardName);
            //return card for player after remove from deck...
        }
    }

    public void removeCardFromSideDeck(String cardName, String deckName) {
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (!Deck.getDeckByName(deckName,player).isCardExistInSideDeck(cardName)) {
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINSIDEDECK, cardName, "");
        } else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).removeCardFromSideDeck_Deck(cardName);
            //return card for player after remove card
        }
    }

    /*public void showAllDecksOfPlayer() {

    }*/

    public void showMainDeck(String deckName){
        if(!Deck.doesPlayerHaveDeckWithThisName(deckName,player))
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        else
        view.printOneDeck(deckName,Deck.getDeckByName(deckName,player).getMainDeck(),"M");
    }

    public void showSideDeck(String deckName){
        view.printOneDeck(deckName,Deck.getDeckByName(deckName,player).getSideDeck(),"S");
    }

    public void showAllCardsOfDeck() {

    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);
    }
}
