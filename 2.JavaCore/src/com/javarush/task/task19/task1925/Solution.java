package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //1. Программа НЕ должна считывать данные с консоли.
        String fileToRead = args[0];
        String fileToWrite = args[1];
        //StringBuilder stringToWriteSB = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(fileToRead));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileToWrite));

        StringBuilder sb = new StringBuilder();
        while (br.ready()) {
            String[] ss = br.readLine().split(" ");
            for (String s : ss)
                if (s.length() > 6)
                    sb.append(s + ",");
        }
        //System.out.println(sb.toString());
        bw.write(sb.delete(sb.length() - 1, sb.length()).toString());

        br.close();
        bw.close();

        //2. Программа должна считывать содержимое первого файла
         //(используй FileReader c конструктором String).
        //3. Поток чтения из файла (FileReader) должен быть закрыт.
        /*try(FileReader fr = new FileReader(fileToRead))
        {
            while (fr.ready()) //пока есть непрочитанные байты в потоке ввода
            {
                int data = fr.read(); //читаем один символ (char будет расширен до int)
                stringToWriteSB.append((char)data); //пишем один символ (int будет обрезан/сужен до char)
            }
        }
        catch(IOException ignore){
            *//* NOP *//*
        }*/

        //4. Программа должна записывать через запятую во второй файл
        // все слова из первого файла длина которых строго больше 6(используй FileWriter).
        //5. Поток записи в файл (FileWriter) должен быть закрыт.
        // fw.write(result.toString(), 0, result.length() - 1);
        /*String[] stringToWriteArray = stringToWriteSB.toString().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringToWriteArray.length; i++) {
            if (i == (stringToWriteArray.length - 1)) {
                if (stringToWriteArray[i].length() > 6) {
                    stringBuilder.append(stringToWriteArray[i]);
                }
            } else {
                if (stringToWriteArray[i].length() > 6) {
                    stringBuilder.append(stringToWriteArray[i]).append(",");
                }
            }
        }
        String stringToWrite = stringBuilder.toString();*/
        //System.out.println(stringToWrite);
        /*try(FileWriter fw = new FileWriter(fileToWrite)) {
            fw.write(stringToWrite);
        } catch (IOException ignore) {
            *//* NOP *//*
        }*/
    }
}
