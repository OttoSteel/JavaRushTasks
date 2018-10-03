package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        /*Cat cat = new Cat();
        cat.name = "tom";
        cat.age = 3;
        cat.weight = 5;
        PrintWriter writer = new PrintWriter(new FileOutputStream("/home/kefir/textFile"));
        cat.save(writer);
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(new FileInputStream("/home/kefir/textFile")));
        cat.load(reader);
        Dog dog = new Dog();
        dog.name = "Sam";
        dog.age = 4;
        Human human = new Human();
        human.cat = cat;
        human.dog = dog;
        human.save(writer);
        human.load(reader);
        System.out.println(human);*/
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("/home/kefir/textFile", null);
            /*PrintWriter printWriter = new PrintWriter
                    (new FileOutputStream("/home/kefir/textFile"));
            BufferedReader bufferedReader = new BufferedReader
                    (new FileReader("/home/kefir/textFile"));*/
            OutputStream outputStream = new FileOutputStream("/home/kefir/textFile");
            InputStream inputStream = new FileInputStream("/home/kefir/textFile");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            /*for (Asset as:somePerson.assets
                 ) {
                System.out.println(as);
            }*/
            if (ivanov.equals(somePerson)) System.out.println("OK");

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(name);
            int assetsSize = assets.size();
            printWriter.println(assetsSize);
            if (assetsSize != 0) {
                for (Asset asset:assets
                     ) {
                    printWriter.println(asset.getName());
                    printWriter.println(asset.getPrice());
                }
            }
            printWriter.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            name = bufferedReader.readLine();
            String assetSizeString = bufferedReader.readLine();
            int assetsSize = Integer.parseInt(assetSizeString);
            if (assetsSize != 0) {
                for (int i = 0; i < assetsSize; i++) {
                    String assetName = bufferedReader.readLine();
                    String assetPriceString = bufferedReader.readLine();
                    double assetPrice = Double.parseDouble(assetPriceString);
                    assets.add(new Asset(assetName, assetPrice));
                }
            }

        }
    }
}
