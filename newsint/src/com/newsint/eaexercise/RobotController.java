package com.newsint.eaexercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newsint.eaexercise.command.Command;
import com.newsint.eaexercise.entities.Plateau;
import com.newsint.eaexercise.entities.Position;
import com.newsint.eaexercise.entities.Robot;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;
import com.newsint.eaexercise.state.Direction;

/**
 * This class reads and validates user input
 * instantiates Plateau and issues commands to 
 * a Robot
 * 
 * This class contains the main method to launch the application
 * 
 * @author elvinali
 */

public class RobotController {
	
	private static Scanner in;
	private static String plateauCoordsStr;
	private static String robotPositionStr;
	private static String commandSeqStr;
	
	/**
	 * Reads and validates console input 
	 *
	 */
	
	private static void readUserInput() {
		
		in = new Scanner(System.in);
        
        System.out.println("Please enter upper-right coordinates of the plateau:");
        
        plateauCoordsStr =in.nextLine().trim();      
        
        while (!plateauCoordsStr.matches("\\d+ \\d+"))
        {
        	System.out.println("Invalid coordinates. Please enter upper-right coordinates of the plateau: eg 5 5");
        	plateauCoordsStr =in.nextLine().trim();
        }
        
        System.out.println("Please enter robot's position:");
		
        robotPositionStr =in.nextLine().toUpperCase().trim();
        
        while (!robotPositionStr.matches("\\d+ \\d+ [NEWS]"))
        {
        	System.out.println("Invalid robot position. Please enter robot's position: eg 1 2 N" );
        	robotPositionStr =in.nextLine().toUpperCase().trim();
        }
		
        System.out.println("Please enter series of instructions:");
        
        commandSeqStr = in.nextLine().toUpperCase().trim();
        
        while( !commandSeqStr.matches("[LMR]+") ) 
        {
        	
        	System.out.println("Invalid instruction series. Please enter series of instructions: eg LMLMLMLMM" );
        	commandSeqStr =in.nextLine().toUpperCase().trim();
        	
        }
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		readUserInput();
		
		String[] splits = plateauCoordsStr.split(" ");
		Position upperRightCorner = new Position(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
		
		Plateau.getInstance(upperRightCorner);
		
		splits = robotPositionStr.split(" ");
		Position robotPosition = new Position(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
		
		Direction robotDirection = null;
		for (Direction d : Direction.values()) {
		     if(d.toString().equals(splits[2])){
		    		 robotDirection = d;
		    		 break;
		     }	 
		 }
		
		Robot robot = new Robot(robotPosition,robotDirection);
		
		splits = commandSeqStr.split("");
		List<Command> commands = new ArrayList<Command>();
		for (int i = 0; i < splits.length; i++) {
			
			for (Command c : Command.values()) {
			     if(c.toString().equals(splits[i])){
			    	 	 commands.add(c); 
			    		 break;
			     }	 
			 }
			
			
		}
		
		try {
			
			robot.executeCommands(commands);
			System.out.println(robot.getPosition().toString() + " " + robot.getDirection().toString());
			
		} catch (OutOfBoundsException e) {
			
			System.out.println(e.getMessage());
		
		} catch (InstanceNotInitializedException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
