package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        String tempMin = strings.get(0);
        String tempMax = strings.get(0);

        for (int i = 1; i < 10 ; i++) {
            if (strings.get(i).length() < tempMin.length())
                tempMin = strings.get(i);
        }

        for (int i = 1; i < 10 ; i++) {
            if (strings.get(i).length() > tempMax.length())
                tempMax = strings.get(i);
        }

        if (strings.indexOf(tempMin) < strings.indexOf(tempMax))
            System.out.println(tempMin);
        else
            System.out.println(tempMax);

    }
}
