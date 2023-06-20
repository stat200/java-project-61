package hexlet.code;

import java.util.Scanner;

public class Cli {
    private Scanner input;

    Cli() {
        this.input = new Scanner(System.in);
    }

    public String dialog(String message, boolean isFinish) {
        System.out.println(message);
        if (!isFinish) {
            return this.input.nextLine();
        }
        return "";
    }

    public void exit() {
        System.exit(0);
    }

    public String dialog(String message) {
        return this.dialog(message, false);
    }

    public void errorMessage(String message) {
        System.out.println(message);
    }
}
