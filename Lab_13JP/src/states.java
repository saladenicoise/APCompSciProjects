import java.util.*;
import java.io.*;

public class states {

	/*
	 * Name: Jules Petit
	 * Lab 13
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("states.in"));
		Scanner in = new Scanner(f);
		int counter = 0;
		boolean searching = false, equal = false;
		ArrayList<String> states = new ArrayList<String>();
		while(in.hasNextLine()) {
			searching = true;
			String line = in.nextLine();
			for(int a = 0; a < states.size() && searching; a++) {
				if(line.compareTo(states.get(a)) < 0) {
					states.add(a, line);
					searching = false;
				}else if(line.equals(states.get(a)))	{
					states.remove(a);
				}
			}
			if(searching) {
				states.add(states.size(), line);
			}
		}
		menu(states);

	}

	public static void menu(ArrayList<String> states) throws IOException{
		ArrayList<String> immutable = (ArrayList<String>) states.clone();
		int choice = 0;
		boolean  looping = true;
		PrintWriter out = new PrintWriter("SavedStates.txt");
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		while(looping) {
			System.out.println("--------------------");
			System.out.println("Menu");
			System.out.println("1. Display List");
			System.out.println("2. Insert Item");
			System.out.println("3. Remove Item");
			System.out.println("4. Save List");
			System.out.println("5. Quit");
			System.out.print("Choice: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				displayList(states);
				break;
			case 2:
				System.out.print("Enter a state to add: ");
				String add = in.nextLine();
				states = insertItem(states, add);
				break;
			case 3:
				System.out.print("Enter a state to remove: ");
				String remove = in.nextLine();
				states = removeItem(states, remove);
				break;
			case 4:
				System.out.println("Saving to file: SavedStates.txt");
				for(String statesLine : states) {
					out.println(statesLine);
				}
				out.close();
				break;
			case 5:
				states = (ArrayList<String>) immutable.clone();
				System.out.println("Bye, Bye");
				looping = false;
				break;
			}
		}
	}

	public static void displayList(ArrayList<String> states) {
		for(String line : states) {
			System.out.println(line);
		}
	}

	public static ArrayList<String> insertItem(ArrayList<String> states, String add) {
		boolean searching = false, dupe = false;
		for(String stateFinder : states) {
			if(add.equals(stateFinder)) {
				System.out.println("Error: State already exists!");
				dupe = true;
			}
		}
		if(!dupe) {
			states.add(add);
			for (int size = states.size(); size != 1; --size) {
		        for (int i = 0; i < size - 1; i++) {
		            String temp1 = states.get(i + 1);
		            String temp2 = states.get(i);
		            if (temp2.compareTo(temp1) < 0) {
		                states.set(i, temp1);
		                states.set(i + 1, temp2);
		            }
		        }
		    }
		}
		return states;
	}

	public static ArrayList<String> removeItem(ArrayList<String> states, String remove) {
		boolean found = false;
		for(int a = 0; a < states.size(); a++) {
			if(remove.equals(states.get(a))) {
				states.remove(states.indexOf(remove)); //Successfully removed state
				found = true;
			}
		}
		if(!found) {
			System.out.println("Error: Element does not exist in the array!");
		}
		return states;
	}
}
