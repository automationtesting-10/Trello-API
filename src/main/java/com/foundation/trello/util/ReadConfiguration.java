package com.foundation.trello.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfiguration {
    private static ReadConfiguration readConfiguration;
    private static Properties properties;

    private ReadConfiguration() {
        properties = readConfigurationFile();
    }

    private Properties readConfigurationFile() {
        InputStream inputProperties;
        properties = new Properties();
        try {
            inputProperties = new FileInputStream("config.properties");
            properties.load(inputProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static ReadConfiguration getInstance() {
        if (readConfiguration == null) {
            readConfiguration = new ReadConfiguration();
        }
        return readConfiguration;
    }

    public String getConsumerKey(){
        return properties.getProperty("consumerKey");
    }

    public String getConsumerSecret (){
        return properties.getProperty("consumerSecret");
    }

    public String getAccessToken(){
        return properties.getProperty("accessToken");
    }

    public String getTokenSecret(){
        return properties.getProperty("tokenSecret");
    }

    public String getUrlBase(){
        return properties.getProperty("urlBase");
    }
}
