package hexlet.code.activities.games;

import hexlet.code.Cli;
import hexlet.code.activities.Actions;
import hexlet.code.activities.Helpers;
import hexlet.code.activities.games.exceptions.InvalidOptionException;

import static hexlet.code.activities.Helpers.isValueInArray;

public class Even extends Actions {
    private final int questionsCounter = 3;
    private final String[] listAnswers = {
        "yes",
        "no"
    };
    private final String[] messages = {
        "Answer 'yes' if the number is even, otherwise answer 'no'.",
        "Question:",
        "Your answer:",
        "Correct!",
        "%s is wrong answer ;(. Correct answer was %s.\nLet's try again, %s!",
    };
    public Even(Cli cli) {
        super(cli);
    }
    private boolean isAnswerCorrect(int randomNumber, String answer) {
        return answer.equals(listAnswers[0]) && this.isEven(randomNumber)
               || answer.equals(listAnswers[1]) && !this.isEven(randomNumber);
    }

    private String correctAnswer(String answer) {
        if (answer.equals(listAnswers[0])) {
            return listAnswers[1];
        }
        return listAnswers[0];
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    public void game() throws InvalidOptionException {
        this.cli.dialog(messages[0], true);
        var answer = "";
        for (var i = 0; i < questionsCounter; i++) {
            var randomNumber = Helpers.randomHelper();
            answer = this.cli.dialog(messages[1] + Integer.toString(randomNumber) + "\n" + messages[2]);
            if (!isValueInArray(listAnswers, answer)) {
                throw new InvalidOptionException("Selected option invalid. Please get choice 'yes' or 'no'");
            }
            if (isAnswerCorrect(randomNumber, answer)) {
                this.cli.dialog(messages[3], true);
                continue;
            } else {
                var correctAnswer = this.correctAnswer(answer);
                this.cli.dialog(String.format(messages[4], answer, correctAnswer, super.name), true);
                break;
            }
        }
    }
}
