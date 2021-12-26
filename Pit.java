package mancala;

public class Pit {
	//field that hold the number of pebbles
	private int pebbles;
	/**
	 * Constructor for pit class. Assigns each pit 4 pebbles to start.
	 */
	public Pit() {
		pebbles = 4;
	}
	
	/**
	 * This method returns the amount of pebbles in a specified pit.
	 * @return pebbles The number of pebbles in the pit.
	 */
	public int getPebbles() {
		return pebbles;
	}
	
	/**
	 * This method increments the number of pebbles by 1.
	 */
	public void addPebble() {
		pebbles++;
	}
	
	/**
	 * This method empties the pit, but assigning pebbles to 0.
	 */
	
	public void emptyPit() {
		pebbles = 0;
	}
	
	/**
	 * This method checks to see if a pit is empty or not.
	 * @param pit The specified pit to check if it's empty.
	 * @return a boolean either true or false. If pebbles is 0
	 * then true, otherwise false. 
	 */
	public boolean emptyPit(Pit pit) {;
		if (pit.pebbles == 0) {
			return true;
		}
		else{
			return false;
		}
	} 
	
}
