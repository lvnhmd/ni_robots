package com.newsint.eaexercise.command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newsint.eaexercise.command.Command;
import com.newsint.eaexercise.entities.Plateau;
import com.newsint.eaexercise.entities.Position;
import com.newsint.eaexercise.entities.Robot;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;
import com.newsint.eaexercise.state.Direction;

public class CommandTest {

	private Robot robot; 
	private Command command;
	
	
	@Before
	public void setUp() throws Exception {
		
		Plateau.getInstance(new Position(5, 5));
		robot = new Robot(new Position(0,0),Direction.NORTH);
	
	}

	@After
	public void tearDown() throws Exception {
		
		robot = null;
		command = null;
		
	}

	@Test
	public void testTurnLeftCommand() {
		
		command = Command.TURN_LEFT;
		
			try {
				
				command.execute(robot);
			
			} catch (OutOfBoundsException | InstanceNotInitializedException e) {
				
				fail(e.getClass().getName() + " not expected.");
			
			}
		
		assertEquals(robot.getDirection(), Direction.WEST);
	
	}
	
	@Test
	public void testTurnLeftCommandToString() {
		
		command = Command.TURN_LEFT;
		assertEquals(command.toString(), "L");
	
	}
	
	@Test
	public void testTurnRightCommand() {
		
		command = Command.TURN_RIGHT;
		try {
			command.execute(robot);
		
		} catch (OutOfBoundsException | InstanceNotInitializedException e) {
			
			fail(e.getClass().getName() + " not expected.");
		
		}
		
		assertEquals(robot.getDirection(), Direction.EAST);
	
	}
	
	@Test
	public void testTurnRightCommandToString() {
		
		command = Command.TURN_RIGHT;
		
		assertEquals(command.toString(), "R");
	
	}
	
	@Test
	public void testMoveCommand() {
		
		command = Command.MOVE;
		try {
			command.execute(robot);
		
		} catch (OutOfBoundsException | InstanceNotInitializedException e) {
			
			fail(e.getClass().getName() + " not expected.");
		
		}
		
		assertEquals(robot.getPosition().getX(), 0);
		assertEquals(robot.getPosition().getY(), 1);
	}
	
	@Test
	public void testMoveCommandToString() {
		
		command = Command.MOVE;
		
		assertEquals(command.toString(), "M");
	}

}
