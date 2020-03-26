package kimia.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    
    public static void i (String TAG, String log){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + " | " + TAG +" - "+ log);
    }

    public static void e (String TAG, String error){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"); 
        LocalDateTime now = LocalDateTime.now();
        System.err.println(dtf.format(now) + " | " + TAG + " - " + error);
    }
}