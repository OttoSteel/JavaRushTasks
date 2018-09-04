package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код


        int sum = 0;

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String B = reader.readLine();
            if(B.equalsIgnoreCase("сумма")){
                System.out.println(sum);
                break;
            }
            else {
                int b = Integer.parseInt(B);
                sum += b;
            }


        }

    }
}
