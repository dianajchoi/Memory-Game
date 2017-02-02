/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #3
 *
 * Design a memory card game using a 4x4 grid, and the following symbols
 * as the card values: ?, +, -, *, !, /, #, %
 *
 * Diana Choi
 */
package edu.cpp.cs.cs141.prog_assgmnt_3;

/**
 * This class represents the Game Engine, the logical brain behind the 
 * game. This class calculates values such as whether the game is over,
 * how many moves the user has currently used, and how to reset the game for
 * when the user wishes to start a new game.
 * 
 * @author Diana Choi
 *
 */
public class GameEngine {

	/**
	 * This field represents whether the game is over or not.
	 */
	private boolean gameOver;
	
	/**
	 * This field represents the number of moves the user has taken so far
	 * to find the matching pairs.
	 */
	private int moves;
	
	/**
	 * This field represents the board this class uses to reference when
	 * calculating whether or not the game is over. Additionally, the Board
	 * used in any instance of the game is stored in this class, so that this
	 * Board instance is the only one referenced during an instance of the game.
	 */
	private Board board;
	
	/**
	 * This constructor initializes all three fields of the class, using the
	 * parameter to initialize the board. {@link #gameOver} is initially set to
	 * false, and can be changed using a setter method in this class. Also, {@link #moves}
	 * is initially set to 0, as the user has not begun the game yet.
	 * @param b the board to be referenced and used in this instance of the Game Engine.
	 */
	public GameEngine(Board b) {
		gameOver = false;
		moves = 0;
		board = b;
	}
	
	/**
	 * This method checks if all the matching pairs have been found on the board by
	 * checking if there are any values still left on the grid of the board. If the
	 * board is empty, {@link #gameOver} is set to {@code true}. Otherwise, the field
	 * is left unchanged.
	 */
	public void checkGameOver(){
		if(board.isEmpty()){
			gameOver = true;
		}
	}
	
	/**
	 * This method is a getter method to access whether the game is over or not.
	 * @return whether the game is over or not (the value of {@link #gameOver}).
	 */
	public boolean isGameOver(){
		return gameOver;
	}
	
	/**
	 * This method increments the value of {@link #moves} by 1.
	 */
	public void newMove(){
		moves++;
	}
	
	/**
	 * This method is a getter method for the value of {@link #moves}.
	 * @return how many moves the user has taken so far in the game.
	 */
	public int getMoves(){
		return moves;
	}
	
	/**
	 * This method is a getter method for the Board instance stored in
	 * this class.
	 * @return the Board field.
	 */
	public Board getGrid(){
		return board;
	}
	
	/**
	 * This method is for resetting the game to its initial state so that a
	 * new game can begin without any lingering data from the previous game.
	 * This method also shuffles and deals the deck of cards onto the grid so
	 * that the game can begin immediately after this method is called.
	 */
	public void reset(){
		moves = 0;
		gameOver = false;
		board.shuffleCards();
	}
}
