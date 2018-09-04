package com.javarush.task.task04.task0428;

/* 
Положительное число
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

        int count = 0;

        if (a > 0)
            count += 1;
        if (b > 0)
            count += 1;
        if (c > 0)
            count += 1;

        System.out.println(count);

    }
}
