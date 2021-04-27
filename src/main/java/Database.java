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

    }

    public static List<String[]> getMonsterCardsInformation() {

        return MonsterCardsInformation;
    }

    public static List<String[]> getSpellAndTrapInformation() {
        return SpellAndTrapInformation;
    }

}
