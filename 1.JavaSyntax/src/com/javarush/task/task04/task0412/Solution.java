package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        int Number = Integer.parseInt(number);

        if (Number > 0)
            System.out.println(Number * 2);
        if (Number < 0)
            System.out.println(Number + 1);
        if (Number == 0)
            System.out.println(0);


    }

}