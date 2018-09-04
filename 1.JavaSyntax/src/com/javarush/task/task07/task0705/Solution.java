package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] big = new int[20];
        int[] little1 = new int[10];
        int[] little2 = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            big[i] = Integer.parseInt(reader.readLine());
        }
        System.arraycopy (big, 0, little1, 0, 10);
        System.arraycopy (big, 10, little2, 0, 10);

        for (int i = 0; i < 10; i++) {
            System.out.println(little2[i]);

        }

    }
}
