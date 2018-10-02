package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder fileContentSB = new StringBuilder();
        try(BufferedReader br = new BufferedReader (new FileReader(fileName)))
        {
            // чтение посимвольно
            int c;
            while((c=br.read())!=-1){
                fileContentSB.append((char) c);
            }
        }
        catch(IOException ignore){
            /* NOP */
        }

        //System.out.println(fileContentSB.toString());

        String fileContent = fileContentSB.toString();
        String tag = args[0];
        Document document = Jsoup.parse(fileContent,  "", Parser.xmlParser());
        Elements elements = document.select(tag);
        System.out.println(elements);
    }
}
