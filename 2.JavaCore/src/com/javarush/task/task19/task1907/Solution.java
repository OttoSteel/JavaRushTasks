package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder fileContentSB = new StringBuilder();
        FileReader reader1 = new FileReader(fileName);

        while (reader1.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader1.read(); //читаем один символ (char будет расширен до int)
            fileContentSB.append((char)data); //пишем один символ (int будет обрезан/сужен до char)
        }
        //закрываем потоки после использования
        reader1.close();

        String fileContent = fileContentSB.toString();
        // System.out.println(fileContent);
        /*String[] fileContentArray = fileContent.split("\\W");  // "[.,!:;?]"
        int counter = 0;
        for (String s:fileContentArray
             ) {
            if (s.equals("world")) {
                counter++;
            }
        }
        System.out.println(counter);*/
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(fileContent);
        int count = 0;
        while(matcher.find())
            count++;
        System.out.println(count);


    }

}
