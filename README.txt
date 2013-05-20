ni_robots
=========
--------------------------------------------------------------------------------------------------------------------------------
Problem Statement
--------------------------------------------------------------------------------------------------------------------------------
A squad of robots will be landed on a plateau. This plateau, which is curiously rectangular, must be navigated by the robots so that their on-board cameras can get a complete view of the surrounding terrain to send back to controller.
A robot's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the robots is in the bottom left corner and facing North.
In order to control a robot, Controller sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintains the same heading.
Assume that the square directly North from (x, y) is (x, y+1).
INPUT:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the robots that have been deployed. Each robot has two lines of input. The first line gives the robot's position, and the second line is a series of instructions telling the robot how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the robot's orientation.
OUTPUT
The output for each rover should be its final co-ordinates and heading.
INPUT AND OUTPUT
Test Input:
5 5
1 2 N
LMLMLMLMM
Expected Output:
1 3 N


--------------------------------------------------------------------------------------------------------------------
Design considerations and assumptions :

A solution to this problem can be designed using State and Command patterns.
The position of a Robot will change depnding oon it's Direction(which is the State in this case).
Each command (turn right,turn left,move) is treated as member of the same Command family.
A Plateau is designed to be a Singleton as each robot will be deployed on the same Plateau.

Assumptions:
The calculations are based on the First quadrant of the Cartesian coordinate system. 
The lower-left coordinates of plateau are (0,0).
A square directly North from (x, y) is (x, y+1).
Only one robot is deployed at any give time ( a possible collision is not handled )
