package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String s;
        while (true) {
            s = br.readLine();
            if (s.startsWith(args[0] + " ")) {
                System.out.println(s);
                break;
            }
        }

        br.close();

        /*InputStream inputStream = new FileInputStream(fileName);
        byte [] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String fileContent = new String(buffer);
        inputStream.close();
        String filePart;
        if (!fileContent.startsWith(args[0])) {
            filePart = fileContent.substring(fileContent.indexOf(" " + args[0] + " "));
        } else {
            filePart = fileContent;
        }

        //System.out.println(filePart.trim());

        String [] partArray = filePart.trim().split(" ");
        int intQuantity = 0;
        String finalString = "";
        for (String s:partArray
             ) {
            if (intQuantity == 2) break;
            try {
                int temp = Integer.parseInt(s);
                intQuantity++;
            } catch (NumberFormatException ignore) {
                *//* NOP *//*
            }
            finalString = finalString + s + " ";
        }
        System.out.println(finalString.trim());*/
    }
}
