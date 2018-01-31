import java.io.*;
import java.util.*;

public class Record {
	
	private char letter;
	private int frequency;

	/**
	 * Creates a new record with just default stuff.
	 */
	
	public Record() {
		this.frequency = 0;
	}
	
	public Record(char curLetter) {
		letter = curLetter;
		frequency = 0;
	}
	
	public void setFrequency(String s) {
		for(Character c : s.toCharArray()) {
			if(c == letter) {
				frequency++;
			}
		}
	}
	
	public void setLetter(char a) {
		letter = a;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int getFrequency() {
		return frequency;
	}
}
