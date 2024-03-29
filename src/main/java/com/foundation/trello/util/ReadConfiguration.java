package com.foundation.trello.util;

import java.io.FileInputStream;
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
     *This method reads the file 'config.properties' and returns its values through the object 'properties'.
     *
     * @return an object 'properties' with which you can get data from "config.properties".
     */
    private Properties readConfigurationFile() {
        try {
            inputProperties = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(inputProperties);
        } catch (Exception e) {
            try {
                inputProperties.close();
            } catch (Exception ex) {
                Log.getInstance().getLog().error("Ops! this don't work", ex);
            }
            Log.getInstance().getLog().error("Ops! bad work", e);
        }
        return properties;
    }

    /**
     * This method ensures that only one instance is created according
     * to the builder pattern.
     *
     * @return an instance of "ReadConfiguration" type.
     */
    public static ReadConfiguration getInstance() {
        if (readConfiguration == null) {
            readConfiguration = new ReadConfiguration();
        }
        return readConfiguration;
    }

    /**
     * Gives the properties read from config.properties file.
     *
     * @return properties.
     */
    public Properties getProperties() {
        return properties;
    }
    /**
     * Gives the consumerKey property read from config.properties file.
     *
     * @return consumerKey.
     */
    public String getConsumerKey() {
        return properties.getProperty("consumerKey");
    }

    /**
     * Gives the consumerKey property read from config.properties file.
     *
     * @return consumerSecret.
     */
    public String getConsumerSecret() {
        return properties.getProperty("consumerSecret");
    }

    /**
     * Gives the accessToken property read from config.properties file.
     *
     * @return accessToken.
     */
    public String getAccessToken() {
        return properties.getProperty("accessToken");
    }

    /**
     * Gives the tokenSecret property read from config.properties file.
     *
     * @return tokenSecret.
     */
    public String getTokenSecret() {
        return properties.getProperty("tokenSecret");
    }

    /**
     * Gives the urlBase property read from config.properties file.
     *
     * @return urlBase.
     */
    public String getUrlBase() {
        return properties.getProperty("urlBase");
    }
}
