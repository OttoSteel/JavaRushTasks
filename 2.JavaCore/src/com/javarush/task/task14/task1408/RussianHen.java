package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country {
    String country = RUSSIA;
    @Override
    public int getCountOfEggsPerMonth() {
        return 33;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
