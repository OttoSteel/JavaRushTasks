package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String [] strings = s.split("\\s+");
        //String [] strings2 = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(""))
                continue;
            char [] strChar = strings[i].toCharArray(); //convert string to array
            char [] firstChar = new char[1]; //create mini-array of one char
            firstChar[0] = strChar[0];
            String mini = new String(firstChar); //convert mini-array to string
            String mini2 = mini.toUpperCase();
            char [] mini1 = mini2.toCharArray(); //convert mini to char array
            strChar[0] = mini1[0];
            String result = new String(strChar);
            //System.out.println(result);
            //strings[i] = result;
            s = s.replaceAll(strings[i], result);
        }


        System.out.println(s);

        //for (int i = 0; i < strings.length; i++) {
            //if (i == strings2.length - 1)
                //System.out.print(strings2[i]);
            //else
                //System.out.print(strings2[i] + " ");

        //}
    }
}
