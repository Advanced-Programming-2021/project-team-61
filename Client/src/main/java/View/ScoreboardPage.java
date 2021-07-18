package View;

import Model.Player;
import Controller.AppController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Controller.ScoreBoardMenu;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScoreboardPage implements Initializable {


    @FXML
    private AnchorPane all;

    @FXML
    private Button back;

    @FXML
    private Text te;

    @FXML
    private Button refresh;

    public void back() throws IOException {
      //  StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    public void refresh(){
        ArrayList<String> names = AppController.getServerOutput("5.nickname").split("#");
        ArrayList<String> scores = AppController.getServerOutput("5.score").split("#");
        ArrayList<String> online = AppController.getServerOutput("5.online").split("#");
        setTexts(names,scores,online);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //List[] name = AppController.getServerOutput("5.nickname").split("#");
        ArrayList<String> names = AppController.getServerOutput("5.nickname").split("#");
        //List[] score = AppController.getServerOutput("5.score").split("#");
        ArrayList<String> scores = AppController.getServerOutput("5.score").split("#");
        //List[] online = AppController.getServerOutput("5.online").split("#");
        ArrayList<String> online = AppController.getServerOutput("5.online").split("#");
        //ScoreBoardMenu.getInstance().sortByNickname();
        //ScoreBoardMenu.getInstance().sortByScore();
        setTexts(names,scores,online);
    }

    public void setTexts(ArrayList<String> names, ArrayList<String> scores, ArrayList<String> online) {
        int rank = 1;
        int j=1;
        for (int i = 0; i < names.size(); i++) {
            String string = "";
            if (online.contains(names.get(i))) {
                string = rank + " : " + "nickName : " + names.get(i) + " Score: " + scores.get(i) + " online";
            }else {
                string = rank + " : " + "nickName : " + names.get(i) + " Score: " + scores.get(i) + " offline";
            }
            Text text = new Text(350,50*(j),string);
            text.setFont(Font.font("Eras Light ITC", 25));
            text.setFill(Color.BLACK);
            //if (names.get(i).equals(Player.getLoggedPlayer().getNickname()))
            //    text.setFill(Color.RED);
            all.getChildren().add(text);
            if (i < names.size() - 1 && Integer.parseInt(scores.get(i)) != Integer.parseInt(scores.get(i+1)));
                rank++;
            j++;
        }
    }
}
