package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    //1. Класс Solution должен содержать публичное статическое поле map
    //типа Map, которое должно быть сразу проинициализировано.
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    //7. Класс Solution должен содержать статический блок,
    //в котором добавляются в map тринадцать пар.
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {

        //2. Программа должна считывать имя файла с консоли (используй BufferedReader).
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //3. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

        //4. Программа должна считывать содержимое файла (используй FileReader).
        //5. Поток чтения из файла (FileReader) должен быть закрыт.

        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                Pattern pattern = Pattern.compile("\\b\\d+\\b");
                Matcher matcher = pattern.matcher(s);
                String newString = s;

                //6. Программа должна выводить в консоль все строки из файла,
                //но числа должны быть заменены на слова из словаря map.
                while (matcher.find()) {
                    //System.out.println(matcher.group());
                    Integer keyDigit = Integer.parseInt(matcher.group());
                    //System.out.println(keyDigit);
                    if (map.containsKey(keyDigit)) {
                        //System.out.println(keyDigit);
                        newString = newString.replaceAll("\\b" + keyDigit + "\\b", map.get(keyDigit));
                        //newString = matcher.replaceAll(map.get(keyDigit));
                        //System.out.println(newString);
                    }
                }
                System.out.println(newString);
            }
        }
        catch(IOException ignore){
            /* NOP */
        }
    }
}
