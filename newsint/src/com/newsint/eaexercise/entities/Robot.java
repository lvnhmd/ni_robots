package com.newsint.eaexercise.entities;


import java.util.Iterator;
import java.util.List;

import com.newsint.eaexercise.command.Command;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;
import com.newsint.eaexercise.state.Direction;

/**
 * The Robot representation
 * This class contains and maintains the Robot Position and Direction
 * This class also provides a method to execute the commands issued by 
 * the Controller
 * 
 * @author elvinali
 *
 */

public class Robot {

	private Position position;
	private Direction direction;
	
	public Robot(Position position, Direction direction)	{
		this.position = position;
		this.direction = direction;
		
	}

	public Position getPosition() {
		
		return position;
	
	}

	public void setPosition(Position position) {
		
		this.position = position;
	
	}

	public Direction getDirection() {
		
		return direction;
	
	}

	public void setDirection(Direction direction) {
		
		this.direction = direction;
	
	}
	/**
     * Executes commands issued by the Controller
     * 
     * @param  List commands
     * @throws OutOfBoundsException if the robot tries to move outside of the 
     * 		   Plateau boundaries
     * @throws InstanceNotInitializedException if there is no instance of Plateau
     */
	public void executeCommands(List<Command> commands) throws OutOfBoundsException, InstanceNotInitializedException {
		 
		for (Iterator<Command> iterator = commands.iterator(); iterator.hasNext();) {
			Command command = (Command) iterator.next();
			command.execute(this);
		} 
	}
}
