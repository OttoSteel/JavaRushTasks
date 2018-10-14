package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("/home/kefir/textFile");
        solution.writeObject("test string");
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("/home/kefir/textFile"));
        o.writeObject(solution);
        //o.close();
        /*FileInputStream fin1 = new FileInputStream("/home/kefir/textFile");
        try (BufferedReader buf1 = new BufferedReader(new InputStreamReader(fin1));) {
            String s;
            while ((s = buf1.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception ignore) {
            *//* NOP *//*
        }*/
        FileInputStream fin = new FileInputStream("/home/kefir/textFile");
        ObjectInputStream in = new ObjectInputStream(fin);
        Solution solution2 = (Solution) in.readObject();
        solution2.writeObject("another string");

        try (BufferedReader buf = new BufferedReader(new InputStreamReader(fin));) {
            String s;
            while ((s = buf.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception ignore) {
            /* NOP */
        }

    }
}
