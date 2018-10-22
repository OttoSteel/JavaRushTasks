package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Path path = Paths.get(root);
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(path, myFileVisitor);
        return myFileVisitor.filesList;

    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        List<String> filesList = new ArrayList<>();

        public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
            File file = path.toFile();
            if(!(file.isDirectory())) {
               filesList.add(file.getAbsolutePath());
           }
            //System.out.println(file.getAbsolutePath());
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> result = getFileTree("d:/testJava");
        for (String file:result
             ) {
            System.out.println(file);
        }
    }

   /* static class MyFileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path path,
                                         BasicFileAttributes fileAttributes) {
            System.out.println("file name:" + path.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) {

        Path pathSource = Paths.get("d:/testJava");
        try {
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}
