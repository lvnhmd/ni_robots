package com.newsint.eaexercise.state;

import com.newsint.eaexercise.entities.Plateau;
import com.newsint.eaexercise.entities.Position;
import com.newsint.eaexercise.entities.Robot;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;

/**
 * Implementation of State pattern 
 * The four compass directions act as the Robot's states
 * Depending on which state a Robot is in ( which direction a Robot is facing )
 * new coordinates will be calculated and new direction will be set
 * 
 * @author elvinali
 *
 */


public enum Direction {
	
 NORTH {
  
	 
		public void move(Robot robot) throws OutOfBoundsException,InstanceNotInitializedException	{
			
			Position temp = robot.getPosition().copy();
			
			temp.incrementY();
			
			try{
			
				if(!Plateau.doesPlateauContain(temp)) {
				
					throw new OutOfBoundsException("The robot can not be moved to position (" + temp.toString() + ") as it is outside the plateau");
				
				}
			
			}catch(	InstanceNotInitializedException e){
				
				throw new InstanceNotInitializedException(e.getMessage());
				
			}
			
			
			robot.getPosition().incrementY();

		}

		
		public void turnRight(Robot robot) {
			
			robot.setDirection(Direction.EAST);

		}
		
		
		public void turnLeft(Robot robot) {
			
			robot.setDirection(Direction.WEST);

		}
		
		public String toString()	{
			
			return "N";
			
		}
	 
},

EAST {
	
	public void move(Robot robot) throws OutOfBoundsException,InstanceNotInitializedException {
		
		Position temp = robot.getPosition().copy();
		
		temp.incrementX();
		
		try{
		
			if(!Plateau.doesPlateauContain(temp)) {
			
				throw new OutOfBoundsException("The robot can not be moved to position (" + temp.toString() + ") as it is outside the plateau");
			
			}
		
		}catch(	InstanceNotInitializedException e){
			
			throw new InstanceNotInitializedException(e.getMessage());
			
		}
		
		
		robot.getPosition().incrementX();

	}

	
	public void turnRight(Robot robot) {
		
		robot.setDirection(Direction.SOUTH);

	}

	
	public void turnLeft(Robot robot) {
		
		robot.setDirection(Direction.NORTH);

	}
	
	public String toString()	{
		
		return "E";
		
	}
	
},

WEST {
	
	public void move(Robot robot) throws OutOfBoundsException, InstanceNotInitializedException {
		
		Position temp = robot.getPosition().copy();
		
		temp.decrementX();
		
		try{
		
			if(!Plateau.doesPlateauContain(temp)) {
			
				throw new OutOfBoundsException("The robot can not be moved to position (" + temp.toString() + ") as it is outside the plateau");
			
			}
		
		}catch(	InstanceNotInitializedException e){
			
			throw new InstanceNotInitializedException(e.getMessage());
			
		}
		
		robot.getPosition().decrementX();

	}

	
	public void turnRight(Robot robot) {
		
		robot.setDirection(Direction.NORTH);

	}

	
	public void turnLeft(Robot robot) {
		
		robot.setDirection(Direction.SOUTH);

	}
	
	public String toString()	{
		
		return "W";
		
	}
	
	
	
},
SOUTH {
	
	public void move(Robot robot) throws OutOfBoundsException, InstanceNotInitializedException	{
		
		Position temp = robot.getPosition().copy();
		
		temp.decrementY();
		
		try{
		
			if(!Plateau.doesPlateauContain(temp)) {
			
				throw new OutOfBoundsException("The robot can not be moved to position (" + temp.toString() + ") as it is outside the plateau");
			
			}
		
		}catch(	InstanceNotInitializedException e){
			
			throw new InstanceNotInitializedException(e.getMessage());
			
			
		}
		
		robot.getPosition().decrementY();

	}

	public void turnRight(Robot robot) {
		
		robot.setDirection(Direction.WEST);

	}

	public void turnLeft(Robot robot) {
		
		robot.setDirection(Direction.EAST);

	}
	
	public String toString()	{
		
		return "S";
		
	}
	
	
};
	
public abstract void move(Robot robot) throws OutOfBoundsException, InstanceNotInitializedException;
public abstract void turnRight(Robot robot);
public abstract void turnLeft(Robot robot);


}
