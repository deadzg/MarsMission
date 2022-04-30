package com.smalwe.mars.robot;


/**
 * Class defining position of the robot
 */
public class Position {
    private Point point;
    private Direction direction;
    private boolean isLost;

    Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public boolean isLost() {
        return isLost;
    }

    public String toString() {
        String output = point.getX().toString() + " " + point.getY().toString() + " " + direction.getDirection();
        if(isLost) {
            return output + " " + "LOST";
        }
        return output;
    }
}
