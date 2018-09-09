package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //Solution sol = new Solution();
        Person chel;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                chel = Person.createMale(args[1], df.parse(args[3]));
            } else {
                chel = Person.createFemale(args[1], df.parse(args[3]));
            }
            allPeople.add(chel);
            System.out.println(allPeople.indexOf(chel));
        } else if (args[0].equals("-u")) {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            } else {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(df.parse(args[4]));
        } else if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
        } else if (args[0].equals("-i")) {
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                    (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                    df2.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        }
    }
}
