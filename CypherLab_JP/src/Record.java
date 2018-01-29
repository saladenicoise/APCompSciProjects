import java.io.*;
import java.util.*;

class mainClass {
	public static void main(String[] args) {
		
	}
}

public class Record {
	
	private char letter;
	private int frequency;

	public Record() {
		this.frequency = 0;
	}
	
	public Record(char curLetter) {
		this.letter = curLetter;
	}
	
	public int getFrequency(String s) {
		for(Character c : s.toCharArray()) {
			if(c == letter) {
				frequency++;
			}
		}
		return frequency;
	}
	
	public char changeLetter(char a) {
		letter = a;
		return a;
	}
	
	public char getLetter() {
		return letter;
	}
}
