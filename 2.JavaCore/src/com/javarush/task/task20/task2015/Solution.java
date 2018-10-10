package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        System.out.println("start");
        for (int i = 0; i < 3; i++) {
            speed++;
            System.out.println("is running ..." + speed);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
                /*NOP*/
            }
        }
        System.out.println("FINISH");
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        //out.defaultWriteObject();
        out.writeInt(speed);
        //System.out.println("### Saving object ###");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //in.defaultReadObject();
        speed = in.readInt();
        //System.out.println("### Reading object ###");
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution(5);
        ObjectOutputStream o = new ObjectOutputStream
                (new FileOutputStream("/home/kefir/textFile"));
        o.writeObject(solution);
        o.close();
        ObjectInputStream in = new ObjectInputStream
                (new FileInputStream("/home/kefir/textFile"));
        solution = (Solution)in.readObject();
    }
}
