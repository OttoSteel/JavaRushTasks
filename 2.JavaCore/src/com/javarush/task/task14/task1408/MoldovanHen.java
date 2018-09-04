package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
    String country = MOLDOVA;
    @Override
    public int getCountOfEggsPerMonth() {
        return 31;
    }

    public String getDescription() {
        return super.getDescription() + String.format(" Моя страна - %s. Я несу %d яиц в месяц.",
                country, getCountOfEggsPerMonth());
    }
}
