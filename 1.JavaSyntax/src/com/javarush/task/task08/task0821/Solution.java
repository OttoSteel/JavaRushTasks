package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<>();
        map.put("One", "First");
        map.put("Two", "Second");
        map.put("One", "Third");
        map.put("Four", "First");
        map.put("Five", "Bad");
        map.put("Six", "Second");
        map.put("Four", "wtf");
        map.put("Eight", "fwt");
        map.put("Nine", "twf");
        map.put("Ten", "Second");
        return  map;

    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
