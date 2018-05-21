
import java.util.*;
import java.io.*;

public class GridCreator {

	/**
	 * The Grid to be filled with the values
	 */
	public char[][] grid; // Row | Col
	private Random rng;
	private ArrayList<Integer> pos;

	public char[][] CreateRandomGrid() {
		grid = new char[4][11];
		grid[0][0] = ' ';
		grid[1][0] = ' ';
		rng = new Random();
		
		//Generates randomed of 1st row of grid
		int randoms = 0, col = 1;
		while(randoms < 10) {
			char num = (char)(rng.nextInt(56) + 48); //56(9 in ascii) is max, 48(0 in ascii) is min;
			if(isUnique(grid, num, 0, 0)) {
				grid[0][col] = num;
				col++;
				randoms++;
			}
		}
		
		//Generates randomed 2nd row of grid
		char[] commons = {'E', 'T', 'A', 'O', 'N', 'R', 'I', 'S'};
		pos = new ArrayList<Integer>();
		for(int a = 0; a < 2; a++) { //We ignore the first index since it is blank
			int column = rng.nextInt(grid[1].length - 1);
			if(grid[1][column] != ' ') {
				grid[1][column] = ' ';
				pos.add(column);
			}
		}
		for(int a = 0; a < grid[1].length; a++) {
			if(grid[1][a] != ' ') {
				grid[1][a] = commons[a];
			}
		}
		
		
	}

	public char[][] CreateDefaultGrid() {

	}
	
	public boolean isUnique(char[][] arr, char search, int rowNum, int start) {
		boolean isUnique = true;
		for(int a = start; a < arr[rowNum].length - 1; a++) {
			if(search == arr[rowNum][a]) {
				isUnique = false;
			}
		}
		return isUnique;
	}



}
