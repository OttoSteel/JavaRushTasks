package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        Map<Integer, Integer> bytes = new HashMap<>();

        FileInputStream inputStream = new FileInputStream(inputFile);

        while (inputStream.available() > 0) //пока остались непрочитанные байты
        {
            int data = inputStream.read(); //прочитать очередной байт
            if (bytes.containsKey(data)) {
                int value = bytes.get(data);
                value++;
                bytes.put(data, value);                // if "bytes" contains data, value += 1
            } else {
                bytes.put(data, 1);
            }
        }
        inputStream.close(); // закрываем поток

        //System.out.println(bytes);

        int maxValue = 0;                                 // here is a maximal value
        for (Integer i:bytes.values()
             ) {
            if (i > maxValue) {
                maxValue = i;
            }
        }

        //System.out.println(maxValue);

        List<Integer> listOfMaxBytes = new ArrayList<>();   // here is a list of max bytes

        for (Integer i:bytes.keySet()
             ) {
            if (bytes.get(i) == maxValue) {
                listOfMaxBytes.add(i);
            }
        }

        for (Integer i:listOfMaxBytes
             ) {
            System.out.print(i + " ");
        }

    }
}
