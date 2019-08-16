package com.foundation.trello.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class reads the config.properties file.
 *
 * @author Andres Burgos
 */
public final class ReadConfiguration {
    private static ReadConfiguration readConfiguration;
    private Properties properties;
    private InputStream inputProperties;

    /**
     * This is constructor for init variables.
     */
    private ReadConfiguration() {
        properties = readConfigurationFile();
    }

    /**
     * @return the values the key.
     */
    private Properties readConfigurationFile() {

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
        return properties;
    }

    /**
     * @return an instance.
     */
    public static ReadConfiguration getInstance() {
        if (readConfiguration == null) {
            readConfiguration = new ReadConfiguration();
        }
        return readConfiguration;
    }

    /**
     * @return properties.
     */
    public Properties getProperties() {
        return properties;
    }
    /**
     * @return consumerKey.
     */
    public String getConsumerKey() {
        return properties.getProperty("consumerKey");
    }

    /**
     * @return consumerSecret.
     */
    public String getConsumerSecret() {
        return properties.getProperty("consumerSecret");
    }

    /**
     * @return accessToken.
     */
    public String getAccessToken() {
        return properties.getProperty("accessToken");
    }

    /**
     * @return tokenSecret.
     */
    public String getTokenSecret() {
        return properties.getProperty("tokenSecret");
    }

    /**
     * @return urlBase.
     */
    public String getUrlBase() {
        return properties.getProperty("urlBase");
    }
}
