package com.newsint.eaexercise.command;

import com.newsint.eaexercise.entities.Robot;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;

/**
 * Implementation of Command pattern 
 * a Robot can be issued three commands L [turn left] R [turn right] M[move]
 * 
 * @author elvinali
 *
 */


public enum Command {
	
	TURN_LEFT	{
		
		public void execute(Robot robot) {
			
			robot.getDirection().turnLeft(robot); 
			
		}
		
		public String toString()	{
			
			return "L";
			
		}
		
	},
	
	TURN_RIGHT	{
		
		public void execute(Robot robot) {
			
			robot.getDirection().turnRight(robot); 
			
		}
		
		public String toString()	{
			
			return "R";
			
		}
	},
	
	MOVE	{
		
		public void execute(Robot robot) throws OutOfBoundsException, InstanceNotInitializedException	{
			
			robot.getDirection().move(robot); 
			
		}
		
		public String toString()	{
			
			return "M";
			
		}
		
	};
	
	public abstract void execute(Robot robot) throws OutOfBoundsException, InstanceNotInitializedException;

}
