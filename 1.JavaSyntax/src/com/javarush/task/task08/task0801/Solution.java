package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> foods = new HashSet<>();
        foods.add("арбуз");
        foods.add("банан");
        foods.add("вишня");
        foods.add("груша");
        foods.add("дыня");
        foods.add("ежевика");
        foods.add("женьшень");
        foods.add("земляника");
        foods.add("ирис");
        foods.add("картофель");

        for (String i:foods
             ) {
            System.out.println(i);
        }

    }
}
