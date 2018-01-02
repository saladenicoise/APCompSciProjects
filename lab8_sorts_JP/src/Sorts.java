//********************************************************************
//  Sorts.java       Author:
//
//  A collection of methods for sorting Arrays.
//********************************************************************

import java.util.*;

public class Sorts
{

	private static int[] temp;

	public static int Insertion(int[] list)
	{
		int icount = 0;
		for (int n = 1; n < list.length; n++)
		{
			// Save the next element to be inserted:

			int listTemp = list[n];

			// Going backward from list[n-1], shift elements to the
			//   right until you find an element list[i] <= aTemp:

			int i = n;
			icount++;
			while (i > 0 && listTemp < list[i-1])
			{
				list[i] = list[i-1];
				i--;
				icount++;
			}

			// Insert the saved element after a[i]:
			list[i] = listTemp;
			// Increment n (accomplished by n++ in the for loop).
		}

		return icount;
	}
	
	public static int InsertionMoveCounter(int[] list)
	{
		int movecount = 0;
		for (int n = 1; n < list.length; n++)
		{
			// Save the next element to be inserted:

			int listTemp = list[n];

			// Going backward from list[n-1], shift elements to the
			//   right until you find an element list[i] <= aTemp:

			int i = n;
			movecount++;
			while (i > 0 && listTemp < list[i-1])
			{
				list[i] = list[i-1];
				i--;
				movecount++;
			}

			// Insert the saved element after a[i]:
			list[i] = listTemp;
			movecount = movecount + 3;
			// Increment n (accomplished by n++ in the for loop).
		}

		return movecount;
	}


	public static int Selection(int[] list)
	{
		int scount = 0;
		for (int n = list.length; n > 1; n--)
		{
			// Find the index iMax of the largest element
			//   among list[0], ..., list[n-1]:

			int iMax = 0;
			for (int i = 1; i < n; i++)
			{
				if (list[i] > list[iMax]) {
					iMax = i;
				}
					scount++;
			}

			swap (list, iMax, n-1);

			// int listTemp = list[iMax];
			// list[iMax] = list[n-1];
			// list[n-1] = listTemp;

			// Decrement n (accomplished by n-- in the for loop).
		}
		return scount;
	}
	
	public static int SelectionMoveCounter(int[] list)
	{
		int movecounter = 0;
		for (int n = list.length; n > 1; n--)
		{
			// Find the index iMax of the largest element
			//   among list[0], ..., list[n-1]:

			int iMax = 0;
			for (int i = 1; i < n; i++)
			{
				if (list[i] > list[iMax]) {
					iMax = i;
				}
				movecounter++;
			}

			swap (list, iMax, n-1);
			movecounter = movecounter + 3;

			// int listTemp = list[iMax];
			// list[iMax] = list[n-1];
			// list[n-1] = listTemp;

			// Decrement n (accomplished by n-- in the for loop).
		}
		return movecounter;
	}

	public static int Merge(int[] list, int from, int middle, int to)
	{
		int mcount = 0;
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			mcount++;
			if (list[i] < list[j])
			{
				temp[k] = list[i];   // Or simply temp[k] = a[i++];
				i++;	
			}
			else
			{
				temp[k] = list[j];
				j++;
			}
			k++;
		}

		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
		{
			temp[k] = list[i];     // Or simply temp[k++] = a[i++]
			i++;
			k++;
		}

		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
		{
			temp[k] = list[j];     // Or simply temp[k++] = a[j++]
			j++;
			k++;
		}

		// Copy temp back into a
		for (k = from; k <= to; k++)
			list[k] = temp[k];
		return mcount;
	}
	
	public static int MergeMoveCoutner(int[] list, int from, int middle, int to)
	{
		int movecount = 0;
		temp = new int[list.length];
		int i = from, j = middle + 1, k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			movecount++;
			if (list[i] < list[j])
			{
				temp[k] = list[i];   // Or simply temp[k] = a[i++];
				i++;	
				movecount = movecount + 3;
			}
			else
			{
				temp[k] = list[j];
				j++;
				movecount = movecount + 3;
			}
			k++;
		}

		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
		{
			temp[k] = list[i];     // Or simply temp[k++] = a[i++]
			i++;
			k++;
			movecount++;
		}

		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
		{
			temp[k] = list[j];     // Or simply temp[k++] = a[j++]
			j++;
			k++;
			movecount++;
		}

		// Copy temp back into a
		for (k = from; k <= to; k++)
			list[k] = temp[k];
		return movecount;
	}

	public static int mergeSort(int[] list, int from, int to)
	{
		int mcount = 0;
		if (to - from < 2)       // Base case: 1 or 2 elements
		{
			mcount++;
			if (to > from && list[to] < list[from])
			{
				int listTemp = list[to];  // swap a[to] and a[from]
				list[to] = list[from];
				list[from] = listTemp;
			}
		}
		else                     // Recursive case
		{
			int middle = (from + to) / 2;
			mcount += mergeSort(list, from, middle);
			mcount += mergeSort(list, middle + 1, to);
			mcount += Merge(list, from, middle, to);
		}
		return mcount;
	}
	
	public static int mergeSortMoveCount(int[] list, int from, int to)
	{
		int movecount = 0;
		if (to - from < 2)       // Base case: 1 or 2 elements
		{
			movecount++;
			if (to > from && list[to] < list[from])
			{
				int listTemp = list[to];  // swap a[to] and a[from]
				list[to] = list[from];
				list[from] = listTemp;
				movecount = movecount + 3;
			}
		}
		else                     // Recursive case
		{
			int middle = (from + to) / 2;
			movecount += mergeSortMoveCount(list, from, middle);
			movecount += mergeSortMoveCount(list, middle + 1, to);
			movecount += Merge(list, from, middle, to);
		}
		return movecount;
	}

	public static int QuickSort(int[] list, int from, int to)
	{
		int qcount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		int p = from;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				qcount++;
		}else if (list[j] >= list[p]) {
				j--;
				qcount = qcount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				qcount = qcount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}

		// Sort recursively:
		qcount += QuickSort(list, from, p - 1);
		qcount += QuickSort(list, p + 1, to);

		return qcount;
	}
	
	public static int QuickSortMoveCounter(int[] list, int from, int to)
	{
		int movecount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		int p = from;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				movecount++;
		}else if (list[j] >= list[p]) {
				j--;
				movecount = movecount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				movecount = movecount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
			movecount = movecount + 3;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
			movecount = movecount + 3;
		}

		// Sort recursively:
		movecount += QuickSortMoveCounter(list, from, p - 1);
		movecount += QuickSortMoveCounter(list, p + 1, to);

		return movecount;
	}

	public static int QuickMid(int[] list, int from, int to)
	{
		int qcount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		int p = (from + to)/2;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				qcount++;
		}else if (list[j] >= list[p]) {
				j--;
				qcount = qcount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				qcount = qcount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}

		// Sort recursively:
		qcount += QuickMid(list, from, p - 1);
		qcount += QuickMid(list, p + 1, to);

		return qcount;
	}
	
	public static int QuickMidMoveCount(int[] list, int from, int to)
	{
		int movecount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		int p = (from + to)/2;
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				movecount++;
		}else if (list[j] >= list[p]) {
				j--;
				movecount = movecount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				movecount = movecount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
			movecount = movecount + 3;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
			movecount = movecount + 3;
		}

		// Sort recursively:
		movecount += QuickMidMoveCount(list, from, p - 1);
		movecount += QuickMidMoveCount(list, p + 1, to);

		return movecount;
	}

	public static int QuickRandom(int[] list, int from, int to)
	{
		int qcount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		Random random = new Random();
		int p =  (from + (random.nextInt(to-from)));
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				qcount++;
		}else if (list[j] >= list[p]) {
				j--;
				qcount = qcount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				qcount = qcount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
		}

		// Sort recursively:
		qcount += QuickRandom(list, from, p - 1);
		qcount += QuickRandom(list, p + 1, to);

		return qcount;
	}
	
	public static int QuickRandomMoveCount(int[] list, int from, int to)
	{
		int movecount = 0;
		if (from >= to)
			return 0;

		// Choose pivot list[p]:
		Random random = new Random();
		int p =  (from + (random.nextInt(to-from)));
		// The choice of the pivot location may vary:
		//   you can also use p = from or p = to or use 
		//   a fancier method, say, the median of the above three.

		// Partition:

		int i = from;
		int j = to;
		while (i <= j)
		{
			if (list[i] <= list[p]) {
				i++;
				movecount++;
		}else if (list[j] >= list[p]) {
				j--;
				movecount = movecount + 2;
		}else
			{
				swap (list, i, j);
				i++;
				j--;
				movecount = movecount + 2;
			}
		}

		// Finish partitioning:

		if (p < j)    // place the pivot in its correct position
		{
			swap (list, j, p);
			p = j;
			movecount = movecount + 3;
		}
		else if (p > i)
		{
			swap (list, i, p);
			p = i;
			movecount = movecount + 3;
		}

		// Sort recursively:
		movecount += QuickRandomMoveCount(list, from, p - 1);
		movecount += QuickRandomMoveCount(list, p + 1, to);

		return movecount;
	}

	private static void swap (int[] list, int a, int b)
	{
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}

}