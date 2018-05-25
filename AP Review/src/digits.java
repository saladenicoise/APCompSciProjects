import java.util.ArrayList;

public class digits {
	private static ArrayList<Integer> digitList;

	public digits(int num) {
		digitList = new ArrayList<Integer>();
		if (num == 0)
		{
			digitList.add(new Integer(0));
		}
		while (num > 0)
		{
			digitList.add(0, new Integer(num % 10));
			num /= 10;
		}
	}

	public boolean isStrictlyIncreasing() {
		int max = 0;
		boolean bool = false;
		for(int curr : digitList) {
			System.out.print(curr + " ");
			if(max <= curr) {
				max = curr;
				System.out.println(max);
			}else {
				bool = false;
			}
		}
		if(bool = false) {
			return false;
		}else {
			return true;
		}
	}
	
	public void showList() {
		for(int i : digitList) {
			System.out.print(i);
		}
	}

	public static void main(String[] args) {
		digits d1 = new digits(123456);
		d1.showList();
		System.out.println();
		System.out.println(d1.isStrictlyIncreasing());
	}
}
