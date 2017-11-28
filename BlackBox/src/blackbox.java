import java.util.*;
import java.math.*;

public class blackbox {

	public static void main(String[] args) {
		char [][] board = new char [10][10]; // Row, Col
		//int [][] board1 = new int [12][12]; // Row, Col
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome!");
		System.out.println("Choose:");
		System.out.println("(1) Shoot a Laser");
		System.out.println("(2) Guess at mirror location");
		System.out.println("(0) Quit the game");
		System.out.print("\nEnter Choice: \n");
		display(board);
	}
	
	/* Functions:
	 * Recursive shoot
	 * Display
	 * Guess
	 * Statistic
	 * Mirror Creator
	 * Setup Array
	 */

	public static void display(char [][] board) {
		System.out.println("   20212223242526272829");
		for(int a = 19, b = 30; b < 40; a--, b++) {
			System.out.print(a);
			for(char boards : board[b-30]) {
				if(boards == 0) {
					System.out.print(" . ");
				}else if(boards == 1) {
					System.out.print(" .");
				}else {
					System.out.print(" " + b + "\n");
				}
			}
		}
		
	}
	
}
