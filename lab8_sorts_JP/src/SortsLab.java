//********************************************************************
//  Sortlab.java       Author:
//
//  Driver to exercise the use of several Sorting Arrays methods.
//********************************************************************


public class SortsLab
{
    static final int MAX=1000;
	
    public SortsLab()
    {
    	int[] list = new int[MAX], list2 = new int[MAX], list3 = new int[MAX], list4 = new int[MAX], list5 = new int[MAX];
		int qcount=0, icount = 0, scount = 0, mcount = 0;
			
			
		//Random Order List//////////////////
		
			System.out.println("Random order lists ");
			ListSetup.MakeRandom (list);
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			
		
			System.out.println("List before sorting:");
			ListSetup.Print (list);
			//System.out.println("Here is the list after the Insertion Sort. ");
			//icount = Sorts.Insertion(list, 0);
			//ListSetup.Print (list);
			//System.out.println("There were " + icount + " comparisons ");
		
		
			//System.out.println("Here is the list after the Selection Sort. ");
			//scount = Sorts.Selection(list2, 0);
			//System.out.println("Scount: " + scount);
			//ListSetup.Print (list2);
			System.out.println("Here is the list after the Quicksort (split first). ");
			qcount = Sorts.QuickSort(list3, 0, list.length - 1, 0);
			System.out.println("Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split mid). ");
			qcount = Sorts.QuickMid(list3, 0, list.length - 1, 0);
			System.out.println("Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split random). ");
			qcount = Sorts.QuickRandom(list3, 0, list.length - 1, 0);
			System.out.println("Qcount: " + qcount);
			ListSetup.Print (list3);
			//System.out.println("Here is the list after the Merge Sort. ");
			////mcount = Sorts.mergeSort(list4, 0, list.length - 1, 0);
			//System.out.println("Mcount: " + mcount);
			//ListSetup.Print (list4);
			System.out.println();
			System.out.println("---------------------------");
			System.out.println();
		//Ascending Order List//////////////////
	
			System.out.println("Ascending order lists ");
			ListSetup.MakeInOrder (list);
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			
		
			System.out.println("List before sorting:");
			ListSetup.Print (list);
			//System.out.println("Here is the list after the Insertion Sort. ");
			//icount = Sorts.Insertion(list, 0);
			//ListSetup.Print (list);
			//System.out.println("There were " + icount + " comparisons in Asceding order");
		
		
			//System.out.println("Here is the list after the Selection Sort. ");
			//scount = Sorts.Selection(list2, 0);
			//System.out.println("Ascending Scount: " + scount);
			//ListSetup.Print (list2);
			System.out.println("Here is the list after the Quicksort (split first). ");
			qcount = Sorts.QuickSort(list3, 0, list.length - 1, 0);
			System.out.println("Ascending Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split mid). ");
			qcount = Sorts.QuickMid(list3, 0, list.length - 1, 0);
			System.out.println("Ascending Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split random). ");
			qcount = Sorts.QuickRandom(list3, 0, list.length - 1, 0);
			System.out.println("Ascneding Qcount: " + qcount);
			ListSetup.Print (list3);
			//System.out.println("Here is the list after the Merge Sort. ");
			//mcount = Sorts.mergeSort(list4, 0, list.length - 1, 0);
			//System.out.println("Ascending Mcount: " + mcount);
			//ListSetup.Print (list4);
			
			System.out.println();
			System.out.println("---------------------------");
			System.out.println();
	
		//Descending Order List//////////////////
	
			System.out.println("Descending order lists ");
			ListSetup.MakeReverse (list);
			ListSetup.Copy (list,list2);
			ListSetup.Copy (list,list3);
			ListSetup.Copy (list,list4);
			ListSetup.Copy (list,list5);
			
		
			System.out.println("List before sorting:");
			ListSetup.Print (list);
			//System.out.println("Here is the list after the Insertion Sort. ");
			//icount = Sorts.Insertion(list, 0);
			//ListSetup.Print (list);
			//System.out.println("There were " + icount + "  descending comparisons ");
		
		
			//System.out.println("Here is the list after the Selection Sort. ");
			//scount = Sorts.Selection(list2, 0);
			//System.out.println("Descending Scount: " + scount);
			//ListSetup.Print (list2);
			System.out.println("Here is the list after the Quicksort (split first). ");
			qcount = Sorts.QuickSort(list3, 0, list.length - 1, 0);
			System.out.println("Descending Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split mid). ");
			qcount = Sorts.QuickMid(list3, 0, list.length - 1, 0);
			System.out.println("Descending Qcount: " + qcount);
			ListSetup.Print (list3);
			System.out.println("Here is the list after the Quicksort (split random). ");
			qcount = Sorts.QuickRandom(list3, 0, list.length - 1, 0);
			System.out.println("Descending Qcount: " + qcount);
			ListSetup.Print (list3);
			//System.out.println("Here is the list after the Merge Sort. ");
			//mcount = Sorts.mergeSort(list4, 0, list.length - 1, 0);
			//System.out.println("Descending Mcount: " + mcount);
			//ListSetup.Print (list4);
			
			
	}	
	
	public static void main(String args[])
	{
		
		new SortsLab();
	}
}
