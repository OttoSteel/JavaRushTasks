package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FileInput = reader.readLine();

        FileInputStream inputStream = new FileInputStream(FileInput);
        int min = 300;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            if (data < min) {
                min = data;
            }
        }
        inputStream.close(); // закрываем поток

        System.out.println(min); //выводим максимум на экран.
    }
}
