package com.foundation.trello.model;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ReadConfigurationTest {

    @Test
    public static void readConfigurationFile(){
        ReadConfiguration reader = new ReadConfiguration();
        String actual = reader.readConfigurationFile("consumerKey");
        String expected = "6604dbb9605356df919ad8f9dd4c960d";
        Assert.assertEquals(actual,expected);
    }

}