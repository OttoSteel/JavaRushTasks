package com.javarush.task.task20.task2010;

import java.io.Serializable;

/*
Как сериализовать что-то свое?
*/
public class Solution implements Serializable {
    public static class Object implements Serializable{
        public String string1;
        public String string2;
    }

    public static int countStrings;

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

        // Create new Solution.Object:
        Object object = new Object();
        String string1 = new String();
        object.string1 = string1;
        String string2 = new String();
        object.string2 = string2;
        //===========================

        string1.print();
        string2.print();
    }
}
