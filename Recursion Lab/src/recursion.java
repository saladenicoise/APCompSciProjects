import java.util.*;

public class recursion {

	/*
	 * Name: Jules
	 * Block: E
	 * Version: 1.0
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = 0, choice = 0;
		do {
			System.out.println("");
			System.out.println("Welcome to the Recursion Menu");
			System.out.println("-----------------------------");
			System.out.println("1. Letters");
			System.out.println("2. Twos");
			System.out.println("3. Power of 3?");
			System.out.println("4. Reverse");
			System.out.println("5. Base5");
			System.out.println("6. Print with Commas");
			System.out.println("7. Quit");
			System.out.println("-----------------------------");
			System.out.print("Choice: ");
			choice = input.nextInt();
			if(choice == 1) {
				System.out.print("Please enter a letter: ");
				String letter = input.next();
				char lowerletter = letter.charAt(0);
				System.out.print("The letters before your letter are: ");
				letters(lowerletter);
			}else if(choice == 2) {
				System.out.print("Please choose a number: ");
				num = input.nextInt();
				System.out.println(num + " contains " + twos(num) + " factors of 2");
			}else if(choice == 3) {
				System.out.print("Please choose a number: ");
				num = input.nextInt();
				if(powerOf3(num) == true) {
					System.out.println(num + " is a power of 3");
				}else {
					System.out.println(num + " is not power of 3");
				}
			}else if(choice == 4) {
				System.out.print("Please choose a number: ");
				num = input.nextInt();
				System.out.println(num + " reversed is " + reverse(num));
			}else if(choice == 5) {
				System.out.print("Please choose a number: ");
				num = input.nextInt();
				System.out.print(num + " in base 5 is ");
				base5(num);
			}else if(choice == 6) {
				System.out.print("Please choose a number: ");
				num = input.nextInt();
				System.out.print("The correct output of " + num + " with commas is: ");
				printWithCommas(num);
			}else {
				System.out.println("Invalid Choice");
			}
		}while(choice != 7);
		System.out.println("Goodbye!");
	}

	/**
	 * Displays the sequence of letters from ‘a’ to the given letter.
	 * @param letter - A single lowercase letter
	 */

	public static void letters(char letter) {
		int lowercase = (int) letter;
		if(lowercase == 97) {
			System.out.print(letter);
		}else{
			lowercase--;
			letters((char)lowercase);
			System.out.print(letter);
		}
	}


	/**
	 * Recursive Prime Factorization
	 * @param num - single integer
	 * @return the number of factors of 2 in the number
	 */
	//13 - > 0
	//12 - > 2 b/c 12= 3 * 4 = 3 * 2 * 2
	//48 - > 4 b/c 48 = 6 * 8 = 3 * 2 * 4 * 2 = 3 * 2 * 2 * 2 * 2	

	public static int twos(int num) {
		if(num%2 != 0) {
			return 0;
		}else {
			return 1 + twos(num/2);
		}
	}

	/**
	 * Boolean method that detects wether its a power of 3
	 * @param num - single positive integer
	 * @return returns true if the integer is a perfect power of 3
	 */

	public static boolean powerOf3(int num) {
		if(num == 1) {
			return true;
		}else if(num%3 != 0) {
			return false;
		}else {
			return powerOf3(num/3);
		}
	}

	/**
	 * Helper function
	 * @param num - takes a non-negative number
	 * @return the current power of ten
	 */

	public static int tenPower(int num) {
		if(num/10 == 0) {
			return 1;
		}else {
			return 10 * tenPower(num/10);
		}
	}

	/**
	 * Reverses a given number.
	 * @param num - single integer argument
	 * @return the result of reversing its digits.
	 */

	public static int reverse(int num) {
		if(num%10 == num) {
			return num;
		} else {
			return (((num%10) * tenPower(num)) + reverse(num/10));
		}
	}

	/**
	 * Outputs the equivalent of num in base 5
	 * @param num - single nonnegative integer
	 */

	public static void base5(int num) {
		if(num != 0) {
			base5(num/5);
			System.out.print(num%5);
		}
	}

	/**
	 * Given a number, output it properly with commas at the correct places
	 * @param num - single nonnegative primitive integer
	 */

	public static void printWithCommas(int num) {
		if (num > 999) {
			printWithCommas(num/1000);
			System.out.print(',');
			if(num % 1000 < 100) {
				System.out.print('0');
			}
			if(num % 1000 < 10) {
				System.out.print('0');
			}
			System.out.print(num%1000);
		}else{
			System.out.print(num);
		}
	}


}
