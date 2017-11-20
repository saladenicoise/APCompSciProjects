import java.util.*;

public class recursion {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
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
		int choice = input.nextInt();
		do {
			if(choice == 1) {
				System.out.print("Please choose a number:");
				int num1 = input.nextInt();
				System.out.println(powerOf3(num1));
			}else if(choice == 2) {

			}else if(choice == 3) {

			}else if(choice == 4) {

			}else if(choice == 5) {

			}else if(choice == 6) {

			}
		}while(choice != 7);

		/*System.out.print("Please choose a number:");
		int num1 = input.nextInt();
		System.out.println(powerOf3(num1));
		System.out.print("Please choose a number:");
		int num2 = input.nextInt();
		System.out.println(reverse(num2));
		System.out.print("Please choose a number:");
		int num3 = input.nextInt();
		printWithCommas(num3);*/
		System.out.print("Please input a letter:");
		String letters = input.next();
		char lowerletter = letters.charAt(0);
		letters(lowerletter);
	}


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


	public static boolean powerOf3(int num) {
		if(num == 1) {
			return true;
		}else if(num%3 != 0) {
			return false;
		}else {
			return powerOf3(num/3);
		}
	}

	public static int tenPower(int num) {
		if(num/10 == 0) {
			return 1;
		}else {
			return 10 * tenPower(num/10);
		}
	}

	public static int reverse(int num) {
		if(num%10 == num) {
			return num;
		} else {
			return (((num%10) * tenPower(num)) + reverse(num/10));
		}
	}

	public static int base5(int num) {
		if(num != 0) {
			base5(num/5);
		}
		return num%5;
	}

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
