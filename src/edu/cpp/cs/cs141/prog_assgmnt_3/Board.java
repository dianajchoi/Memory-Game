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
 * This class represents the entity of the board, where the cards are arranged in a 4x4 grid.
 * This class holds the deck, which is the single grouping of all 16 possible cards, the "board"
 * where the cards are to be rearranged/assigned each game, and methods such as displaying the
 * "board" and flipping a card at a particular spot on the "board".
 * 
 * @author Diana Choi
 *
 */
public class Board {

	/**
	 * This field represents the grid along which the 16 cards are shuffled and arranged.
	 */
	private static final Card[][] board = new Card[4][4];
	
	/**
	 * This field represents the deck of 16 cards with which the game is played.
	 */
	private static final Card[] deck = new Card[16];
	
	/**
	 * The constructor fills the {@link #deck} with the 8 unique card pairs.
	 */
	public Board() {
		deck[0] = new Asterisk();
		deck[1] = new Asterisk();
		deck[2] = new ExclamationMark();
		deck[3] = new ExclamationMark();
		deck[4] = new ForwardSlash();
		deck[5] = new ForwardSlash();
		deck[6] = new Hashtag();
		deck[7] = new Hashtag();
		deck[8] = new MinusSign();
		deck[9] = new MinusSign();
		deck[10] = new PercentSign();
		deck[11] = new PercentSign();
		deck[12] = new PlusSign();
		deck[13] = new PlusSign();
		deck[14] = new QuestionMark();
		deck[15] = new QuestionMark();
	}
	
	/**
	 * This method is a getter method for a card at a specific position on the {@link #board}.
	 * @param x the row the card is located on.
	 * @param y the column the card is located on.
	 * @return the card located at the (x, y) position on the {@link #board}.
	 */
	public Card getCard(int x, int y){
		return board[x][y];
	}
	
	/**
	 * This method returns the symbol on the card at a specific position on the {@link #board}.
	 * @param x the row the card is located on.
	 * @param y the column the card is located on.
	 * @return the symbol on the card at the (x, y) position on the {@link #board}
	 */
	public String getCardValue(int x, int y){
		return board[x][y].getType();
	}
	
	/**
	 * This method randomly assigns each card from {@link #deck} to a position in {@link #board}.
	 */
	public void shuffleCards(){
		for(int i = 0; i < deck.length; i++){
			int x = (int)(Math.random()*4);
			int y = (int)(Math.random()*4);
			while(board[x][y] != null){
				x = (int)(Math.random()*4);
				y = (int)(Math.random()*4);
			}
			board[x][y] = deck[i];
		}
	}
	
	/**
	 * This method turns all cards on the {@link #board} face-down.
	 */
	public void flipAllCardsDown(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] != null && board[i][j].isCardFlipped()){
					board[i][j].flipCard();
				}
			}
		}
	}
	
	/**
	 * This method flips a card face-up at a specific position on the {@link #board}.
	 * @param x the row the card is located on.
	 * @param y the column the card is located on.
	 */
	public void flipCard(int x, int y){
		board[x][y].flipCard();
	}
	
	/**
	 * This method counts how many cards are face-up on the {@link #board}.
	 * @return the number of cards face-up on the {@link #board}.
	 */
	public int numOfFaceUp(){
		int counter = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] != null && board[i][j].isCardFlipped()){
					counter++;
				}
			}
		}
		return counter;
	}
	
	/**
	 * This method removes the face-up cards from the board, assuming the face-up cards
	 * are a matching pair.
	 */
	public void clearMatchingPair(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] != null && board[i][j].isCardFlipped()){
					board[i][j] = null;
				}
			}
		}
	}
	
	/**
	 * This method formats the grid into a user-friendly format and returns it as a String.
	 * Null values in the {@link #board} are represented by a space, face-down cards are
	 * represented by zeroes, and face-up cards are represented by their symbol.
	 * @return the {@link #board} as a user-friendly grid.
	 */
	public String drawBoard(){
		String b = "";
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				Card c = board[i][j];
				b += "[";
				if(c == null){
					b += " ";
				}else if(c.isCardFlipped()){
					b += c.getType();
				}else{
					b += "0";
				}
				b += "]";
			}
			b += "\n";
		}
		return b;
	}
	
	/**
	 * This method returns whether the two face-up cards are a matching pair,
	 * assuming that there are two face-up cards, and not any more or any less.
	 * @return whether two face-up cards are a matching pair.
	 */
	public boolean matchPair(){
		String card1 = null;
		String card2 = null;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				Card temp = board[i][j];
				if(temp != null && temp.isCardFlipped()){
					if(card1 == null){
						card1 = temp.getType();
					}else{
						card2 = temp.getType();
					}
				}
			}
		}
		if(card1 == card2){
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if the {@link #board} has any values left to be
	 * displayed. If the {@link #board} is completely filled with null values,
	 * then this method is {@code true}. Otherwise, it is {@code false}.
	 * @return {@code true} if the {@link #board} is empty, {@code false} if not.
	 */
	public boolean isEmpty(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] != null){
					return false;
				}
			}
		}
		return true;
	}
	
}
