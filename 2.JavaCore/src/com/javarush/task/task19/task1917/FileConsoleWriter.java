package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String var1) throws IOException {
        //super(new FileOutputStream(var1));
        this.fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(String var1, boolean var2) throws IOException {
        //super(new FileOutputStream(var1, var2));
        this.fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(File var1) throws IOException {
        //super(new FileOutputStream(var1));
        this.fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(File var1, boolean var2) throws IOException {
        //super(new FileOutputStream(var1, var2));
        this.fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(FileDescriptor var1) {
        //super(new FileOutputStream(var1));
        this.fileWriter = new FileWriter(var1);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.valueOf(cbuf).substring(off, off+len));
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off+len));
    }

    public void close() throws IOException {
        fileWriter.close();
    }


    public static void main(String[] args) {
    }
    /*1. Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter,
    которое не должно быть сразу проинициализировано.
2. Класс FileConsoleWriter должен иметь пять конструкторов
которые инициализируют fileWriter для записи.
3. Класс FileConsoleWriter должен содержать
метод write(char[] cbuf, int off, int len) throws IOException,
в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.

4. Класс FileConsoleWriter должен содержать метод write(int c) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.

5. Класс FileConsoleWriter должен содержать метод write(String str) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.

 6. Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.

 7. Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException,
 в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.

 8. Класс FileConsoleWriter должен содержать метод close() throws IOException,
 в котором должен вызываться такой же метод поля fileWriter.
*/
}
