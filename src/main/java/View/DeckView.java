package View;


import Model.Card;
import Model.Deck;
import Model.MonsterCard;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class DeckView {

    public enum Commands {
        CREATESUCCESSFULLY,
        EXISTDECKALREADY,
        DELETEDECKSUCCESSFULLY,
        DONTHAVETHISDECK,
        ACTIVATESUCCESSFULLY,
        ADDCARDSUCCESSFULLY,
        DONTHAVETHISCARD,
        FULLMAINDECK,
        FULLSIDEDECK,
        LIMIT3ERROR,
        NOTEXISTTHISCARDINMAINDECK,
        NOTEXISTTHISCARDINSIDEDECK,
        REMOVECARDSUCCESSFULLY

    }

    private static DeckView s = null;
    public static Scanner scanner = new Scanner(System.in);

    private DeckView() {
    }

    public static DeckView getInstance() {
        if (s == null)
            s = new DeckView();
        return s;
    }
/*
            else if ((getCommandMatcher(command, "deck show --all")).find()) {
                printAllDecksOfPlayer(player.getAllDecks());
            }
            else if ((getCommandMatcher(command, "^deck show --deck-name ([a-zA-Z\\s]+)(--side)?$")).find()) {
                if(matcher.group(2)==null)
                    deckMenu.showMainDeck(matcher.group(1),player);
                else
                    deckMenu.showSideDeck(matcher.group(1),player);
            }
            else if ((getCommandMatcher(command, "deck show --cards")).find()) {
                printAllCardsOfPlayer(player.getPlayerCards());
            }
            else {
                printMessage(DeckView.Commands.INVALID, "", "");
            }
        }
    }
*/
    public void printMessage(DeckView.Commands message, String st1, String st2) {
        switch (message) {

            case CREATESUCCESSFULLY: {
                JOptionPane.showConfirmDialog(null,"deck created successfully!","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("deck created successfully!");
                break;
            }
            case EXISTDECKALREADY: {
                JOptionPane.showConfirmDialog(null,"deck with name " + st1 + " already exists","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("deck with name " + st1 + " already exists");
                break;
            }
            case DELETEDECKSUCCESSFULLY: {
                JOptionPane.showConfirmDialog(null,"deck deleted successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("deck deleted successfully");
                break;
            }
            case DONTHAVETHISDECK: {
                JOptionPane.showConfirmDialog(null,"deck with name " + st1 + " does not exist","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("deck with name " + st1 + " does not exist");
                break;
            }
            case ACTIVATESUCCESSFULLY: {
                JOptionPane.showConfirmDialog(null,"deck activated successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("deck activated successfully");
                break;
            }
            case ADDCARDSUCCESSFULLY: {
                JOptionPane.showConfirmDialog(null,"card added to deck successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card added to deck successfully");
                break;
            }
            case DONTHAVETHISCARD: {
                JOptionPane.showConfirmDialog(null,"card with name " + st1 + " does not exist","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card with name " + st1 + " does not exist");
                break;
            }
            case FULLMAINDECK: {
                JOptionPane.showConfirmDialog(null,"main deck is full","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("main deck is full");
                break;
            }
            case FULLSIDEDECK: {
                JOptionPane.showConfirmDialog(null,"side deck is full","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("side deck is full");
                break;
            }
            case LIMIT3ERROR: {
                JOptionPane.showConfirmDialog(null,"there are already three cards with name " + st1 + " in deck " + st2,"Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("there are already three cards with name " + st1 + " in deck " + st2);
                break;
            }
            case NOTEXISTTHISCARDINMAINDECK: {
                JOptionPane.showConfirmDialog(null,"card with name " + st1 + " does not exist in main deck","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card with name " + st1 + " does not exist in main deck");
                break;
            }
            case NOTEXISTTHISCARDINSIDEDECK: {
                JOptionPane.showConfirmDialog(null,"card with name " + st1 + " does not exist in side deck","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card with name " + st1 + " does not exist in side deck");
                break;
            }
            case REMOVECARDSUCCESSFULLY: {
                JOptionPane.showConfirmDialog(null,"card removed form deck successfully","Message",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                //System.out.println("card removed form deck successfully");
                break;
            }
            default:
                break;
        }
    }

    public String printAllDecksOfPlayer(ArrayList<Deck> allDecks) {
        StringBuilder s = new StringBuilder();
        String validCheck;
        int counter = 1;
        //System.out.println("Decks:");
        s.append("Decks:\n");
        //System.out.println("Active Deck:");
        s.append("Active Deck:\n");
        for (Deck deck : allDecks) {
            if (deck.isActivated()) {
                if (deck.isDeckValid()) {
                    validCheck = "valid";
                } else {
                    validCheck = "invalid";
                }
                //System.out.println(deck.getDeckName() + " : main deck " + deck.getMainDeck().size() + " , side deck " + deck.getSideDeck().size() + validCheck);
                s.append(deck.getDeckName() + " : number of cards in main deck => " + deck.getMainDeck().size() + " * number of cards in side deck => " + deck.getSideDeck().size() + " * " + validCheck + "\n");
                break;
            }
        }
        //System.out.println("Other Decks:");
        s.append("Other Decks:\n");
        sortDeck(allDecks);
        for (Deck deck : allDecks) {
            if (deck.isDeckValid()) {
                validCheck = "valid";
            } else {
                validCheck = "invalid";
            }
            if (!deck.isActivated())
                //System.out.println(deck.getDeckName() + " : main deck " + deck.getMainDeck().size() + " , side deck " + deck.getSideDeck().size() + validCheck);
                s.append(counter + ". " + deck.getDeckName() + " : number of cards in main deck => " + deck.getMainDeck().size() + " * number of cards in side deck => " + deck.getSideDeck().size() + " * " + validCheck + "\n");
            counter++;
        }
        return s.toString();
    }

    public void printOneDeck(String deckName, ArrayList<Card> cards, String M_S) {
        ArrayList<Card> monsters = new ArrayList<>();
        ArrayList<Card> spellTrap = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof MonsterCard)
                monsters.add(card);
            else
                spellTrap.add(card);
        }
        System.out.println("Deck: " + deckName );
        if (M_S.equals("M")) {
            System.out.println("Main deck:");
        } else {
            System.out.println("Side deck:");
        }
        sortCards(monsters);
        sortCards(spellTrap);
        System.out.println("Monsters:");
        for (Card monster : monsters)
            System.out.println(monster.getCardName() + ":" + monster.getDescription());
        System.out.println("Spell and Traps:");
        for (Card spell : spellTrap)
            System.out.println(spell.getCardName() + ":" + spell.getDescription());

    }

    private void sortDeck(ArrayList<Deck> allDecks) {
        for (int i = 0; i < allDecks.size() - 1; i++) {
            for (int j = i; j < allDecks.size(); j++) {
                if (allDecks.get(i).getDeckName().compareTo(allDecks.get(j).getDeckName()) > 0)
                    Collections.swap(allDecks, i, j);
            }
        }
    }

    private void sortCards(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            for (int j = i; j < cards.size(); j++) {
                if (cards.get(i).getCardName().compareTo(cards.get(j).getCardName()) > 0)
                    Collections.swap(cards, i, j);
            }
        }
    }

    public void printAllCardsOfPlayer(ArrayList<Card> allCards) {
        sortCards(allCards);
        for (Card card : allCards) {
            System.out.println(card.getCardName() + " : " + card.getDescription());
        }

    }
}
