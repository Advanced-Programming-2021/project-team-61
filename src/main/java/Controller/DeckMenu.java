package Controller;

import Model.Deck;
import Model.Player;
import View.DeckView;

public class DeckMenu {

    private static DeckMenu s = null;
    private DeckView view;


    private DeckMenu() {

    }

    public static DeckMenu getInstance() {
        if (s == null) {
            s = new DeckMenu();
        }
        return s;
    }


    public void createDeck(String deckName, Player player) {
        view = DeckView.getInstance();
        if (Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.EXISTDECKALREADY, deckName, "");
        } else {
            new Deck(deckName, player.getUsername());
            view.printMessage(DeckView.Commands.CREATESUCCESSFULLY, "", "");
        }
    }

    public void deleteDeck(String deckName, Player player) {
        view = DeckView.getInstance();
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else {
            view.printMessage(DeckView.Commands.DELETEDECKSUCCESSFULLY, "", "");
            player.addCardsAfterRemoveDeck(Deck.getDeckByName(deckName,player));
            player.removeDeck(Deck.getDeckByName(deckName,player));
        }
    }

    public void setActivateDeck(String deckName, Player player) {
        view = DeckView.getInstance();
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else {
            view.printMessage(DeckView.Commands.ACTIVATESUCCESSFULLY, "", "");
            Deck.activateDeck(deckName,player);
        }
    }

    public void addCardToMainDeck(String cardName, String deckName, Player player) {
        view = DeckView.getInstance();
        if (!player.doesPlayerHaveSpecialCard(cardName)) {
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
            player.removeCardFromPlayerAfterAddToDeck(cardName);
        }
    }

    public void addCardToSideDeck(String cardName, String deckName, Player player) {
        view = DeckView.getInstance();
        if (!player.doesPlayerHaveSpecialCard(cardName)) {
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
            player.removeCardFromPlayerAfterAddToDeck(cardName);
        }
    }

    public void removeCardFromMainDeck(String cardName, String deckName, Player player) {
        view = DeckView.getInstance();
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (!Deck.getDeckByName(deckName,player).isCardExistInMainDeck(cardName)) {
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINMAINDECK, cardName, "");
        } else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).removeCardFromMainDeck_Deck(cardName);
            player.addCardToPlayerCardsAfterRemoveFromDeck(cardName);
        }
    }

    public void removeCardFromSideDeck(String cardName, String deckName, Player player) {
        view = DeckView.getInstance();
        if (!Deck.doesPlayerHaveDeckWithThisName(deckName, player)) {
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK, deckName, "");
        } else if (!Deck.getDeckByName(deckName,player).isCardExistInSideDeck(cardName)) {
            view.printMessage(DeckView.Commands.NOTEXISTTHISCARDINSIDEDECK, cardName, "");
        } else {
            view.printMessage(DeckView.Commands.REMOVECARDSUCCESSFULLY, "", "");
            Deck.getDeckByName(deckName,player).removeCardFromSideDeck_Deck(cardName);
            player.addCardToPlayerCardsAfterRemoveFromDeck(cardName);
        }
    }


    public void showMainDeck(String deckName, Player player){
        view = DeckView.getInstance();
        if(!Deck.doesPlayerHaveDeckWithThisName(deckName,player))
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        else
        view.printOneDeck(deckName, Deck.getDeckByName(deckName,player).getMainDeck(),"M");
    }

    public void showSideDeck(String deckName, Player player){
        view = DeckView.getInstance();
        if(!Deck.doesPlayerHaveDeckWithThisName(deckName,player))
            view.printMessage(DeckView.Commands.DONTHAVETHISDECK,deckName,"");
        else
        view.printOneDeck(deckName, Deck.getDeckByName(deckName,player).getSideDeck(),"S");
    }
}
