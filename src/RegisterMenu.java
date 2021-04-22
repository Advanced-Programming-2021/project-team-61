import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMenu {
    private static RegisterMenu r = null;
    private String command;
    private RegisterView view;


    private RegisterMenu(RegisterView view) {
        this.view = view;
    }

    public static RegisterMenu getInstance() {
        if (r == null) {
            RegisterView view = RegisterView.getInstance();
            r = new RegisterMenu(view);
        }
        return r;
    }

    public void run() {
        while (true) {
            int changed = 0;
            command = view.scan();
            if (command.startsWith("user create ")) {
                changed = 1;
                String regex = "user create --username ([^\\s]+) --nickname ([^\\s]+) --password ([^\\s]+)";
                Matcher matcher = getCommandMatcher(command, regex);
                if (matcher.find()) {
                    view.printMessage(RegisterView.Commands.SUCCESSFULL, "nothing");
                }


            }
            if (command.equals("menu exit") && changed == 0) {
                break;
            }
            if (changed == 0)
                view.printMessage(RegisterView.Commands.INVALID, "");
        }


    }

    private Matcher getCommandMatcher(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        return p.matcher(input);

    }
}
