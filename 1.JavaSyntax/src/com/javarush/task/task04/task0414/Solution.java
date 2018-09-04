package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        int Number = Integer.parseInt(number);

        //if (((Number % 4) == 0) && (((Number % 100) == 0) && ((Number % 400) == 0)) )
            //System.out.println("количество дней в году: 366");
        if ((((Number % 100) == 0) && ((Number % 400) == 0)))
            System.out.println("количество дней в году: 366");
        if (((Number % 4) == 0) && ((Number % 100) > 0))
            System.out.println("количество дней в году: 366");
        if (((Number % 4) > 0) && ((Number % 100) > 0))
            System.out.println("количество дней в году: 365");
        if ((((Number % 100) == 0) && ((Number % 400) > 0)))
            System.out.println("количество дней в году: 365");
        //else
            //System.out.println("количество дней в году: 365");
    }
}