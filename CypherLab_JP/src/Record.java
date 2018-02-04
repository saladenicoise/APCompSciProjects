import java.io.*;
import java.util.*;

public class Record implements Comparable <Record>{
	
	private char letter;
	private int frequency;

	/**
	 * Creates a new record with just default stuff.
	 */
	
	
	/*TODO:
	 * Read each frequency letter into an array, then compare the sorted array of frequencies and find highestFreq in array and output what is the frequencyTable[a];
	 */
	
	public Record() {
		this.frequency = 0;
	}
	
	public Record(char curLetter) {
		letter = curLetter;
		frequency = 0;
	}
	
	//public void calcFrequency(String s) {
	//	for(Character c : s.toCharArray()) {
	//		if(c == letter) {
	//			frequency++;
	//		}
	//	}
	//}
	
	public void addFrequency(char c) {
		if(c == letter) {
			frequency++;
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
	
	public void setFrequency(int freq) {
		frequency = freq;
	}

	public int compareTo(Record freq) {
		return freq.getFrequency() - frequency;
	}
	
	public boolean equals(Record a) {
		return (frequency == a.getFrequency());
	}
	
	public int compareMe(Record a, Record b) {
		return a.compareTo(b);
	}
	
	public int recordIntoArray(char frequencyLetter) {
		return 0;
	}
}
