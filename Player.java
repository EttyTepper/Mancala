package mancala;

public class Player {
	private Pit[] pits; 	//The array of pits
	private Mancala mancala;//The mancala 
	private String name;	//The name inputed by the user
	
	/**
	 * This method instantiates a player giving it an array of 6 pits and a mancala.
	 * @param name The name of the player the user entered.
	 */
	public Player(String name) {
		this.name = name;
		pits = new Pit[6];
		for(int x = 0; x < pits.length; x++) {
			pits[x] = new Pit();
		}
		mancala = new Mancala();
	}
	
	/**
	 * This method returns the array of pits.
	 * @return pits The array of pits.
	 */
	public Pit[] getPits() {
		return pits;
	}
	
	/**
	 * This method returns the mancala
	 * @return mancala The mancala
	 */
	
	public Mancala getMancala() {
		return mancala;
	}
	
	
	/**
	 * This method returns the name of the player.
	 * @return name The name of the player.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method checks to see if all the player's pits are empty
	 * @return true/false If empty it returns true, if not false.
	 */
	public boolean isempty() {
		for (int x = 0; x < pits.length; x++) {
			if(pits[x].getPebbles() > 0) {
				return false;
			}
		} return true;
		
		}

	
	}
	
	


