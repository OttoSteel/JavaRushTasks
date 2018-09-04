package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        String temp = strings.get(0);

        for (int i = 1; i < 5 ; i++) {
            if (strings.get(i).length() > temp.length())
                temp = strings.get(i);
        }

        for (String i:strings
             ) {
            if (i.length() == temp.length())
                System.out.println(i);
        }

    }
}
