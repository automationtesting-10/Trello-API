package com.foundation.trello;

import com.foundation.trello.util.Regex;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String endpoint = "{idBoard}/{idList}/{idCard}";
        Map<String, String> map = new HashMap<>();
        map.put("idBoard","Josue");
        System.out.println(Regex.getInstance().getString(endpoint,map));
    }
}
