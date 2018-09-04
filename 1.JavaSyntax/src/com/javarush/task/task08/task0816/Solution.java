package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        //map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Chikkone", df.parse("JANUARY 24 1981"));
        map.put("Calsone", df.parse("FEBRUARY 1 1980"));
        map.put("Pistone", df.parse("MARCH 1 1980"));
        map.put("Morrikone", df.parse("APRIL 1 1980"));
        map.put("Costello", df.parse("MAY 1 1980"));
        map.put("Mozarello", df.parse("JUNE 1 1980"));
        map.put("Donatello", df.parse("JULY 1 1980"));
        map.put("Micelangelo", df.parse("SEPTEMBER 1 1980"));
        map.put("Stullone", df.parse("OCTOBER 1 1980"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        //Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        //while (iterator.hasNext())
        //{
            //получение «пары» элементов
            //HashMap.Entry<String, Date> pair = iterator.next();
            //String key = pair.getKey();
            //Date value = pair.getValue();
            //if (map.get(key).getMonth() > 4 && map.get(key).getMonth() < 8)
                //map.remove(key);
        //}
        Iterator<Map.Entry<String, Date>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry<String, Date> pair = it.next();
            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8 )
                it.remove();
        }

        //Iterator<String> iterator = map.keySet().iterator();

        //while (iterator.hasNext())        //проверка, есть ли ещё элементы
        //{
            //получение текущего элемента и переход на следующий
            //String key = iterator.next();
            //if (map.get(key).getMonth() > 4 && map.get(key).getMonth() < 8)
                //map.remove(key);

        //}
        //return map;

    }

    public static void main(String[] args) throws ParseException {
        //System.out.println(removeAllSummerPeople(createMap()));



    }
}
