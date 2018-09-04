package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        Random random = new Random();
        Set<Integer> picked = new HashSet<>();
        while (picked.size() < 20) {
            picked.add(random.nextInt(100));
        }
        return (HashSet<Integer>) picked;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            Integer s = (Integer) iter.next();

            if (s > 10) {
                iter.remove();
            }
        }
        return set;

    }

    public static void main(String[] args) {
        //System.out.println(createSet());
        //System.out.println(removeAllNumbersMoreThan10(createSet()));

    }
}
