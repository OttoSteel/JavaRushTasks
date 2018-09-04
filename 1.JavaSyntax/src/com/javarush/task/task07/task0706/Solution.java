package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] nums = new int[15];
        int even = 0;
        int odd = 0;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
            if (i % 2 > 0)
                odd += nums[i];
            else
                even += nums[i];
        }

        if (odd > even)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else if (even > odd)
            System.out.println("В домах с четными номерами проживает больше жителей.");


    }
}
