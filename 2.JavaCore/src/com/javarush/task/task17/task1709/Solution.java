package com.javarush.task.task17.task1709;

/* 
Предложения
*/

public class Solution {
    /*public static volatile int proposal = 0;

    public static void main(String[] args) {
        new AcceptProposal().start();
        new MakeProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }

            }
        }
    }*/

    public static int i = 0;

    public static void changeI() {
        int i = Solution.i;

        i++;

        Solution.i = i;

        System.out.println("Sol.i = " + Solution.i);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Solution.changeI();
    }
}
