package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        FileReader reader1 = new FileReader(fileOne);
        FileWriter writer = new FileWriter(fileTwo);
        int counter = 0;

        while (reader1.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            counter++;
            int data = reader1.read(); //читаем один символ (char будет расширен до int)
            if (counter % 2 == 0) {
                writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
            }

        }

        //закрываем потоки после использования
        reader1.close();
        writer.close();
    }
}
