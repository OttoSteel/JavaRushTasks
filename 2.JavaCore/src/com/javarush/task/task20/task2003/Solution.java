package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        if (!properties.isEmpty()) {
            for (Map.Entry entry : properties.entrySet()) {
                props.setProperty(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        /*if (!properties.isEmpty()) {
            for (String key:properties.keySet()
                 ) {
                props.setProperty(key,properties.get(key));
            }
        }*/
        props.store(new PrintWriter(outputStream), "");

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);
        for ( String name: props.stringPropertyNames())
            properties.put(name, props.getProperty(name));
    }

    public static void main(String[] args) {

    }
}
