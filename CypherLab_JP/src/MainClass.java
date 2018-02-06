import java.io.*;
import java.util.*;


public class MainClass {
	/*
	 * Name: Jules Petit
	 * Block: E
	 */
	
	/*
	 * TODO:
	 * 1. Ask Mr. Harris about his wanted output for the doubles and when decoded acording to the rubric and frequency chart it doesnt make sense
	 * 2. Implement Answer
	 */

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		BufferedReader g = new BufferedReader(new FileReader("replace.txt"));
		BufferedReader h = new BufferedReader(new FileReader("cipher.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("decoded.txt")); 
		Scanner in = new Scanner(f);
		Scanner in2 = new Scanner(h);
		Scanner input = new Scanner(g);
		Scanner userInput = new Scanner(System.in);
		Record[] alphabet = new Record[26];
		char[] lineArray;
		char[] frequencyArray = new char[26];
		int z = 0;
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
		for(int j = 0; j < alphabet.length; j++) {
			alphabet[j].setAssociated(frequencyArray[j]);
			System.out.println(alphabet[j].getLetter() + " " + alphabet[j].getFrequency() + " " + alphabet[j].getAssociated());
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

		while(in2.hasNext()) {
			line = in2.nextLine();
			newLine = "";
			for(int a = 0; a < line.length(); a++) {
				char curChar = line.charAt(a);
				if(!(curChar == '!' || curChar == ',' || curChar == '.' || curChar == '"' || curChar == '\'' || curChar == ' ')) {
					for(int b = 0; b < alphabet.length; b++) {
						if(curChar == alphabet[b].getLetter()) {
							if((alphabet[b].getFrequency() == alphabet[b+1].getFrequency())&& b < alphabet.length) {
								System.out.print(" Duplicate found, which letter should be assigned to " + curChar + " ?:");
								String inputString = userInput.next();
								char replace = inputString.charAt(0); // Get the given character
								alphabet[b].setAssociated(replace); 
								newLine = newLine + alphabet[b].getAssociated(); 
							} else {
								newLine = newLine + alphabet[b].getAssociated(); 
							}
						}
					}
				}else {
					//System.out.print(curChar);
					newLine = newLine + curChar; 
				}
			}
			System.out.println(newLine);
			out.write(newLine);
			out.write("\n");
		}
		out.close();
	}
}
