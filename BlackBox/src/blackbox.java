import java.util.*;
import java.math.*;

public class blackbox {

	/*
	 * Name: Jules Petit
	 * Block: E
	 * Version: 1.0.0
	 */
	
	public static void main(String[] args) {
		char [][] board = setup(); // Row, Col
		Scanner input = new Scanner(System.in);
		int choice = 0, cguess = 0, iguess = 0, shots = 0, num1 = 0;
		//display(board, true); // Debug function to display mirror locations
		do {
			if(cguess == 10) {
				System.out.println("Congratulations! You have found all the mirrors, you have won the day!");
				System.exit(0);
			}
			System.out.println("Welcome!");
			display(board, false);
			System.out.println("Correct Guesses: " + cguess + " Incorrect Guesses: " + iguess + " Shots Fired: " + shots);
			System.out.println("Choose:");
			System.out.println("(1) Shoot a Laser");
			System.out.println("(2) Guess at mirror location");
			System.out.println("(0) Quit the game");
			System.out.print("\nEnter Choice: ");
			choice = input.nextInt();
			if(choice == 1) {
				System.out.print("Enter where you want to shoot from: ");
				int num = input.nextInt();
				if(num < 10 && num >= 0) { // Bottom
					shoot('T', board, 0, num);
				}else if(num < 20 && num >= 0) { //Left
					num1 = num - 10;
					shoot('R', board, num1, 0); // row, col
				}else if(num < 30 && num >= 0) { // Top
					num1 = num - 20;
					shoot('B', board, 9, num1);
				}else if(num < 40 && num >= 0) { // Right
					num1 = num - 30;
					shoot('L', board, num1, 9);
				}else {
					System.out.println("Incorrect Input!");
				}
				shots++;
			}else if(choice == 2){ // Guess
				switch(guess(board)) {
				case 1:
					cguess++;
					break;
				case -1:
					iguess++;
					break;
				default: // Nothing happens if 0 b/c it's simply an invalid input	
				}
			}else if(choice != 0){
				System.out.println("Not a valid input.");
			}
		}while(choice != 0);
		System.out.println("Thank you for playing blackbox, have a good day user.");
		input.close();
	}

	/**
	 * Our setup function for the array of chars, randomly places 10 mirror(\ or /) in the array. 
	 */
	
	public static char[][] setup() {
		char [][]board = new char[10][10];
		for(int a = 0; a < board.length; a++) {
			for(int b = 0; b < board[0].length; b++) {
				board[a][b] = '.'; // Board starts filled with periods by default.
			}
		}
		Random random = new Random();
		int countMirrors=10;
		int row=0,col=0;
		while (countMirrors>0) { // Loop to make sure we get 10 unique randomly placed mirrors.
			row=random.nextInt(10);
			col=random.nextInt(10);
			if ( board[row][col] == '.') { // If there is no mirror already there place one, else try again.
				board[row][col] = (char)(random.nextInt(2)+48); // We add 48 to prevent it from being casted as either NULL or SOH(Start of heading) as they are respectively 0 and 1 in ascii.
				countMirrors--; // Decrease mirrors left to place by 1 until we get to 0 mirror left to place.
			}
		}
		return board; // Return the board with all the hidden mirror
	}
	/*public static void display(char [][] board) { //Uncomment function to activate debug mode for very first display call(Debug will output all mirror locations as 0 = / and 1 = \).
		display(board, false);
	}*/
	/**
	 * Displays our array with mirrors hidden
	 * @param board the array with the mirrors and periods
	 * @param debug true or false depending on wether you want debug(default case is false)
	 */
	
	public static void display(char [][] board, boolean debug) {
		System.out.println("   20212223242526272829"); // Top Numbers.
		for(int a = 19, b = 39; b >= 30; a--, b--) {
			System.out.print(a); // Left Numbers.
			for(char boards : board[b-30]) { // For each element in array check if they are one of the values.
				if(debug == false && (boards == '0' || boards == '1')) { // If debug isn't on display hidden grid.
					System.out.print(" .");
				}else { // If debug is on, display debug grid.
					System.out.print(" " + boards); 
				}
			}
			System.out.print(" " + b + "\n"); // Right Numbers.
		}
		System.out.println("   0 1 2 3 4 5 6 7 8 9"); // Bottom Numbers.
	}
	
	/**
	 * Allows user to guess for the position of a mirror given a left/right input and a bottom/top input.
	 * @param board the array
	 * @return returns whether correct guess(1), Incorrect Guess(-1), or wrong input(0)
	 */

	public static int guess(char[][] board) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter which coordinate(left/right) to check for: ");
		int row = in.nextInt();
		if((9 < row) && (row < 20)) {
			row = row - 10; // Convert their input into a readable number for the array.
		}else if((29 < row) && (row < 40)) {
			row = row - 30; // Convert their input into a readable number for the array.
		}else {
			System.out.println("Unfortunately that is not a correct input");
			return 0;
		}
		System.out.print("Please enter which coordinate(top/bottom) to check for: ");
		int col = in.nextInt();
		if((19 < col) && (col < 30)) {
			col = col - 20; // Convert their input into a readable number for the array.
		}else if(col < 10) {
			col = (col+1) - 1; // Convert their input into a readable number for the array.
		}else {
			System.out.println("Unfortunately that is not a correct input");
			return 0;
		}
		if(board[row][col] == '0') { // If forwards mirror is found (/)
			board[row][col] = '/'; // Display it
			System.out.println("That is correct! Mirror will now appear! MAGIC");
			return 1;
		}else if(board[row][col] == '1') { // If backwards mirror is found
			board[row][col] = '\\'; // Display it
			System.out.println("That is correct! Mirror will now appear! MAGIC");
			return 1;
		}else {
			System.out.println("I'm sorry, that is incorrect!");
			return -1;
		}
	}

	/**
	 * 
	 * @param direction L = Left, R = Right, T = Top, B = Bottom
	 * @param board the array
	 * @param row input by user to see if it's left or right
	 * @param col input by user to see if it's top or bottom
	 * @return Nothing. Just output where the shot ended up at.
	 */
	public static void shoot(char direction, char[][]board, int row, int col) {
		if(row < 0 || row >= board.length || col < 0 || col >= board.length) { // Terminal Case
			System.out.print("Shot ended up at: ");
			if(row < 0) {
				System.out.println(col); // Bottom Numbers(0-9)
			}else if(row >= 10) {
				System.out.println(col + 20); //Top Numbers(20-29)
			}else if(col < 0) {
				System.out.println(row + 10); // Left Numbers(10-19)
			}else if(col >= 10){
				System.out.println(row + 30); // Right Numbers(30-39)
			}else {
			}
			return;
		}
		//handle direction change if any
		switch(direction) { 
		case 'T': // If shot is going towards the top
			switch(board[row][col]) { // Check if mirrors are present
			case '0':
			case '/':
			case '2':
				direction='R'; // Change Direction
				break;
			case '1':
			case '\\':
			case '3':
				direction='L'; // Change Direction
				break;
			default:
			}
			break;
		case 'B': // If shot is going towards the bottom
			switch(board[row][col]) {
			case '0':
			case '/':
			case '2':
				direction='L'; // Change Direction
				break;
			case '1':
			case '\\':
			case '3':
				direction='R'; // Change Direction
				break;
			default:
			}
			break;
		case 'R': // If shot is going towards the right
			switch(board[row][col]) {
			case '0':
			case '/':
			case '2':	
				direction='T'; // Change Direction
				break;
			case '1':
			case '\\':
			case '3':
				direction='B'; // Change Direction
				break;
			default:
			}
			break;
		case 'L': // If shot is going towards the left
			switch(board[row][col]) {
			case '0':
			case '/':
			case '2':	
				direction='B'; // Change Direction
				break;
			case '1':
			case '\\':
			case '3':
				direction='T'; // Change Direction
				break;
			default:
				//Default switch does nothing.
			}
			break;
		default:
			//Default switch does nothing.
		}
		//board[row][col] = '*'; <-- Uncomment to get trail of laser.
		// Recurse to continue in the new direction
		switch(direction) {
		case 'T':
			shoot(direction, board, row+1, col);		
			break;
		case 'B':
			shoot(direction, board, row-1, col);
			break;
		case 'L':
			shoot(direction, board, row, col-1);
			break;
		case 'R':
			shoot(direction, board, row, col+1);
			break;
		}

	}
}
