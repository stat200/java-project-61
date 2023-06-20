package hexlet.code.activities;

public class Helpers {
    public static int randomHelper() {
        return (int) (Math.random() * 100);
    }

    public static boolean isValueInArray(String[] options, String answer) {
        for (var option: options) {
            if (answer.equals(option)) {
                return true;
            }
        }
        return false;
    }
}
