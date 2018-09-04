package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int left;
    int top;
    int width = 0;
    int height = 0;

    public Rectangle(int left, int top, int width, int height) {
        this.height = height;
        this.left = left;
        this.top = top;
        this.width = width;
    }

    public Rectangle(int left, int top) {
        this.left = left;
        this.top = top;
    }

    public Rectangle(int left, int top, int width) {
        this.height = width;
        this.left = left;
        this.top = top;
        this.width = width;
    }

    public Rectangle(Rectangle rectangle) {
        this.height = rectangle.height;
        this.left = rectangle.left;
        this.top = rectangle.top;
        this.width = rectangle.width;
    }



    public static void main(String[] args) {

    }
}
