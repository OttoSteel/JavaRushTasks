package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human grandPaOne = new Human("Vasia", true, 60);
        Human grandPaTwo = new Human("Petia", true, 60);
        Human grandMaOne = new Human("Vera", false, 60);
        Human grandMaTwo = new Human("Liuba", false, 60);
        Human Father = new Human("Kolia", true, 30, grandPaOne, grandMaOne);
        Human Mother = new Human("Sveta", false, 30, grandPaTwo, grandMaTwo);
        Human son1 = new Human("Misha", true,10, Father, Mother);
        Human son2 = new Human("Grisha", true,11, Father, Mother);
        Human son3 = new Human("Fedia", true, 12, Father, Mother);

        System.out.println(grandPaOne);
        System.out.println(grandPaTwo);
        System.out.println(grandMaOne);
        System.out.println(grandMaTwo);
        System.out.println(Father);
        System.out.println(Mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;


        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















