import java.util.*;
import java.math.*;

public class blackbox {

	public static void main(String[] args) {
		char [][] board = setup(); // Row, Col
		//int [][] board1 = new int [12][12]; // Row, Col
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("Choose:");
		System.out.println("(1) Shoot a Laser");
		System.out.println("(2) Guess at mirror location");
		System.out.println("(0) Quit the game");
		System.out.print("\nEnter Choice: \n");
		System.out.print("Please enter the coordinates: ");
		int c1 = input.nextInt();
		int c2 = input.nextInt();
		input.close();
		display(board);
		guess(board, c1, c2);
		
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
				if(boards == 0) { // backward
					System.out.print(". ");
				}else if(boards == 1) { //forward
					System.out.print(" .");
				}else {
					System.out.print(" " + boards);
				}
			}
			System.out.print(" " + b + "\n"); // Right Numbers
		}
		System.out.println("   0 1 2 3 4 5 6 7 8 9"); // Bottom Numbers
	}
	
	public static void guess(char[][] board, int num1, int num2) {
		int cguess = 0, iguess = 0;
		if(board[num1][num2] == '0' || board[num1][num2] == '1') { // Successful Guess
			stats();
		}else { //Unsucessfull
			
		}
	}
	
	public static void stats() {
		System.out.print("Sucess!");
	}
	
/*	public static int shoot(int num1, char[][]board) {
		if(num1 < 20) { // Left and bottom input
			if(num1 < 10) { // Bottom Input
				
			}else { // Left Input
				
			}
		}else { // Right and top input
			if(num1 < 30 ) { // Top Input
				
			}else { // Right Input
				
			}
		}
	}*/
	
}
