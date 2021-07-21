package View;

import Controller.AppController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
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
        ref();
    }

    private void ref() {
        String[] name = AppController.getServerOutput("5.nickname").split("#");
        String[] score = AppController.getServerOutput("5.score").split("%");
        String[] online = AppController.getServerOutput("5.online").split("#");
        ArrayList<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(name));
        ArrayList<String> scores = new ArrayList<>();
        scores.addAll(Arrays.asList(score));
        ArrayList<String> onlines = new ArrayList<>();
        onlines.addAll(Arrays.asList(online));
        setTexts(names,scores,onlines);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ref();
    }

    public void setTexts(ArrayList<String> names, ArrayList<String> scores, ArrayList<String> onlines) {
        System.out.println(names);
        System.out.println(scores);
        System.out.println(onlines);
        int rank = 1;
        int j=1;
        for (int i = 0; i < names.size(); i++) {
            String string = "";
            if (onlines.contains(names.get(i))) {
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
