package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        while (true) {
            key = reader.readLine();
            if ((!(key.equals("user"))) && (!(key.equals("loser")))
                && (!(key.equals("coder"))) && (!(key.equals("proger")))) {
                break;
            }
            else if (key.equals("user")) {
                person = new Person.User();
                doWork(person);
            }
            else if (key.equals("loser")) {
                doWork(new Person.Loser());
            }
            else if (key.equals("coder")) {
                doWork(new Person.Coder());
            }
            else if (key.equals("proger")) {
                doWork(new Person.Proger());
            }
        }
        /*
        {
            //создаем объект, пункт 2

            doWork(person); //вызываем doWork

        }
        */
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder) person).coding();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }

    }
}
