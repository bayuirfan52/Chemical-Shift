package kimia.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    public static void i (String TAG, String log){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ANSI_YELLOW_BACKGROUND + dtf.format(now) + " | " + TAG +" - "+ log + ANSI_RESET);
    }

    public static void e (String TAG, String error){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"); 
        LocalDateTime now = LocalDateTime.now();
        System.err.println(dtf.format(now) + " | " + TAG + " - " + error);
    }
    
    public static void d (String TAG, String error){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"); 
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + " | " + TAG + " - " + error);
    }
    
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_RESET = "\u001B[0m";
}