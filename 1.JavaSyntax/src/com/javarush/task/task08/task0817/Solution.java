package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> elem = iterator.next();
            int curSize = map.size();
            removeItemFromMapByValue(map, elem.getValue());
            if (curSize - map.size() == 1)
                map.put(elem.getKey(), elem.getValue());

        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        //removeTheFirstNameDuplicates(createMap());

    }
}
