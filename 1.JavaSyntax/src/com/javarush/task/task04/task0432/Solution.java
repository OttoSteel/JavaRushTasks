package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();

        String B = reader.readLine();
        int b = Integer.parseInt(B);

        while (b > 0){
            System.out.println(a);
            b--;
        }

    }
}
