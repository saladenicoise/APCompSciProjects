import java.io.*;
//Author: Jules Petit | E Block
import java.util.*;

/**
 * Decryption Class
 * @author Jules Petit | E Block
 */
public class Decryption {

	/* TODO:
	 * 1. Figure out double digit boolean math variables
	 */


	private static File file;
	private static BufferedReader f;
	private static char[] numDigits;
	//Author: Jules Petit | E Block

	/**
	 * Decrypts a given string with a given grid
	 * @param text the text to decode
	 * @param grid the grid to decode with
	 * @param modAdd the number used for mod addition during encryption process(0 if none)
	 * @throws IOException
	 */
	public static void decryptFromText(String text, char[][] grid, int modAdd) throws IOException {
		text = text.replace(" ", "").toUpperCase();
		char[] textChars = text.toCharArray();
		if(modAdd != 0) {
			numDigits = getDigits(modAdd);
			textChars = ArrayDecoder(text.toCharArray());
		}
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
		String key1 = Character.valueOf(grid[2][0]).toString();
		String key2 = Character.valueOf(grid[3][0]).toString();
		String decoded = "";
		for(int c = 0; c < textChars.length; c++) {
			if(Character.toString(textChars[c]).toString().equals(key1) || Character.toString(textChars[c]).toString().equals(key2)) { //A pair
				for(int b = 1; b < grid[0].length; b++) { //Col
					if(Character.toString(textChars[c]).toString().equals(key1) && textChars[c+1] == grid[0][b]) {
						decoded += Character.toString(grid[2][b]);
						c++;
					}else if(Character.toString(textChars[c]).toString().equals(key2) && textChars[c+1] == grid[0][b]) {
						decoded += Character.toString(grid[3][b]);
						c++;
					}
				}
			}else if(textChars[c] == '/') {
				decoded += Character.toString(textChars[c+1]);
				c += 2; // Adding 2 in order to ignore . at the the end
			}else { //Not a pair therefore it is a common
				for(int b = 1; b < grid[0].length; b++) {
					if(textChars[c] == grid[0][b]) {
						decoded += Character.toString(grid[1][b]);
					}
				}
			}
		}
		System.out.println(decoded);
		out.println(decoded);
		out.close();
	}


	/**
	 * Decrypts a given file with a given grid
	 * @param fileName The name of the file
	 * @param grid The grid to use to decode
	 * @param modAdd The number used for modular addition from the encryption process
	 * @throws IOException 
	 * @throws FileNotFoundException
	 */
	public static void decryptFromFile(String fileName, char[][] grid, int modAdd) throws IOException, FileNotFoundException {
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + fileName + ".txt");
		File newFile = new File(homeDir + "/Desktop/" + "Decrypted" + fileName + ".txt");
		f = new BufferedReader(new FileReader(file));
		boolean doubleLoop = false;
		Scanner line = new Scanner(f);
		PrintWriter out = new PrintWriter(new FileWriter(newFile, true));
		System.out.println("Will be overwriting file: " + newFile.toString() + " with new encoded file");
		out.println();
		out.println("--------------Decrypted Message Below--------------");
		while(line.hasNextLine()) {
			String curLine = line.nextLine();
			curLine = curLine.replace(" ", "").toUpperCase();
			char[] textChars = curLine.toCharArray();
			if(modAdd != 0) {
				numDigits = getDigits(modAdd);
				textChars = ArrayDecoder(curLine.toCharArray());
			}
			String key1 = Character.valueOf(grid[2][0]).toString();
			String key2 = Character.valueOf(grid[3][0]).toString();
			String decoded = "";
			for(int c = 0; c < textChars.length; c++) {
				doubleLoop = false;
				if(Character.toString(textChars[c]).toString().equals(key1) || Character.toString(textChars[c]).toString().equals(key2)) { //A pair
					for(int b = 1; b < grid[0].length; b++) { //Col
						if(Character.toString(textChars[c]).toString().equals(key1)) {
							if(textChars[c+1] == grid[0][b] && doubleLoop == false) {
								decoded += Character.toString(grid[2][b]);
								//System.out.println(decoded);
								doubleLoop = true;
								c++;
							}
						}else if(Character.toString(textChars[c]).toString().equals(key2)) {
							if(textChars[c+1] == grid[0][b] && doubleLoop == false) {
								decoded += Character.toString(grid[3][b]);
								//System.out.println(decoded);
								doubleLoop = true;
								c++;
							}
						}
					}
				}else if(textChars[c] == '/') {
					decoded += Character.toString(textChars[c+1]);
					c += 2; // Adding 2 in order to ignore . at the the end
					//System.out.println(decoded);
				}else { //Not a pair therefore it is a common
					for(int b = 1; b < grid[0].length; b++) {
						if(textChars[c] == grid[0][b]) {
							decoded += Character.toString(grid[1][b]);
							//System.out.println(decoded);
						}
					}
				}
			}
			System.out.println(decoded);
			out.println(decoded);
		}
		out.close();
	}

	/**
	 * Gets all the digits of the given mod
	 * @param a
	 * @return
	 */
	public static char[] getDigits(int a ) {
		String num = String.valueOf(a);
		char[] digits = num.toCharArray();
		return digits;
	}


	/**
	 * Performs the opposite of the mod addition
	 * @param a the character to do do the subtraction on
	 * @param modDigit what the current digit of the mod subtraction is(for multidigit)
	 * @return
	 */
	public static String performModSub(char a, int modDigit, boolean dig) {
		String decoded = ""; 
		if(dig == false) {
			String decodedNum = "";
			String aChar = Character.toString(a);
			int aVal = Integer.parseInt(aChar);
			for(int b = 0; b < 10; b++) {
				if((modDigit + b)%10 == aVal) {
					decodedNum = String.valueOf(b);
				}
			}
			decoded = decodedNum;
		}else {
			decoded =  "/" + a + ".";
		}
		return decoded;
	}


	/**
	 * Bashes out the decoded array given a mod addition
	 * @param text what the text to decode is
	 * @return the decoded array
	 */
	public static char[] ArrayDecoder(char[] text) {
		char[] decodedArray = new char[text.length];
		int d = 0;
		for(int a = 0; a < decodedArray.length; a++) {
			if(d == numDigits.length) {
				d = 0;
			}
			if(!(text[a] == '/')) {
				decodedArray[a] = performModSub(text[a], Integer.parseInt(Character.toString(numDigits[d])), false).charAt(0);
				d++;
			}else {
				String dig = performModSub(text[a+1], Integer.parseInt(Character.toString(numDigits[d])), true);
				for(int b = 0; b < dig.length(); b++) {
					decodedArray[a] = dig.charAt(b);
					a += 1;
				}
				a -= 1;
				d++;
			}
		}
		return decodedArray;
	}

}
