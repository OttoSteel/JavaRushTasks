package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person chel;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat df2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 2; i+=3) {
                        if (args[i+1].equals("м")) {
                            chel = Person.createMale(args[i], df.parse(args[i+2]));
                        } else {
                            chel = Person.createFemale(args[i], df.parse(args[i+2]));
                        }
                        allPeople.add(chel);
                        System.out.println(allPeople.indexOf(chel));
                    }
                    break;
                }
            case "-u" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 3; i+=4) {
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i+1]);
                        if (args[i+2].equals("м")) {
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        } else {
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                        }
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(df.parse(args[i+3]));
                    }
                    break;
                }
            case "-d" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
                    }
                    break;
                }
            case "-i" :
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " " +
                                (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                                df2.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
                    }
                }
                break;

        }
        /*if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                chel = Person.createMale(args[1], df.parse(args[3]));
            } else {
                chel = Person.createFemale(args[1], df.parse(args[3]));
            }
            allPeople.add(chel);
            System.out.println(allPeople.indexOf(chel));*/
        /*} else if (args[0].equals("-u")) {
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            } else {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(df.parse(args[4]));*/
        /*} else if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);*/
        /*} else if (args[0].equals("-i")) {
            System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " " +
                    (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE) ? "м" : "ж") + " " +
                    df2.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
        }*/
        /*for (Person p:allPeople
             ) {
            System.out.println(p);
        }*/
    }
}
