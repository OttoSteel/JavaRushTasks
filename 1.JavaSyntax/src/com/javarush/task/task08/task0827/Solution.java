package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);

        Date day = df.parse(date);
        Date start = new Date();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        start.setDate(1);      // первое число
        start.setMonth(0);     // месяц январь, нумерация для месяцев 0-11
        start.setYear(day.getYear());

        long msTimeDistance = day.getTime() - start.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay);

        //if (dayCount == 0)
            //return true;
        if (dayCount % 2 > 0)
            return true;
        else
            return false;
    }
}
