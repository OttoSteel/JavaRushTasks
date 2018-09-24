package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine();
        String fileTwo = reader.readLine();
        reader.close();

        StringBuilder digitsOfFileOneSB = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(fileOne)))
        {
            //чтение построчно
            Pattern pattern = Pattern.compile("\\b\\d+\\b");

            String s;
            while((s=br.readLine())!=null){
                Matcher matcher = pattern.matcher(s);
                while(matcher.find()) {
                    digitsOfFileOneSB.append(matcher.group()).append(" ");
                }
            }
        }
        catch(IOException ignore){
            /*NOP*/
        }

        // char[] digitsOfFileOneArray = digitsOfFileOneSB.toString().toCharArray();  "-?\\d+(\\.\\d+)?"

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileTwo)))
        {
            String text = digitsOfFileOneSB.toString().trim();
            bw.write(text);
        }
        catch(IOException ignore){
            /*NOP*/
        }

    }
}
