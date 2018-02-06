import java.io.*;
import java.util.*;


public class MainClass {
	/*
	 * Name: Jules Petit
	 * Block: E
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		BufferedReader g = new BufferedReader(new FileReader("replace.txt"));
		BufferedReader h = new BufferedReader(new FileReader("cipher.txt"));
		BufferedReader i = new BufferedReader(new FileReader("cipher.txt"));
		BufferedReader j = new BufferedReader(new FileReader("cipher.txt"));
		Scanner input3 = new Scanner(j);
		Scanner in = new Scanner(f);
		Scanner in2 = new Scanner(h);
		Scanner input = new Scanner(g);
		Scanner userInput = new Scanner(System.in);
		Scanner input2 = new Scanner(i);
		Record[] alphabet = new Record[26];
		char[] lineArray;
		char[] frequencyArray = new char[26];
		int dupePairCount = 0;
		String line = "", newLine = "";
		char letter = 'A';
		for(int a = 0; a < alphabet.length; a++) {
			Record obj = new Record(letter);
			alphabet[a] = obj;
			letter++;
			//System.out.println(alphabet[a].getLetter() + " " + alphabet[a].getFrequency());
		}
		while(in.hasNext()) {
			lineArray = in.nextLine().toCharArray();
			for(int b = 0; b < alphabet.length; b++) {
				for(char c : lineArray) {
					alphabet[b].addFrequency(c);
				}
			}
		}
		for(int c = 0; c < alphabet.length; c++) {
			System.out.println(alphabet[c].getLetter() + " " + alphabet[c].getFrequency());
		}
		System.out.println("--------------------------------");
		Arrays.sort(alphabet);
		for(int c = 0; c < alphabet.length; c++) {
			System.out.println(alphabet[c].getLetter() + " " + alphabet[c].getFrequency());
		}
		System.out.println("--------------------------------");
		while(input.hasNext()) {
			for(int c = 0; c < frequencyArray.length; c++) {
				line = input.next();
				frequencyArray[c] = line.charAt(0);
			}
		}
		System.out.println("Size: " + frequencyArray.length);
		for(int j1 = 0; j1 < alphabet.length; j1++) {
			alphabet[j1].setAssociated(frequencyArray[j1]);
			System.out.println(alphabet[j1].getLetter() + " " + alphabet[j1].getFrequency() + " " + alphabet[j1].getAssociated());
		}
		System.out.println("--------------------------------");
		//		while(in2.hasNext()) {
		//			lineArray = in2.nextLine().toCharArray();
		//			for(int a = 0; a < alphabet.length; a++) {
		//				for(char c : lineArray) {
		//					if((c == alphabet[a].getAssociated()) && (c != '!' || c != ',' || c != '"' || c != '.' || c!= '\'')) {
		//						System.out.print(alphabet[a].getAssociated() + " ");
		//					}else {
		//						System.out.print(c);
		//					}
		//				}
		//			}
		//			System.out.println();
		//		}

		while(in2.hasNext()) { // Output Text without duplicates changed
			line = in2.nextLine();
			newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ')) {
					for(int b = 0; b < alphabet.length; b++) {
						if(curChar == alphabet[b].getLetter()) {
							newLine = newLine + alphabet[b].getAssociated();
						}
					}
				}else {
					//System.out.print(curChar);
					newLine = newLine + curChar; 
				}
			}
			System.out.println(newLine);
		}

		System.out.println();
		for(int a = 0; a < 25; a++) {
			if(alphabet[a].getFrequency() == alphabet[a+1].getFrequency()) {
				System.out.println("Dupeplicate Letter: " + alphabet[a].getAssociated() + " and " + alphabet[a+1].getAssociated());
				alphabet[a].setDupe(true);
				alphabet[a+1].setDupe(true);
				dupePairCount++;
			}
		}
		while(input2.hasNext()) { // Find and translate dupes
			line = input2.next();
			newLine = "";
			System.out.println("Dupe Pair Count: "+ dupePairCount);
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
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

	public static void print(Record[]alphabet) throws IOException {
		BufferedReader h = new BufferedReader(new FileReader("cipher.txt"));
		Scanner input = new Scanner(h);
		while(input.hasNext()) {
			String line = input.nextLine();
			String newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ')) {
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
		BufferedReader h = new BufferedReader(new FileReader("cipher.txt"));
		PrintWriter out = new PrintWriter("decoded.txt"); 
		Scanner input = new Scanner(h);
		while(input.hasNext()) {
			String line = input.nextLine();
			String newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ')) {
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
