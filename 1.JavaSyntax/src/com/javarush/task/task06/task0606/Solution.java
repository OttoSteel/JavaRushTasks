package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even = 0;
    public static int odd = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();

        for (int i = 0; i < A.length(); i++) {
            String a = A.substring(i, i+1);
            int b = Integer.parseInt(a);
            if(b % 2 == 0) even += 1;
            else odd += 1;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
