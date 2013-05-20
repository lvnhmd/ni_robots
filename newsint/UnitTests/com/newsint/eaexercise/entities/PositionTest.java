package com.newsint.eaexercise.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newsint.eaexercise.entities.Position;

public class PositionTest {

	private Position position;
	
	@Before 
	public void setUp() throws Exception {
		
		position = new Position(1, 1);
		
	}
	
	@Test
	public void testPosition() {
		
		assertEquals(position.getX(), 1);
		assertEquals(position.getY(), 1);
		
	}

	@Test
	public void testIncrementX() {
		
		position.incrementX();
		assertEquals(position.getX(), 2);

	}

	@Test
	public void testDecrementX() {
		
		position.decrementX();
		assertEquals(position.getX(), 0);
	}

	@Test
	public void testIncrementY() {
		
		position.incrementY();
		assertEquals(position.getY(), 2);
	}

	@Test
	public void testDecrementY() {
		
		position.decrementY();
		assertEquals(position.getY(), 0);
	}

	@Test
	public void testToString() {
		
		assertEquals(position.toString(), "1 1");
	}

	
	@After
	public void tearDown() throws Exception {
		
		position = null;
	}
}
