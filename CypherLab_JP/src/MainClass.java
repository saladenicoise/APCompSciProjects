import java.io.*;
import java.util.*;


public class MainClass {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		BufferedReader g = new BufferedReader(new FileReader("replace.txt"));
		Scanner in = new Scanner(f);
		Scanner input = new Scanner(g);
		Record[] alphabet = new Record[26];
		char[] lineArray = null;
		char[] frequencyArray = null;
		int z = 0;
		String line = "";
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
			frequencyArray = input.next().toCharArray();
			for(int d = 0; d < frequencyArray.length; d++) {
				System.out.println(frequencyArray[d]);
			}
		}
		System.out.println("--------------------------------");
		for(int j = 0; j < alphabet.length; j++) {
			alphabet[j].setAssociated(frequencyArray[j]);
		}
	}

}
