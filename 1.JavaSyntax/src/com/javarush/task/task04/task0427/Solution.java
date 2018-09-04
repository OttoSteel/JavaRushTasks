package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        int a = Integer.parseInt(A);
        int b = A.length();

        if ((1 <= a) && (a <= 999)){
            if ((a % 2) > 0){
                if (b == 1)
                    System.out.println("нечетное однозначное число");
                else if (b == 2)
                    System.out.println("нечетное двузначное число");
                else if (b == 3)
                    System.out.println("нечетное трехзначное число");
            }
            else {
                if (b == 1)
                    System.out.println("четное однозначное число");
                else if (b == 2)
                    System.out.println("четное двузначное число");
                else if (b == 3)
                    System.out.println("четное трехзначное число");

            }
        }

    }
}
