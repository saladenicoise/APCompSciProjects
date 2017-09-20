import java.io.*;
import java.util.*;

/*
 * name: jules petit
 * Version: 1.0
 * Block: E
 * Date of Creation: 9/20/17
 */

public class StatisitcsPackage {

	public static void main(String[] args) {
		String pathname = "src/nums.txt";
		File file = new File(pathname);
		Scanner input = null;
		int arraysize = 0;
		try {
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex) {
			System.out.println("*** Cannot Open " + pathname + " ***");
			System.exit(1);
		}
		arraysize = input.nextInt();
		int []numbers = new int[arraysize];
		while(input.hasNextInt()) {
			for(int i = 0; i < arraysize; i++) {
				numbers[i] = input.nextInt();
			}
		}

		System.out.println("Unsorted Array: ");
		output(numbers, arraysize);
		System.out.println("Sorted Array:");
		sort(numbers, arraysize);
		output(numbers, arraysize);
		System.out.println("Mean of the array:");
		System.out.println(mean(numbers, arraysize));
		input.close();
	}

	/**
	 * Outputs the array given an array and the size 
	 * @param nums the array
	 * @param size the size of the array
	 */
	private static void output(int[]nums, int size) {
		int linecounter = 0;
		for(int i = 0; i < size; i++) {
			System.out.print(nums[i] + " ");
			linecounter++;
			if(linecounter%10==0) {
				System.out.print("\n");
			}
		}
	}

	/**
	 * A Bubble Sort Sorting System 
	 * @param nums the array
	 * @param size the size of the array
	 */
	private static void sort(int []nums, int size) {
		boolean swapped = true; // Boolean variable to check when sort is done
		int j = 0;
		int temp;
		while (swapped) { // While swapped = true repeat
			swapped = false; // Set it to false so that when were done sorting it doesnt keep doing it
			j++;
			for (int i = 0; i < size - j; i++) { // For loop to actually swap the array
				if (nums[i] > nums[i + 1]) {
					temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					swapped = true; // Set it to true so we can continue sorting
				}
			}
		}
	}
	//Math Functions
	/**
	 * Calculates the mean of our array
	 * @param nums the array
	 * @param size the size
	 * @return the mean
	 */
	private static int mean(int []nums, int size) {
		int add = 0;
		for(int i = 0; i < size; i++) {
			add = add + nums[i];
		}
		return add/size;
	}

	private static int median(int []nums, int size) {
		int median = 0;
		int size2 = 0;
		double doublemedian = 0;
		double []doublenums = new double[size];
		for(int i = 0; i < size; i++) {
			doublenums[i] = nums[i]; 
		}
		if(size%2 == 0) {
			median = nums[size/2] + nums[(size/2) + 1];
			median = median/2;
		}else {
			size2 = size/2 + 0.5;
			doublemedian = doublenums[size2];
		}
	}

}