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
    //private ImageView[] images;
    private static int i = 1;


    @FXML
    private ImageView im1;

    @FXML
    private ImageView im2;

    @FXML
    private ImageView im3;

    @FXML
    private ImageView im4;

    @FXML
    private ImageView im5;

    @FXML
    private ImageView im6;

    @FXML
    private ImageView im7;

    @FXML
    private ImageView im8;

    @FXML
    private ImageView im9;

    @FXML
    private ImageView im10;

    @FXML
    private ImageView im11;

    @FXML
    private ImageView im12;

    @FXML
    private ImageView im13;

    @FXML
    private ImageView im14;

    @FXML
    private ImageView image;

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

    @FXML
    private Button showNextFieldGame;

    @FXML
    private Button showPreviousFieldGame;

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
        //images = new ImageView[14];
        image.setImage(im1.getImage());
        /*images[0].setImage(im1.getImage());
        images[1].setImage(im2.getImage());
        images[2].setImage(im3.getImage());
        images[3].setImage(im4.getImage());
        images[4].setImage(im5.getImage());
        images[5].setImage(im6.getImage());
        images[6].setImage(im7.getImage());
        images[7].setImage(im8.getImage());
        images[8].setImage(im9.getImage());
        images[9].setImage(im10.getImage());
        images[10].setImage(im11.getImage());
        images[11].setImage(im12.getImage());
        images[12].setImage(im13.getImage());
        images[13].setImage(im14.getImage());
*/
    }

    public void showNextFieldGame() {
        i = i + 1;
        if(i > 14){
            i = 1;
        }
        se(i);
    }

    public void showPreviousFieldGame() {
        i = i - 1;
        if(i < 1){
            i = 14;
        }
        se(i);
    }

    public void se(int i){
        switch (i){
            case 1:{
                image.setImage(im1.getImage());
            }
            case 2:{
                image.setImage(im2.getImage());
            }
            case 3:{
                image.setImage(im3.getImage());
            }
            case 4:{
                image.setImage(im4.getImage());
            }
            case 5:{
                image.setImage(im5.getImage());
            }
            case 6:{
                image.setImage(im6.getImage());
            }
            case 7:{
                image.setImage(im7.getImage());
            }
            case 8:{
                image.setImage(im8.getImage());
            }
            case 9:{
                image.setImage(im9.getImage());
            }
            case 10:{
                image.setImage(im10.getImage());
            }
            case 11:{
                image.setImage(im11.getImage());
            }
            case 12:{
                image.setImage(im12.getImage());
            }
            case 13:{
                image.setImage(im13.getImage());
            }
            case 14:{
                image.setImage(im14.getImage());
            }
        }
    }


}
