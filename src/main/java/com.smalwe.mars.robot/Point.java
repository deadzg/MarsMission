package com.smalwe.mars.robot;

/**
 * Class defining the coordinates on the grid
 */
public class Point {
    private Integer x;
    private Integer y;

    Point (Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
