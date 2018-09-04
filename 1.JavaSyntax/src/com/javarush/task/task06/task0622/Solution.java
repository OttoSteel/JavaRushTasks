package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        int nums [] = {a, b, c, d, e};

        int t;

        for (int i = 1; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i ; j--) {
                if (nums[j - 1] > nums[j]) {
                    t = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            System.out.println(nums[j]);

        }

    }
}
