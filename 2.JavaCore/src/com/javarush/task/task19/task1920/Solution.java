package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        // 1. Программа НЕ должна считывать данные с консоли.
        // 2. Программа должна считывать содержимое файла (используй FileReader).
        TreeMap<String, Double> nameSalary = new TreeMap<>();
        Double maxSalary = 0.0;
        try(BufferedReader br = new BufferedReader(new FileReader(args[0])))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                String[] splittedS = s.split(" ");
                String first = splittedS[0];
                Double second = Double.parseDouble(splittedS[1]);
                if (nameSalary.containsKey(first)) {
                    nameSalary.put(first, nameSalary.get(first) + second);
                } else {
                    nameSalary.put(first, second);
                }
            }
        }
        catch(IOException ignore){
            /* NOP */
        }
        // 3. Поток чтения из файла (FileReader) должен быть закрыт.
        // 4. Программа должна выводить в консоль каждое имя и сумму всех его значений,
        // все данные должны быть отсортированы в возрастающем порядке по имени.
        for (Double val:nameSalary.values()
             ) {
            if (val > maxSalary) {
                maxSalary = val;
            }
        }

        Map sortedMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        sortedMap.putAll(nameSalary);

        Iterator<Map.Entry<String, Double>> iterator = sortedMap.entrySet().iterator();

        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Double> pair = iterator.next();
            String key = pair.getKey();            //ключ
            Double value = pair.getValue();        //значение

            if (value.equals(maxSalary)) {
                System.out.println(key);
            }
        }

    }
}
