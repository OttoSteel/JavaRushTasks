package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3= reader.readLine();
        reader.close();

        InputStream isFile2 = new FileInputStream(file2);
        InputStream isFile3 = new FileInputStream(file3);
        OutputStream osFile1 = new FileOutputStream(file1, true); // true -- allows to append

        byte [] file2Bytes = new byte[isFile2.available()];
        byte [] file3Bytes = new byte[isFile3.available()];

        int file2length = isFile2.read(file2Bytes);
        int file3length = isFile3.read(file3Bytes);

        osFile1.write(file2Bytes);
        osFile1.write(file3Bytes);



        osFile1.close();
        isFile2.close();
        isFile3.close();

    }
}
