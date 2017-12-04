import java.util.*;
import java.math.*;

public class blackbox {

	public static void main(String[] args) {
		char [][] board = setup(); // Row, Col
		Scanner input = new Scanner(System.in);
		int choice = 0, cguess = 0, iguess = 0, shots = 0;
		do {
			System.out.println("Welcome!");
			display(board);
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
				if(num < 10) { // Bottom
					shoot(num, board, 0, num, false, false);
				}else if(num < 20) { //Left
					int num1 = (-num + 19);
					shoot(num, board, num1-1, 0, false, false);
				}else if(num < 30) { // Top
					int num1 = num - 20;
					shoot(num, board, 9, num1, false, false);
				}else if(num < 40) { // Right
					int num1 = num - 30;
					shoot(num, board, num1-1, 9, false, false);
				}else {
					//Nope
				}
				shots++;
			}else if(choice == 2){ // Guess
				if(guess(board)) {
					cguess++;
				}else {
					iguess++;
				}
			}else {
				System.out.println("Not a valid input.");
			}
		}while(choice != 0);
		input.close();
	}

	/* Functions:
	 * Recursive shoot
	 * Display √
	 * Guess
	 * Statistic
	 * Mirror Creator √
	 * Setup Array √
	 */

	public static char[][] setup() {
		char [][]board = new char[10][10];
		for(int a = 0; a < board.length; a++) {
			for(int b = 0; b < board[0].length; b++) {
				board[a][b] = '.';
			}
		}
		Random random = new Random();
		for(int c = 0; c <= 10; c++) {
			board[(random.nextInt(10))][(random.nextInt(10))] = (char)(random.nextInt(2)+48);
		}
		return board;
	}

	public static void display(char [][] board) {
		System.out.println("   20212223242526272829"); // Top Numbers
		for(int a = 19, b = 30; b < 40; a--, b++) {
			System.out.print(a); // Left Numbers
			for(char boards : board[b-30]) {
				if(boards == 0) { // backward placeholder
					System.out.print(". ");
				}else if(boards == 1) { //forward placeholer
					System.out.print(" .");
				}else if(boards == 2) { // Backwards slash
					System.out.print(" /");
				}else if(boards == 3) { // Forwards slash
					System.out.print("\\ ");
				}else {
					System.out.print(" " + boards); // Position of mirror to cheat
				}
			}
			System.out.print(" " + b + "\n"); // Right Numbers
		}
		System.out.println("   0 1 2 3 4 5 6 7 8 9"); // Bottom Numbers
	}

	public static boolean guess(char[][] board) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter which coordinate(left/right) to check for: ");
		int a = in.nextInt();
		if((9 < a) && (a < 20)) {
			a = (-a + 19);
		}else if((29 < a) && (a < 40)) {
			a = a - 30;
		}else {
			System.out.println("Unfortunately that is not a correct input");
		}
		System.out.print("Please enter which coordinate(top/bottom) to check for: ");
		int b = in.nextInt();
		if((19 < b) && (b < 30)) {
			b = b - 20;
		}else if(b < 10) {
			b = (b+1) - 1;
		}else {
			System.out.println("Unfortunately that is not a correct input");
		}
		if(board[a][b] == '0') { // Backwards
			board[a][b] = (char) 2;
			System.out.println("That is correct! Mirror will now appear! MAGIC");
			return true;
		}else if(board[a][b] == '1') { // Forwards
			board[a][b] = (char) 3;
			System.out.println("That is correct! Mirror will now appear! MAGIC");
			return true;
		}else {
			System.out.println("I'm sorry, that is incorrect!");
			return false;
		}
	}


	public static int shoot(int num1, char[][]board, int row, int col, boolean forwards, boolean backwards) {
		System.out.println("In function");
		if(num1 < 20) { // Left and bottom input
			System.out.println("Left or Bottom");
			if(num1 < 10) { // Bottom Input
				System.out.println("Bottom"); // Col stays the same.
				if(col > board.length || row > board.length) {
					System.out.println("The Shot ended up at: " + (row) + " " + (col));
				}else {
					if(backwards) { // As long as there is a backwards slash it should go to the left
						shoot(num1, board, row, col+1, false, true);
					}else if(forwards) { // Forward slash, therefore col to the right(col-1)
						shoot(num1, board, row, col-1, true, false);
					}
					if(board[row][col] == '0') {//Backwards slash //
						shoot(num1, board, row, col+1, false, true); // Needs to keep increasing col
					}else if(board[row][col] == '1') { // Forwards slash \\
						shoot(num1, board, row, col+1, true, false);
					}else {
						shoot(num1, board, row + 1, col, false, false);
					}
				}
			}else { // Left Input
				System.out.println("Left"); // Row stays the same
				if(col > board.length || row > board.length) {
					System.out.println("The Shot ended up at: " + (row) + " " + (col-1));
				}else {
					shoot(num1, board, row, col + 1, false, false);
				}
			}
		}else { // Right and top input
			if(num1 < 30) { // Top Input

			}else { // Right Input

			}
		}
		return -1;
	}

}
