package logging;

public class ConsoleLogger {

    public void writeLog(String message) {
        System.out.println("Info: " + message);
    }

    public void writeError(String message, Exception e) {
        System.err.println("Error: " + message + ";" + e);
    }
}
