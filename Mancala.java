package mancala;

public class Mancala {
	//field that stores the number of pebbles for a mancala
	private int pebbles;
	
	/**
	 * This constructor starts the mancala off with 0 pebbles 
	 * by assigning pebbles to 0.
	 */
	public Mancala() {
		pebbles = 0;
	}
	
	/**
	 * This method returns the number of pebbles in the mancala.
	 * @return pebbles The number of pebbles in the mancala.
	 */
	public int getMancala() {
		return pebbles;
	}
	
	/**
	 * This method adds a specific amount of pebbles to the mancala.
	 * @param num The amount of pebbles specified that is passed in to be added to mancala.
	 */
	public void addPebbles(int num) {
		pebbles += num;
	}
	
	/**
	 * This method increments the mancala by one.
	 */
	public void addPebbles() {
		pebbles++;
	}	
	
}
