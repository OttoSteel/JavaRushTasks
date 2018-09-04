package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        for (Cat c:cats
             ) {
            cats.remove(c);
            break;
        }
        //System.out.println(cats.size());

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        HashSet<Cat> cats = new HashSet<>();
        Cat tom = new Cat();
        cats.add(tom);
        Cat ben = new Cat();
        cats.add(ben);
        Cat sem = new Cat();
        cats.add(sem);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        for (Cat c:cats
             ) {
            System.out.println(c);
        }
    }

    // step 1 - пункт 1
    public static class Cat {

    }
}
