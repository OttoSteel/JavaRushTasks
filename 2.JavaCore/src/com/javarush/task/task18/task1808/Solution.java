package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(file1);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        int bytesCount = inputStream.available();
        if ((bytesCount % 2) > 0) {
            byte[] bufferFile2 = new byte[(bytesCount / 2) + (bytesCount % 2)];
            byte[] bufferFile3 = new byte[(bytesCount / 2)];
            if (bytesCount > 0) //пока есть еще непрочитанные байты
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = inputStream.read(bufferFile2);
                outputStream.write(bufferFile2, 0, count); //записать блок(часть блока) во второй поток
                int count2 = inputStream.read(bufferFile3);
                outputStream2.write(bufferFile3, 0, count2);
            }
        } else if ((bytesCount % 2) == 0) {
            byte[] bufferFile2 = new byte[(bytesCount / 2)];
            byte[] bufferFile3 = new byte[(bytesCount / 2)];
            if (bytesCount > 0) //пока есть еще непрочитанные байты
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = inputStream.read(bufferFile2);
                outputStream.write(bufferFile2, 0, count); //записать блок(часть блока) во второй поток
                int count2 = inputStream.read(bufferFile3);
                outputStream2.write(bufferFile3, 0, count2);
            }
        }

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
        outputStream2.close();
    }
}
