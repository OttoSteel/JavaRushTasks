package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private int countOfDirs;
    private int countOfFiles;
    private long commonSize;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countOfDirs++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(path)) {
            preVisitDirectory(path, attrs);
        } else {
            countOfFiles++;
            commonSize += Files.size(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public int getCountOfDirs() {
        return countOfDirs;
    }

    public int getCountOfFiles() {
        return countOfFiles;
    }

    public long getCommonSize() {
        return commonSize;
    }
}
