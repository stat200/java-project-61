package hexlet.code.activities.games;

import hexlet.code.Cli;
import hexlet.code.activities.Actions;
import hexlet.code.activities.Helpers;

public class Gcd extends Actions {
    private final int questionsCounter = 3;
    private final String[] messages = {
        "Find the greatest common divisor of given numbers.",
        "Question:",
        "Your answer:",
        "Correct!",
        "%s is wrong answer ;(. Correct answer was %s.\nLet's try again, %s!",
        "Congratulations, %s!"
    };

    public Gcd(Cli cli) {
        super(cli);
    }

    private int correctAnswer(int number1, int number2) {
        if (number1 == 0) {
            return number2;
        }

        if (number2 == 0) {
            return number1;
        }

        int n;
        for (n = 0; ((number1 | number2) & 1) == 0; n++) {
            number1 >>= 1;
            number2 >>= 1;
        }

        while ((number1 & 1) == 0) {
            number1 >>= 1;
        }

        do {
            while ((number2 & 1) == 0) {
                number2 >>= 1;
            }

            if (number1 > number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            number2 = (number2 - number1);
        } while (number2 != 0);
        return number1 << n;
    }

    public void game() {
        this.cli.dialog(messages[0], true);
        var answer = "";
        var correctAnswersCounter = 0;
        for (var i = 0; i < questionsCounter; i++) {
            var number1 = Helpers.randomHelper();
            var number2 = Helpers.randomHelper();
            var correctAnswer = this.correctAnswer(number1, number2);
            answer = this.cli.dialog(messages[1] + Integer.toString(number1) + " "
                    + Integer.toString(number2) + "\n" + messages[2]);
            if (Integer.parseInt(answer) == correctAnswer) {
                this.cli.dialog(messages[3], true);
                correctAnswersCounter++;
                continue;
            } else {
                this.cli.dialog(String.format(messages[4], answer, correctAnswer, super.name), true);
                break;
            }
        }
        if (correctAnswersCounter == questionsCounter) {
            this.cli.dialog(String.format(messages[5], super.name), true);
        }
    }
}
