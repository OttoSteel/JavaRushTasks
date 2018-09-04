package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();

        // strings to strings, numbers -- to nums
        for (String s:array
             ) {
            if (isNumber(s))
                nums.add(Integer.parseInt(s));
            else
                strings.add(s);
        }

        Collections.sort(nums);
        Collections.reverse(nums);

        String[] array2 = strings.toArray(new String[strings.size()]);

        String t;

        for (int i = 1; i < array2.length; i++) {
            for (int j = array2.length - 1; j >= i ; j--) {
                if (isGreaterThan(array2[j - 1], array2[j])) {
                    t = array2[j - 1];
                    array2[j - 1] = array2[j];
                    array2[j] = t;
                }
            }
        }

        int i = 0;
        int j = 0;

        for (int k = 0; k < array.length; k++) {
            if (isNumber(array[k])) {
                array[k] = nums.get(i).toString();
                i++;
            }
            else {
                array[k] = array2[j];
                j++;
            }

        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }
}
