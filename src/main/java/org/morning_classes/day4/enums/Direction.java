package org.morning_classes.day4.enums;

public enum Direction {
    NORTH(5,6),
    SOUTH(3,3),
    EAST(8,9),
    WEST(0,0);
    private int deltaX;
    private int deltaY;

    Direction(int x, int y){
        this.deltaX = x;
        this.deltaY = y;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }
}
