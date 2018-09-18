package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while(true) {
            fileName = reader.readLine();
            if (fileName.equals("exit")) {
                reader.close();
                break;
            } else {
                Thread thread = new ReadThread(fileName);
                thread.start();
            }
        }

        /*for (Integer i:resultMap.values()
             ) {
            System.out.println(i);
        }*/
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(fileName);
                int [] symbolQuantity = new int [256];

                while (inputStream.available() > 0) {
                    int date = inputStream.read();
                    symbolQuantity[date]++;
                }

                int max = 0;
                int Byte = 0;
                for (int i = 0; i < symbolQuantity.length; i++) {
                    if (symbolQuantity[i] > max) {
                        max = symbolQuantity[i];
                    }
                }
                for (int i = 0; i < symbolQuantity.length; i++) {
                    if (symbolQuantity[i] == max) {
                        Byte = i;
                    }
                }
                resultMap.put(fileName, Byte);
            } catch (IOException ignore) {
            } finally {
                try {
                    inputStream.close();
                } catch (IOException ignore2) {
                }
            }
        }
    }
}
