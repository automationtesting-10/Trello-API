package com.foundation.trello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads the config.properties file.
 *
 * @author Andres Burgos
 */
public class ReadConfiguration {
    private InputStream inputProperties;
    private Properties properties = new Properties();

    /**
     * @param value The value parameter defines the key input.
     * @return the values the key.
     */
    public String readConfigurationFile(String value) {
        try {
            inputProperties = new FileInputStream("config.properties");
            properties.load(inputProperties);
        } catch (IOException e) {
            try {
                inputProperties.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties.getProperty(value);
    }
}
