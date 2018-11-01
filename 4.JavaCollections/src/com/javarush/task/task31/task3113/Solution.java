/*
package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

*/
/*
Что внутри папки? d:/testJava
*//*

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
        Path filePath = Paths.get(fileName);
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        if (filePath.normalize().toAbsolutePath().toFile().isDirectory()) {
            Files.walkFileTree(filePath, myFileVisitor);
            System.out.println("Всего папок - " + (myFileVisitor.getCountOfDirs() - 1));
            System.out.println("Всего файлов - " + myFileVisitor.getCountOfFiles());
            System.out.println("Общий размер - " + myFileVisitor.getCommonSize());
        } else {
            System.out.println(filePath.normalize().toAbsolutePath().toString() + " - не папка");
        }
    }
}
*/

package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Path path = Paths.get(reader.readLine());
            FileVizitor fileVizitor = new FileVizitor();
            /*if (!path.toFile().isDirectory())
            {
                System.out.println(path.toAbsolutePath() + " - не папка");

            }*/
            if (!Files.isDirectory(path)) {
                System.out.println(path.toAbsolutePath() + " - не папка");
                return;
            }
            else {
                Files.walkFileTree(path, fileVizitor);
                System.out.println("Всего папок - " + (fileVizitor.getFoldersCount() - 1));
                System.out.println("Всего файлов - " + fileVizitor.getFilesCount());
                System.out.println("Общий размер - " + fileVizitor.getSize());
            }

        }
    }

    static class FileVizitor extends SimpleFileVisitor<Path> {

        private int foldersCount = 0;
        private int filesCount = 0;
        private int size = 0;

        public int getFilesCount() {
            return filesCount;
        }

        public int getFoldersCount() {
            return foldersCount;
        }

        public int getSize() {
            return size;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            size += attrs.size();
            ++filesCount;
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            ++foldersCount;
            return super.postVisitDirectory(dir, exc);
        }
    }
}
