package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(file1);
        byte [] bytesFile1 = new byte[inputStream.available()];
        inputStream.read(bytesFile1);
        inputStream.close();

        OutputStream outputStream = new FileOutputStream(file1);

        InputStream inputStream2 = new FileInputStream(file2);
        byte [] bytesFile2 = new byte[inputStream2.available()];
        inputStream2.read(bytesFile2);
        inputStream2.close();

        byte [] bytes = new byte[bytesFile1.length + bytesFile2.length];
        System.arraycopy(bytesFile2, 0, bytes, 0, bytesFile2.length);
        System.arraycopy(bytesFile1, 0, bytes, bytesFile2.length, bytesFile1.length);

        outputStream.write(bytes);
        outputStream.close();
    }
}
