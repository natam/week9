package org.morning_classes.day4.enums;

public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public DayOfWeek getNextDay(){
        return switch (this) {
            case SUNDAY -> MONDAY;
            case MONDAY -> TUESDAY;
            case TUESDAY -> WEDNESDAY;
            case WEDNESDAY -> THURSDAY;
            case THURSDAY -> FRIDAY;
            case FRIDAY -> SATURDAY;
            case SATURDAY -> SUNDAY;
            default -> null;
        };
    }
}
