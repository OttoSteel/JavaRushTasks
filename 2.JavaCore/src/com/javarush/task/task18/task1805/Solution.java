package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        long [] bytesArray = new long[256];
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            bytesArray[data]++;
        }
        inputStream.close();
        for (int i = 0; i < bytesArray.length; i++) {
            if (bytesArray[i] > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
