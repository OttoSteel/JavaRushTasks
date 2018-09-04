package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Character> baseList = new ArrayList<>();
        ArrayList<Character> vowList = new ArrayList<>();
        ArrayList<Character> consList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] array = str.toCharArray();
        for (char c:array
             ) {
            String s = new String();
            if (!(s.valueOf(c).equals(" ")))
                baseList.add(c);
        }

        for (Character c:baseList
             ) {
            if (isVowel(c))
                vowList.add(c);
            else
                consList.add(c);
        }
        for (Character c:vowList
             ) {
            System.out.print(c + " ");
        }

        System.out.println();

        for (Character c:consList
             ) {
            System.out.print(c + " ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}