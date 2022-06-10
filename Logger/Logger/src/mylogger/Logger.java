package mylogger;

public class Logger {

    private final Appender appender;

    public Logger(Appender appender) {
        this.appender = appender;
    }

    public void log(String message) {
        final String prefix = "Prefix: "; // komplex ermittelt
       appender.write(prefix + message);
    }


}
