package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    private ArrayList<String> array1 = new ArrayList<>();
    private ArrayList<String> array2 = new ArrayList<>();

    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();
        ArrayList<String> lastArray = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            try (BufferedReader bR1 = new BufferedReader(new FileReader(fileName1))) {
                String line = null;
                while ((line = bR1.readLine()) != null) {
                    array1.add(line);
                }
            }
            try (BufferedReader bR2 = new BufferedReader(new FileReader(fileName2))) {
                String line = null;
                while ((line = bR2.readLine()) != null) {
                    array2.add(line);
                }
            }
            while (!array1.isEmpty() && !array2.isEmpty())
                if (array1.get(0).equals(array2.get(0))) {
                    lines.add(new LineItem(Type.SAME, array1.remove(0)));
                    array2.remove(0);
                }
                else if (array2.size() == 1 || !array1.get(0).equals(array2.get(1)))
                    lines.add(new LineItem(Type.REMOVED, array1.remove(0)));
                else
                    lines.add(new LineItem(Type.ADDED, array2.remove(0)));


            if (array1.size() > array2.size())
                lines.add(new LineItem(Type.REMOVED, array1.remove(0)));
            else
                lines.add(new LineItem(Type.ADDED, array2.remove(0)));

        }
        catch (IOException e) {e.printStackTrace();}

        // for (LineItem s : lines) System.out.println(s.line + " " + s.type);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
