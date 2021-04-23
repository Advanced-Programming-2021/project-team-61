import java.util.ArrayList;

public class Player {

    private static ArrayList<Player> allPlayers = new ArrayList<>();
    private String username;
    private String nickname;
    private String password;
    private int score;
    private int coin;

    public Player(String username, String nickname, String password){
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        allPlayers.add(this);
    }
    public static Player getPlayerByUsername(String username){
        for (Player allPlayer : allPlayers) {
            if (allPlayer.username.equals(username))
                return allPlayer;
        }
        return null;
    }
    public static boolean isUserNameExists(String username){

        return Player.getPlayerByUsername(username) != null;
    }
    public static boolean isNickNameExists(String nickname){
        for (Player allPlayer : allPlayers) {
            if (allPlayer.nickname.equals(nickname))
            return true;

        }
        return false;
    }
    public static ArrayList<Player> getAllPlayers(){
        return allPlayers;
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

    public static int getScoreByNickname(String nickname){
        for (Player player:allPlayers) {
            if (player.nickname.equals(nickname))
                return player.score;
        }
        return 0;
    }

    public static ArrayList<String> getAllNickNames(){
        ArrayList<String> allNickName = new ArrayList<>();
        for (Player player:allPlayers) {
            allNickName.add(player.nickname);
        }
        return allNickName;
    }
}