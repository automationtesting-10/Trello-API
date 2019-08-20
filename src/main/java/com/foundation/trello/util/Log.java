package com.foundation.trello.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * This class is used for testing 'ReadConfiguration' class.
 *
 * @author Maday Alcala Cuba.
 * @version 0.0.1
 */
public final class Log {
    private static final String LOG4J_PROPERTIES = "src/main/resources/log4j.properties";
    private static Log instance = null;
    private static Logger log = Logger.getLogger(Log.class);

    /**
     * Private constructor for the Singleton pattern.
     */
    private Log() {
        super();
    }

    /**
     * This method ensures that only one instance is created according
     * to the builder pattern and returns a log instance.
     *
     * @return an 'instance'.
     */
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
            PropertyConfigurator.configure(LOG4J_PROPERTIES);
            log.setLevel(Level.ALL);
        }
        return instance;
    }

    /**
     * This method returns a 'log' with which more loggers can be added.
     *
     * @return a 'log'.
     */
    public Logger getLog() {
        return log;
    }
}
