# Introduction
This repository contains the code to navigate a robot to Mars

## Assumptions
- The code assumes all the inputs entered are valid (inclusive of format and acceptable values)
- Each class/method has comments in the source code where ever relevant
- Test cases are covered in the MarsMissonTest class

## Pre-requisites
- Java 11 installed on the machine
- Gradle6 + installed on the machine
- CLI to execute the code

## Steps to build the jar
- Make sure you are on the root of the project
- Run : `./gradlew clean build`
    - This will compile, run the test cases and build the executable jar
- Navigate to `build/libs`
- Execute jar from commandline: ` java -jar MarsMission-1.0-SNAPSHOT.jar`
- Below is the sample input/output post execution of the jar:
```$xslt
Enter top right coordinates of grid:
5 3
Enter number of robots:
3
Enter start position of the robot 1:
1 1 E
Enter instructions for the robot:
RFRFRFRF
Enter start position of the robot 2:
3 2 N
Enter instructions for the robot:
FRRFLLFFRRFLL
Enter start position of the robot 3:
0 3 W
Enter instructions for the robot:
LLFFFLFLFL
===Output Below===
1 1 E
3 3 N LOST
2 3 S
```

