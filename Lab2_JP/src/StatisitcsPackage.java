import java.io.*;
import java.util.*;

public class StatisitcsPackage {

	public static void main(String[] args) {
		String pathname = "src/nums.txt";
		File file = new File(pathname);
		Scanner input = null;
		int arraysize = 0;
		try {
			input = new Scanner(file);
		}
		catch(FileNotFoundException ex) {
			System.out.println("*** Cannot Open " + pathname + " ***");
			System.exit(1);
		}
		arraysize = input.nextInt();
		int []numbers = new int[arraysize];
		int linecounter = 0;
		while(input.hasNextInt()) {
			for(int i = 0; i < arraysize; i++) {
				numbers[i] = input.nextInt();
			}
			
			for(int i = 0; i < arraysize; i++) {
				System.out.print(numbers[i] + " ");
				linecounter++;
				if(linecounter%10==0) {
					System.out.print("\n");
				}
			}
		}
		input.close();
	}
	
	public static void output(int arraysize) {
		
	}
}