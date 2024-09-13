package org.example;
import java.util.logging.Logger;

public class LoggerFactory {
    private static final Logger logger = Logger.getLogger(LoggerFactory.class.getName());

    public static void log(String message) {
        logger.info(message);
    }
}