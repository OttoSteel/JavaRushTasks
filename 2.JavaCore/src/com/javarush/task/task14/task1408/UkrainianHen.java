package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen implements Country {
    String country = UKRAINE;
    @Override
    public int getCountOfEggsPerMonth() {
        return 32;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
