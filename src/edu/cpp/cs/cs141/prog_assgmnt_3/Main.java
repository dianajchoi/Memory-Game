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
 * This class represents where the program is launched from. It calls
 * the initial method that starts the chain of actions and methods from
 * the User Interface class and instantiates all objects necessary, such
 * as the Game Engine and the Board.
 * 
 * @author Diana Choi
 *
 */
public class Main {
	
	/**
	 * This field is the Board that the Game Engine refers to and receives as
	 * a parameter for instantiation.
	 */
	private static Board board;
	
	/**
	 * This field is the Game Engine that the User Interface refers to and
	 * receives as a parameter for instantiation.
	 */
	private static GameEngine ge;
	
	/**
	 * This field represents the instance of the User Interface class that
	 * will help launch the program from this class.
	 */
	private static UserInterface UI;

	/**
	 * This constructor initializes all the fields above to be new instances
	 * of their respective classes.
	 */
	public Main() {
		board = new Board();
		ge = new GameEngine(board);
		UI = new UserInterface(ge);
	}
	
	/**
	 * This method is the method called in order to make the program
	 * run. In this method, the initial method for the User Interface
	 * class is called, effectively beginning the game.
	 * @param args the methods and classes to be called and accessed
	 * using this method.
	 */
	public static void main(String[] args){
		Main main = new Main();
		UI.welcomeMessage();
	}

}
