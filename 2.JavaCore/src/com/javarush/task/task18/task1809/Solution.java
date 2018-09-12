package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileRead = reader.readLine();
        String fileWrite = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileRead);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(fileWrite);

        byte[] buffer = new byte[inputStream.available()];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int count = inputStream.read(buffer);
        }
        for (int i = (buffer.length - 1); i >= 0 ; i--) {
            outputStream.write(buffer[i]);
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
