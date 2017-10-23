import java.util.*;
import java.math.*;


public class MiddleEarthBase {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number 1: ");
		int num1 = input.nextInt();
		System.out.print("Number 2: ");
		int num2 = input.nextInt();
		int result = add(num1, num2, 5);
		System.out.println(result);
	}

	public static int add(int num1, int num2, int base) {
		int num1digit = 0, num2digit = 0, sum = 0, sum2 = 0, carry = 0, digitcounter = 0, tens = 1, digits = 0, num1hold = num1;
		do {
			num1hold = num1hold/10;
			digits++;
		}while(num1hold >= 1);
		do {
			carry = 0;
					num1digit = (num1/tens) % 10;
					num2digit = (num2/tens) % 10;
					if(carry > 0) {
						num2digit = num2digit + carry;
					}
					sum = num1digit + num2digit;
					if(sum > base) {
						sum = sum%base;
						carry = 1;
					}
			sum2 = sum* (int) Math.pow(tens, digitcounter) + sum2 + (carry * 10 *((int) Math.pow(tens, digitcounter)));
			tens = tens * 10;
			digitcounter++;
			num1 = num1/10;
			num2 = num2/10;
		}while(digitcounter != digits);
		return sum2;
	}

}

