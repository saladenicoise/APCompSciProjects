
public class Main {

	public static void main(String[] args) {
		char[][] grid = GridCreator.CreateRandomGrid();
		for(char [] c : grid) {
			for(char c1 : c) {
				System.out.print(c1 + " | ");
			}
			System.out.println();
		}
	}
	
}
