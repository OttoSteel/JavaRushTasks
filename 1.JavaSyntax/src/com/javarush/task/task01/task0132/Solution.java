package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String text = String.valueOf(number);
        int length = text.length();
        int x = 0;
        for (int i = 0; i < length; i++){
            x = x + Character.getNumericValue(text.charAt(i));
        }
        return x;
    }
}