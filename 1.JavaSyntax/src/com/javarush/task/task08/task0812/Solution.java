package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nums.add(Integer.parseInt(reader.readLine()));
        }

        int count = 1;

        for (int i = 1; i < 10; i++) {
            if (nums.get(i).equals(nums.get(i-1))) {
                count += 1;
                counts.add(count);
            }
            else {
                counts.add(count);
                count = 1;
            }
        }

        int max = counts.get(0);

        for (int i = 1; i < counts.size(); i++) {
            if (counts.get(i) > max)
                max = counts.get(i);
            else
                continue;
        }

        //System.out.println(counts);

        System.out.println(max);

    }
}