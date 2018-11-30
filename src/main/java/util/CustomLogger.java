package util;

public class CustomLogger {

    public static void logIntoConsoleInfo(CharSequence charSequence) {
        System.out.println("*****************************************************");
        System.out.println(charSequence);
        System.out.println("\n");
    }

    public static void logIntoConsoleError(CharSequence charSequence) {
        System.out.println("*****************************************************");
        System.err.println(charSequence);
        System.out.println("\n");
    }
}
