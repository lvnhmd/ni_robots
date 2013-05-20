package com.newsint.eaexercise.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newsint.eaexercise.entities.Plateau;
import com.newsint.eaexercise.entities.Position;
import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;

public class PlateauTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetInstance() {
		
			assertNotNull(Plateau.getInstance(new Position(5,5)));
		
	}
	
	@Test
	public void testIsPlateauContains() {
		
			Position position = new Position(3,3);
			
			try {
			
				assertTrue(Plateau.doesPlateauContain(position));
			
			} catch (InstanceNotInitializedException e) {
				
				fail(e.getClass().getName() + " not expected.");
			
			}
			
		
	}
	
}
