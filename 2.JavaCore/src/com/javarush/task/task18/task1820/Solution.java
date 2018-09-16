package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(file1);
        byte [] file1Bytes = new byte[inputStream.available()];

        inputStream.read(file1Bytes);
        inputStream.close();
        String string = new String(file1Bytes);                    //create string from byte array
        String [] stringArr = string.split(" ");
        String stringFromNumbers = "";
        for (int i = 0; i < stringArr.length; i++) {
            double tempNumber = Double.parseDouble(stringArr[i]);
            long tempNumber2 = (long) tempNumber;
            Long tempNumber3 = tempNumber2;
            if (tempNumber > 0) {
                if ((tempNumber - tempNumber2) >= 0.5) {
                    tempNumber3++;
                }
            } else if (tempNumber < 0) {
                    if ((tempNumber - tempNumber2) < -0.5) {
                        tempNumber3--;
                    }
                }

            String number = tempNumber3.toString();
            if (i == (stringArr.length - 1)) {
                stringFromNumbers = stringFromNumbers + number;
            } else {
                stringFromNumbers = stringFromNumbers + number + " ";
            }
        }

        byte [] result = stringFromNumbers.getBytes();          // now we have byte-array for writing

        OutputStream outputStream = new FileOutputStream(file2);
        outputStream.write(result);
        outputStream.close();
    }
}
