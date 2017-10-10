import java.util.*;

public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = 0, object = 0, element = 0, choice = 0, choice2 = 0;
		System.out.print("Hello, what is your desired size for the array: ");
		size = input.nextInt();
		int array[] = new int[size];
		for(int a = 0; a < size; a++) {
			if(a%10 == 1) {
				System.out.print("Enter your " + a + "st element: ");
			}else if(a%10 == 2) {
				System.out.print("Enter your " + a + "nd element: ");
			}else if(a%10 == 3) {
				System.out.print("Enter your " + a + "rd element: ");
			}else {
				System.out.print("Enter your " + a + "th element: ");
			}
			object = input.nextInt();
			array[a] = object;
		}
		do {
			System.out.println("\n");
			System.out.println("Welcome!");
			System.out.println("Please select what you want:");
			System.out.println("1. Display array");
			System.out.println("2. Find Number");
			System.out.println("3. Smallest with first number switch");
			System.out.println("4. Rotate Array");
			System.out.println("5. Delete 0s");
			System.out.println("6. Quit");
			System.out.print("Choice: ");
			choice = input.nextInt();
			if(choice == 1) {
				display(array);
			}else if(choice == 2) {
				do {
					System.out.print("What element would you like to find: ");
					element = input.nextInt();
					find(array, element);
					System.out.print("Another Search(0 = yes/ 1 = no): ");
					choice2 = input.nextInt();
				}while(choice2 != 1);
			}else if(choice == 3) {
				System.out.println("Smallest Element First");
				switchSmallest(array);
			}else if(choice == 4) {
				System.out.print("How many steps?: ");
				choice2 = input.nextInt();
				rotate(array, choice2);
				display(array);
			}else if(choice == 5) {
				System.out.println("Deleting Zerores!");
				deleteMeZeroes(array);
			}else {
				System.out.println("Invalid choice!");
			}
		}while(choice != 6);
	}

	/**
	 * Displays the array
	 * @param array2 the input array
	 */

	public static void display(int[]array2) {
		System.out.print("Array Positions: ");
		for(int a = 0; a < array2.length; a++) {
			System.out.printf("%-8d", a);
		}
		System.out.print("\n");
		System.out.print("Array Entries:   ");
		for(int b = 0; b < array2.length; b++) {
			System.out.printf("%-8d", array2[b]);
		}
	}

	/**
	 * Finds the give element in the array	
	 * @param array2 the array
	 * @param element the given element to find
	 */

	public static void find(int[]array2, int element) {
		boolean found = false;
		int pos = 0;
		for(int a = 0; a < array2.length; a++) {
			if(array2[a] == element) {
				found = true;
				pos = a;
			}
		}
		if(found == true) {
			System.out.println("Entry of " + element + " found at position: " + pos);
		}else{
			System.out.println("Entry of " + element + " not found");
		}	
	}

	/**
	 * Switches the smallest with the first
	 * @param array2
	 */

	public static void switchSmallest(int []array2) {
		int smallest = array2[0], hold = 0;
		for(int i = 0; i < array2.length; i++) {
			if(array2[i] < smallest) {
				smallest = array2[i];
				hold = i;
			}
		}
		array2[hold] = array2[0];
		array2[0] = smallest;
		display(array2);
	}

	/**
	 * Rotates the array either backwards or forwards
	 * @param array2 the array
	 * @param direction the direction in which we rotate
	 */

	public static void rotate(int []array2, int direction) {
		int count = 0, i;
		if(direction > 0) { // Forwards
			for(int b = 0; b < direction; b++) {
				int temp = array2[array2.length-1];
				for(i = array2.length-1; i > 0; i--) {
					array2[i] = array2[i - 1];
				}
				array2[0] = temp;
			}
		}else{ // backwards
			direction = array2.length-(-direction);
			for(int b = 0; b < direction; b++) {
				int temp = array2[array2.length-1];
				for(i = array2.length-1; i > 0; i--) {
					array2[i] = array2[i - 1];
				}
				array2[0] = temp;
			}
		}
	}

	public static void deleteMeZeroes(int array2[]) {
		int count = 0;
		for(int i = 0; i < array2.length; i++) {
			if (array2[i] == 0) {
				count++;
			}
		}
		if(count == 0) {
			System.out.println("No zeroes were found! Aborting deletion!");
		}else {
			int array3[] = new int[array2.length-count];
			for(int b = 0; b < array3.length; b++) {
				if(array2[b] == 0) {		
					array3[b] = array2[b+1];
				}else {
					array3[b] = array2[b];
				}
			}
			display(array3);
		}
	}


}