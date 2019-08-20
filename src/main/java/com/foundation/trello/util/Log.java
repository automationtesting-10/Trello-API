package com.foundation.trello.util;

import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

public class Log {

    private static final String LOG_4_J_PROPERTIES = "../Trello-API/src/main/resources/log4j.properties";

    private static Log instance = null;

    private final static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Log.class);

    private Log() {
        super();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
            PropertyConfigurator.configure(LOG_4_J_PROPERTIES);
            LOGGER.setLevel(Level.ALL);
        }
        return instance;
    }

    public org.apache.log4j.Logger getLog() {
        return LOGGER;
    }
}