package com.newsint.eaexercise.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newsint.eaexercise.entities.Plateau;
import com.newsint.eaexercise.entities.Position;
import com.newsint.eaexercise.entities.Robot;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;
import com.newsint.eaexercise.exceptions.OutOfBoundsException;
import com.newsint.eaexercise.state.Direction;

public class DirectionWestTest {

	private Robot robot;
	
	
	@Before
	public void setUp() throws Exception {
		
		Plateau.getInstance(new Position(5,5));
		robot = new Robot(new Position(1,1),Direction.WEST);
		
	}

	@After
	public void tearDown() throws Exception {
		
		robot = null;
	}
	

	
	@Test
	public void testMove() {
		
		try {
			robot.getDirection().move(robot);
		} catch (OutOfBoundsException | InstanceNotInitializedException e) {
			
			fail(e.getClass().getName() + " not expected.");
		
		}
		
		assertEquals(robot.getPosition().getX(),0);
		assertEquals(robot.getPosition().getY(),1);
			
	}

	@Test
	public void testTurnRight() {
		
		robot.getDirection().turnRight(robot);
		
		assertEquals(robot.getDirection(),Direction.NORTH);
	}

	@Test
	public void testTurnLeft() {
		
		robot.getDirection().turnLeft(robot);
		
		assertEquals(robot.getDirection(),Direction.SOUTH);
	}
	
	@Test
	public void testToString() {
		
		assertEquals(robot.getDirection().toString(), "W");
	}

	
}
