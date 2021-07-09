package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    public void back() throws IOException {
        StartPage.click.play();
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScoreBoardMenu.getInstance().sortByNickname();
        ScoreBoardMenu.getInstance().sortByScore();
        setTexts();
    }

    public void setTexts() {
        ArrayList<String> nickNames = ScoreBoardMenu.getInstance().getAllPlayerNickName();
        int rank = 1;
        int j=1;
        for (int i = 0; i < nickNames.size(); i++) {
            String string = rank + " : " + "nickName : " + nickNames.get(i)  + " Score: " + Player.getScoreByNickname(nickNames.get(i));
            Text text = new Text(350,50*(j),string);
            text.setFont(Font.font("Eras Light ITC", 25));
            text.setFill(Color.BLACK);
            if (nickNames.get(i).equals(Player.getLoggedPlayer().getNickname()))
                text.setFill(Color.RED);
            all.getChildren().add(text);
            if (i < nickNames.size() - 1 && Player.getScoreByNickname(nickNames.get(i)) != Player.getScoreByNickname(nickNames.get(i + 1)));
                rank++;
            j++;
        }
    }
}
