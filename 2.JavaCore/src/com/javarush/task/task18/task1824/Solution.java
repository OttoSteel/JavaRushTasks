package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileNames = br.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileNames)) {
            } catch (FileNotFoundException e) {
                System.out.println(fileNames);
                break;
            }
        }

        /*while (true) {
            String fileName = null;
            InputStream inputStream = null;
            try {
                fileName = reader.readLine();
            } catch (IOException ignore) {
            }
            try {
                inputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                break;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ignore2) {
                }
            }
        }*/
    }
}
