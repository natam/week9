package org.morning_classes.day4.enums;

public class Main {
    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.FRIDAY;
        System.out.println(day.getNextDay());
        CardSuit card = CardSuit.getRandomSuit();
        System.out.println(card);
        Month month = Month.OCTOBER;
        System.out.println(month.getDays());
    }
}
