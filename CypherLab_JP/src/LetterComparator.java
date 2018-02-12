import java.io.*;
import java.util.*;

public class LetterComparator implements Comparator {

	public int compare(Object a, Object b) {
		char associatedLetter1 = ((Record)a).getAssociated();
		char associatedLetter2 = ((Record)b).getAssociated();
		if((int)associatedLetter1 > (int)associatedLetter2) {
			return 1;
		}else if((int)associatedLetter1 < (int)associatedLetter2) {
			return -1;
		}else {
			return 0;
		}
	}

}
