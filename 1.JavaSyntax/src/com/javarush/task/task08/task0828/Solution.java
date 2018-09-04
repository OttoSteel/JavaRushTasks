package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> months = new ArrayList<>();
        months.add(0, "January");
        months.add(1, "February");
        months.add(2, "March");
        months.add(3, "April");
        months.add(4, "May");
        months.add(5, "June");
        months.add(6, "July");
        months.add(7, "August");
        months.add(8, "September");
        months.add(9, "October");
        months.add(10, "November");
        months.add(11, "December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        System.out.println(month + " is the " + (months.indexOf(month) + 1) + " month");
    }
}
