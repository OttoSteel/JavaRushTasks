package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 1;
        int b = 1;

        while(a <= 10){
            while(b <= 10){
                System.out.print((a * b) + " ");
                b++;
            }
            System.out.print("\n");
            b = 1;
            a++;
        }

    }
}
