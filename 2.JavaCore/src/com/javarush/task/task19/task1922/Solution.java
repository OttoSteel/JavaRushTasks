package com.javarush.task.task19.task1922;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    //1. Класс Solution должен содержать публичное статическое поле words типа List,
    //которое должно быть сразу проинициализировано.
    public static List<String> words = new ArrayList<String>();

    //2. Класс Solution должен содержать статический блок,
    //в котором добавляются три или больше слов в список words.
    static {
        /*words.add("А");
        words.add("Б");
        words.add("В");*/
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        //3. Программа должна считывать имя файла с консоли (используй BufferedReader).
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //4. BufferedReader для считывания данных с консоли должен быть закрыт.
        reader.close();

        //5. Программа должна считывать содержимое файла (используй FileReader).
        //6. Поток чтения из файла (FileReader) должен быть закрыт.
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                int counter = 0;
                for (String word:words
                     ) {
                    String pat = "\\b" + word + "\\b";
                    Pattern pattern = Pattern.compile(pat);
                    Matcher matcher = pattern.matcher(s);
                    while (matcher.find()) {
                        counter++;
                    }
                }

                //7. Программа должна выводить в консоль все строки из файла,
                //которые содержат всего 2 слова из списка words.
                if (counter == 2) {
                    System.out.println(s);
                }
            }
        }
        catch(IOException ignore){
            /* NOP */
        }
    }
}
