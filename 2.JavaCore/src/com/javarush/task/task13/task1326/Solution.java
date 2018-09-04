package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        String fileName = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s;
        while((s=br.readLine())!=null){

            Integer number = Integer.parseInt(s);
            if (Math.abs((int)number) % 2 == 0)
                list.add(number);
        }
        br.close();

        //InputStream inStream = new FileInputStream(fileName); //  /home/kefir/textFile
        //while (inStream.available() > 0)
        //{
            //char number = (char) inStream.read();
            //if (Math.abs((int)number) % 2 == 0)
                //list.add((int)number);
            //list.add(number);
        //}
        //inStream.close();
        //reader.close();

        //int t;
        // int[] array = list.toArray();

        /*
        for (int i = 1; i < array.length; i++) {
            for (int j = array.length - 1; j >= i ; j--) {
                if (array[j - 1] > array[j]) {
                    t = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = t;
                }
            }
        }
        */
        Collections.sort(list);
        for (Integer i:list
             ) {
            System.out.println(i);
        }

        FileInputStream inStream = new FileInputStream(fileName);
        while (inStream.available() > 0)
            {
            char number = (char) inStream.read();
            //if (Math.abs((int)number) % 2 == 0)
            //list.add((int)number);
            //list.add(number);
            }
        inStream.close();

        /*
        public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите путь к файлу");
        String nameFile=bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream=new FileInputStream(nameFile);
        Scanner scanner=new Scanner(inputStream);

        List<Integer> array2=new ArrayList<>();

        while (scanner.hasNextLine()) {
            int line=Integer.parseInt(scanner.nextLine());
            if (line % 2 == 0 && line==0) {
                array2.add(line);
            }

        }
        Collections.sort(array2);




        inputStream.close();
        for (Integer numberless: array2
             ) {
            System.out.println(numberless);

        }


    }

}

         */



    }
}
