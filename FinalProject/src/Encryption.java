import java.io.*;
//Author: Jules Petit | E Block
import java.util.*;

/**
 * Encryption Class
 * @author Jules Petit | E Block
 */
public class Encryption {
	private static File file;
	private static BufferedReader f;
	private static char[] numDigits;

	/**
	 * Encrypts a string from a given grid
	 * @param text the text to encrypt
	 * @param grid the grid to encrypt with
	 * @param modAdd the modular addition number for added security(0 if none)
	 * @throws IOException
	 */
	public static void encryptFromText(String text, char[][] grid, int modAdd) throws IOException{
		if(modAdd != 0) {
			numDigits = getDigits(modAdd);
		}
		text = text.replace(" ", "").toUpperCase();
		char[] textChars = text.toCharArray();
		String encoded = "";
		int d = 0;
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + "EncryptedLine" + ".txt");
		if(!file.exists()) {
			System.out.println("File does not exist");
			file.createNewFile();
			System.out.println("Created new file at: " + file.toString());
		}
		PrintWriter out = new PrintWriter(file);
		boolean loopOnlyOnce = false;
		for(int c = 0; c < textChars.length; c++) {
			for(int a = 1; a < grid.length; a++) {
				for(int b = 1; b < grid[0].length; b++) {
					if(textChars[c] == grid[a][b]) {
						if(a == 1) { //First row(commons E, T, A etc...)
							if(modAdd == 0) {
								encoded += Character.toString(grid[0][b]);
							}else {
								if(d == numDigits.length) {
									d = 0;
								}
								encoded += performModAdd(grid[0][b], numDigits[d], modAdd);
								d++;
							}
						}else { //2nd or 3rd row
							if(modAdd == 0) {
								encoded += Character.toString(grid[a][0]) + Character.toString(grid[0][b]);	
							}else {
								if(d == numDigits.length) {
									d = 0;
								}
								encoded += performModAdd(grid[a][0], numDigits[d], modAdd);
								if(d == numDigits.length) {
									d = 0;
								}
								encoded	+= performModAdd(grid[0][b], numDigits[d+1], modAdd);
								d += 2;
							}
						}
					}else if((Character.toString(textChars[c]).equals("0") || Character.toString(textChars[c]).equals("1") || Character.toString(textChars[c]).equals("2") || Character.toString(textChars[c]).equals("3") || Character.toString(textChars[c]).equals("4") || Character.toString(textChars[c]).equals("5") || Character.toString(textChars[c]).equals("6") || Character.toString(textChars[c]).equals("7") || Character.toString(textChars[c]).equals("8") || Character.toString(textChars[c]).equals("9")) && loopOnlyOnce == false) {//Is a digit, therefore we encode it differently
						encoded += "/" + Character.toString(textChars[c]) + ".";
						loopOnlyOnce = true;
					}
				}
			}
			loopOnlyOnce = false;
		}
		System.out.println(encoded);
		System.out.println("Your file has been created at " + file.toString());
		out.println(encoded);
		out.close();
	}
	
	/**
	 * Encrypts a file using a given grid 
	 * @param fileName the name of the file to encrypt
	 * @param grid the grid to use
	 * @param modAdd the number for modular addition
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void encryptFromFile(String fileName, char[][] grid, int modAdd) throws IOException, FileNotFoundException {
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + fileName + ".txt");
		File newFile = new File(homeDir + "/Desktop/" + "encrypted" + fileName + ".txt");
		f = new BufferedReader(new FileReader(file));
		boolean loopOnlyOnce = false;
		Scanner line = new Scanner(f);
		PrintWriter out = new PrintWriter(new FileWriter(newFile, true));
		System.out.println("Will be overwriting file: " + newFile.toString() + " with new encoded file");
		out.println();
		out.println("--------------Encrypted Message Below--------------");
		while(line.hasNextLine()) {
			String curLine = line.nextLine();
			if(modAdd != 0) {
				numDigits = getDigits(modAdd);
			}
			curLine = curLine.replace(" ", "").toUpperCase();
			char[] textChars = curLine.toCharArray();
			String encoded = "";
			int d = 0;
			for(int c = 0; c < textChars.length; c++) {
				for(int a = 1; a < grid.length; a++) {
					for(int b = 1; b < grid[0].length; b++) {
						if(textChars[c] == grid[a][b]) {
							if(a == 1) { //First row(commons E, T, A etc...)
								if(modAdd == 0) {
									encoded += Character.toString(grid[0][b]);
								}else {
									if(d == numDigits.length) {
										d = 0;
									}
									encoded += performModAdd(grid[0][b], numDigits[d], modAdd);
									d++;
								}
							}else { //2nd or 3rd row
								if(modAdd == 0) {
									encoded += Character.toString(grid[a][0]) + Character.toString(grid[0][b]);	
								}else {
									if(d == numDigits.length) {
										d = 0;
									}
									encoded += performModAdd(grid[a][0], numDigits[d], modAdd);
									if(d == numDigits.length) {
										d = 0;
									}
									encoded	+= performModAdd(grid[0][b], numDigits[d+1], modAdd);
									d += 2;
								}
							}
						}else if((Character.toString(textChars[c]).equals("0") || Character.toString(textChars[c]).equals("1") || Character.toString(textChars[c]).equals("2") || Character.toString(textChars[c]).equals("3") || Character.toString(textChars[c]).equals("4") || Character.toString(textChars[c]).equals("5") || Character.toString(textChars[c]).equals("6") || Character.toString(textChars[c]).equals("7") || Character.toString(textChars[c]).equals("8") || Character.toString(textChars[c]).equals("9")) && loopOnlyOnce == false) {//Is a digit, therefore we encode it differently
							encoded += "/" + Character.toString(textChars[c]) + ".";
							loopOnlyOnce = true;
						}
					}
				}
			}
			System.out.println(encoded);
			out.println(encoded);
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
	 * Performs modular addition
	 * @param a the first char
	 * @param b the second char
	 * @param modAdd the modAdd
	 * @return the value of the mod addition
	 */
	public static String performModAdd(char a, char b, int modAdd) {
		String reg = Character.toString(a);
		String mod = Character.toString(b);
		int regVal = Integer.parseInt(reg);
		int modVal = Integer.parseInt(mod);
		int added = regVal + modVal;
		if(added >= 10) {
			added = added % 10;
		}
		return String.valueOf(added);
	}
}
