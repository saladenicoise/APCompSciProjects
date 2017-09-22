import java.io.*;
import java.util.*;
import java.lang.Math;

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
		System.out.println("Median of the array:");
		System.out.println(median(numbers, arraysize));
		System.out.println("Range of the array:");
		System.out.println(range(numbers, arraysize));
		System.out.println("Standard Deviation of the array:");
		System.out.println(standarddev(numbers, arraysize));
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
	 * @param size the size of the array
	 * @return the mean
	 */
	private static double mean(int []nums, int size) {
		double add = 0;
		for(int i = 0; i < size; i++) {
			add = add + nums[i];
		}
		return add/size;
	}

	/**
	 * Calculates the median of our array	
	 * @param nums the array
	 * @param size the size of said array
	 * @return the median
	 */
	private static double median(int []nums, int size) {
		int median = 0;
		double doublemedian = 0;
		if(size%2 == 0) {
			doublemedian = nums[size/2] + nums[(size/2) + 1];
			doublemedian = doublemedian/2;
		}else {
			median = nums[size/2];
		}
		if(doublemedian > 0) {
			return doublemedian;
		}else {
			return median;
		}
	}
	/**
	 * Calculate the range of the array
	 * @param nums the array
	 * @param size the size
	 * @return the range
	 */
	private static int range(int []nums, int size) {
		int range = 0;
		range = nums[size-1] - nums[0]; 
		return range;
	}
	
	/**
	 * Calculates the standard deviation
	 * @param nums the array
	 * @param size of said array
	 * @return the standard deviation
	 */
	private static double standarddev(int []nums, int size) {
		double standarddev = 0, hold = 0, sum = 0;
		for(int i = 0; i < size; i++) { 
			hold = nums[i] - mean(nums, size); // (x - xbar)
			hold = hold * hold; //Square it
			sum = hold + sum; // Add it
		}
		standarddev = sum/(size-1);
		return Math.sqrt(standarddev);
	}
	
	private static int mode(int []nums, int size) {
		int count = 0,count2 = 0;
		for(int i = 0; i < size; i++) {
			if(nums[i] == nums[i+1]) {
				if(nums[i+1] == nums[i+2]) {
					if(count == 0) {
						
					}else if(count == 1)
				}
				count++;
				count2 = count;
			}
		}
	}

}