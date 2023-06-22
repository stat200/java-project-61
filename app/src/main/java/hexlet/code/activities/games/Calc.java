package hexlet.code.activities.games;

import hexlet.code.Cli;
import hexlet.code.activities.Actions;
import hexlet.code.activities.Helpers;

public class Calc extends Actions {
    private final int questionsCounter = 3;
    private final String[] messages = {
        "What is the result of the expression?",
        "Question:",
        "Your answer:",
        "Correct!",
        "%s is wrong answer ;(. Correct answer was %s.\nLet's try again, %s!",
        "Congratulations, %s!"
    };

    private final String[] actions = {
        "+",
        "-",
        "*"
    };
    public Calc(Cli cli) {
        super(cli);
    }

    private String actionGenerator() {
        return actions[(int) (Math.random() * actions.length)];
    }

    private int correctAnswer(int number1, int number2, String action) {
        if (action.equals("+")) {
            return number1 + number2;
        } else if (action.equals("-")) {
            return number1 - number2;
        } else {
            return number1 * number2;
        }
    }

    public void game() {
        this.cli.dialog(messages[0], true);
        var answer = "";
        for (var i = 0; i < questionsCounter; i++) {
            var number1 = Helpers.randomHelper();
            var number2 = Helpers.randomHelper();
            var action = this.actionGenerator();
            var correctAnswer = this.correctAnswer(number1, number2, action);
            answer = this.cli.dialog(messages[1] + Integer.toString(number1) + action
                    + Integer.toString(number2) + "\n" + messages[2]);
            if (Integer.parseInt(answer) == correctAnswer) {
                this.cli.dialog(messages[3], true);
                continue;
            } else {
                this.cli.dialog(String.format(messages[4], answer, correctAnswer, super.name), true);
                break;
            }
        }
        this.cli.dialog(String.format(messages[5], super.name), true);
    }
}
