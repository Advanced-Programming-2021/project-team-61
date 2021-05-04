import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;

public class Board {

    private Player player;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> sideDeck;
    private String[] monsterZone = new String[5];
    private HashMap<Integer, Card> monsterCardsInField = new HashMap<>();
    private String[] spellTrapZone = new String[5];
    private HashMap<Integer, Card> spellTrapCardsInField = new HashMap<>();
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();
    private boolean isACardSelected = false;
    private boolean isSummonedInTurn = false;
    private static ArrayList<Board> boards = new ArrayList<>();


    public Board(Player player) {
        this.player = player;
        this.mainDeck = Deck.getActivatedDeck(player).getMainDeck();
        this.sideDeck = Deck.getActivatedDeck(player).getSideDeck();
        this.initializeMonsterZone();
        this.initializeSpellTrapZone();
        boards.add(this);
    }

    public static Board getBoardByPlayer(Player player) {
        for (Board board : boards) {
            if (board.player.getUsername().equals(player.getUsername()))
                return board;
        }
        return null;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setSummonedInTurn(boolean summonedInTurn) {
        isSummonedInTurn = summonedInTurn;
    }

    public boolean isSummonedInTurn() {
        return isSummonedInTurn;
    }

    public void createHand() {
        Collections.shuffle(mainDeck);
        for (int i = 0; i < 6; i++)
            hand.add(mainDeck.get(i));
    }

    public void addCardToHand() {
        hand.add(mainDeck.get(0));
    }

    public void setMonsterZone(int index, String manner) {
        monsterZone[index] = manner;
    }

    public void setSpellTrapZone(int index, String manner) {
        spellTrapZone[index] = manner;
    }

    public void addSpellTrapCardToField(int position, Card card) {
        spellTrapCardsInField.put(position, card);
    }

    public void addMonsterCardToField(int position, Card card) {
        monsterCardsInField.put(position, card);
    }

    public void destroyCard(Card card) {
        graveYard.add(card);
    }

    public boolean isMonsterZoneFull() {
        for (int i = 0; i < 5; i++) {
            if (monsterZone[i].equals("E"))
                return false;
        }
        return true;
    }

    public boolean isACardSelected() {
        return isACardSelected;

    }

    public boolean isMonsterCardInHand() {
        Card card = getSelectedCardFromHand();
        return card instanceof MonsterCard;
    }

    public Card getSelectedCardFromHand() {
        for (Card card : hand) {
            if (card.isSelected)
                return card;
        }
        return null;
    }

    //this method needs to be put in MainPhase;
    public boolean isSelectionValid(Matcher matcher) {
        if (matcher.find()) {
            if (!isCardAddressValid(matcher.group(1))) {
                return false;
            } else if (!isNumberValid(matcher.group(1), Integer.parseInt(matcher.group(2)))) {
                return false;
            } else if (isCardAvailable(matcher.group(1), Integer.parseInt(matcher.group(2))))
        }

    }

    private boolean isCardAvailable(String addreess, int position) {
        switch (addreess) {
            case "--hand": {
                return true;
            }
            case "--monster": {
                if (isMonsterAvailableInMonsterZone(position))
                    return true;
                else
                    return false;


            }
            case "--spell": { //to be completed

            }
        }
    }

    public void summon(int position) {
        switch (position) {
            case 1: {
                setMonsterZone(2, "OO");
                break;
            }
            case 2: {
                setMonsterZone(3, "OO");
                break;
            }
            case 3: {
                setMonsterZone(1, "OO");
                break;
            }
            case 4: {
                setMonsterZone(4, "OO");
                break;
            }
            case 5: {
                setMonsterZone(0, "OO");
            }
            default:
                break;
        }
        addMonsterCardToField(position, getSelectedCardFromHand());
    }

    private boolean isSpellTrapAvailableInSpellZone(int position) {
        switch (position) {
            case 1: {
                return !spellTrapZone[2].equals("E");
            }
            case 2: {
                return !spellTrapZone[1].equals("E");
            }
            case 3: {
                return !spellTrapZone[3].equals("E");
            }
            case 4: {
                return !spellTrapZone[0].equals("E");
            }
            case 5: {
                return !spellTrapZone[4].equals("E");
            }
            default: {
                return false;
            }
        }


    }

    private boolean isMonsterAvailableInMonsterZone(int position) {
        switch (position) {
            case 1: {
                return !monsterZone[2].equals("E");
            }
            case 2: {
                return !monsterZone[1].equals("E");
            }
            case 3: {
                return !monsterZone[3].equals("E");
            }
            case 4: {
                return !monsterZone[0].equals("E");
            }
            case 5: {
                return !monsterZone[4].equals("E");
            }
            default: {
                return false;
            }
        }
    }

    private boolean isNumberValid(String address, int number) {
        switch (address) {
            case "--hand": {
                return (number <= hand.size() && number >= 1);
            }
            //fieldZone needs to be added
            default: {
                return (number <= 5 && number >= 1);
            }
        }
    }

    private boolean isCardAddressValid(String address) {
        switch (address) {
            case "--monster":
            case "--hand":
            case "--spell--opponent":
            case "--spell":
            case "--monster--opponent": {
                return true;
            }
            //fieldZone needs to be added
            default: {
                return false;
            }
        }


    }

    private void initializeMonsterZone() {
        for (int i = 0; i < 5; i++)
            monsterZone[i] = "E";
    }

    private void initializeSpellTrapZone() {
        for (int i = 0; i < 5; i++)
            spellTrapZone[i] = "E";
    }


}
