
import java.util.*;

import javax.naming.LimitExceededException;

import java.io.*;

public class cabbages {

	public static void main(String[] args) throws IOException {
		String line = "", BiggestLine = "";
		int b = 0, c = 0;
		// TODO Auto-generated method stub
		//Using buffered reader is much faster to read.
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		Scanner in = new Scanner(f);
		while(in.hasNext()) {
			b++;
			line = in.next();
			if(line.length() > BiggestLine.length()) {
				BiggestLine = line;
			}
			System.out.println(b + " " + line);
		}
		System.out.println("The longest word in the text is: <" + BiggestLine + ">");
		output2();

	}

	public static void output2() throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		String line = "", duplicate = "", noPunctuation = "";
		int b = 0;
		Scanner in = new Scanner(f);
		String[] words = stringArray();
		for(int a = 0; a < words.length; a++) {
			b++;
			words[a] = words[a].replace('.', ' ');
			words[a] = words[a].replace(',', ' ');
			words[a] = words[a].replace(';', ' ');
			words[a] = words[a].replace(':', ' ');
			words[a] = words[a].replace('\'', ' ');
			words[a] = words[a].replace('"', ' ');
			words[a] = words[a].replace('!', ' ');
			words[a] = words[a].replace('?', ' ');
			words[a] = words[a].replace('-', ' ');
			words[a] = words[a].trim().toLowerCase();
		}
		Arrays.sort(words);
		for(int i = 1,  j = 1; i < words.length; i++) {
			if(!(words[i].equals(words[i-1]))) {
				System.out.println(j + " " + words[i]);
				j++;
			}
		}
	}

	public static String[] stringArray() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		Scanner in = new Scanner(f);
		int a = 0;
		while(in.hasNext()) {
			a++;
			in.next();
		}
		in.close(); // Close the scanner so we can open a new one
		BufferedReader g = new BufferedReader(new FileReader("Cabbages.txt"));
		Scanner input = new Scanner(g);
		String []words = new String[a];
		for(int b = 0; input.hasNext(); b++) {
			words[b] = input.next();
		}
		return words;
	}

}
