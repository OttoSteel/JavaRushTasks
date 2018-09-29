package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        //1. Программа НЕ должна считывать данные с консоли.
        String fileOne = args[0];
        String fileTwo = args[1];
        //2. Программа должна считывать содержимое первого файла
        //(используй FileReader c конструктором String).
        //3. Поток чтения из файла (FileReader) должен быть закрыт.
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileTwo));
        try(BufferedReader br = new BufferedReader(new FileReader(fileOne)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                Pattern pattern = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b");
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    //4. Программа должна записывать во второй файл все слова из
                    //первого файла которые содержат цифры (используй FileWriter).
                    bw.write(matcher.group() + " ");
                    //System.out.println(matcher.group());
                }
            }
        }
        catch(IOException ignore){
            /* NOP */
        }
       //5. Поток записи в файл (FileWriter) должен быть закрыт.
        bw.close();
    }
}
