package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
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

        String d = reader.readLine();

        int D = Integer.parseInt(d);

        int max1;
        int max2;

        if (A > B)
            max1 = A;
        else
            max1 = B;
        if (C > D)
            max2 = C;
        else
            max2 = D;
        if (max1 > max2)
            System.out.println(max1);
        else
            System.out.println(max2);


    }
}
