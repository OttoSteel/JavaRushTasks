package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> source = new ArrayList<Integer>();
        ArrayList<Integer> div3 = new ArrayList<Integer>();
        ArrayList<Integer> div2 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            int temp = (Integer.parseInt(reader.readLine()));
            source.add(temp);
        }

        for (Integer i:source
             ) {
            if ((i % 3 == 0) && (i % 2 == 0)) {
                div2.add(i);
                div3.add(i);
            }
            else if (i % 3 == 0)
                div3.add(i);
            else if (i % 2 == 0)
                div2.add(i);
            else
                other.add(i);
        }


        printList(div3);
        printList(div2);
        printList(other);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i:list
             ) {
            System.out.println(i);
        }
    }
}
