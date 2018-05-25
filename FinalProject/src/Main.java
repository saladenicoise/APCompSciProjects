import java.util.*;
//Author: Jules Petit | E Block
import java.io.*;

/**
 * Main Class
 * @author Jules Petit | E Block
 */
public class Main {

	private static char[][] grid;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		grid = GridCreator.CreateDefaultGrid();
		Scanner userIn = new Scanner(System.in);
		Scanner menuIn = new Scanner(System.in);
		int userChoice = 0;
		String fileName = "", userFileChoice = "";
		while(userChoice != 9) {
			System.out.println("---------[Cryptography Menu]---------");
			System.out.println("1. Create and save a default grid");
			System.out.println("2. Create and save a random grid");
			System.out.println("3. Load a grid from a text file");
			System.out.println("4. Display the current grid");
			System.out.println("5. Encrypt text and print to a file");
			System.out.println("6. Encrypt text file");
			System.out.println("7. Decrypt text and print to a file");
			System.out.println("8. Decrypt text file");
			System.out.println("9. Quit");
			System.out.println("-------------------------------------");
			System.out.print("Choice: ");
			userChoice = menuIn.nextInt();
			switch(userChoice) {
			case 1:
				grid = GridCreator.CreateDefaultGrid();
				System.out.print("What name do you want to save the grid under?: ");
				userFileChoice = userIn.nextLine();
				FileUtil.outputGridToFile(grid, userFileChoice);
				break;
			case 2:
				grid = GridCreator.CreateRandomGrid();
				System.out.print("What name do you want to save the grid under?: ");
				userFileChoice = userIn.nextLine();
				FileUtil.outputGridToFile(grid, userFileChoice);
				break;
			case 3:
				System.out.print("What is the name of the text file(must be on desktop, please ommit .txt): ");
				fileName = userIn.nextLine();
				grid = FileUtil.loadGridFromFile(fileName);
				break;
			case 4:
				if(grid.length == 0) {
					System.out.println("Error: grid is empty, cannot output an empty grid");
				}else {
					FileUtil.printArrayToConsole(grid);
				}
				break;
			case 5:
				if(grid.length == 0) {
					System.out.println("Error: grid is empty, cannot encrypt with an empty grid");
				}else {
					int modAdd = 0;
					FileUtil.printArrayToConsole(grid);
					System.out.println("Enter text to encrypt: ");
					String text = userIn.nextLine();
					System.out.print("Would you like extra security in the form of a modular addition(yes/no)? ");
					String choice = userIn.nextLine();
					choice = choice.toLowerCase();
					if(choice.equals("yes")) {
						System.out.print("Number to perform modular addition with: ");
						modAdd = menuIn.nextInt();
					}else if(choice.equals("no")) {
						modAdd = 0;
					}else {
						System.out.println("Error: Invalid Choice");
					}
					Encryption.encryptFromText(text, grid, modAdd);
				}
				break;
			case 6:
				if(grid.length == 0) {
					System.out.println("Error: grid is empty, cannot encrypt with an empty grid");
				}else {
					int modAdd = 0;
					FileUtil.printArrayToConsole(grid);
					System.out.println("Enter name of file to encrypt(Must be on desktop): ");
					fileName = userIn.nextLine();
					System.out.print("Would you like extra security in the form of a modular addition(yes/no)? ");
					String choice = userIn.nextLine();
					choice = choice.toLowerCase();
					if(choice.equals("yes")) {
						System.out.print("Number to perform modular addition with: ");
						modAdd = menuIn.nextInt();
					}else if(choice.equals("no")) {
						modAdd = 0;
					}else {
						System.out.println("Error: Invalid Choice");
					}
					Encryption.encryptFromFile(fileName, grid, modAdd);
				}
				break;
			case 7:
				if(grid.length == 0) {
					System.out.println("Error: grid is empty, cannot encrypt with an empty grid");
				}else {
					int modAdd = 0;
					FileUtil.printArrayToConsole(grid);
					System.out.println("Enter text to decrypt: ");
					String text = userIn.nextLine();
					System.out.print("Was the text encrypted with extra security(yes/no)? ");
					String choice = userIn.nextLine();
					choice = choice.toLowerCase();
					if(choice.equals("yes")) {
						System.out.print("Number used to perfom modular addition: ");
						modAdd = menuIn.nextInt();
					}else if(choice.equals("no")) {
						modAdd = 0;
					}else {
						System.out.println("Error: Invalid Choice");
					}
					Decryption.decryptFromText(text, grid, modAdd);
				}
				break;
			case 8:
				if(grid.length == 0) {
					System.out.println("Error: grid is empty, cannot encrypt with an empty grid");
				}else {
					int modAdd = 0;
					FileUtil.printArrayToConsole(grid);
					System.out.println("Enter name of file to decrypt(Must be on desktop): ");
					fileName = userIn.nextLine();
					System.out.print("Was the text encrypted with extra security(yes/no)? ");
					String choice = userIn.nextLine();
					choice = choice.toLowerCase();
					if(choice.equals("yes")) {
						System.out.print("Number used to perfom modular addition: ");
						modAdd = menuIn.nextInt();
					}else if(choice.equals("no")) {
						modAdd = 0;
					}else {
						System.out.println("Error: Invalid Choice");
					}
					Decryption.decryptFromFile(fileName, grid, modAdd);
				}
				break;
			}
		}
	}

}
