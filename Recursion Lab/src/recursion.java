import java.util.*;

public class recursion {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please choose a number:");
		int num1 = input.nextInt();
		System.out.println(powerOf3(num1));
		System.out.print("Please choose a number:");
		int num2 = input.nextInt();
		System.out.println(reverse(num2));
		System.out.print("Please choose a number:");
		int num3 = input.nextInt();
		printWithCommas(num3);
	}
	
	//13 - > 0
	//12 - > 2 b/c 12= 3 * 4 = 3 * 2 * 2
	//48 - > 4 b/c 48 = 6 * 8 = 3 * 2 * 4 * 2 = 3 * 2 * 2 * 2 * 2
	
	public static int twos(int num) {
		if(num%2 != 0) {
			return 0;
		}else {
			
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
