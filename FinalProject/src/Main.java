import java.util.*;
import java.io.*;

public class Main {
	
	private static char[][] grid;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		grid = GridCreator.CreateDefaultGrid();
		Scanner userIn = new Scanner(System.in);
		FileUtil.printArrayToConsole(grid);
		//System.out.print("What name do you save the grid under?: ");
		//String userFileChoice = userIn.nextLine();
		//FileUtil.OutputGridToFile(grid, userFileChoice);
		//System.out.print("What is the name of the file you want to load?(Must be on user desktop): ");
		//String userInChoice = userIn.nextLine();
		//grid = FileUtil.loadGridFromFile(userInChoice);
		//FileUtil.printArrayToConsole(grid);
		//System.out.println("What would you like to encode?: ");
		//String encode = userIn.nextLine();
		//Encryption.EncryptFromFile("TestEncrypt", grid, 37421);
		//Encryption.EncryptFromText("apcomputerscience8", grid, 0);
		Decryption.decryptFromText("534626138190528215018152/8.", grid, 37421);
	}
	
}
