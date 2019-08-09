package com.foundation.trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {
    @Test
    public void Prueba(){
        String hola = "Hello";
        Assert.assertEquals("Hello", hola);
    }

}
