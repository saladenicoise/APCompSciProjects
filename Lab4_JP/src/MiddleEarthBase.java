import java.util.*;
import java.math.*;


public class MiddleEarthBase {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("What Race: ");
		String race = input.nextLine();
		System.out.println(race);
		System.out.print("Number 1: ");
		int num1 = input.nextInt();
		System.out.print("Number 2: ");
		int num2 = input.nextInt();
		if(race.equals("wizard") || race.equals("Wizard")) {
			System.out.println(add(num1, num2, 2));
		}else if(race.equals("dwarf") || race.equals("Dwarf")) {
			System.out.println(add(num1, num2, 5));
		}else if(race.equals("elves") || race.equals("Elves")) {
			System.out.println(add(num1, num2, 8));
		}else if(race.equals("human") || race.equals("Human")) {
			System.out.println(add(num1, num2, 10));
		}else {
			System.out.println("Not a valid race, valid choices are: human, Human, Elves, elves, dwarf, Dwarf, Wizard, wizard");
		}
		//System.out.print(multiply(num1, num2, 10));
		
	}

	public static int add(int num1, int num2, int base) {
		int num1digit = 0, num2digit = 0, sum = 0, sum2 = 0, carry = 0, digitcounter = 0, tens = 1, digits = 0, num1hold = num1, sum2carry = 0;
		do {
					num1digit = (num1/tens) % 10;
					num2digit = (num2/tens) % 10;
					if(carry > 0) {
						num2digit = num2digit + carry;
					}
					sum = num1digit + num2digit;
					carry = 0;
					if(sum > base) {
						sum = sum%base;
						carry = 1;
					}
			sum2 = sum * (int) Math.pow(10, digitcounter) + sum2;
			tens = tens * 10;
			digitcounter++;
		}while(digitcounter != 4);
		System.out.println(num1);
		System.out.println("+ " + num2);
		System.out.println("----");
		return sum2;
	}
	
	public static int multiply(int num1, int num2, int base) {
		//Finds the number of digits to see how many times to repeat
		int num2digit = 0, sum = 0, tens = 1, sumdigit = 0, digitcounter = 0, digithold = 0, carry = 0, result = 0, tens1 = 1;
	do {
		num2digit = (num2/tens) % 10;
		digitcounter++;
		sum = num2digit * num1 + sum;
		tens = tens * 10;
	}while(digitcounter != 4);
	do {
		sumdigit = (sum/tens1) % 10;
		if(sumdigit > base) {
			digithold = sumdigit%base;
			carry = 1;
		}
		result = digithold + (carry * 10 * (int) Math.pow(10, digitcounter)) + result;
	tens1 = tens1 * 10;
	}while(sumdigit != 0) ;
	return sum;
	}	


}

