package mancala;
import java.util.*;
public class MancalaGame {
	private Player player1;
	private Player player2;
	
	/**
	 * This method instantiates the mancala game.
	 * @param name1 The name of player1.
	 * @param name2 The name of player2.
	 */
	public MancalaGame(String name1, String name2) {
		player1 = new Player(name1);
		player2 = new Player(name2);
	}
	
	/**
	 * This method starts the game. 
	 */
	public void playGame() {
		Player currPlayer = player1; //The current player starts off at player1
		boolean gameOver = false; //Instantiates gameOver to false so the game starts 
		
		while (!gameOver) {
			currPlayer = pitChoice(currPlayer); //Call to the pitChoice method, passing the currPlayer.
			gameOver = gameWinner(currPlayer); //Call to the gameWinner method, passing the currPlayer.
			}
		
		Pit[] pits = player1.getPits();
		Pit[] pitsOther = player2.getPits();
		if (gameOver) {
			int sumOfPits = 0;
				for (int i = 0; i < player1.getPits().length; i++) {
					sumOfPits += pits[i].getPebbles();
				}
				player1.getMancala().addPebbles(sumOfPits);
				sumOfPits = 0;
				for (int i = 0; i < player2.getPits().length; i++) {
					sumOfPits += pitsOther[i].getPebbles();
				}
				player2.getMancala().addPebbles(sumOfPits);
				
				System.out.println(player1.getName() + "'s Mancala: " + player1.getMancala().getMancala());
				System.out.println(player2.getName() + "'s Mancala: " + player2.getMancala().getMancala());				
			}
			if(player1.getMancala().getMancala() > player2.getMancala().getMancala()) {
				System.out.println("Congratulations " + player1.getName() + "! You won the game!");
			}
			else if (player2.getMancala().getMancala() > player1.getMancala().getMancala()){
				System.out.println("Congratulations " + player2.getName() + "! You won the game!");
			}
			else {
				System.out.println("The game has tied!");
			}
		}
		
	/**
	 * This method gives the current player a turn and using the rules
	 * of the game returns the currPlayer as player1 or player2.
	 * @param currPlayer The currPlayer passed to the method.
	 * @return currPlayer The newly assigned currPlayer. 
	 */
	
	
	public Player pitChoice(Player currPlayer) {
		Player otherPlayer;
		//Assigns the otherPlayer using if-else statement
		if (currPlayer == player1) {
			otherPlayer = player2;
		}
		else {
			otherPlayer = player1;
		}
		
		displayPits(currPlayer, otherPlayer); //call to the displayPits method which displays the mancala board
		Pit[] pits = currPlayer.getPits(); //currPlayer's pits are assigned to pits
		Pit[] pitsOther = otherPlayer.getPits(); //otherPlayer's pits are assigned to pitsOther
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print(currPlayer.getName() + ", Please enter the pit number: (1-6)");
		int choice = keyboard.nextInt() ; //currPlayer enters a number pit
		 
		//input validation that tests if the player's pit choice was invalid
		while(choice < 1 || choice > 6 || pits[choice - 1].getPebbles() == 0) {
			System.out.print(currPlayer.getName() + ", that was invalid! Please enter a different pit number: (1-6)");
			choice = keyboard.nextInt() ;
		}
		keyboard.nextLine(); //clears the buffer
		
		
		boolean thisSide = true; //instantiates a boolean that thisSide is true because default is that we start on this side.
		boolean goAgain = false;//instantiates a boolean goAgain that is set to false unless certain conditions change that.
		
		int amount = pits[choice-1].getPebbles();//a variable to hold the amount of pebbles in the chosen pit 
		
		int lastDrop = -1; //keeps track of where the last pit a pebble was dropped into
		pits[choice-1].emptyPit();//empties the pit the player chose
		
		//for loop loops through so long as it's less than the amount of pebbles 
		for (int i = 0; i < amount; i++) {
			//3 if-else statements that determine which pits to increment
			//increments pits of the current player
			if (choice % 13 < 6) {	
				 pits[choice%13].addPebble();
				 lastDrop = choice%13; //only need to assign lastDrop her because thisSide is true
				 goAgain = false;
				 thisSide = true;
			}
			//if up to the current player's mancala, increments the mancala
			else if(choice % 13 == 6) {
				currPlayer.getMancala().addPebbles();
				goAgain = true;
				thisSide = false;
			}
			//otherwise increments other player's pits
			else if(choice % 13 >= 7 ) {
				pitsOther[(choice%13)%7].addPebble();
				goAgain = false;
				thisSide = false;	
			}

			

				choice++;//increments choice by 1

			}
	
		//tests to see if the last pit that was on the current side has one, 
		//which means it was orignally empty
		if (thisSide && pits[lastDrop].getPebbles() == 1) {			 
				pits[lastDrop].emptyPit();
				currPlayer.getMancala().addPebbles(pitsOther[5-lastDrop].getPebbles()+1);
				pitsOther[5-lastDrop].emptyPit();

			}
			
		
		//tests to see if the current player should go again
		//if not reassigns current player to the other player
		if (!goAgain && !currPlayer.isempty()) {
			currPlayer = otherPlayer;
		}
	
		
		return currPlayer;

	}
	
	/**
	 * This method displays the mancala board, with the value of each pit
	 * @param currPlayer The current player, the one who's turn it is
	 * @param otherPlayer The other player
	 */
	public void displayPits(Player currPlayer, Player otherPlayer) {
		Pit[] pits = currPlayer.getPits();
		Pit[] pitsOther = otherPlayer.getPits();
		System.out.println("\t\t\t" + otherPlayer.getName() + "'s side");
		System.out.println();
		System.out.print(otherPlayer.getMancala().getMancala() + "\t");
		//displays the other players pits in reverse order
			for (int i = pits.length - 1; i >= 0; i--) {
				System.out.print(pitsOther[i].getPebbles() + "\t");
			}
			
		
			System.out.println();
			System.out.print("\t");
			for (int j = 0; j < pitsOther.length; j++) {
				System.out.print(pits[j].getPebbles() + "\t");
			}
			System.out.print(currPlayer.getMancala().getMancala() + "\n\n");
			System.out.println("\t\t\t" + currPlayer.getName() + "'s side");
			System.out.println();
	}
	
	/**
	 * This method checks to see if there is a winner
	 * @param currPlayer The player who's turn it is
	 * @return a boolean - true/false, whether game is over or not
	 */
	public boolean gameWinner(Player currPlayer) {
		boolean over = currPlayer.isempty();
		return over;
	}
}
