package Controller;

import Model.Player;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBoardController {
    //first we run bubbleSort on nickNames;after that we run bubble sort on scores;
    private static ScoreBoardController s = null;
    private ArrayList<String> allPlayerNickName ;
    private ScoreBoardController() {
    }

    public static ScoreBoardController getInstance() {
        if (s == null)
            s = new ScoreBoardController();
        return s;
    }

    public void sortByNickname(){
        allPlayerNickName = Player.getAllNickNames();
        allPlayerNickName.remove("AI");
        Collections.sort(allPlayerNickName);
    }

    public void sortByScore(){
        int n = allPlayerNickName.size();
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){
                if (Player.getScoreByNickname(allPlayerNickName.get(j)) < Player.getScoreByNickname(allPlayerNickName.get(j+1))){
                    Collections.swap(allPlayerNickName , j , j+1);
                }
            }
        }
    }


    public String getNick(){
        StringBuilder s = new StringBuilder();
        System.out.println(allPlayerNickName);//
        for (String st:allPlayerNickName) {
            s.append(st + '#');
        }
        return s.toString();
    }

    public String getScore(){
        StringBuilder p = new StringBuilder();
        System.out.println(allPlayerNickName);//
        for (String st:allPlayerNickName) {
            p.append(Player.getScoreByNickname(st) + "%");
        }
        System.out.println(p.toString());//
        return p.toString();
    }

    public String checkCommand(String command){
        forTest();
        sortByNickname();
        sortByScore();
        switch (command) {
            case "5.nickname":
                return getNick();
            case "5.score":
                return getScore();
            case "5.online":
                return Player.getLoggedPlayers();
            default:
                return "invalid";
        }
    }

    public void forTest(){
        new Player("ahmad","ahmad","ahmad").setScore(200);
        new Player("sara","sara","sara").setScore(150);
        new Player("mmd","mmd","mmd").setScore(100);
        new Player("reza","reza","reza").setScore(220);
        new Player("ali","ali","ali").setScore(80);
        //Player.getPlayerByUsername("ahmad").setScore(200);
        //Player.getPlayerByUsername("mmd").setScore(100);
        //Player.getPlayerByUsername("sara").setScore(150);
        //Player.getPlayerByUsername("ali").setScore(80);
        //Player.getPlayerByUsername("reza").setScore(220);

    }
}
