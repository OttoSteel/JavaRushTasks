package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        /*Path path = Paths.get("/home/kefir/textFile4");
        PersonScannerAdapter personScannerAdapter =
                new PersonScannerAdapter(new Scanner(path));
        System.out.println(personScannerAdapter.read());*/
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            //fileScanner.hasNextLine();
            //String line = fileScanner.nextLine();

            String[] splittedLine = fileScanner.nextLine().split(" ");
            //SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            //String date = String.format("%ss %ss %ssss", splittedLine[3], splittedLine[4],
                    //splittedLine[5]);
            String date = splittedLine[3] + " " + splittedLine[4] + " " +
                    splittedLine[5];
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                Date birthdate = sdf.parse(date);
                return new Person(splittedLine[1], splittedLine[2], splittedLine[0], birthdate);
            } catch (ParseException ignore) {
                /*NOP*/
            }
            return null;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
