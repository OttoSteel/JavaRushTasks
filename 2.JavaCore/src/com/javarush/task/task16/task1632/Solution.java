package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
//        threads.add(new Thread1());
    }

    public static void main(String[] args) {
        //threads.get(2).start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
               while (true) {
                   try {
                       System.out.println("Ура");
                       Thread.sleep(500);

                   } catch (InterruptedException e) {

                   }
               }
            }

    }

    public static class Thread5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            int sum = 0;
            int i;
            while (true) {
                try {
                    if (reader.ready()) {
                        input = reader.readLine();
                        if (input.equals("N")) {
                            System.out.println(sum);
                            reader.close();
                            break;
                        } else {
                            i = Integer.parseInt(input);
                            sum += i;
                        }
                    }

                } catch (IOException ignore) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        static boolean isCancelled = false;
        @Override
        public void showWarning() {
           isCancelled = true;
        }

        @Override
        public void run() {
            while (true) {
                if (isCancelled) {
                    break;
                }
            }
        }
    }


}