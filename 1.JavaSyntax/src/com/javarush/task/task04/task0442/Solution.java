package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int i = 0;

        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a = reader.readLine();

            int A = Integer.parseInt(a);

            i += A;

            if (A == -1) {
                System.out.println(i);
                break;
            }

        }
    }
}
