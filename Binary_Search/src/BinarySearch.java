import java.util.*;

/*
 * Name: Jules Petit
 * Version: 1.0
 */

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = setup();
		output(array);
		System.out.println("\nBuilt-in Binary Search: ");
		for(int a = 0; a < 2; a++) {
			defaultBinarySearch(array);
		}
		System.out.println("\nMy Binary Search");
		for(int b = 0; b < 2; b++) {
			customBinarySearch(array, 0, array.length);
		}
	}

	/**
	 * Sets up the array with a random size between 30 and 50 and fills it with random numbers from 0 to 99
	 * @return the completed array.
	 */
	
	public static int[] setup() {
		Random random = new Random();
		int binarySearchArray[] = new int[random.nextInt(31) + 20];
		for(int a = 0; a < binarySearchArray.length; a++) {
			binarySearchArray[a] = random.nextInt(100);
		}
		return binarySearchArray;
	}
	
	/**
	 * Outputs the array
	 * @param array The Array to output
	 */

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

	/**
	 * Uses the default Arrays.binarySearch.
	 * @param array The array
	 */
	
	public static void defaultBinarySearch(int []array) {
		Scanner input = new Scanner(System.in);
		System.out.print("What Entry? ");
		int entry = input.nextInt();
		int index = Arrays.binarySearch(array, entry);
		if(index >= 0) { // Element has been found
			System.out.println("Status: found at index " + index);
		}else {
			System.out.println("Status: not found");
		}

	}

	/**
	 * An Iterative binary search, finds a midpoint. Guesses whether or not its bigger or smaller and repeat.
	 * @param array The Array
	 * @param from Where we start(0)
	 * @param to The end of the array(array.length-1)
	 */
	
	public static void customBinarySearch(int []array, int from, int to) { //Our Iterative Binary Search Function
		Scanner input = new Scanner(System.in);
		System.out.print("What Entry? ");
		int item = input.nextInt();
		int probes = 0;
		int max = to-1;
		int min = from;

		while(min <= max) {
			int guess = (max + min)/2;
			int middleValue = array[guess];

			if(middleValue < item) {
				min = guess + 1;
				probes++;
			}else if(middleValue > item) {
				max = guess - 1;
				probes++;
			}else {
				System.out.println("Status: found at index " + guess + " after " + probes + " probes.");
				break;
			}
			if(max + 1 == min) {
				System.out.println("Status: not found after " + probes + " probes.");
				break;
			}
		}
	}
}
