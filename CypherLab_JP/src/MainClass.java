import java.io.*;
import java.util.*;


public class MainClass {
	/*
	 * Name: Jules Petit
	 * Block: E
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		Scanner in = new Scanner(f);
		Record[] alphabet = new Record[26];
		char[] lineArray;
		char letter = 'A';

		//Creates our array
		for(int a = 0; a < alphabet.length; a++) {
			Record obj = new Record(letter);
			alphabet[a] = obj;
			letter++;
		}
		//Fills the Array
		while(in.hasNext()) {
			lineArray = in.nextLine().toCharArray();
			for(int b = 0; b < alphabet.length; b++) {
				for(char c : lineArray) {
					alphabet[b].addFrequency(c);
				}
			}
		}

		for(int c = 0; c < alphabet.length; c ++) {
			System.out.println("Array: " + alphabet[c].getLetter());
		}

		printLetterFreq(alphabet);
		System.out.println("--------------------------------");
		Arrays.sort(alphabet);
		printLetterFreq(alphabet);
		System.out.println("--------------------------------");
		setAssociated(alphabet);
		printAssociated(alphabet);
		System.out.println("--------------------------------");
		print(alphabet);
		duplicateFunction(alphabet);
	}

	public static void duplicateFunction(Record[] alphabet) throws IOException{
		int dupePairCount = 0;
		BufferedReader d = new BufferedReader(new FileReader("cipher.txt"));
		Scanner input = new Scanner(d);
		Scanner userInput = new Scanner(System.in);
		String line = "";
		for(int a = 0; a < 25; a++) {
			if(alphabet[a].getFrequency() == alphabet[a+1].getFrequency()) {
				System.out.println("Duplicate Letter: " + alphabet[a].getAssociated() + " and " + alphabet[a+1].getAssociated());
				alphabet[a].setDupe(true);
				alphabet[a+1].setDupe(true);
				dupePairCount++;
			}
		}
		while(input.hasNext()) { // Find and translate dupes
			line = input.next();
			for(int a = 0; a < line.length(); a++) {
				for(int b = 0; b < 25; b++) {
					if(alphabet[b].getDupe() && alphabet[b+1].getDupe()) {
						for(int c = 0; c < dupePairCount; c++) { // Does it exactly as many times
							System.out.print("Is the message decoded?(Y/N) : ");
							char choice = userInput.next().charAt(0);
							if(choice == 'N' || choice == 'n') {
								System.out.print("Enter 2 Letters to swap: ");
								char l1 = userInput.next().charAt(0);
								char l2 = userInput.next().charAt(0);
								int pos1 = 0;
								int pos2 = 0;
								for(int k = 0; k < 26; k++) {
									if(alphabet[k].getAssociated() == l1) {
										pos1 = k;
									}
									if(alphabet[k].getAssociated() == l2) {
										pos2 = k;
									}
								}
								if(alphabet[pos1].getFrequency() == alphabet[pos2].getFrequency()) {
									char l3 = alphabet[pos1].getAssociated();
									char l4 = alphabet[pos2].getAssociated();
									alphabet[pos1].setAssociated(l4);
									alphabet[pos2].setAssociated(l3);
								}else {
									System.out.print("\n Error! They cannont be swapped!");
								}
								print(alphabet);
							}else {
								System.out.print("Are you sure? (Y/N)? ");
								char confirm = userInput.next().charAt(0);
								if(confirm == 'Y' || confirm == 'y') {
									printToFile(alphabet);
									System.out.println("Decoded file as been written, you may now check it");
									System.exit(1); // We exit as the user is done with the program.
								}
							}
						}
					}
				}
			}
		}
	}

	public static void printLetterFreq(Record []alphabet) {
		for(int c = 0; c < alphabet.length; c++) {
			System.out.println(alphabet[c].getLetter() + " " + alphabet[c].getFrequency());
		}
	}

	public static void setAssociated(Record []alphabet) throws IOException{
		BufferedReader a = new BufferedReader(new FileReader("replace.txt"));
		Scanner input2 = new Scanner(a);
		char[] frequencyArray = new char[26];
		String line = "";
		while(input2.hasNext()) {
			for(int c = 0; c < frequencyArray.length; c++) {
				line = input2.next();
				frequencyArray[c] = line.charAt(0);
			}
		}
		for(int j = 0; j < alphabet.length; j++) {
			alphabet[j].setAssociated(frequencyArray[j]);
			
		}
	}

	public static void printAssociated(Record[] alphabet) {
		for(int j = 0; j < alphabet.length; j++)
		System.out.println(alphabet[j].getLetter() + " " + alphabet[j].getFrequency() + " " + alphabet[j].getAssociated());
	}
	
	public static void print(Record[] alphabet) throws IOException {
		BufferedReader c = new BufferedReader(new FileReader("cipher.txt"));
		Scanner input3 = new Scanner(c);
		while(input3.hasNext()) {
			String line = input3.nextLine();
			String newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ' || curChar == '-' || curChar == ';' || curChar == ':')) {
					for(int b = 0; b < alphabet.length; b++) {
						if(curChar == alphabet[b].getLetter()) {
							newLine = newLine + alphabet[b].getAssociated();
						}
					}
				}else {
					newLine = newLine + curChar; 
				}
			}
			System.out.println(newLine);
		}
	}

	public static void printToFile(Record[]alphabet) throws IOException {
		BufferedReader m = new BufferedReader(new FileReader("cipher.txt"));
		PrintWriter out = new PrintWriter("decoded.txt"); 
		Scanner input4 = new Scanner(m);
		while(input4.hasNext()) {
			String line = input4.nextLine();
			String newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ' || curChar == '-' || curChar == ';' || curChar == ':')) {
					for(int b = 0; b < alphabet.length; b++) {
						if(curChar == alphabet[b].getLetter()) {
							newLine = newLine + alphabet[b].getAssociated();
						}
					}
				}else {
					newLine = newLine + curChar; 
				}
			}
			out.write(newLine);
			out.write("\n");
		}
		out.close();
	}
}
