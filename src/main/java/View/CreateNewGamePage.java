package View;

import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import Controller.DualMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateNewGamePage implements Initializable {
    private Image[] images = new Image[14];
    private static int i = 0;
    @FXML
    private ImageView fieldImages;

    @FXML
    private Text round;

    @FXML
    private Text numOfRound;

    @FXML
    private Button positive;

    @FXML
    private Button negative;

    @FXML
    private TextField username;

    @FXML
    private Button start;

    public void positive(){
        int num = Integer.parseInt(numOfRound.getText());
        num++;
        numOfRound.setText(String.valueOf(num));
    }

    public void negative(){
        int num = Integer.parseInt(numOfRound.getText());
        num--;
        numOfRound.setText(String.valueOf(num));
    }

    public void start(){
        DualMenu.getInstance().ProcessNewGame(Player.getLoggedPlayer().getUsername(),username.getText(),numOfRound.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        images[0] = new Image("resources/Images/fie_burn.bmp");
        images[1] = new Image("resources/Images/fie_dark.bmp");
        images[2] = new Image("resources/Images/fie_desert.bmp");
        images[3] = new Image("resources/Images/fie_fusion.bmp");
        images[4] = new Image("resources/Images/fie_gaia.bmp");
        images[5] = new Image("resources/Images/fie_mori.bmp");
        images[6] = new Image("resources/Images/fie_normal.bmp");
        images[7] = new Image("resources/Images/fie_sanctu.bmp");
        images[8] = new Image("resources/Images/fie_shine.bmp");
        images[9] = new Image("resources/Images/fie_sougen.bmp");
        images[10] = new Image("resources/Images/fie_umi.bmp");
        images[11] = new Image("resources/Images/fie_water.bmp");
        images[12] = new Image("resources/Images/fie_yama.bmp");
        images[13] = new Image("resources/Images/fie_yami.bmp");
    }

    public void showNextFieldGame(MouseEvent mouseEvent) {
        i = i + 1;
        if(i > 13){
            i = 14;
            fieldImages.setImage(null);
        }
        else{
            fieldImages.setImage(images[i]);
        }


    }

    public void showPreviousFieldGame(MouseEvent mouseEvent) {
        i = i - 1;
        if(i < 0){
            i = -1;
            fieldImages.setImage(null);
        }
        else{
            fieldImages.setImage(images[i]);
        }
    }
}
