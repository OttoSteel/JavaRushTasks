package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();

        int A = Integer.parseInt(a);

        String b = reader.readLine();

        int B = Integer.parseInt(b);

        String c = reader.readLine();

        int C = Integer.parseInt(c);

        if ((A + B) <= C)
            System.out.println("Треугольник не существует.");
        //else
           // System.out.println("Треугольник не существует.");
        else if ((B + C) <= A)
            System.out.println("Треугольник не существует.");
        //else
            //System.out.println("Треугольник не существует.");
        else if ((A + C) <= B)
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");
    }
}