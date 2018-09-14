package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream component;

    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }

    @Override
    public void write(int i) throws IOException {
        component.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        component.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        component.write(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        component.flush();
        write("JavaRush © All rights reserved.".getBytes());
        component.close();
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
