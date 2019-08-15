package com.foundation.trello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class read the config.properties file.
 *
 * @author Andres Burgos
 */
public class ReadConfiguration {
    private static final String CONFIG_FILE = "config.properties";
    /**
     * @param value The value parameter defines the key input.
     * @return the values the key.
     */
    public String readConfigurationFile(String value) throws IOException {
        Properties properties = new Properties();
        InputStream inputProperties = new FileInputStream(CONFIG_FILE);
        properties.load(inputProperties);
        inputProperties.close();
        return properties.getProperty(value);
    }
}
