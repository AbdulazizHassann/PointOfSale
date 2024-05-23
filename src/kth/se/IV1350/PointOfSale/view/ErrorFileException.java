package kth.se.IV1350.PointOfSale.view;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * ErrorFileException class creates a log file for all exceptions that occur during sale.
 */
public class ErrorFileException {
private static PrintWriter logFileExc ;

    /**
     * this class creates ErrorFile when an exceptions is caught.
     */
    public ErrorFileException(){
    try{
        logFileExc = new PrintWriter ( new FileWriter ( "ErrorExceptionsFile.txt", true), true);
    }catch (IOException exc){
        System.out.println(" could not write to file");
        exc.printStackTrace();
    }
}

    /**
     * Logs the details of an exception to a file.
     *
     * @param exc The exception to be logged.
     */

    public static void logError(Exception exc) {
        StringBuilder sbError = new StringBuilder();
        sbError.append("-------------------------------------------\n");
        sbError.append("Exception: ").append(exc.toString()).append("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(formatter);
        sbError.append("Occurred at: ").append(formattedDateTime).append("\n");
        sbError.append("Stacktrace:\n");
        for (StackTraceElement element : exc.getStackTrace()) {
            sbError.append(element.toString()).append("\n");
        }
        sbError.append("-------------------------------------------\n");
        logFileExc.println(sbError.toString());
    }
}
