package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name = null;
    int age ;
    int weight ;
    String address = null;
    String color;

    public Cat(String name) {
        this.name = name;
        this.age = 3;
        this.weight = 3;
        this.color = "red";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "red";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 3;
        this.color = "red";
    }

    public Cat(int weight, String color) {
        this.age = 3;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color,String address) {
        this.address = address;
        this.age = 3;
        this.weight = weight;
        this.color = color;
    }


    public static void main(String[] args) {

    }
}
