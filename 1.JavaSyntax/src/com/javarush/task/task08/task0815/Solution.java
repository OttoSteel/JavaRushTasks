package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("One", "First");
        map.put("Two", "Second");
        map.put("Three", "Third");
        map.put("Four", "First");
        map.put("Five", "Bad");
        map.put("Six", "Second");
        map.put("Seven", "wtf");
        map.put("Eight", "fwt");
        map.put("Nine", "twf");
        map.put("Ten", "Second");
        return (HashMap<String, String>) map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String s:map.values()
             ) {
            if (s.equals(name))
                count++;
        }
        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String s:map.keySet()
             ) {
            if (s.equals(lastName))
                count++;
        }
        return count;

    }

    public static void main(String[] args) {
    }
}
