package hexlet.code.activities;

import hexlet.code.Cli;

public class Actions {

    protected Cli cli;
    protected String name;

    public Actions(Cli cli) {
        this.cli = cli;
    }

    public void greeting() {
        String[] messages = {"Welcome to the Brain Games!\nMay I have your name?", "Hello, %s!\n"};
        this.name = this.cli.dialog(messages[0]);
        this.cli.dialog(String.format(messages[1], this.name), true);
    }
    public void exit() {
        this.cli.exit();
    }

    public String start() {
        String[] messages = {
            "Please enter the game number and press Enter.\n1 - Greet\n2 - Even\n0 - Exit\nYour choice: "
        };
        var answer = this.cli.dialog(messages[0]);
        this.cli.dialog("", true);
        return answer;
    }
}
