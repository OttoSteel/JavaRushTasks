package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human son1 = new Human("petia", true, 10);
        Human son2 = new Human("kolia", true, 11);
        Human son3 = new Human("misha", true, 12);
        ArrayList<Human> children = new ArrayList<>();
        children.add(son1);
        children.add(son2);
        children.add(son3);
        Human father = new Human("vasia", true, 30, children);
        Human mother = new Human("mania", false, 30, children);
        ArrayList<Human> parents1 = new ArrayList<>();
        parents1.add(father);
        ArrayList<Human> parents2 = new ArrayList<>();
        parents2.add(mother);
        Human grandpa1 = new Human("stepa",true, 60, parents1);
        Human grandma1 = new Human("lida",true, 60, parents1);
        Human grandpa2 = new Human("stepa",true, 60, parents2);
        Human grandma2 = new Human("lida",true, 60, parents2);

        System.out.println(grandpa1);
        System.out.println(grandpa2);
        System.out.println(grandma1);
        System.out.println(grandma2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean b, int i) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
