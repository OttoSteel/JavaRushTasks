package com.javarush.task.task19.task1905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        /*Customer customer = new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        };
        Contact contact = new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+3(805)0123-4567";
            }
        };
        DataAdapter dataAdapter = new DataAdapter(customer, contact);
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());*/
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.contact = contact;
            this.customer = customer;
        }

        @Override
        public String getCountryCode() {
            //return countries.get(customer.getCountryName());
            /*String country = null;
            switch (customer.getCountryName()) {
                case "Ukraine" :
                    country = "UA";
                    break;
                case "Russia" :
                    country = "RU";
                    break;
                case "Canada":
                    country = "CA";
                    break;
            }
            return country;*/
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                //if (customer.getCountryName().equals(entry.getValue())) return entry.getKey();
                if (customer.getCountryName().equals(entry.getValue())) return entry.getKey();
                //else return entry.getKey();
            }
            return "";
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            ArrayList<Character> digits = new ArrayList<>();
            digits.add('0');
            digits.add('1');
            digits.add('2');
            digits.add('3');
            digits.add('4');
            digits.add('5');
            digits.add('6');
            digits.add('7');
            digits.add('8');
            digits.add('9');
            StringBuilder phoneSB = new StringBuilder("callto://+");
            for (Character c:contact.getPhoneNumber().toCharArray()
                 ) {
                if (digits.contains(c)) {
                    phoneSB.append(c);
                }
            }
            return phoneSB.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}