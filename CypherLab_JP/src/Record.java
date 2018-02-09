import java.io.*;
import java.util.*;

public class Record implements Comparable <Record>{
	
	/*
	 * Name: Jules Petit
	 * Block: E
	 */
	
	private char letter;
	private int frequency;
	private char associated;
	private boolean isDupe = false;
	//private char[] frequencyArray;

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
	
	//public int addFrequencyReturn(char c) {
	//	if(c == letter) {
	//		frequency++;
	//	}
	//	return frequency;
	//}
	
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
	
	public void setAssociated(char a) {
		associated = a;
	}
	
	public char getAssociated() {
		return associated;
	}
	
	public void setDupe(boolean check) {
		isDupe = check;
	}
	
	public boolean getDupe() {
		return isDupe;
	}
	
}

class LetterComparator implements Comparator {
	
	public int compare(Object a, Object b) {
		char originalLetter1 = ((Record)a).getLetter();
		char originalLetter2 = ((Record)b).getLetter();
		if((int)originalLetter1 > (int)originalLetter2) {
			return 1;
		}else if((int)originalLetter1 < (int)originalLetter2) {
			return -1;
		}else {
			return 0;
		}
	}
}
//Associated comparator
