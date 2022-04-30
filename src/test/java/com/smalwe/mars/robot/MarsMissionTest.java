package com.smalwe.mars.robot;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to test the MarsMission class
 */
public class MarsMissionTest {

    @Test
    public void testSingleRobot_WithSamePosition() {
        int[][] grid = new int[6][4]; // Right corner coordinates 5,3
        Direction direction = new Direction("E", "N", "S", new Point(1, 0));
        Position startPos = new Position(new Point(1,1), direction);
        String ins = "RFRFRFRF";
        List<Instruction> instructionList = new ArrayList<>();
        for(String instruction : ins.split("")) {
            instructionList.add(Instruction.valueOf(instruction));
        }
        Position output = MarsMission.singleRobot(grid, startPos, instructionList);
        Assert.assertEquals("1 1 E", output.toString());
    }

    @Test
    public void testSingleRobot_WithLostPosition() {
        int[][] grid = new int[6][4]; // Right corner coordinates 5,3
        Direction direction = new Direction("N", "W", "E", new Point(0, 1));
        Position startPos = new Position(new Point(3,2), direction);
        String ins = "FRRFLLFFRRFLL";
        List<Instruction> instructionList = new ArrayList<>();
        for(String instruction : ins.split("")) {
            instructionList.add(Instruction.valueOf(instruction));
        }

        Position output = MarsMission.singleRobot(grid, startPos, instructionList);
        Assert.assertEquals("3 3 N LOST", output.toString());
    }

    @Test
    public void testSingleRobot_WithRobotScent() {
        int[][] grid = new int[6][4]; // Right corner coordinates 5,3
        grid[3][3] = -1; // Simulates the robot scent
        Direction direction = new Direction("W", "S", "N", new Point(-1, 0));
        Position startPos = new Position(new Point(0,3), direction);
        String ins = "LLFFFLFLFL";
        List<Instruction> instructionList = new ArrayList<>();
        for(String instruction : ins.split("")) {
            instructionList.add(Instruction.valueOf(instruction));
        }

        Position output = MarsMission.singleRobot(grid, startPos, instructionList);
        Assert.assertEquals("2 3 S", output.toString());
    }

    @Test
    public void testSingleRobot_WithInstructionEmpty() {
        int[][] grid = new int[6][4]; // Right corner coordinates 5,3
        Direction direction = new Direction("E", "N", "S", new Point(1, 0));
        Position startPos = new Position(new Point(1,1), direction);
        List<Instruction> instructionList = new ArrayList<>();

        Position output = MarsMission.singleRobot(grid, startPos, instructionList);
        Assert.assertEquals("1 1 E", output.toString());
    }

    @Test
    public void testSingleRobot_WithEmptyGrid() {
        int[][] grid = new int[0][0]; // Empty Grid
        Direction direction = new Direction("E", "N", "S", new Point(1, 0));
        Position startPos = new Position(new Point(1,1), direction);
        List<Instruction> instructionList = new ArrayList<>();

        Position output = MarsMission.singleRobot(grid, startPos, instructionList);
        Assert.assertEquals(null, output);
    }
}
