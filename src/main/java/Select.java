import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Select {
    private Player player;
    private Player rivalPlayer;
    enum location{
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
        }else if ((matcher = getCommandMatcher(command,"select --monster --opponent (\\d+)")).find()){
            monsterOpponent(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --monster (\\d+)")).find()){
            monster(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --spell --opponent (\\d+)")).find()){
            spellOpponent(matcher);
        }else if ((matcher = getCommandMatcher(command,"select --spell (\\d+)")).find()){
            spell(matcher));
        }else if ((getCommandMatcher(command,"select --field --opponent")).find()){
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((getCommandMatcher(command,"select --field")).find()){
            //save information
            GameView.getInstance().printMessage(GameView.Command.CARDSELECTED);
        }else if ((matcher = getCommandMatcher(command,"select --hand (\\d+)")).find()){
            hand(matcher);
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
        if (/*check is card selected yet*/) {
            GameView.getInstance().printMessage(GameView.Command.NOTCARDSELECTED);
        }else {
            //remove information
            GameView.getInstance().printMessage(GameView.Command.CARDDESELECTED);
        }
    }


    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
