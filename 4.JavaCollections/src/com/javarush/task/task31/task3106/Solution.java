package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(args[0]);
        List<String> sourceFiles = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            sourceFiles.add(args[i]);
        }
        Collections.sort(sourceFiles);
        List<FileInputStream> sourceStreams = new ArrayList<>();
        try
        {
            for(int i = 0; i < sourceFiles.size(); i++)
            {
                sourceStreams.add(new FileInputStream(sourceFiles.get(i)));
            }
        }
        catch (FileNotFoundException ignore)
        {
           /* NOP */
        }
        ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(Collections.enumeration(sourceStreams)));
        zipIn.getNextEntry();
        // Files.copy(zipIn, Paths.get(args[0]));
        byte[] buffer =new byte[1024];
        int countOfBytes;
        while ((countOfBytes = zipIn.read(buffer))>0) {
            fos.write(buffer, 0, countOfBytes);
            fos.flush();
        }
        zipIn.closeEntry();
        zipIn.close();
        fos.close();

    }
}
