package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private char sex;
        private String address;
        private int school;
        private String skill;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, char sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, int age, char sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, char sex, int age, String address) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String name, int age, char sex, String address, int school) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.school = school;
        }

        public Human(String name, int age, char sex, int school) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.school = school;
        }

        public Human(String name, int age, char sex, String address) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, String skill, int school) {
            this.name = name;
            this.skill = skill;
            this.school = school;
        }

    }
}
