package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(address);
            objectOutput.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
           // while (objectInput.available() > 0) {
                address = (String) objectInput.readObject();
                year = objectInput.readInt();
           // }
        }
    }

    public static void main(String[] args) throws
            IOException, ClassNotFoundException {
        Apartment apartment = new Apartment("House", 1111);
//        apartment.address = "House";
//        apartment.year = 1987;
        System.out.println(apartment);
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("/home/kefir/textFile"));
        o.writeObject(apartment);
        o.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("/home/kefir/textFile"));
        apartment = (Apartment)in.readObject();
        System.out.println(apartment);
    }
}
