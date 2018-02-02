import java.io.*;
import java.util.*;


public class MainClass {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		Scanner in = new Scanner(f);
		Record[] alphabet = new Record[26];
		char[] lineArray;
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
	}

}
