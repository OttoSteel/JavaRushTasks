package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //Создаем поток-чтения-байт-из-файла                         /home/kefir/textFile2
        FileInputStream inputStream = new FileInputStream(fileName);
        long commaCount = 0;
        int comma = (int)',';

        byte[] buffer = new byte[1024];
        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer
            int count = inputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] == comma) {
                    commaCount++;
                }
            }
        }

        inputStream.close(); //закрываем
        System.out.println(commaCount);
    }
}
