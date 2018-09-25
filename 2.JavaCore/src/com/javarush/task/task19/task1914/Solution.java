package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //upgrage string

        Pattern pattern = Pattern.compile("\\d+");
        Pattern pattern2 = Pattern.compile("[+\\-*]");
        int varOne = 0;
        int varTwo = 0;
        int varRes = 0;
        String action = "";
        String[] splitted = result.split("[+\\-*]");
        String partOne = splitted[0];
        String partTwo = splitted[1];
        Matcher matcherOne = pattern.matcher(partOne);
        Matcher matcherTwo = pattern.matcher(partTwo);
        Matcher matcherThree = pattern2.matcher(result);

        if (matcherOne.find()) {
            varOne = Integer.parseInt(matcherOne.group());
        }
        if (matcherTwo.find()) {
            varTwo = Integer.parseInt(matcherTwo.group());
        }
        if (matcherThree.find()) {
            action = action + matcherThree.group();
        }
        if (action.equals("+")) {
            varRes = varOne + varTwo;
        } else if (action.equals("-")) {
            varRes = varOne - varTwo;
        } else if (action.equals("*")) {
            varRes = varOne * varTwo;
        }


        //выводим ее в консоль
        System.out.printf("%d %s %d = %d", varOne, action, varTwo, varRes);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

