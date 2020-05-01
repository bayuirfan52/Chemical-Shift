package kimia.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import kimia.ui.Main;

/**
 * Class for logging like on Android
 * This feature will use if CONFIG in Main class is Constant.DEBUG
 * @author BAYU IRFAN
 * @version 1.0
 */
public class Log {
    private static DateTimeFormatter dtf = dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");;
    private static LocalDateTime now = now = LocalDateTime.now();;

    /**
     * This log use to information logging
     * @param TAG format String
     * @param log format String
     */
    public static void i(String TAG, String log) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.out.println(WHITE + ANSI_YELLOW_BACKGROUND + dtf.format(now) + " | " + TAG + " - " + log + ANSI_RESET);
        }
    }

    /**
     * This log use to error logging
     * @param TAG format String
     * @param error format String
     */
    public static void e(String TAG, String error) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.err.println(dtf.format(now) + " | " + TAG + " - " + error);
        }
    }

    /**
     * This log use to debug logging
     * @param TAG format String
     * @param value format String
     */
    public static void d(String TAG, String value) {
        if (Main.CONFIG == Constant.DEBUG) {
            System.out.println(dtf.format(now) + " | " + TAG + " - " + value);
        }
    }

    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String WHITE = "\033[0;37m";
}
