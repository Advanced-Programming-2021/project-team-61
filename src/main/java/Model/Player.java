package Model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private static ArrayList<Player> allPlayers = new ArrayList<>();
    private String username;
    private String nickname;
    private String password;
    private int score;
    private int coin = 100000;
    private Image image;
    private ArrayList<Deck> allDecks = new ArrayList<>();
    private static ArrayList<Card> playerCards = new ArrayList<>();
    private static Player loggedPlayer;
    private static Player graveYard;


    public Player(String username, String nickname, String password) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.image = proImage();
        allPlayers.add(this);
    }

    public static Player getPlayerByUsername(String username) {
        for (Player allPlayer : allPlayers) {
            if (allPlayer.username.equals(username))
                return allPlayer;
        }
        return null;
    }

    public static boolean isUserNameExists(String username) {

        return Player.getPlayerByUsername(username) != null;
    }

    public static boolean isNickNameExists(String nickname) {
        for (Player allPlayer : allPlayers) {
            if (allPlayer.nickname.equals(nickname))
                return true;

        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static ArrayList<Player> getAllPlayers() {
        return allPlayers;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCoin() {
        return coin;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCoin(int coin) {
        this.coin -= coin;
    }

    public void increaseCoin(int coin) {
        this.coin += coin;
    }

    public static int getScoreByNickname(String nickname) {
        for (Player player : allPlayers) {
            if (player.nickname.equals(nickname))
                return player.score;
        }
        return 0;
    }

    public static ArrayList<String> getAllNickNames() {
        ArrayList<String> allNickName = new ArrayList<>();
        for (Player player : allPlayers) {
            allNickName.add(player.nickname);
        }
        return allNickName;
    }

    public void addDeck(Deck deck) {
        allDecks.add(deck);
    }

    public void removeDeck(Deck deck) {
        allDecks.remove(deck);
    }

    public ArrayList<Deck> getAllDecks() {
        return allDecks;
    }

    public void addCard(Card card) {
        playerCards.add(card);
    }

    public void buyCard(Card card) {
        this.setCoin(card.getPrice());
        addCard(card);
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public boolean doesPlayerHaveSpecialCard(String cardName) {
        for (Card card : playerCards) {
            if (card.cardName.equals(cardName))
                return true;
        }
        return false;
    }

    public void addCardsAfterRemoveDeck(Deck deck) {
        playerCards.addAll(deck.getSideDeck());
        playerCards.addAll(deck.getSideDeck());
    }

    public void removeCardFromPlayerAfterAddToDeck(String cardName) {
        playerCards.remove(Card.getCardByName(cardName));
    }

    public void addCardToPlayerCardsAfterRemoveFromDeck(String cardName) {
        playerCards.add(Card.getCardByName(cardName));
    }

    public String getNickname() {
        return nickname;
    }

    public static void setLoggedPlayer(Player player) {
        loggedPlayer = player;
    }

    public static Player getLoggedPlayer() {
        return loggedPlayer;
    }

    public int numberOfSpecialCard(String cardName) {
        int num = 0;
        for (Card card : playerCards) {
            if (card.getCardName().equals(cardName))
                num++;
        }
        return num;
    }

    public int numberOfCardsInAndOutDecks(String cardName) {
        int num = numberOfSpecialCard(cardName);
        for (Deck deck : allDecks) {
            num += deck.numberOfSpecialCardInMainDeck(cardName);
            num += deck.numberOfSpecialCardInSideDeck(cardName);
        }
        return num;
    }

    public Image proImage() {
        Random random = new Random();
        int randomNum = random.nextInt(7);
        switch (randomNum) {
            case 1: {
                return new Image("/profileImage/1.png");
            }
            case 2: {
                return new Image("/profileImage/2.png");
            }
            case 3: {
                return new Image("/profileImage/3.png");
            }
            case 4: {
                return new Image("/profileImage/4.png");
            }
            case 5: {
                return new Image("/profileImage/5.png");
            }
            case 6: {
                return new Image("/profileImage/6.png");
            }
        }
        return new Image("/profileImage/6.png");
    }

    public Image getImage(){
        return this.image;
    }

    public static Player getGraveYard() {
        return graveYard;
    }

    public static void setGraveYard(Player graveYard) {
        Player.graveYard = graveYard;
    }
}

