package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        byte [] bytes = alphabet.getBytes();
        InputStream inputStream = new FileInputStream(args[0]);
        int sum = 0;

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == data) {
                    sum++;
                }
            }
        }
        inputStream.close();
        System.out.println(sum);
    }
}
/*
mport java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream(args[0]);
        int count = 0;
        String result = "";

        while (fin.available() > 0) {
          result += (char) fin.read();
        }
        fin.close();

        Pattern pat = Pattern.compile("[a-zA-z]");
        Matcher mat = pat.matcher(result);
        while (mat.find()) {
            count++;
        }
        System.out.println(count);
    }
}
 */
