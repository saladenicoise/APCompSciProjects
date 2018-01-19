
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
		noPunctuation();
		
	}
	
	public static void noPunctuation() throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		String line = "", duplicate = "", noPunctuation = "";
		int b = 0;
		Scanner in = new Scanner(f);
		while(in.hasNext()) {
			b++;
			line = in.next().toLowerCase();
				if(line.indexOf('.') != -1) {
					noPunctuation = line.replace(".", "");
				}else if(line.indexOf(',') != -1) {
					noPunctuation = line.replace(",", "");
				}else if(line.indexOf(';') != -1) {
					noPunctuation = line.replace(";", "");
				}else if(line.indexOf(':') != -1) {
					noPunctuation = line.replace(":", "");
				}else if(line.indexOf('!') != -1) {
					noPunctuation = line.replace("!", "");
				}else if(line.indexOf('?') != -1) {
					noPunctuation = line.replace("?", "");
				}else if(line.indexOf("--") != -1) {
					noPunctuation = line.replace("--", "");
				}else if(line.indexOf('"') != -1) {
					noPunctuation = line.replace("\"", "");
				}else if(line.indexOf('\'') != -1) {
					noPunctuation = line.replace("'", "");
				}else if(line.indexOf('-') != -1) {
					noPunctuation = line.replace("-", "");
				}else {
					noPunctuation = line;
				}
			System.out.println(b + " " + noPunctuation);
		}
	}
	
	public static String[] stringArray() throws IOException {
		
	}

}
