package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        int spaceSum = 0;
        int symbolSum = 0;
        String fileName = args[0];

        InputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data == 32) {
                spaceSum++;
                symbolSum++;
            } else {
                symbolSum++;
            }
        }
        inputStream.close();
        double ratio =  (spaceSum / (double) symbolSum) * 100;
        System.out.printf("%.2f",ratio);

       /*String space = "   ";
       byte [] bytes = space.getBytes();
        for (byte b:bytes
             ) {
            System.out.println(b);
        }*/
    }
}
