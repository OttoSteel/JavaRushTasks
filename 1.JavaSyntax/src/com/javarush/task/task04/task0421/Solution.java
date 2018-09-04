package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int A = a.length();
        String b = reader.readLine();
        int B = b.length();

        if (a.equals(b))
            System.out.println("Имена идентичны");
        else if (A == B)
            System.out.println("Длины имен равны");

    }
}
