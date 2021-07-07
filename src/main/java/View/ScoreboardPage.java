package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Controller.ScoreBoardMenu;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ScoreboardPage implements Initializable {

    @FXML
    private TextArea list;

    @FXML
    private Button back;

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/mainMenuPage.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ScoreBoardMenu.getInstance().sortByNickname();
        ScoreBoardMenu.getInstance().sortByScore();
        list.setText(ScoreBoardMenu.getInstance().printScoreBoard());
    }
}
