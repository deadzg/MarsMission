package com.smalwe.mars.robot;

import java.util.*;

/**
 * Class to accomplish Mars Mission
 */
public class MarsMission {

    private static  Direction north;
    private static Direction south;
    private static Direction east;
    private static Direction west;

    private static Map<String, Direction> directionMap = new HashMap<>();


    // Data Preparation
    static {
        north = new Direction("N", "W", "E", new Point(0, 1));
        east = new Direction("E", "N", "S", new Point(1, 0));
        south = new Direction("S", "E", "W", new Point(0, -1));
        west = new Direction("W", "S", "N", new Point(-1, 0));

        directionMap.put("N", north);
        directionMap.put("E", east);
        directionMap.put("S", south);
        directionMap.put("W", west);
    }

    public static void main(String[] args) {
        List<Position> output = new ArrayList<>();

        // Assumption: All the inputs entered as per the specified format and are valid
        // In future more logic can be added to handle any exceptions if the inputs are not in the correct format or invalid.
        // For now the focus is on building the core logic of Robot Navigation
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter top right coordinates of grid:");
        String coordinates = sc.nextLine();
        String[] coordinateValues = coordinates.split(" ");
        int[][] grid = new int[Integer.parseInt(coordinateValues[0] + 1)][Integer.parseInt(coordinateValues[1]) + 1];

        System.out.println("Enter number of robots:");
        int numRobots = Integer.parseInt(sc.nextLine());

        for(int i=1; i<= numRobots; i++) {
            System.out.println("Enter start position of the robot "+ i + ":" );
            String startPos = sc.nextLine();
            String[] startPosValues = startPos.split(" ");

            Point point = new Point(Integer.parseInt(startPosValues[0]), Integer.parseInt(startPosValues[1]));
            Position position = new Position(point, directionMap.get(startPosValues[2]));

            System.out.println("Enter instructions for the robot:");
            String[] instructions = sc.nextLine().split("");

            List<Instruction> instructionList = new ArrayList<>();
            for(String instruction : instructions) {
                instructionList.add(Instruction.valueOf(instruction));
            }
            output.add(singleRobot(grid, position, instructionList));
        }
        System.out.println("===Output Below===");
        for(Position p : output) {
            System.out.println(p.toString());
        }
    };

    /**
     * Method to help navigate the robot on the grid
     * @param grid 2D Array representing the grid
     * @param startPos Start position of the robot containing coordinates and direction
     * @param instructions Instructions to help navigate the bot
     * @return
     */
    public static Position singleRobot(int[][] grid, Position startPos, List<Instruction> instructions) {
        // Handling empty grid
        if(grid.length == 0) {
            return null;
        }
        Position currPos = startPos;
        for(Instruction i : instructions) {
            if(i.equals(Instruction.R)) {
                currPos.setDirection(directionMap.get(currPos.getDirection().getRight()));
            }
            if(i.equals(Instruction.L)) {
                currPos.setDirection(directionMap.get(currPos.getDirection().getLeft()));
            }
            if(i.equals(Instruction.F)){

                int nRow = currPos.getPoint().getX() + currPos.getDirection().getForward().getX();
                int nCol = currPos.getPoint().getY() + currPos.getDirection().getForward().getY();

                if(nRow <0 || nRow >=grid.length || nCol <0 || nCol >= grid[0].length) {

                    // Logic to ignore the instruction if the robot scent is present
                    if(grid[currPos.getPoint().getX()][currPos.getPoint().getY()] == -1) {
                        continue;
                    }

                    // Capture the robot scent if the robot is falling off the grid
                    grid[currPos.getPoint().getX()][currPos.getPoint().getY()] = -1;
                    currPos.setLost(true);
                    return currPos;
                }  else {
                    currPos.setPoint(new Point(nRow, nCol));
                }
            }
        }
        return currPos;
    }

}