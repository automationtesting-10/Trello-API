package com.foundation.trello.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfiguration {

    public String readConfigurationFile(String value) {
        InputStream inputProperties;
        Properties properties = new Properties();
        try {
            inputProperties = new FileInputStream("config.properties");
            properties.load(inputProperties);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(value);
    }
}
