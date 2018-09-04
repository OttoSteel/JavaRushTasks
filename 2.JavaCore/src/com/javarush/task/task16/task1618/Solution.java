package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread test = new TestThread();
        test.start();
        Thread.sleep(2000);
        test.interrupt();

    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        /*
        public TestThread() {
            this.start();
        }
        */

        public void run(){
            /*
            int num = 0;
            while (!currentThread().isInterrupted()) {
                try {
                    Thread.sleep(500);
                    num++;
                    System.out.println("CHECK" + num);
                } catch (InterruptedException e) {
                    return;
                }
                */
            }
        }
    }
