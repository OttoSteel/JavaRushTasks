package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double i = 0.0;
        int count = 0;

        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a = reader.readLine();

            double A = Double.parseDouble(a);

            if (A == -1) {
                System.out.println(i / count);
                break;
            }

            i += A;
            count += 1;

        }
    }
}

