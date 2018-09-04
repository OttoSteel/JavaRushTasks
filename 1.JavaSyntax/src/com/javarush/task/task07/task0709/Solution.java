package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        String temp = strings.get(0);

        for (int i = 1; i < 5 ; i++) {
            if (strings.get(i).length() < temp.length())
                temp = strings.get(i);
        }

        for (String i:strings
                ) {
            if (i.length() == temp.length())
                System.out.println(i);
        }
    }
}
