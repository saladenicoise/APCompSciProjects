
import java.util.*;
import java.io.*;

public class cabbages {

	public static Scanner in = null;
	public static void main(String[] args) throws IOException {
		String line = "";
		int b = 0, c = 0;
		// TODO Auto-generated method stub
		//Using buffered reader is much faster to read.
		BufferedReader f = new BufferedReader(new FileReader("Cabbages.txt"));
		in = new Scanner(f);
		while(in.hasNext()) {
			b++;
			line = in.next();
			System.out.println(b + " " + line);
		}
	}

}
