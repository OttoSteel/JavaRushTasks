package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        ArrayList<String> strings = new ArrayList<>();
        HashMap<String, String> addresses = new HashMap<>();
        while (true) {
            String var = reader.readLine();
            if (var.isEmpty()) break;

            strings.add(var);
        }
        for (String s:strings
             ) {
            if (strings.indexOf(s) % 2 > 0)
                addresses.put(strings.get(strings.indexOf(s) - 1), s);
        }

        //read home number
        String city = reader.readLine();

        if (addresses.containsKey(city)) {
            String familySecondName = addresses.get(city);
            System.out.println(familySecondName);
        }
    }
}
