package com.javarush.task.task18.task1825;

import org.omg.CORBA.portable.OutputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        List<String> filesList = new ArrayList<>();


        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) {
                reader.close();
                break;
            } else {
                filesList.add(fileName);
            }
        }
        reader.close();

        String[] filesArray = new String[filesList.size()];

        for (String s:filesList
             ) {
            String stringPart = s.substring(s.indexOf(".part"));
            //System.out.println(stringPart);                                       //todo
            String stringPart2 = stringPart.substring(5);
            //System.out.println(stringPart2);                                      //todo
            int partNumber = Integer.parseInt(stringPart2);
            filesArray[partNumber - 1] = s;
        }

        /*for (String str:filesArray                                               //todo
        ) {
            System.out.println(str);
        }
*/
        String newFile = filesArray[0].substring(0, filesArray[0].indexOf(".part"));
        //System.out.println(newFile);                                             //todo

        FileOutputStream outputStream = new FileOutputStream(newFile, true);

        for (String str:filesArray
        ) {
            FileInputStream inputStream = new FileInputStream(str);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            outputStream.write(buffer);
            inputStream.close();
        }

        outputStream.close();

    }
}
