package Model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<String[]> MonsterCardsInformation = new ArrayList<>();
    private static List<String[]> SpellAndTrapInformation = new ArrayList<>();

    public static void readDataLineByLine(String monsterFile, String spellAndTrapFile) {
        try {
            FileReader fileReader = new FileReader(monsterFile);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            MonsterCardsInformation = csvReader.readAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(spellAndTrapFile);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            SpellAndTrapInformation = csvReader.readAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        makeObject();

    }
    public static void makeObject(){
        for(String[]row : MonsterCardsInformation){
            new MonsterCard(row[0],Integer.parseInt(row[1]),row[2],row[3],row[4],Integer.parseInt(row[5]),Integer.parseInt(row[6]),row[7],Integer.parseInt(row[8]));
        }
        for(String[]row: SpellAndTrapInformation){
            if(row[1].equals("Trap"))
                new TrapCard(row[0],row[2],row[3],row[4],Integer.parseInt(row[5]));
            else
                new SpellCard(row[0],row[2],row[3],row[4],Integer.parseInt(row[5]));
        }
    }

    public static List<String[]> getMonsterCardsInformation() {
        return MonsterCardsInformation;
    }
}
