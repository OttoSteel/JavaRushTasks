package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            throw null;
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        int[] array = new int[2];
        int number;

        try {
            number = array[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new ClassCastException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new UnsupportedOperationException());

    }
}
