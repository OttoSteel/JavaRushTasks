package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args.length > 0) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                //чтение построчно
                String line;
                while ((line = br.readLine()) != null) {
                    stringArrayList.add(line);
                }
            } catch (IOException ignore) {
                /*NOP*/
            }

            if (args[0].equals("-d")) {
                for (String s : stringArrayList
                ) {
                    if (s.startsWith(args[1])) {
                        stringArrayList.remove(s);
                        break;
                    }
                }
                /*for (String s:stringArrayList
                     ) {
                    System.out.println(s);
                }*/
            }
            if (args[0].equals("-u")) {
                String[] args2 = new String[5];
                if (args.length > 5) {
                    args2[0] = args[0];
                    args2[1] = args[1];
                    args2[4] = args[args.length - 1];
                    args2[3] = args[args.length - 2];
                    StringBuilder argsSB = new StringBuilder();
                    for (int i = 2; i < (args.length - 2); i++) {
                        argsSB.append(args[i]).append(" ");
                    }
                    String newArgs = argsSB.toString().trim();
                    args2[2] = newArgs;
                } else {
                    args2[0] = args[0];
                    args2[1] = args[1];
                    args2[2] = args[2];
                    args2[3] = args[3];
                    args2[4] = args[4];
                }
                String newLine = args2[1];
                if (newLine.length() < 8) {
                    StringBuilder idSB = new StringBuilder(newLine);
                    for (int i = 0; i < (8 - newLine.length()); i++) {
                        idSB.append(" ");
                    }
                    newLine = idSB.toString();
                }
                String productName = args2[2];
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                    newLine = newLine + productName;
                } else if (productName.length() < 30) {
                    StringBuilder productNameSB = new StringBuilder(productName);
                    for (int i = 0; i < (30 - productName.length()); i++) {
                        productNameSB.append(" ");
                    }
                    newLine = newLine + productNameSB.toString();
                } else {
                    newLine = newLine + productName;
                }
                String price = args2[3];
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                    newLine = newLine + price;
                } else if (price.length() < 8) {
                    StringBuilder priceSB = new StringBuilder(price);
                    for (int i = 0; i < (8 - price.length()); i++) {
                        priceSB.append(" ");
                    }
                    newLine = newLine + priceSB.toString();
                } else {
                    newLine = newLine + price;
                }
                String quantity = args2[4];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                    newLine = newLine + quantity;
                } else if (quantity.length() < 4) {
                    StringBuilder quantitySB = new StringBuilder(quantity);
                    for (int i = 0; i < (4 - quantity.length()); i++) {
                        quantitySB.append(" ");
                    }
                    newLine = newLine + quantitySB.toString();
                } else {
                    newLine = newLine + quantity;
                }
                /*StringBuilder newLineSB = new StringBuilder("\n");
                newLineSB.append(newLine);*/

                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (stringArrayList.get(i).substring(0, 7).equals(newLine.substring(0, 7))) {
                        stringArrayList.set(i, newLine);
                        break;
                    }
                }
            }
            FileOutputStream outputStream = new FileOutputStream(fileName);
            for (int i = 0; i < stringArrayList.size(); i++) {
                if (i == 0) {
                    byte[] newLineBytes = stringArrayList.get(i).getBytes();
                   // System.out.print(stringArrayList.get(i));
                    outputStream.write(newLineBytes);
                } else {
                    StringBuilder newLineSB = new StringBuilder("\n");
                    newLineSB.append(stringArrayList.get(i));
                   // System.out.print(newLineSB.toString());
                    byte[] newLineBytes = newLineSB.toString().getBytes();
                    outputStream.write(newLineBytes);
                }
            }
            outputStream.close();
        }
    }
}
