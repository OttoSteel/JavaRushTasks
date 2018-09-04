package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 10;
        int b = 10;
        while(a > 0){
            while(b > 0){
                System.out.print("S");
                b--;
            }
            b = 10;
            a--;
            System.out.print("\n");
        }

    }
}
