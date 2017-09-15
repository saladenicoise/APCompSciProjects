import java.util.Scanner;

/*
 * Name: Jules Petit
 * Block: E
 * Titles: Simple Algorithm Lab
 */


public class SimpleAlgorithm {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int choice = 0, number = 0, num1 = 0, num2 = 0, exponent = 0;
		double base = 0.0;
		System.out.println("Welcome to the simple algorithms");
		do {
		System.out.println("Options: ");
		System.out.println("1. List the Factors");
		System.out.println("2. Is my number a prime");
		System.out.println("3. Greatest Common Denominator");
		System.out.println("4. Powers");
		System.out.print("Please choose an option: ");
		choice = cin.nextInt();
			if(choice != 3 && choice !=4) {
			System.out.print("Number: ");
			 number = cin.nextInt();
			}else if(choice == 3){
			System.out.print("Please enter the first number: ");
			num1 = cin.nextInt();
			System.out.print("Please enter the second number: ");
			num2 = cin.nextInt();
			}else if(choice == 4) {
				System.out.print("Please enter the base: ");
				base = cin.nextDouble();
				System.out.print("Please enter the exponent: ");
				 exponent = cin.nextInt();
			}
		if(choice == 1) {
			factors(number);
			System.out.println("");
		}else if(choice == 2) {
			if(prime(number)) { //Call method prime to check for Primeness
				System.out.print(number + " is a prime number.");
			}else {
				System.out.print(number + " is not a prime number.");
			}
			System.out.println("");
		}else if(choice == 3) {
			System.out.println("GCD of the numbers: " + num1 + " and " + num2 + " is " + GCD(num1, num2));
		}else if(choice == 4) {
			if(exponent < 1) { // If the exponent is negative
			System.out.println("The base of " + base + " raised to " + exponent + " is 1/" + power(base, exponent));	
			}else {
			System.out.println("The base of " + base + " raised to " + exponent + " is " + power(base, exponent));
			}
		}else if(choice == 5) {
			downDigit(number);
		}else if(choice == 6) {
			
		}else if(choice == 7) {
			
		}else if(choice == 8) {
			
		}
			
	}while(choice != 9);
	}
	
	private static void factors(int num) { // Factors function
		System.out.print("The Factors of " + num + " are: ");
		for(int i = 1; i < num; i++) {
			if(num%i == 0) {
				System.out.print(i + ", ");
			}
		}
		System.out.print(num + ".");
	}
	
	private static boolean prime(int n) { // Function to check for prime
	    for(int i=2;i<n;i++) 
	    {
	        if(n%i==0)
	            return false; //Not Prime
	    }
	    return true; // Is Prime
	}
	
	private static int GCD(int a, int b) { // Using euclid 's method to find GCD
		if(b == 0) { // If a is zero, then we set 
			return a; // If the bottom number is zero then we return 
		}
		return GCD(b, a%b); // We return with the function with int a being our previous b value, and int b being the modulus of a%b
	}
	
	private static double power(double base, int exponent) { // Power function, cause we cant use .pow() :(
		// To calculate the power we first get the power
		Scanner cin = new Scanner(System.in);
		double poweredint = 0;
		if(base == 0 && exponent < 1) {
			System.out.print("If the base is 0, then your exponent has to be positive");
			System.out.print("Please enter a base: ");
			base = cin.nextDouble();
			System.out.print("Please enter an exponent: ");
			exponent = cin.nextInt();
			power(base, exponent); 
			return 0;
		}else if(exponent == 0) {
			poweredint = 1.0;
			return poweredint;
		}else if(exponent > 0) {
			return base * power(base, --exponent); // RECURSION WOOP WOOP
		}else { // Negative Exponent
			exponent = -exponent; // Absolute Value
			return base * power(base, --exponent);
		}
	}
	
	private static int downDigit(int num) { // num is the number, n is the nth digit
		int digit = 0, mod = 1;
		do {
			 mod *= 10;
			 System.out.println(mod);
			 System.out.println(num/mod);
			 System.out.println(mod%10);
			//digit = (num/mod)/(mod%10);
			return digit;
		}while(mod != 1000000);
	}
}
