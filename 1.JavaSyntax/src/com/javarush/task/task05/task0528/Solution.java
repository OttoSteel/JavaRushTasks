package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        //System.out.println("27 06 2018");
        GregorianCalendar gcalendar = new GregorianCalendar();


        System.out.print(gcalendar.get(Calendar.DATE) + " ");
        System.out.print(gcalendar.get(Calendar.MONTH) + 1 + " ");
        System.out.print(gcalendar.get(Calendar.YEAR));


    }
}
