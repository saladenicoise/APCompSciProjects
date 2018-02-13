/**
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The very slow dog, was jumping over the slow cat who was running after the slow turtle";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		//  Try other methods here:
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn);

		//.indexOf with 2 arguments
		int pos = 0;
		int pos2 = 0;
		pos = sample.indexOf("slow"); // Gets the position of the first letter of the string.
		System.out.println("Pos: " + pos);
		pos2 = sample.indexOf("slow", pos+"slow".length()); // Gets the position of the string "slow" starting at the index of the last letter of the previous occurence, allowing us to check for more than 1 occurence
		System.out.println("Pos: " + pos2);
		
	}

}
