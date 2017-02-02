/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #3
 *
 * Design a memory card game using a 4x4 ge.getGrid(), and the following symbols
 * as the card values: ?, +, -, *, !, /, #, %
 *
 * Diana Choi
 */
package edu.cpp.cs.cs141.prog_assgmnt_3;

import java.util.Scanner;

/**
 * This class represents the User Interface which interacts with user input, both
 * prompting for and receiving whatever the user types in, and analyzing it to
 * print out an appropriate response. This class is where all the text is displayed
 * from, including the "board" and the instructions and main menu.
 * 
 * @author Diana Choi
 *
 */
public class UserInterface {
	
	/**
	 * This field represents the Scanner that reads all the user inputs during the game.
	 */
	private static Scanner s = new Scanner(System.in);
	
	/**
	 * This field represents the Game Engine that helps perform all the logical mechanisms
	 * for the game. It is initialized in the constructor.
	 */
	private static GameEngine ge;
	
	/**
	 * The constructor takes in a {@link GameEngine} as an argument in order to initialize the
	 * {@link #ge}'s value.
	 * @param GE the game engine to be used in this instance of the game.
	 */
	public UserInterface(GameEngine GE) {
		ge = GE;
	}
	
	/**
	 * This method is the initial method to be called to begin the game. It internally calls the
	 * subsequent method, which, in turn, also internally calls the next method, so that the Main
	 * class does not have to call each individual method in the correct sequence, and only needs
	 * to call this beginning method to begin the game. This method prints the welcome message, and
	 * allows the user to choose option 1 (which leads to the instructions) or option 2 (which leads
	 * directly into the game).
	 */
	public static void welcomeMessage(){
		System.out.println("Welcome to the Memory Card Game.");
		System.out.println("Enter the number of the option you wish to explore.");
		System.out.println("1. Instructions\n2. Start Game");
		int choice = errorCheckInt(1, 2);
		if(choice == 1){
			printInstructions();
		}else{
			startGame();
		}
	}
	
	/**
	 * This method prints out the instructions to the game, including how the user is supposed to input
	 * their choices for choosing a card. Additionally, as practice for user input calibration, there is
	 * a password necessary to begin the game.
	 */
	public static void printInstructions(){
		System.out.println("Instructions:\nThis is a memory game played with cards.");
		System.out.println("There are 8 different pairs of cards, each with one of the following unique symbols: *, !, /, #, -, %, +, ?");
		System.out.println("To flip over a card, first enter the row number of the card, then the column number.");
		System.out.println("Each time you flip a card, it counts as a move.");
		System.out.println("You can have two cards face up at a time. If they match, they'll be removed from the board.");
		System.out.println("If they do not match, they are turned face down again, and you will choose two more cards to flip.");
		System.out.println("Flip over all the pairs to win!");
		System.out.println("At the end of the game, you will see how many moves you took to find all the pairs.");
		System.out.println("When you are ready to begin, enter \"Coffee\" to begin playing.");
		System.out.println("(The keyword to begin is case-sensitive.)");
		System.out.println("Keyword: ");
		String input = errorCheckString("Coffee");
		startGame();
	}
	
	/**
	 * This method effectively begins the game and is the central method that runs the game. It begins by resetting
	 * the game via the GameEngine reset method which shuffles and reassigns the cards on the grid. Then,
	 * the grid is continuously printed out after every move, that is, each time a card is flipped face-up, and each
	 * time the cards are all flipped face-down. After every turn, the method checks if all the pairs have been found,
	 * and if so, the game is over and the method ends with the end message.
	 */
	public static void startGame(){
		ge.reset();
		System.out.println("-----------------------------------------------------------------------------------------\n");
		printBoard();
		while(!ge.isGameOver()){
			if(ge.getGrid().numOfFaceUp() < 2){
				chooseCard();
			}else{
				if(ge.getGrid().matchPair()){
					System.out.println("Match found!\n");
					ge.getGrid().clearMatchingPair();
				}else{
					System.out.println("No match.\n");
					ge.getGrid().flipAllCardsDown();
				}
				ge.newMove();
			}
			printBoard();
			ge.checkGameOver();
		}
		endMessage();
	}
	
	/**
	 * This method is for flipping a card face-up based upon the user input.
	 */
	public static void chooseCard(){
		System.out.println("Choose a row (1 to 4): ");
		int x = errorCheckInt(1, 4);
		System.out.println("Choose a column (1 to 4): ");
		int y = errorCheckInt(1, 4);
		if(ge.getGrid().getCard(x - 1, y - 1) == null){
			System.out.println("No card there!");
		}else if(ge.getGrid().getCard(x - 1,  y - 1).isCardFlipped()){
			System.out.println("This card is already face up!");
		}else{
			ge.getGrid().flipCard(x - 1, y - 1);
		}
	}
	
	/**
	 * This method is for asking the user for a valid input each time an unrecognized or
	 * improper input is received. This method is specifically for checking if the inputed
	 * integer is within the allowed range.
	 * @param min the minimum value the user's inputed integer can be.
	 * @param max the maximum value the user's inputed integer can be.
	 * @return the first proper inputed integer by the user.
	 */
	public static int errorCheckInt(int min, int max){
		int input = s.nextInt();
		while(input < min || input > max){
			System.out.println("Invalid input. Try again: ");
			input = s.nextInt();
		}
		return input;
	}
	
	/**
	 * This method is for asking the user for a valid input each time an unrecognized
	 * or improper input is received. This method is specifically for checking if the
	 * inputed String is the same as the keyword.
	 * @param keyword the word being compared to the user's input.
	 * @return the first proper inputed String by the user.
	 */
	public static String errorCheckString(String keyword){
		String input = s.next();
		while(!input.equals(keyword)){
			System.out.println("Invalid input. Try again: ");
			input = s.next();
		}
		return input;
	}
	
	/**
	 * This method is an overloaded version of {@link #errorCheckString(String)}. This method
	 * allows for two keywords to be compared to the user's input.
	 * @param keyword1 one of the choices for acceptable user inputs.
	 * @param keyword2 the other choice for acceptable user inputs.
	 * @return the first proper inputed String by the user.
	 */
	public static String errorCheckString(String keyword1, String keyword2){
		String input = s.next();
		while(!input.equals(keyword1) && !input.equals(keyword2)){
			System.out.println("Invalid input. Try again: ");
			input = s.next();
		}
		return input;
	}

	/**
	 * This method prints out the grid using the Board instance in the {@link #ge}.
	 */
	public static void printBoard(){
		System.out.println(ge.getGrid().drawBoard());
	}
	
	/**
	 * This method prints out the end message, which is when the user has successfully found
	 * all 8 pairs, and prints out the number of moves the user took to complete the game. This
	 * method also asks if the user would like to start the game again, in which case, the
	 * {@link #startGame()} method would be called once more. Otherwise, the method prints out a
	 * thank-you message and no further subsequent methods are called.
	 */
	public static void endMessage(){
		System.out.println("Congratulations! You found all the pairs in " + ge.getMoves() + " moves!");
		System.out.println("Would you like to play again? (Y/N): ");
		String choice = errorCheckString("Y", "N");
		if(choice.equals("Y")){
			ge.reset();
			System.out.println("\n");
			welcomeMessage();
		}else{
			System.out.println("Thank you for playing!");
		}
	}
	
}
