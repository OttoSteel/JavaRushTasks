package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
        //downloadFile("http://udaff.com/image/53/68/536869.jpg", Paths.get("d:/testJava"));
       /* URL url  = new URL("http://udaff.com/image/53/68/536869.jpg");
        Path path = Paths.get(url.getFile());
        System.out.println(path.toString());
        System.out.println(path.getFileName().toString());*/
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        /*URL url = new URL(urlString);

        // Creating temporary file
        Path tempFile = Files.createTempFile(downloadDirectory, "temp-", ".tmp");

        // Creating InputStream for downloading the file
        try (InputStream in = url.openStream()) {
            Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
        }

        // Creating result file
        Path result = Paths.get(url.getFile());
        String fileName = downloadDirectory.toString() + "/" + result.getFileName().toString();
        //System.out.println(fileName);
        Path file = Paths.get(fileName);
        //Files.createFile(file);

        // Moving downloaded directory
        return Files.move(tempFile, file, StandardCopyOption.REPLACE_EXISTING);*/
        Path result=Paths.get(downloadDirectory.toString(),urlString.split(".+/",2)[1]);
        URL url=new URL(urlString);
        InputStream i=url.openStream();

//Path tmp=Paths.get(Files.createTempFile("name-[", "]").toString().split(".+\\\\",2)[1]); //тут из пути вырезаем имя временного файла, оставляя только путь до него.
        Path tmp=Files.createTempFile("name-[", "]"); //А здесь в пути указано также и имя этого созданного файла, поэтому и возникает ошибка при попытке работать с этим путём.

        Files.copy(i,tmp);
        i.close();
        Files.move(tmp,result);
        return result;

    }
}
