package com.foundation.trello.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static String Log4JProperties = "src/main/resources/log4j.properties";

    private static Log instance = null;

    private static Logger log = Logger.getLogger(Log.class);

    private Log() {
        super();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
            PropertyConfigurator.configure(Log4JProperties);
            log.setLevel(Level.ALL);
        }
        return instance;
    }

    public org.apache.log4j.Logger getLog() {
        return log;
    }
}