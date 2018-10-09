package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        public OutputToConsole() {
        }

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputToConsole outputToConsole = new OutputToConsole(5);
        outputToConsole.printMessage();

        ObjectOutputStream o = new ObjectOutputStream
                (new FileOutputStream("/home/kefir/textFile"));
        o.writeObject(outputToConsole);
        o.close();
        ObjectInputStream in = new ObjectInputStream
                (new FileInputStream("/home/kefir/textFile"));
        outputToConsole = (OutputToConsole)in.readObject();
        outputToConsole.printMessage();
    }
}
