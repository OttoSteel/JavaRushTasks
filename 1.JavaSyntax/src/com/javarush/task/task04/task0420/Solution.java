package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();

        int A = Integer.parseInt(a);

        String b = reader.readLine();

        int B = Integer.parseInt(b);

        String c = reader.readLine();

        int C = Integer.parseInt(c);

        /*
        ABC
        CBA
        BAC
        CAB
        BCA
        ACB
         */


        if ((A > B) && (B > C))
            System.out.println(A + " " + B + " " + C);
        else if ((C > B) && (B > A))
            System.out.println(C + " " + B + " " + A);
        else if ((B > A) && (A > C))
            System.out.println(B + " " + A + " " + C);
        else if ((C > A) && (A > B))
            System.out.println(C + " " + A + " " + B);
        else if ((B > C) && (C > A))
            System.out.println(B + " " + C + " " + A);
        else if ((A > C) && (C > B))
            System.out.println(A + " " + C + " "+ B);







    }
}
