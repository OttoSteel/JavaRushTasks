package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> cats = new HashMap<>();
        cats.put("cat1", new Cat("cat1"));
        cats.put("cat2", new Cat("cat2"));
        cats.put("cat3", new Cat("cat3"));
        cats.put("cat4", new Cat("cat4"));
        cats.put("cat5", new Cat("cat5"));
        cats.put("cat6", new Cat("cat6"));
        cats.put("cat7", new Cat("cat7"));
        cats.put("cat8", new Cat("cat8"));
        cats.put("cat9", new Cat("cat9"));
        cats.put("cat10", new Cat("cat10"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat>cats = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            Cat value = pair.getValue();
            cats.add(value);

        }
        return (HashSet<Cat>) cats;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
