package com.javarush.task.task31.task3104;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* 
Поиск скрытых файлов
*/
public class Solution { //extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        /*EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();
        Files.walkFileTree(Paths.get("D:/"), options, 5, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }*/
        /*StringBuilder sb = new StringBuilder();
        sb.append("Test String");

        File f = new File("d:/test.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
        ZipEntry e = new ZipEntry("mytext.txt");
        out.putNextEntry(e);

        byte[] data = sb.toString().getBytes();
        out.write(data, 0, data.length);
        out.closeEntry();

        out.close();*/

        File someFile = new File("d:/testJava/someText.txt");
        // input file
        FileInputStream in = new FileInputStream(someFile);

        // out put file
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("d:/testJava/tmp.zip"));

        // name the file inside the zip  file
        out.putNextEntry(new ZipEntry("zippedjava.txt"));

        // buffer size
        byte[] b = new byte[1024];
        int count;

        while ((count = in.read(b)) > 0) {
            out.write(b, 0, count);
        }
        out.close();
        in.close();
    }



    /*private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if ( file.toString().toLowerCase().endsWith(".rar") || file.toString().toLowerCase().endsWith(".zip")) {
            archived.add(file.toString());
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }*/
}
