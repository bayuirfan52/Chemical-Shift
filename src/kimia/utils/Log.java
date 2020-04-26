package kimia.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import kimia.ui.Main;

public class Log {
    private static DateTimeFormatter dtf = dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");;
    private static LocalDateTime now = now = LocalDateTime.now();;

    public static void i(String TAG, String log) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.out.println(ANSI_YELLOW_BACKGROUND + dtf.format(now) + " | " + TAG + " - " + log + ANSI_RESET);
        }
    }

    public static void e(String TAG, String error) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.err.println(dtf.format(now) + " | " + TAG + " - " + error);
        }
    }

    public static void d(String TAG, String error) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.out.println(dtf.format(now) + " | " + TAG + " - " + error);
        }
    }

    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_RESET = "\u001B[0m";
}
