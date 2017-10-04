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
					System.out.print("Another Search(1 = yes/ 0 = no): ");
					choice2 = input.nextInt();
				}while(choice2 != 0);
			}else if(choice == 3) {
				System.out.println("Smallest Element First");
				switchSmallest(array);
			}else if(choice == 4) {

			}else if(choice == 5) {

			}else {

			}
		}while(choice != 6);
		display(array);
		element = input.nextInt();
		find(array, element);
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

	public static void find(int[]array2, int element) {
		for(int a = 0; a < array2.length; a++) {
			if(array2[a] == element) {
				System.out.println("Entry of " + element + " found at position: " + a);
			}
		}
	}

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
	

}
