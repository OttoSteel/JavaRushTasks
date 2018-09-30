package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {
                StringBuffer buffer = new StringBuffer(s);
                buffer.reverse();
                System.out.println(buffer);
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
