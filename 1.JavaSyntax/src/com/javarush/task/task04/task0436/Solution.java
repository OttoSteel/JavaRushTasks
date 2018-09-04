package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        int a = Integer.parseInt(A);

        String B = reader.readLine();
        int b = Integer.parseInt(B);

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("8");
            }
            System.out.print("\n");

        }

    }
}
