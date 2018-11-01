package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

     /*   Map<String,ByteArrayOutputStream> content = new HashMap<>();
        try(
                ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
        ){


            ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) !=null){
                ByteArrayOutputStream by = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = zipIn.read(buf)) !=-1){
                    by.write(buf,0,count);
                }
                content.put(entry.toString(),by);
                zipIn.closeEntry();
            }
        try(ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));){
            String fileName = args[0].substring(args[0].lastIndexOf(File.separator)+1);
            entry = new ZipEntry("new/" +fileName );
            zipOut.putNextEntry(entry);
            Files.copy(Paths.get(args[0]),zipOut);
            zipOut.closeEntry();
            for (Map.Entry<String,ByteArrayOutputStream> pair:content.entrySet()
            ) {
                entry =new ZipEntry(pair.getKey());
                //System.out.println(pair.getKey()); //todo
                if(!entry.toString().endsWith(fileName)){
                    zipOut.putNextEntry(entry);
                    zipOut.write(pair.getValue().toByteArray());
                    zipOut.closeEntry();
                }
            }
        }
    }*/
     Map<String, ByteArrayOutputStream> zipContent = new HashMap<>();
     try (ZipInputStream zis = new ZipInputStream(new FileInputStream(args[1]))) {
         ZipEntry zipEntry;
         while ((zipEntry = zis.getNextEntry()) != null) {
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             byte[] buffer = new byte[1024];
             int count;
             while ((count = zis.read(buffer)) != -1) {
                 byteArrayOutputStream.write(buffer, 0, count);
             }
             zipContent.put(zipEntry.toString(), byteArrayOutputStream);
             zis.closeEntry();
         }
     }
     try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(args[1]))) {
         String fileName = Paths.get(args[0]).getFileName().toString();
         System.out.println("This is a fileName: " + fileName);
         ZipEntry zipEntry = new ZipEntry("new/" + fileName);
         zout.putNextEntry(zipEntry);
         Files.copy(Paths.get(args[0]), zout);
         zout.closeEntry();
         for (Map.Entry<String, ByteArrayOutputStream> pair:zipContent.entrySet()
              ) {
             zipEntry = new ZipEntry(pair.getKey());
             if (zipEntry.getName().endsWith(fileName)) {
                 System.out.println("This is a zipEntry.getName: " + zipEntry.getName());
             } else {
                 zout.putNextEntry(zipEntry);
                 zout.write(pair.getValue().toByteArray());
                 zout.closeEntry();
             }
         }


     }

    }
}
