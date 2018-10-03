package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("/home/kefir/textFile", null);
            OutputStream outputStream = new FileOutputStream("/home/kefir/textFile");
            InputStream inputStream = new FileInputStream("/home/kefir/textFile");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте
            // поле users для объекта javaRush тут
            User first = new User();
            first.setFirstName("Vasia");
            first.setLastName("Pupkin");
            first.setBirthDate(new Date());
            first.setMale(true);
            first.setCountry(User.Country.UKRAINE);
            javaRush.users.add(first);
            javaRush.save(outputStream);
            System.out.println(javaRush.users.get(0));
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object -
            // проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.get(0));
            if (javaRush.equals(loadedObject)) System.out.println("OK");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            int usersSize = users.size();
            printWriter.println(usersSize);
            if (usersSize != 0) {
                for (User user:users
                     ) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss:S");
                    printWriter.println(sdf.format(user.getBirthDate()));
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry().getDisplayedName());
                }
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(bufferedReader.readLine());
            if (usersSize != 0) {
                for (int i = 0; i < usersSize; i++) {
                    users.add(new User());
                    String firstName = bufferedReader.readLine();
                    users.get(i).setFirstName(firstName);
                    String lastName = bufferedReader.readLine();
                    users.get(i).setLastName(lastName);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss:S");
                    Date birthDate = sdf.parse(bufferedReader.readLine());
                    users.get(i).setBirthDate(birthDate);
                    String sex = bufferedReader.readLine();
                    users.get(i).setMale(sex.equals("true"));
                    //boolean isMale = sex.equals("true");
                    String countryStr = bufferedReader.readLine();
                    switch (countryStr) {
                        case "Ukraine" :
                            users.get(i).setCountry(User.Country.UKRAINE);
                            break;
                        case "Russia" :
                            users.get(i).setCountry(User.Country.RUSSIA);
                            break;
                        case "Other" :
                            users.get(i).setCountry(User.Country.OTHER);
                            break;
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
