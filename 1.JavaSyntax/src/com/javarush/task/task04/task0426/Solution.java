package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String A = reader.readLine();
        int a = Integer.parseInt(A);

        if (a == 0)
            System.out.println("ноль");
        else if (a > 0){
            if ((a % 2) > 0)
                System.out.println("положительное нечетное число");
            else
                System.out.println("положительное четное число");
        }
        else if (a < 0){
            if((-(a % 2)) > 0)
                System.out.println("отрицательное нечетное число");
            else
                System.out.println("отрицательное четное число");
        }
    }
}
