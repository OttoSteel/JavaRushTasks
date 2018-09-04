package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String s = String.valueOf(i);
            list.add(s);
        }
        System.out.println(list.size());
        for (String str:list
             ) {
            System.out.println(str);
        }
    }
}
