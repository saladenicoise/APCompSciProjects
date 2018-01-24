
import java.util.*;
import java.io.*;

public class cabbages {

	/*
	 *	Name: Jules Petit
	 *	Block: E 
	 */

	/*
	 * TODO:
	 * 1. Make it so grep can handle wrapped phrases
	 * 2. Ask what the delimeter for new phrases is.
	 */
	public static void main(String[] args) throws IOException {
		String line = "", BiggestLine = "";
		int b = 0, c = 0;
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
		System.out.println("------------------------");
		System.out.println("Words sorted alphabetically with duplicates and punctuation removed");
		output2();
		System.out.println("------------------------");
		for(int a = 0; a < 3; a++) {
			grep();
			System.out.println("------------------------");
		}

	}

	/**
	 * Function which removes all punctuation, removes duplicates, sorts the words alphabetically, and put to lowercase
	 * @throws IOException
	 */

	public static void output2() throws IOException{
		String[] words = stringArray();
		for(int a = 0; a < words.length; a++) { // Replaces all punctuation
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

	/**
	 * grep(globally search for the regular expression and print the lines) function. Finds how many times a given input string is found with the text
	 * @throws IOException
	 */

	public static void grep() throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		Scanner in = new Scanner(System.in);
		String line = "", input = "", wrappedPhrase = "", modified = "";
		int c = 0, foundCount = 0;
		boolean found = false;
		System.out.print("Please enter something you want to grep: ");
		input = in.nextLine();
		while((line = f.readLine()) != null) {
			c++;
			found = false;
			int index = line.indexOf(input);
			while(index >= 0) {
				modified = "<" + line.substring(line.indexOf(input), (line.indexOf(input)+input.length())) + ">";
				found = true;
				index = line.indexOf(input, index + 1);
				foundCount++;
			}
			if(found) {
				System.out.println("Found on line: " + c + ", which is: " + line.replace(input, modified));
			}
		}
		if(foundCount <= 0) {
			System.out.println("Sorry, the input string of: \"" + input + "\" was not found within the given file.");
		}else {
			System.out.println("In total, the input string of: \"" + input + "\"" + " was found " + foundCount + " times.");
		}
	}
	


	
	
	/**
	 * Creates our array of strings with correct length
	 * @return the Array filled with every single word.
	 * @throws IOException throws out errors.
	 */

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
