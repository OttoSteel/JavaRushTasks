package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;   // /home/kefir/textFile
    public static String secondFileName;   // /home/kefir/textFile2

    //add your code here - добавьте код тут
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException ignore) {
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fullFileName;
        StringBuilder sb = new StringBuilder();

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return sb.toString();
        }

        public void run() {
            try {
                BufferedReader br = new BufferedReader(new FileReader(fullFileName));
                String str;
                while (true) {
                    str = br.readLine();
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str).append(" ");
                    }
                }
                br.close();
            } catch (FileNotFoundException ignore) {
            } catch (IOException ignore2) {
            }

        }
    }
}
