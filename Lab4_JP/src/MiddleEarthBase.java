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
		input.nextLine(); // Code to allow for operation input
		System.out.print("What Operation(+ or *): ");
		String op = input.nextLine();
		if(race.equals("wizard") || race.equals("Wizard")) {
			if(op.equals("+")) {
				System.out.println(add(num1, num2, 2));
			}else if(op.equals("*")) {
				System.out.println(multiply(num1, num2, 2));
			}else {
				System.out.println("Not a valid operation, valid operations are: * or +");
			}
		}else if(race.equals("dwarf") || race.equals("Dwarf")) {
			if(op.equals("+")) {
				System.out.println(add(num1, num2, 5));
			}else if(op.equals("*")) {
				System.out.println(multiply(num1, num2, 5));
			}else {
				System.out.println("Not a valid operation, valid operations are: * or +");
			}
		}else if(race.equals("elf") || race.equals("Elf")) {
			if(op.equals("+")) {
				System.out.println(add(num1, num2, 8));
			}else if(op.equals("*")) {
				System.out.println(multiply(num1, num2, 8));
			}else {
				System.out.println("Not a valid operation, valid operations are: * or +");
			}
		}else if(race.equals("human") || race.equals("Human")) {
			if(op.equals("+")) {
				System.out.println(add(num1, num2, 10));
			}else if(op.equals("*")) {
				System.out.println(multiply(num1, num2, 10));
			}else {
				System.out.println("Not a valid operation, valid operations are: * or +");
			}
		}else {
			System.out.println("Not a valid race, valid choices are: human, Human, Elves, elves, dwarf, Dwarf, Wizard, wizard");
		}

	}

	public static int add(int num1, int num2, int base) {
		int num1digit = 0, num2digit = 0, sum = 0, sum2 = 0, carry = 0, digitcounter = 0, digitpos = 1;
		do {
			num1digit = (num1/digitpos) % 10;
			num2digit = (num2/digitpos) % 10;
			if(carry > 0) {
				num2digit = num2digit + carry;
			}
			sum = num1digit + num2digit;
			carry = 0;
			if(sum >= base) {
				sum = sum%base;
				carry = 1;
			}
			sum2 = sum * (int) Math.pow(10, digitcounter) + sum2;
			digitpos = digitpos * 10;
			digitcounter++;
		}while(digitcounter <= 4);
		System.out.println(num1);
		System.out.println("+ " + num2);
		System.out.println("----");
		return sum2;
	}

	public static int multiply(int num1, int num2, int base) {
		//Finds the number of digits to see how many times to repeat
		//For each digit of number 2 multiply by each digit of number 1, loops inside of loops.
		int digitcounter2 = 0, num2digit = 0, tens = 1, sum = 0, sum2 = 0, digitcounter = 0, important = 1, tens1 = 1, sum3 = 0, sumhold = 0, digits = 0, digitcounter3 = 0, sumdigit = 0, tens2 = 1, carry = 0, result = 0, num1hold = num1, num2hold = num2, digits1 = 0, digits2= 0, sum3hold = 0, sum4 = 0, sum4hold, digits3 = 0, sum5 = 0, resultdigit = 0, tens3 = 1, digitcounter4 = 0;
		do {
			if(num1hold >= 1) {
				num1hold = num1hold/10;
				digits1++;
			}
			if(num2hold >= 1) {
				num2hold = num2hold/10;
				digits2++;
			}
		}while(num2hold >= 1 || num1hold >= 1);
		do {
			tens1 = 1;
			num2digit = (num2/tens) % 10;
			digitcounter = 0;
			sum2 = 0;
			sum3 = 0;
			digits = 0;
			tens2 = 1;
			digitcounter3 = 0;
			do {
				carry = 0;
				sum = num2digit * ((num1/tens1) % 10);
				if(sum > base) {
					carry = sum/base;
					sum = sum%base;
				}
				sum2 = sum2 + (sum * (int) Math.pow(10, digitcounter)) + (carry * (int) Math.pow(10, digitcounter+1));
				tens1 *= 10;
				digitcounter++;
			}while(digitcounter <= digits1 || digitcounter <= digits2);
			sum2 = sum2 * important;
			sum3 = sum2 + sum3 + (carry * (int) Math.pow(10, digitcounter2));
			tens *= 10;
			digitcounter2++;
			sum3hold = sum3;
			sum4 = 0;
			do {
				sum3hold = sum3hold/10;
				digits++;
			}while(sum3hold >= 1);
			do {
				sumdigit = (sum3/tens2) % 10;
				carry = 0;
				if(sumdigit >= base) {
					carry = sumdigit/base;
					sumdigit = sumdigit%base;
				}
				sum4 = (sumdigit * (int) Math.pow(10, digitcounter3)) + (carry * (int) Math.pow(10, digitcounter3+1)) + sum4;
				tens2 *= 10;
				digitcounter3++;
			}while(digitcounter3 <= digits);
			result = sum4 + result;
			sumhold = sum4;
			System.out.println(sumhold);
			important *= 10;
		}while(digitcounter2 <= digits1);
		sum4hold = result;
		System.out.println("Answer Before Conversion: " + result);
		do {
			sum4hold = sum4hold/10;
			digits3++;
		}while(sum4hold >= 1);
		do {
			resultdigit = (result/tens3) % 10;
			carry = 0;
			if(resultdigit >= base) {
				carry = resultdigit/base;
				resultdigit = resultdigit%base;
			}
			sum5 = (resultdigit * (int) Math.pow(10, digitcounter4)) + (carry * (int) Math.pow(10, digitcounter4+1)) + sum5;
			tens3 *= 10;
			digitcounter4++;
		}while(digitcounter4 <= digits3);
		System.out.println("====");
		return sum5;
	}
}

