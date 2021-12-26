package mancala;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome!! Let's play Mancala!");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter Player #1: ");
		String name1 = keyboard.nextLine();
		System.out.println("Enter Player #2: ");
		String name2 = keyboard.nextLine();
		
		//instantiates the game
		MancalaGame newGame = new MancalaGame(name1, name2);
		//starts the game
		newGame.playGame();	
		
	
	}

}
