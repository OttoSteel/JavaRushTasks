package com.javarush.task.task04.task0424;

/* 
Три числа
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

        String C = reader.readLine();
        int c = Integer.parseInt(C);

        if (((a != b) && (a != c)) && (b == c))
            System.out.println("1");
        else if (((b != c) && (b != a)) && (a == c))
            System.out.println("2");
        else if (((c != b) && (a != c)) && (b == a))
            System.out.println("3");
    }
}
