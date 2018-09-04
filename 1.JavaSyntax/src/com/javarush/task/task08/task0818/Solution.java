package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 500);
        map.put("Two", 600);
        map.put("Three", 700);
        map.put("Four", 200);
        map.put("Five", 300);
        map.put("Six", 1000);
        map.put("Seven", 600);
        map.put("Eight", 400);
        map.put("Nine", 500);
        map.put("Ten", 550);
        return (HashMap<String, Integer>) map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500)
                iterator.remove();
            //String key = pair.getKey();
            //Integer value = pair.getValue();
        }
        //System.out.println(map);

    }

    public static void main(String[] args) {
        //removeItemFromMap(createMap());

    }
}