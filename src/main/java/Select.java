import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select {
    private Player player;
    private Player rivalPlayer;
    private static Select s = null;
    Location location;
    private int position;//for field we set 10 -- for deselect we set 0
    enum Location{
        MONSTER,
        MONSTEROPPONENT,
        SPELL,
        SPELLOPPONENT,
        FIELD,
        FIELDOPPONENT,
        HAND
    }
    public static Select getInstance(){
        if(s==null)
            s = new Select();
        return s;
    }

    public void run(Player my, Player rival, String command){
        player = my;
        rivalPlayer = rival;
        Matcher matcher;
        if ((getCommandMatcher(command,"select -d")).find()){
            deSelect();
            setLocation(null);
        }else if ((matcher = getCommandMatcher(command,"select --monster --opponent (\\d+)")).find()){
            monsterOpponent(matcher);
            setLocation(Location.MONSTEROPPONENT);
        }else if ((matcher = getCommandMatcher(command,"select --monster (\\d+)")).find()){
            monster(matcher);
            setLocation(Location.MONSTER);
        }else if ((matcher = getCommandMatcher(command,"select --spell --opponent (\\d+)")).find()){
            spellOpponent(matcher);
            setLocation(Location.SPELLOPPONENT);
        }else if ((matcher = getCommandMatcher(command,"select --spell (\\d+)")).find()){
            spell(matcher);
            setLocation(Location.SPELL);
        }else if ((getCommandMatcher(command,"select --field --opponent")).find()){
            position = 10;
            setLocation(Location.FIELDOPPONENT);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((getCommandMatcher(command,"select --field")).find()){
            position = 10;
            setLocation(Location.FIELD);
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((matcher = getCommandMatcher(command,"select --hand (\\d+)")).find()){
            hand(matcher);
            setLocation(Location.HAND);
        }else {
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }

    }

    private void monsterOpponent(Matcher matcher){
        handleMonsterSelect(matcher, rivalPlayer);
    }

    private void monster(Matcher matcher){
        handleMonsterSelect(matcher, player);
    }

    private void handleMonsterSelect(Matcher matcher, Player player) {
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getMonsterCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            position = loc;
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void spellOpponent(Matcher matcher){
        handleSpellSelect(matcher, rivalPlayer);
    }

    private void handleSpellSelect(Matcher matcher, Player player) {
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>5){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getSpellTrapCardsInField().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            position = loc;
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void spell(Matcher matcher){
        handleSpellSelect(matcher, player);
    }

    private void hand(Matcher matcher){
        int loc = Integer.parseInt(matcher.group(1));
        if (loc>6){
            GameView.getInstance().printMessage(GameView.Command.INVALIDSELECTION);
        }else if (Board.getBoardByPlayer(player).getHand().size()<loc){
            GameView.getInstance().printMessage(GameView.Command.NOCARDFOUNDINGIVENPOSITION);
        }else {
            position = loc;
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }
    }

    private void deSelect() {
        if (getLocation()==null) {
            GameView.getInstance().printMessage(GameView.Command.NOTCARDSELECTED);
        }else {
            position = 0;
            GameView.getInstance().printMessage(GameView.Command.CARDDESELECTED);
        }
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public int getPosition() {
        return position;
    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
