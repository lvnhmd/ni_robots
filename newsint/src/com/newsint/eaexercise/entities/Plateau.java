package com.newsint.eaexercise.entities;

import com.newsint.eaexercise.exceptions.InstanceNotInitializedException;

/**
 * The Plateau class is a Singleton holding the coordinates of the grid
 * Lower left corner is always 0,0
 * 
 * @author elvinali
 *
 */
public class Plateau {
	
	private static Position upperRightCorner;
	private static Plateau plateau;

	
	protected Plateau(Position upperRightCorner) {
		
		Plateau.upperRightCorner = upperRightCorner;
		
	}
	
	/**
     * If an instance of Plateau does not exist 
     * instantiates a Plateau with specified upper right corner
     * 
     * @return instance of Plateau
     * @param  Position upperRightCorner
     * 
     */
	
	
	public static Plateau getInstance(Position upperRightCorner) {
    	
		if(plateau == null) 
			plateau = new Plateau(upperRightCorner);
    	
		return plateau;
    
	}
	
	/**
     * Determines whether a Position is within the boundaries
     * of Plateau  
     * 
     * @return boolean  
     * @param  Position upperRightCorner
     * 
     */
	
	public static boolean doesPlateauContain(Position position) throws InstanceNotInitializedException {
		
		if(plateau == null) 
			throw new InstanceNotInitializedException(Plateau.class.getName() + " is a Singleton and have not been initialized.");
		
		int x = position.getX();
		int y = position.getY() ;
		
		return(0 <=  x && x < upperRightCorner.getX() 
				&& 0 <= y && y <upperRightCorner.getY());
		
		
	}

}
