package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        reader.close();

        String[] first = input.split("\\?");
        /*for (String s : first
        ) {
            System.out.println(s);
        }*/

        String[] second = first[1].split("\\&");
        List<String> secondList = new ArrayList<String>();
        for (String s : second
        ) {
            //System.out.println(s);
            System.out.print(s.split("\\=")[0] + " ");
            /*if (s.split("\\=")[0].equals("obj")) {
                System.out.println((s.split("\\=")[1]));
            } */
            //secondList.add((s.split("\\=")[0])
        }

        System.out.println();

        for (String s : second
        ) {
            if (s.split("\\=")[0].equals("obj")) {
               // if ((s.split("\\=")[1]).contains(".")) {
                    try {
                        Double doubleInput = Double.parseDouble((s.split("\\=")[1]));
                        alert(doubleInput);
                    } catch (NumberFormatException e) {
                        alert((s.split("\\=")[1]));
                    }
                }
            }
        }
    //}

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
