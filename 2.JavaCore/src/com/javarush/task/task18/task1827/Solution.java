package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        if (args.length > 0) {

            long max = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                //чтение построчно
                String line;
                while ((line = br.readLine()) != null) {
                    String idStr  = line.substring(0, 8);
                    if (idStr.endsWith(" ")) {
                        idStr = idStr.substring(0, idStr.indexOf(" "));
                    }
                    long id = Long.parseLong(idStr);

                    if (id > max) {
                        max = id;
                    }
                }
            } catch (IOException ignore) {
                /*NOP*/
            }

            max++;
            String newLine = "" + max;
            if (newLine.length() < 8) {
                for (int i = 0; i < (8 - newLine.length()); i++) {
                    newLine = newLine + " ";
                }
            }
            String productName = args[1];
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
            String price = args[2];
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
            String quantity = args[3];
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
            StringBuilder newLineSB = new StringBuilder("\n");
            newLineSB.append(newLine);

            // now we transform newLine into a byte array

            byte[] newLineBytes = newLineSB.toString().getBytes();
            FileOutputStream outputStream = new FileOutputStream(fileName, true);
            outputStream.write(newLineBytes);
            outputStream.close();
        }
    }
}
