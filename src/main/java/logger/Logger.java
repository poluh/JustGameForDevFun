package logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Class classType;
    private List<String> allLogInfo;

    public Logger(Class classType) {
        allLogInfo = new ArrayList<>();
        this.classType = classType;
    }

    public enum LogType {
        FINE,
        NORMAL,
        MESSAGE,
        ERROR
    }

    public void log(String message) {
        log(message, LogType.NORMAL);
    }

    public void log(String message, LogType logType) {
        var normalLog = createLog(message, logType);
        if (logType == LogType.ERROR) {
            System.err.println(normalLog);
        } else {
            System.out.println(normalLog);
        }
        allLogInfo.add(normalLog);
    }

    public void toFile(String path) throws IOException {
        Files.write(Paths.get(path), allLogInfo);
    }

    private String createLog(String message, LogType logType) {
        var time = LocalTime.now().toString().split("\\.")[0];
        return classType + " :: " + time + " :: " + logType + " :: " + message;
    }

}
