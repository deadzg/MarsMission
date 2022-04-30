package com.smalwe.mars.robot;

/**
 * Class to represent direction of robot
 */
public class Direction {
    private String direction;
    private String left;
    private String right;
    private Point forward;

    public Direction (String direction, String left, String right, Point forward) {
        this.direction = direction;
        this.left = left;
        this.right = right;
        this.forward = forward;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Point getForward() {
        return forward;
    }

    public void setForward(Point forward) {
        this.forward = forward;
    }
}
