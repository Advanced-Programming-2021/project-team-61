import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select {
    private Player player;
    private Player rivalPlayer;
    Location location;
    enum Location{
        MONSTER,
        MONSTEROPPONENT,
        SPELL,
        SPELLOPPONENT,
        FIELD,
        FIELDOPPONENT,
        HAND
    }

    public void run(Player my, Player rival, String command){
        player = my;
        rivalPlayer = rival;
        Matcher matcher;
        if ((getCommandMatcher(command,"select -d")).find()){
            deSelect();
            //*setLocation(null);
        }else if ((matcher = getCommandMatcher(command,"select --monster --opponent (\\d+)")).find()){
            monsterOpponent(matcher);
            //*setLocation(Location.MONSTEROPPONENT);
        }else if ((matcher = getCommandMatcher(command,"select --monster (\\d+)")).find()){
            monster(matcher);
            //*setLocation(Location.MONSTER);
        }else if ((matcher = getCommandMatcher(command,"select --spell --opponent (\\d+)")).find()){
            spellOpponent(matcher);
            //*setLocation(Location.SPELLOPPONENT);
        }else if ((matcher = getCommandMatcher(command,"select --spell (\\d+)")).find()){
            spell(matcher);
            //*setLocation(Location.SPELL);
        }else if ((getCommandMatcher(command,"select --field --opponent")).find()){
            //save information
            //*setLocation(Location.FIELDOPPONENT);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((getCommandMatcher(command,"select --field")).find()){
            //save information
            //*setLocation(Location.FIELD);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((matcher = getCommandMatcher(command,"select --hand (\\d+)")).find()){
            hand(matcher);
            //*setLocation(Location.HAND);
        }else {
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }

    }

    private void monsterOpponent(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(rivalPlayer).getMonsterCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void monster(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getMonsterCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void spellOpponent(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(rivalPlayer).getSpellTrapCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void spell(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getSpellTrapCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void hand(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>6){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getHand().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void deSelect() {
        if (getLocation().equals(null)) {/////
            GameView.getInstance().printMessage(GameView.Command.NOTCARDSELECTED);
        }else {
            //remove information
            GameView.getInstance().printMessage(GameView.Command.CARDDESELECTED);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
