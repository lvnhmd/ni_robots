package com.newsint.eaexercise.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

public class RobotTest {

	private Robot robot;
	
	@Before
	public void setUp() throws Exception {
		
		Plateau.getInstance(new Position(5,5));
		robot = new Robot(new Position(1,2),Direction.NORTH);
		
	}

	@After
	public void tearDown() throws Exception {
		
		robot = null;
	}
	

	@Test
	public void testRobot() {
		
		assertEquals(robot.getPosition().getX(), 1);
		assertEquals(robot.getPosition().getY(), 2);
		assertEquals(robot.getDirection(), Direction.NORTH);
		
	}
	
	@Test
	public void testGetPosition() {
		
		Position position = robot.getPosition();
		
		assertEquals(position.getX(), 1);
		assertEquals(position.getY(), 2);
		
		position = null;
	}
	
	@Test
	public void testSetPosition() {
		
		Position position = new Position(5,5); 
		robot.setPosition(position);
		
		assertEquals(robot.getPosition().getX(), 5);
		assertEquals(robot.getPosition().getY(), 5);
		
		position = null;
		
	}
	
	@Test
	public void testGetDirection() {
		
		assertEquals(robot.getDirection(), Direction.NORTH);
		
	}

	@Test
	public void testSetDirection() {
		
		robot.setDirection(Direction.EAST);
		
		assertEquals(robot.getDirection(), Direction.EAST);
		
	}
	
	@Test
	public void testExecuteCommmands() {
	
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.TURN_LEFT);
		commands.add(Command.MOVE);
		commands.add(Command.TURN_LEFT);
		commands.add(Command.MOVE);
		commands.add(Command.TURN_LEFT);
		commands.add(Command.MOVE);
		commands.add(Command.TURN_LEFT);
		commands.add(Command.MOVE);
		commands.add(Command.MOVE);
		
		try {
			robot.executeCommands(commands);
		
		} catch (OutOfBoundsException | InstanceNotInitializedException e) {
			
			fail(e.getClass().getName() + " not expected.");
		
		}
		
		String testStr = 
				robot.getPosition().toString() + " " + robot.getDirection().toString();
		
		assertEquals(testStr, "1 3 N");
		
		testStr = null;
	}
	
	
	@Test(expected=OutOfBoundsException.class)	
	public void testExecuteCommmandsThrowOutOfBoundsException() throws OutOfBoundsException {
	
		robot.setPosition(new Position(5, 5));
		
		List<Command> commands = new ArrayList<Command>();
		commands.add(Command.MOVE);
		
		try {
			robot.executeCommands(commands);
		
		} catch (InstanceNotInitializedException e) {
			
			fail(e.getClass().getName() + " not expected.");
		
		}
		
		
	}
	
}

