package hexlet.code;

import hexlet.code.activities.Actions;
import hexlet.code.activities.games.Calc;
import hexlet.code.activities.games.Even;
import hexlet.code.activities.games.exceptions.InvalidOptionException;

public class App {

    public static void main(String[] args) {
        var cli = new Cli();
        var actions = new Actions(cli);
        var choice = actions.start();
        switch (Integer.parseInt(choice)) {
            case (0) -> actions.exit();
            case (1) -> actions.greeting();
            case (2) -> {
                try {
                    var game = new Even(cli);
                    game.greeting();
                    game.game();
                } catch (NumberFormatException nfe) {
                    cli.errorMessage("NumberFormatException: " + nfe.getMessage());
                } catch (InvalidOptionException e) {
                    cli.errorMessage("InvalidOptionExcept: " + e.getMessage());
                }
            }
            case (3) -> {
                try {
                    var game = new Calc(cli);
                    game.greeting();
                    game.game();
                } catch (NumberFormatException nfe) {
                    cli.errorMessage("NumberFormatException: " + nfe.getMessage());
                }
            }
            default ->
                // TODO: 17.06.2023
                    cli.errorMessage("out of range");
        }
    }
}
