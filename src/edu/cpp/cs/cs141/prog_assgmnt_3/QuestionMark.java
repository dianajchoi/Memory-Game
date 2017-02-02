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
 * This class represents the Question Mark Card, which is a card of the type "?".
 * 
 * @author Diana Choi
 *
 */
public class QuestionMark extends Card{

	/**
	 * This constructor sets the value of the card to a question mark symbol. All
	 * other relevant fields and methods are inherited from the superclass.
	 */
	public QuestionMark() {
		super();
		setType("?");
	}

}
