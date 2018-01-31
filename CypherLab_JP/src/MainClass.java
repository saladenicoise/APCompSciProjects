import java.io.*;
import java.util.*;


public class MainClass {

	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("cipher.txt"));
		Scanner in = new Scanner(f);
		Record[] alphabet = new Record[26];
		String line = "";
		char letter = 'A';
		for(int a = 0; a < alphabet.length; a++) {
			Record obj = new Record(letter);
			alphabet[a] = obj;
			letter++;
			System.out.println(alphabet[a].getLetter() + " " + alphabet[a].getFrequency());
		}
		while(in.hasNext()) {
			line = in.next();
			for(int b = 0; b < line.length(); b++) {
				char curLetter = line.charAt(b);
				for(int c = 0; c < alphabet.length; c++) {
					if(alphabet[c].getLetter() == curLetter) {
						int pos = c;
					}
				}
				if(curLetter != '\'') {
					
				}
			}
		}
	}

}
