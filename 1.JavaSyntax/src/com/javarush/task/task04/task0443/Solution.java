package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        String a = reader.readLine();

        int A = Integer.parseInt(a);

        String b = reader.readLine();

        int B = Integer.parseInt(b);

        String c = reader.readLine();

        int C = Integer.parseInt(c);

        System.out.println("Меня зовут " + name + ".");
        System.out.println("Я родился " + C + "." + B + "." + A);
    }
}
