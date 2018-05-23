import java.io.*;
import java.util.*;

public class Encryption {
	private static File file;
	private static BufferedReader f;
	private static char[] numDigits;

	public static void EncryptFromText(String text, char[][] grid, int modAdd) throws IOException{
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
					}
				}
			}
		}
		System.out.println(encoded);
		out.println(encoded);
		out.close();
	}

	public static void EncryptFromFile(String fileName, char[][] grid, int modAdd) throws IOException, FileNotFoundException {
		String homeDir = System.getProperty("user.home");
		file = new File(homeDir + "/Desktop/" + fileName + ".txt");
		f = new BufferedReader(new FileReader(file));
		Scanner line = new Scanner(f);
		PrintWriter out = new PrintWriter(new FileWriter(file, true));
		System.out.println("Will be overwriting file: " + homeDir + "/Desktop/" + fileName + ".txt with new encoded file");
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
						}
					}
				}
			}
			System.out.println(encoded);
			out.println(encoded);
		}
		out.close();
	}


	public static char[] getDigits(int a ) {
		String num = String.valueOf(a);
		char[] digits = num.toCharArray();
		return digits;
	}

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
