package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country {
    String country = BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return 30;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
