import java.util.*;

public class ArrayManipulation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = 0, object = 0;
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
		display(array);
	}
	
	public static void display(int[]array2) {
		System.out.print("Array Positions: ");
		for(int a = 0; a < array2.length; a++) {
			System.out.printf("%-5d", a);
		}
		System.out.print("\n");
		System.out.print("Array Entries: ");
		for(int b = 0; b < array2.length; b++) {
			System.out.printf("%-d", array2[b]);
		}
	}

}
