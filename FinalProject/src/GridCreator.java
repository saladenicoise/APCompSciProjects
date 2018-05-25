
import java.util.*;
//Author: Jules Petit | E Block
import java.io.*;

/**
 * Grid Creator Class
 * @author Jules Petit | E Block
 */
public class GridCreator {

	/**
	 * The Grid to be filled with the values
	 */
	public static char[][] grid; // Row | Col
	private static Random rng;
	private static char[] rowLabel;
	private static ArrayList<Character> alphabet;

	/**
	 * Creates a a fully random grid
	 * @return a randomly generated grid
	 */
	public static char[][] CreateRandomGrid() {
		grid = new char[4][11];
		grid[0][0] = ' ';
		grid[1][0] = ' ';
		rng = new Random();

		//Generates randomed of 1st row of grid
		int randoms = 0, col = 1;
		while(randoms < 10) {
			char num = (char)(rng.nextInt(10) + 48);
			if(isUnique(grid, num, 0, 0)) {
				grid[0][col] = num;
				col++;
				randoms++;
			}
		}

		//Generates randomed 2nd row of grid
		char[] commons = {'E', 'T', 'A', 'O', 'N', 'R', 'I', 'S'};
		rowLabel = new char[2];
		for(int a = 0; a < 2; a++) { //We ignore the first index since it is blank
			int column = rng.nextInt(grid[1].length - 1);
			if(grid[1][column] != ' ') {
				grid[1][column] = ' ';
				rowLabel[a] = grid[0][column];
			}
		}
		int b = 0;
		for(int a = 1; a < grid[1].length; a++) {
			if(grid[1][a] != ' ') {
				grid[1][a] = commons[b];
				b++;
			}
		}

		//Generates Randomed rest of alphabet
		grid[2][0] = rowLabel[1];
		grid[3][0] = rowLabel[0];
		ArrayList<Character> randomAlph = randomAlphabet();
		boolean nextRow = false;
		for(int a = 1; a < grid[2].length; a++) {
			grid[2][a] = randomAlph.remove(a);
		}
		for(int a = randomAlph.size() - 1; a > 1; a--) {
			grid[3][a] = randomAlph.remove(a);
		}
		grid[3][10] = randomAlph.remove(1);
		grid[3][1] = randomAlph.remove(0);
		//Return the completed random grid
		return grid;
	}

	/**
	 * Generates the default given grid.
	 * @return the default grid
	 */
	public static char[][] CreateDefaultGrid() {
		char [][] grid = {{' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'},
				{' ', 'E', 'T', 'A', 'O', ' ', 'N', ' ', 'R', 'I', 'S'},
				{'4', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M'},
				{'6', 'P', 'Q', '/', 'U', 'V', 'W', 'X', 'Y', '.', 'Z'}};
		return grid;
	}

	/**
	 * Checks if the given character is unique within the array
	 * @param arr the array to look into
	 * @param search what to look for
	 * @param rowNum the number of the row
	 * @param start the start position
	 * @return true if unique, false otherwise
	 */
	public static boolean isUnique(char[][] arr, char search, int rowNum, int start) {
		boolean isUnique = true;
		for(int a = start; a < arr[rowNum].length - 1; a++) {
			if(search == arr[rowNum][a]) {
				isUnique = false;
			}
		}
		return isUnique;
	}

	/**
	 * Generates a random alphabet
	 * @return a randomly generate ArrayList of the alphabet
	 */
	public static ArrayList<Character> randomAlphabet() {
		alphabet = new ArrayList<Character>();
		alphabet.add('B');
		alphabet.add('C');
		alphabet.add('D');
		alphabet.add('F');
		alphabet.add('G');
		alphabet.add('H');
		alphabet.add('J');
		alphabet.add('K');
		alphabet.add('L');
		alphabet.add('M');
		alphabet.add('P');
		alphabet.add('Q');
		alphabet.add('/');
		alphabet.add('U');
		alphabet.add('V');
		alphabet.add('W');
		alphabet.add('X');
		alphabet.add('Y');
		alphabet.add('.');
		alphabet.add('Z');
		Collections.shuffle(alphabet);
		return alphabet;
	}

}
