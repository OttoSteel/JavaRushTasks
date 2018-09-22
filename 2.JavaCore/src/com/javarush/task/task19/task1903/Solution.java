package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 1;
            }

            @Override
            public int getPhoneNumber() {
                return 2;
            }
        };
        IncomeDataAdapter incomeDataAdapter = new IncomeDataAdapter(incomeData);
        System.out.println(incomeDataAdapter.getName());
        System.out.println(incomeDataAdapter.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return  data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder newPhoneSB = new StringBuilder();
            String oldPhone = ((Integer) data.getPhoneNumber()).toString(); // "501234567"
            ArrayList<Character> number = new ArrayList<>();

            // if old number is shorter than 10, then we add "0" in the beginning of the new number

            if (oldPhone.length() < 10) {
                for (int i = 0; i < (10 - oldPhone.length()); i++) {
                    newPhoneSB.append("0");
                }
                newPhoneSB.append(oldPhone);      // 0501234567
                oldPhone = newPhoneSB.toString(); // "0501234567"
            }

            for (Character c : oldPhone.toCharArray()
            ) {
                number.add(c);     // {0, 5, 0, 1, 2, 3, 4, 5, 6, 7 }
            }

            number.add(0, '(');    // (0501234567
            number.add(4, ')');    // (050)1234567
            number.add(8, '-');    // (050)123-4567
            number.add(11, '-');   // (050)123-45-67

            String phonePartOne = "+" + data.getCountryPhoneCode();  // "+38"
              // "(050)123-45-67"
            StringBuilder phonewPartTwoSB = new StringBuilder();
            for (Character c:number
                 ) {
                phonewPartTwoSB.append(c);
            }

            String phoneFinal = phonePartOne + phonewPartTwoSB.toString();    // "+38(050)123-45-67"

            return phoneFinal;
            /*return "+" + data.getCountryPhoneCode() + String.format(
                    "%010d",
                    data.getPhoneNumber()
            ).replaceFirst(
                    "(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
                    "($1)$2-$3-$4"
            );*/
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}