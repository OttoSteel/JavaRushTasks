package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a + b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a - b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a * b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double div = (double) a / (double) b;
        return div;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш кодu
        double perc = (double) a * ((double)b / 100);
        return perc;
    }

    public static void main(String[] args) {
        //System.out.println(percent(100, 13));
        //System.out.println(division(25, 5));

    }
}