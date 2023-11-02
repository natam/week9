package org.morning_classes.day4.enums;

public enum TrafficLight {
    GREEN,
    YELLOW,
    RED;

    public TrafficLight getNextColor(){
        return switch (this){
            case RED -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
        };
    }
}
