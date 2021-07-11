package View;

import Model.Board;
import Model.Card;
import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.apache.commons.logging.Log;

import javax.naming.spi.InitialContextFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GraveyardPage implements Initializable {
    @FXML
    private ImageView pr;

    @FXML
    private ImageView g1;

    @FXML
    private ImageView g2;

    @FXML
    private ImageView g3;

    @FXML
    private ImageView g4;

    @FXML
    private ImageView g5;

    @FXML
    private ImageView g6;

    @FXML
    private ImageView g7;

    @FXML
    private ImageView g8;

    @FXML
    private ImageView g9;

    @FXML
    private ImageView g10;

    @FXML
    private ImageView g11;

    @FXML
    private ImageView g12;

    @FXML
    private ImageView g13;

    @FXML
    private ImageView g14;

    @FXML
    private ImageView g15;

    @FXML
    private ImageView g16;

    @FXML
    private ImageView g17;

    @FXML
    private ImageView g18;

    @FXML
    private ImageView g19;

    @FXML
    private ImageView g20;

    @FXML
    private Button back;

    public void back() throws IOException {
        Logic.viewManager.changeScene("/sample/gamePage.fxml");

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Card> graveYard = new ArrayList<>();
        graveYard = Board.getBoardByPlayer(Player.getGraveYard()).getGraveYard();
        for(int i = 0 ; i< graveYard.size(); i++){
            getImageViewByIndex(i).setImage(Card.getImageByCardName(graveYard.get(i).getCardName()));
        }
        for(int i = 19; i >= graveYard.size();i--){
            getImageViewByIndex(i).setImage(pr.getImage());
        }
     //   if (graveYard.get(0)!=null)
       //     g1.setImage(Card.getImageByCardName(graveYard.get(0).getCardName()));
      //  getImageViewByIndex(0);
      /*  else
            g1.setImage(pr.getImage());
        if (graveYard.get(1)!=null)
            g2.setImage(Card.getImageByCardName(graveYard.get(1).getCardName()));
        else
            g2.setImage(pr.getImage());
        if (graveYard.get(2)!=null)
            g3.setImage(Card.getImageByCardName(graveYard.get(2).getCardName()));
        else
            g3.setImage(pr.getImage());
        if (graveYard.get(3)!=null)
            g4.setImage(Card.getImageByCardName(graveYard.get(3).getCardName()));
        else
            g4.setImage(pr.getImage());
        if (graveYard.get(4)!=null)
            g5.setImage(Card.getImageByCardName(graveYard.get(4).getCardName()));
        else
            g5.setImage(pr.getImage());
        if (graveYard.get(5)!=null)
            g6.setImage(Card.getImageByCardName(graveYard.get(5).getCardName()));
        else
            g6.setImage(pr.getImage());
        if (graveYard.get(6)!=null)
            g7.setImage(Card.getImageByCardName(graveYard.get(6).getCardName()));
        else
            g7.setImage(pr.getImage());
        if (graveYard.get(7)!=null)
            g8.setImage(Card.getImageByCardName(graveYard.get(7).getCardName()));
        else
            g8.setImage(pr.getImage());
        if (graveYard.get(8)!=null)
            g9.setImage(Card.getImageByCardName(graveYard.get(8).getCardName()));
        else
            g9.setImage(pr.getImage());
        if (graveYard.get(9)!=null)
            g10.setImage(Card.getImageByCardName(graveYard.get(9).getCardName()));
        else
            g10.setImage(pr.getImage());
        if (graveYard.get(10)!=null)
            g11.setImage(Card.getImageByCardName(graveYard.get(10).getCardName()));
        else
            g11.setImage(pr.getImage());
        if (graveYard.get(11)!=null)
            g12.setImage(Card.getImageByCardName(graveYard.get(11).getCardName()));
        else
            g12.setImage(pr.getImage());
        if (graveYard.get(12)!=null)
            g13.setImage(Card.getImageByCardName(graveYard.get(12).getCardName()));
        else
            g13.setImage(pr.getImage());
        if (graveYard.get(13)!=null)
            g14.setImage(Card.getImageByCardName(graveYard.get(13).getCardName()));
        else
            g14.setImage(pr.getImage());
        if (graveYard.get(14)!=null)
            g15.setImage(Card.getImageByCardName(graveYard.get(14).getCardName()));
        else
            g15.setImage(pr.getImage());
        if (graveYard.get(15)!=null)
            g16.setImage(Card.getImageByCardName(graveYard.get(15).getCardName()));
        else
            g16.setImage(pr.getImage());
        if (graveYard.get(16)!=null)
            g17.setImage(Card.getImageByCardName(graveYard.get(16).getCardName()));
        else
            g17.setImage(pr.getImage());
        if (graveYard.get(17)!=null)
            g18.setImage(Card.getImageByCardName(graveYard.get(17).getCardName()));
        else
            g18.setImage(pr.getImage());
        if (graveYard.get(18)!=null)
            g19.setImage(Card.getImageByCardName(graveYard.get(18).getCardName()));
        else
            g19.setImage(pr.getImage());
        if (graveYard.get(19)!=null)
            g20.setImage(Card.getImageByCardName(graveYard.get(19).getCardName()));
        else
            g20.setImage(pr.getImage());*/
    }

    private ImageView getImageViewByIndex(int index) {
        switch (index){
            case 0 : {
                return g1;
            }
            case 1 : {
                return g2;
            }
            case 2 : {
                return g3;
            }
            case 3: {
                return g4;
            }
            case 4 : {
                return g5;
            }
            case 5 : {
                return g6;
            }
            case 6 : {
                return g7;
            }
            case 7 : {
                return g8;
            }
            case 8 : {
                return g9;
            }
            case 9 : {
                return g10;
            }
            case 10 : {
                return g11;
            }
            case 11 : {
                return g12;
            }
            case 12 : {
                return g13;
            }
            case 13 : {
                return g14;
            }
            case 14 : {
                return g15;
            }
            case 15 : {
                return g16;
            }
            case 16 : {
                return g17;
            }
            case 17 : {
                return g18;
            }
            case 18 : {
                return g19;
            }
            case 19 : {
                return g20;
            }
            default:break;
        }
        return null;
    }
}
