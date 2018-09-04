package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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

        if((A == B)&&(B == C))
            System.out.println(A + " " + B + " " + C);

        else if (A == B) System.out.println(A + " " + B);
        else if (A == C)
            System.out.println(A + " " + C);
        else if (B == C)
            System.out.println(B + " " + C);

    }
}