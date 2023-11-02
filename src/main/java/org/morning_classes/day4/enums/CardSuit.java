package org.morning_classes.day4.enums;

import java.util.Random;

public enum CardSuit {
    HEARTS,
    DIAMONDS,
    CLUBS,
    SPADES;

    private static final Random random = new Random();
    public static CardSuit getRandomSuit(){
        CardSuit[] cardSuits = values();
        return cardSuits[random.nextInt(cardSuits.length)];
    }
}
