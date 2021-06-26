import Model.Database;
import View.RegisterView;

import java.io.File;


public class Main {
    public static void main(String[] args) {

        File f = new File("src\\main\\resources\\Monster.csv");
        String absolute = f.getAbsolutePath();
        File f2 = new File("src\\main\\resources\\SpellTrap.csv");
        String absolute2 = f2.getAbsolutePath();
        Database.readDataLineByLine(absolute, absolute2);
        Database.AISetup();

       RegisterView registerView = RegisterView.getInstance();
        registerView.scan();


    }


}