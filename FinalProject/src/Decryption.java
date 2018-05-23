import java.io.*;
import java.util.*;
public class Decryption {

	private static File file;
	private static BufferedReader f;
	private static char[] numDigits;

	public static void decryptFromText(String text, char[][] grid, int modAdd) throws IOException {
		if(modAdd != 0) {
			numDigits = getDigits(modAdd);
		}
		text = text.replace(" ", "").toUpperCase();
		char[] textChars = text.toCharArray();
		String encoded = "";
		int d = 0;
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + "DecryptedLine" + ".txt");
		if(!file.exists()) {
			System.out.println("File does not exist");
			file.createNewFile();
			System.out.println("Created new file at: " + file.toString());
		}
		PrintWriter out = new PrintWriter(file);
		int key1 = grid[2][0], key2 = grid[3][0];
		for(int c = 0; c < textChars.length; c++) {
			for(int a = 1; a < grid.length; a++) {
				for(int b = 1; b < grid[0].length; b++) {
					
				}
			}
		}
	}

	public static char[] getDigits(int a ) {
		String num = String.valueOf(a);
		char[] digits = num.toCharArray();
		return digits;
	}

}
