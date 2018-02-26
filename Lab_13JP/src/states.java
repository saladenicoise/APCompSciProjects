import java.util.*;
import java.io.*;

public class states {

	/*
	 * Name: Jules Petit
	 * Lab 13
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("states.in"));
		Scanner in = new Scanner(f);
		int counter = 0;
		ArrayList<String> states = new ArrayList<String>();
		while(in.hasNextLine()) {
			String line = in.nextLine(), nextLine = in.nextLine();
			states.add(line);
			states.add(nextLine);
			for(String compare : states) {
				if(compare.compareTo(line) < 0) {
					int comparePos = states.indexOf(compare), linePos = states.indexOf(line);
					states.remove(comparePos);
					states.remove(linePos);
					states.add(comparePos, )
				}
			}
		}
		for(String line : states) {
			System.out.println(line);
		}
	}
}
