package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = null;
        String file2 = null;
        try {
             file1 = reader.readLine();
             file2 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file1)))
        {
            //чтение построчно
            String s;
            while((s=br.readLine())!=null){
                allLines.add(s);
            }
        }
        catch(IOException ex){
        }

        try(BufferedReader br2 = new BufferedReader(new FileReader(file2)))
        {
            //чтение построчно
            String s;
            while((s=br2.readLine())!=null){
                forRemoveLines.add(s);
            }
        }
        catch(IOException ex){
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        /*Iterator iter = forRemoveLines.iterator();
        while (iter.hasNext()) {
            String s = (String) iter.next();

            if (allLines.contains(s)) {
                iter.remove();
            } else {

            }*/
       /* for (String s:forRemoveLines
             ) {
            if (allLines.contains(s)) {
                allLines.remove(s);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }*/

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
