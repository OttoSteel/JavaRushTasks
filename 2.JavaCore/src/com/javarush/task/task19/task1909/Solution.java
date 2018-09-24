package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        StringBuilder newStringSB = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(fileOne)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                newStringSB.append(s);
            }
        }
        catch(IOException ignore){
            /*NOP*/
        }
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(newStringSB.toString());
        String newString = matcher.replaceAll("!");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileTwo)))
        {
            bw.write(newString);
        }
        catch(IOException ignore){
            /*NOP*/
        }

    }
}
