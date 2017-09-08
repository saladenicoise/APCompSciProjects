import java.util.Scanner;

public class factorialofprimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner fac = new Scanner(System.in);
		int num = 0, factorial = 0, count = 0;
		int primes[] = new int[120]; // Definition of array to contain our primes
		do {
		System.out.print("Number: ");
		num = fac.nextInt(); // Input
		for(int i = 2; i <= 120; i++) { // Adds the first 120 primes to the array
			if(isPrime(i)) { // Checks if i is prime
				primes[count] = i; // Adds i to array if its prime
				count++;
			}
		}
		//Factorial Calculations
		if(num != -1) {
			if(primes[num] == 0) {
				factorial = 0;
			}else {
				int fact = primes[num];
				for(int i = 1; i <= num; i++) {
					fact *= i; // Calculates the factorial
					System.out.println("Fact: " + fact);
				}
				factorial = fact;
			}
			System.out.println("Result: " + primes[num] + ", " + factorial);
		}
		}while(num != -1); // Repeat everything until user wants to quit
		
	}
	
	private static boolean isPrime(int n) { // Function to check for prime
	    for(int i=2;i<n;i++) 
	    {
	        if(n%i==0)
	            return false; //Not Prime
	    }
	    return true; // Is Prime
	}
}
