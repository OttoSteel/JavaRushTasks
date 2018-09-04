package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> foods = new HashMap<>();
        foods.put("арбуз", "ягода");
        foods.put("банан", "трава");
        foods.put("вишня", "ягода");
        foods.put("груша", "фрукт");
        foods.put("дыня", "овощ");
        foods.put("ежевика", "куст");
        foods.put("жень-шень", "корень");
        foods.put("земляника", "ягода");
        foods.put("ирис", "цветок");
        foods.put("картофель", "клубень");

        for (Map.Entry<String, String> pair : foods.entrySet()
             ) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
