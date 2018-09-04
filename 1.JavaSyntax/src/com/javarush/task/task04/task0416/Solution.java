package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        double t = Double.parseDouble(number);
        //System.out.println(t);
        //float t0 = 0;
        if(((t >= 0)&&(t < 3)) || ((t >= 5)&&(t < 8)) || ((t >= 10)&&(t < 13)) || ((t >= 15)&&(t < 18)) || ((t >= 20)&&(t < 23)) || ((t >= 25)&&(t < 28)) || ((t >= 30)&&(t < 33)) || ((t >= 35)&&(t <= 38)) || ((t >= 40)&&(t < 43)) || ((t >= 45)&&(t < 48)) || ((t >= 50)&&(t < 53)) || ((t >= 55)&&(t < 58)) )
            System.out.println("зелёный");
        if(((t >= 3)&&(t < 4)) || ((t >= 8)&&(t < 9)) || ((t >= 13)&&(t < 14)) || ((t >= 18)&&(t < 19)) || ((t >= 23)&&(t < 24)) || ((t >= 28)&&(t < 29)) || ((t >= 33)&&(t < 34)) || ((t >= 38)&&(t < 39)) || ((t >= 43)&&(t < 44)) || ((t >= 48)&&(t < 49)) || ((t >= 53)&&(t < 54)) || ((t >= 58)&&(t < 59)) )
            System.out.println("жёлтый");
        if(((t >= 4)&&(t < 5)) || ((t >= 9)&&(t < 10)) || ((t >= 14)&&(t < 15)) || ((t >= 19)&&(t < 20)) || ((t >= 24)&&(t < 25)) || ((t >= 29)&&(t < 30)) || ((t >= 34)&&(t < 35)) || ((t >= 39)&&(t < 40)) || ((t >= 44)&&(t < 45)) || ((t >= 49)&&(t < 50)) || ((t >= 54)&&(t < 55)) || ((t >= 59)&&(t < 60)) )
            System.out.println("красный");



    }
}