package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread one = new SpecialThread();
        SpecialThread two = new SpecialThread();
        SpecialThread three = new SpecialThread();
        SpecialThread four = new SpecialThread();
        SpecialThread five = new SpecialThread();
        list.add(new Thread(one));
        list.add(new Thread(two));
        list.add(new Thread(three));
        list.add(new Thread(four));
        list.add(new Thread(five));


    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
