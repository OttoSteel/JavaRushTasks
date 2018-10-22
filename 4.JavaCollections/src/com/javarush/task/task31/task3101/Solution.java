package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File file = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, file);
        fileSort(path, file);

//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        writer.close();

    }

    private static void fileSort(File path, File file) throws IOException {
        ArrayList<File> list = new ArrayList<>();
        recursivePath(path, list);
        list.sort(Comparator.comparing(File::getName));
        readAndWrite(list, file);
    }

    public static void recursivePath(File path,ArrayList<File> list) {
        for (File file : path.listFiles()) {
            if (file.isDirectory()){
                recursivePath(file,list);
            }

            if (file.length() <= 50) {
                list.add(file);
            }
        }

    }

    private static void readAndWrite(ArrayList<File> list, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        BufferedReader reader = null;
        try {


            for (File pp : list) {
                String str;
                reader = new BufferedReader(new FileReader(pp));
                while ((str = reader.readLine()) != null) {
                    writer.write(str + "\n");
                }
                reader.close();
            }


        }
        catch (IOException e){
            /*e.printStackTrace();*/
        } finally {
            writer.close();
        }
    }
}
/*import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

*//*
Проход по дереву файлов
*//*
public class Solution {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File folder = new File(path);
        File source = new File(resultFileAbsolutePath);
        File destination = new File(source.getParent() + "/allFilesContent.txt");

        // Renaming the files
        if((FileUtils.isExist(folder)) && (FileUtils.isExist(source)) ) {
            FileUtils.renameFile(source, destination);
        }

        // Searching the files with size less than 50
        Files.walkFileTree(folder.toPath(), new MyFileVisitor());

        // Writing content of files from set to allFilesContent.txt
        try(FileWriter fileWriter = new FileWriter(destination, true)) {
            for (File file:filesLess50
                 ) {
                try(FileReader fileReader = new FileReader(file)) {
                    char[] chars = new char[(int)file.length()];
                    fileReader.read(chars);
                    String content = new String(chars);
                    System.out.println(content);                      //todo
                    fileWriter.write(content);
                    fileWriter.write("/n");
                } catch (Exception ignore) {
                    *//* NOP *//*
                }
            }
        } catch (Exception ignore) {
            *//* NOP *//*
        }

    }
    // Creating class, that implements Comparator
    static class FileComparator implements Comparator<File> {
        public int compare(File a, File b){
            return a.getName().compareTo(b.getName());
        }
    }

    // Creating map of files less than 50
    static FileComparator fc = new FileComparator();
    static TreeSet<File> filesLess50 = new TreeSet<>(fc);

    // Creating MyFileVisitor class
    static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!(file.toFile().isDirectory()) && file.toFile().length() <= 50) {
                filesLess50.add(file.toFile());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}*/


