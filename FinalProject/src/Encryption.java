import java.io.*;
import java.util.*;

public class Encryption {
	private static File file;
	private static BufferedReader f;

	public static void EncryptFromText(String text, char[][] grid) {
		text = text.replace(" ", "").toUpperCase();
		char[] textChars = text.toCharArray();
		String encoded = "";
		for(int a = 1; a < grid.length; a++) {
			for(int c = 0; c < textChars.length; c++) {
				for(int b = 1; b < grid[0].length; a++) {
					if(textChars[c] == grid[a][b]) {
						if(a == 1) { //First row(commons E, T, A etc...)
							encoded += grid[0][b];
						}else { //2nd or 3rd row
							encoded += grid[a][0] + grid[0][b];
						}
					}
				}
			}
		}
		System.out.println(encoded);
	}

	public static void EncryptFromFile(String file, char[][] grid) {

	}

}
