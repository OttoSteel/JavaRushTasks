package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = reader.readLine();
            if (input.equals("exit")) {
                break;
            }
            if (input.contains(".")) {
                try {
                    Double doubleInput = Double.parseDouble(input);
                    print(doubleInput);
                } catch (NumberFormatException e) {
                    print(input);
                }
            } else {
                try {
                    Integer intInput = Integer.parseInt(input);
                    if (intInput > 0 && intInput < 128) {
                        print(intInput.shortValue());
                    } else if (intInput <= 0 || intInput >= 128) {
                        print(intInput);
                    }
                } catch (NumberFormatException ee) {
                    print(input);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
