import java.util.*;
import java.math.*;
import java.io.*;

/*
 * Name: Jules Petit
 * Version: 1.0
 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = setup();
		output(array);
		System.out.println();
		defaultBinarySearch(array);

	}

	public static int[] setup() {
		Random random = new Random();
		int binarySearchArray[] = new int[random.nextInt(31) + 20];
		for(int a = 0; a < binarySearchArray.length; a++) {
			binarySearchArray[a] = random.nextInt(100);
		}
		return binarySearchArray;
	}

	public static void output(int[] array) {
		System.out.println("Original Array of " + array.length + " elements before sort: ");
		for(int a = 0; a < array.length; a++) {
			System.out.printf("%3d", array[a]);
			if(a%10 == 9) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Array of " + array.length + " elements after sort: ");
		Arrays.sort(array);
		for(int a = 0; a < array.length; a++) {
			System.out.printf("%3d", array[a]);
			if(a%10 == 9) {
				System.out.println();
			}
		}
	}

	public static void defaultBinarySearch(int []array) {
		Scanner input = new Scanner(System.in);
		System.out.println("Built-in Binary Search: ");
		System.out.print("What Entry? ");
		int entry = input.nextInt();
		int index = Arrays.binarySearch(array, entry);
		if(index >= 0) { // Element has been found
			System.out.println("Status: found at index " + index);
		}else {
			System.out.println("Status: not found");
		}

	}

	public static int customBinarySearch(int []array, int from, int to, int probes, int item) { //Our Recursive Binary Search Function
		int high = array.lenth-1;
		int low = 0;
		int mid = ((from+low)/2);
		if(array[mid] == item) {
			return mid;
		}
		if()
	}
}
