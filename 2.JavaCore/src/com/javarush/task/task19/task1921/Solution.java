package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws ParseException {
        //1. Класс Solution должен содержать публичную константу PEOPLE типа List,
        // которая должна быть сразу проинициализирована.
        //2. Программа НЕ должна считывать данные с консоли.
        //3. Программа должна считывать содержимое файла (используй FileReader).
        //4. Поток чтения из файла (FileReader) должен быть закрыт.
        try(BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {
            //чтение построчно
            String s;
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            while((s=br.readLine())!=null){
                String[] splittedS = s.split(" ");
                String year = splittedS[splittedS.length - 1];
                String month = splittedS[splittedS.length - 2];
                String day = splittedS[splittedS.length - 3];
                String name = s.substring(0, (s.indexOf(day) - 1));
                //System.out.println(name);
                String dayMonthYear = day + " " + month + " " + year;
                //System.out.println(dayMonthYear);
                Date datePerson = sdf.parse(dayMonthYear);
                //5. Программа должна заполнить список PEOPLE данными из файла.
                //6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
                PEOPLE.add(new Person(name,datePerson));
            }
        }
        catch(IOException ignore){
            /* NOP */
        }
    }
}
