package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[5]);
        for (int i = 0; i < list.get(0).length; i++) {
            list.get(0)[i] = i;
        }
        list.add(new int[2]);
        for (int i = 0; i < list.get(1).length; i++) {
            list.get(1)[i] = i;
        }
        list.add(new int[4]);
        for (int i = 0; i < list.get(2).length; i++) {
            list.get(2)[i] = i;
        }
        list.add(new int[7]);
        for (int i = 0; i < list.get(3).length; i++) {
            list.get(3)[i] = i;
        }
        list.add(new int[0]);
        for (int i = 0; i < list.get(4).length; i++) {
            list.get(4)[i] = i;
        }
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
