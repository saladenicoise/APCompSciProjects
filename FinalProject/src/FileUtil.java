import java.io.*;
import java.util.*;

public class FileUtil {
	private static File file;
	private static PrintWriter out;

	public static void OutputGridToFile(char[][] arr, String userFileChoice) throws IOException, FileNotFoundException {
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + userFileChoice + ".txt");
		if(!file.exists()) {
			System.out.println("File does not exist");
			file.createNewFile();
			System.out.println("Created new file");
		}
		out = new PrintWriter(file);
		for(char [] c : arr) {
			for(char c1 : c) {
				out.print(c1 + " | ");
			}
			out.println();
		}
		out.close();
		System.out.println("Your grid has been saved to: " + homeDir + "/Desktop/" + userFileChoice + ".txt");
	}

	public static char[][] loadGridFromFile(String fileName) throws FileNotFoundException {
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + fileName + ".txt");
		BufferedReader f = new BufferedReader(new FileReader(file));
		Scanner gridIn = new Scanner(f);
		int row = 0;
		char[][] grid = new char[4][11];
		while(gridIn.hasNextLine()) {
			char[] currentRow = new char[11];
			String curLine = gridIn.nextLine();
			curLine = curLine.replace(" | ", "");
			currentRow = curLine.toCharArray();
			for(int a = 0; a < currentRow.length; a++) {
				grid[row][a] = currentRow[a];
			}
			row++;
		}
		return grid;
	}
	
	public static void printArrayToConsole(char[][] arr) {
		for(char [] c : arr) {
			for(char c1 : c) {
				System.out.print(c1 + " | ");
			}
			System.out.println();
		}
	}
}
