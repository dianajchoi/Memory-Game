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
 * This class represents the concept of a card. It has the general aspects of a card,
 * namely, if the card has been flipped over, and the ability to change that state.
 * 
 * @author Diana Choi
 *
 */
public abstract class Card {

	/**
	 * This field represents whether the card is showing its value to the player or not.
	 */
	private boolean isFlipped;
	
	/**
	 * This field represents the symbol on the card that acts as the identifying factor
	 * in the game.
	 */
	private String type;
	
	/**
	 * This constructor initializes the value of  {@link #isFlipped} to {@code false}.
	 */
	public Card() {
		isFlipped = false;
	}

	/**
	 * This method allows the program to change the value of {@link #isFlipped} to the
	 * opposite of what it was. If the card was face-up, or showing its value to the player,
	 * then calling this method will then hide the value, and vice versa.
	 */
	public void flipCard(){
		isFlipped = !isFlipped;
	}
	
	/**
	 * This method is for the subclasses to set what symbol the card holds.
	 * @param type the symbol the card has.
	 */
	public void setType(String type){
		this.type = type;
	}
	
	/**
	 * This method returns the value of the card.
	 * @return the symbol on the card.
	 */
	public String getType(){
		return type;
	}
	
	/**
	 * This method returns whether the card is face-up or face-down.
	 * @return whether the card is face-up {@code true} or face-down {@code false}.
	 */
	public boolean isCardFlipped(){
		return isFlipped;
	}
}
