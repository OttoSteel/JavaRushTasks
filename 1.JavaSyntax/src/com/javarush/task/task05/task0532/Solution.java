package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = n;

        int mass[] = new int[n];
        while (n > 0) {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            int x = Integer.parseInt(reader1.readLine());
            mass[n - 1] = x;
            n -= 1;
            //System.out.println(n);
        }


        int maximum = mass[0];

        for (int i = 1; i < m; i++) {
            if (mass[i] > maximum) maximum = mass[i];
            //System.out.println("step " + i +": " + maximum);
        }

        //напишите тут ваш код

        System.out.println(maximum);

    }
}
