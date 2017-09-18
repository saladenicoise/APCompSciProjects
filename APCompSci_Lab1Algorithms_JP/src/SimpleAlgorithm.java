import java.util.Scanner;

/*
 * Name: Jules Petit
 * Block: E
 * Titles: Simple Algorithm Lab
 */


public class SimpleAlgorithm {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int choice = 0, num1 = 0, num2 = 0, exponent = 0, number = 0;
		double base = 0.0, doublenum = 0;
		System.out.println("Welcome to the simple algorithms");
		do {
			System.out.println("Options: ");
			System.out.println("1. List the Factors");
			System.out.println("2. Is my number a prime");
			System.out.println("3. Greatest Common Denominator");
			System.out.println("4. Powers");
			System.out.println("5. Find Digits");
			System.out.println("6. Down Digits");
			System.out.println("7. Count Digits");
			System.out.println("8. Quit");
			System.out.print("Please choose an option: ");
			choice = cin.nextInt();
			//Input menu for where we need others
			if(choice == 3) { // Our GCD
				System.out.print("Please enter the first number: ");
				num1 = cin.nextInt();
				System.out.print("Please enter the second number: ");
				num2 = cin.nextInt();
			}else if(choice == 4) { //Powers
				System.out.print("Please enter the base: ");
				base = cin.nextDouble();
				System.out.print("Please enter the exponent: ");
				exponent = cin.nextInt();
				if(base == 0 && exponent < 1) {
					if(exponent == 1) {
						power(base, exponent);
					}else {
						System.out.println("If the base is 0, then your exponent has to be positive!");
						System.out.print("Please enter a base: ");
						base = cin.nextDouble();
						System.out.print("Please enter the exponent: ");
						exponent = cin.nextInt();
						power(base, exponent);
					}
				}
			}else if(choice == 7) { // countDigits
				System.out.print("Number: ");
				doublenum = cin.nextDouble();
			}else if(choice == 5) { // findDigits
				System.out.print("Number: ");
				num1 = cin.nextInt();
				System.out.print("Nth Digit(N = input): ");
				num2 = cin.nextInt();				
			}else if(choice < 8){ // Every other
				System.out.print("Number: ");
				number = cin.nextInt();
			}else if(choice == 8){
				//Blank
			}else {
				System.out.println("That is not a valid choice!");
			}
			if(choice == 1) {
				factors(number);
				System.out.println("");
			}else if(choice == 2) {
				if(number <= 1) {
					System.out.println("Please enter a number greater than one!");
				}else {
					if(prime(number)) { //Call method prime to check for Primeness
						System.out.print(number + " is a prime number.");
					}else {
						System.out.print(number + " is not a prime number.");
					}
					System.out.println("");
				}
			}else if(choice == 3) {
				System.out.println("GCD of the numbers: " + num1 + " and " + num2 + " is " + GCD(num1, num2));
			}else if(choice == 4) {
				if(exponent < 1 && exponent != 0) { // If the exponent is negative
					System.out.println("The base of " + base + " raised to " + exponent + " is 1/" + power(base, exponent));	
				}else if(exponent == 0) {
					System.out.println("The Base of " + base + " raised to " + exponent + " is " + power(base, exponent));
				}else {
					System.out.println("The base of " + base + " raised to " + exponent + " is " + power(base, exponent));
				}
			}else if(choice == 5) { // Find Digits
				if(num2 > 3) {
					System.out.println("The " + num2 + "th digit from the right of " + num1 + " is " + findDigit(num1, num2));
				}else if(num2 == 3) {
					System.out.println("The " + num2 + "rd digit from the right of " + num1 + " is " + findDigit(num1, num2));
				}else if(num2 == 2) {
					System.out.println("The " + num2 + "nd digit from the right of " + num1 + " is " + findDigit(num1, num2));
				}else {
					System.out.println("The " + num2 + "st digit from the right of " + num1 + " is " + findDigit(num1, num2));
				}
			}else if(choice == 6) { // down Digits
				//Array Output
				/*res = downDigits(number); 
			System.out.println("The Digits of " + number + " are:");
			for(int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
			}*/
				//Regular Output using Recursion
				System.out.println("The Digits of " + number + " are:");
				downDigits(number);
			}else if(choice == 7) { // Count Digits
				System.out.println("There are " + countDigits(doublenum) + " digit(s) in " + doublenum);
			}	
		}while(choice != 8);
		cin.close();
		System.out.println("Thank you for using simple algorithm, good bye!");
	}

	/**
	 * Prints in console the factors of num
	 * @param num the number to get the factors of
	 * @return Nothing
	 */
	private static void factors(int num) { 
		System.out.print("The Factors of " + num + " are: ");
		for(int i = 1; i < num; i++) {
			if(num%i == 0) {
				System.out.print(i + ", ");
			}
		}
		System.out.print(num + ".");
	}

	/**Function to check for Primeness
	 * @param
	 * n is the number which we will check primeness of
	 * @return True if Prime, False Otherwise**/
	private static boolean prime(int n) { 
		for(int i=2;i<n;i++) 
		{
			if(n%i==0)
				return false; //Not Prime
		}
		return true; // Is Prime
	}
	
	/**
	 * Using Euclid's method we find the GCD(Greatest common divisor)
	 * @see https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param a first number 
	 * @param b second number
	 * @return a if b is 0
	 */
	private static int GCD(int a, int b) { 
		if(b == 0) { // If a is zero, then we set 
			return a; // If the bottom number is zero then we return 
		}
		return GCD(b, a%b); // We return with the function with int a being our previous b value, and int b being the modulus of a%b
	}

	
	/**
	 * We get our base and put it to the power of the exponent
	 * @param base our base can be positive, negative or 0
	 * @param exponent if base is 0 then has to be positive, otherwise can be positive, negative or 0
	 * @return 1 if exponent is 0
	 */
	private static double power(double base, int exponent) {
		// To calculate the power we first get the power
		double poweredint = 0;

		if(exponent == 0) {
			poweredint = 1.0;
			return poweredint;
		}else if(exponent > 0) {
			return base * power(base, --exponent); // RECURSION WOOP WOOP
		}else { // Negative Exponent
			exponent = -exponent; // Absolute Value
			return base * power(base, --exponent);
		}
	}

	//Was a test with arrays, but since arrays aren't primitive data type, can't use it.
	//Gets the digits and stores them in an array, then returns the array to be used elsewhere. 
	/*private static int[] downDigit(int num) { 
		int digit = 0, arraysize = 0;
		arraysize = countDigits(num);
		int []downdigits = new int[arraysize];
		for(int i = arraysize-1; i >= 0; i--){
			digit = num%10;
			downdigits[i] = digit;
			num = num/10;
		}
		return downdigits;
	}*/

	/**
	 * Recursive approach to downDigits which lists all the digits of a given number
	 * @param num our positive integer which we find the digits of
	 */
	private static void downDigits(int num) {
		int digits = num%10;
		if(num == 0) {
			return;
		}else {
			downDigits(num/10);
		}
		System.out.println(digits);
	}

	/**
	 * Finds the nth digit from the right of a given positive or negative integer
	 * @param num the number which we find the nth digit of
	 * @param n the nth digit
	 * @return the digits of the given int
	 */
	private static int findDigit(int num, int n) {
		int digits = 0;
		if(num < 0) {
			num = -num;
		}
		for(int i = 0; i < n; i++){
			digits = num%10;
			num = num/10;
		}
		return digits;
	}

	/**
	 * Counts number of digits before the decimal point.
	 * @param num our input of which we get the number of digits.
	 * @return Numbers inferior to 1 will return 1, otherwise it will return the number of digits.
	 */
	private static int countDigits(double num) { 
		int digits = 0;
		if(num < 0) {
			num = -num;
		}
		do {
			num = num/10;
			digits++;
		}while(num >= 1);
		return digits;
	}
}
