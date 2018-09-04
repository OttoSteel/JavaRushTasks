package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        int Number = Integer.parseInt(number);

        if(Number == 1)
            System.out.println("понедельник");
        if(Number == 2)
            System.out.println("вторник");
        if(Number == 3)
            System.out.println("среда");
        if(Number == 4)
            System.out.println("четверг");
        if(Number == 5)
            System.out.println("пятница");
        if(Number == 6)
            System.out.println("суббота");
        if(Number == 7)
            System.out.println("воскресенье");
        if (Number > 7 || Number < 1)
            System.out.println("такого дня недели не существует");

    }
}