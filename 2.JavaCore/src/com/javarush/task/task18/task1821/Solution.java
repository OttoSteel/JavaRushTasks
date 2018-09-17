package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        InputStream inputStream = new FileInputStream(fileName);

        int [] symbolQuantity = new int [256];

        while (inputStream.available() > 0) {
            int date = inputStream.read();
            symbolQuantity[date]++;
        }
        inputStream.close();

        for (int i = 0; i < symbolQuantity.length; i++) {
            if (symbolQuantity[i] > 0) {
                char symbol = (char) i;
                System.out.println(symbol + " " + symbolQuantity[i]);
            }
        }
    }
}
