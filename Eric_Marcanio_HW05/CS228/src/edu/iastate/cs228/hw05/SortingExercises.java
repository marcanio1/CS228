package edu.iastate.cs228.hw05;

/**
 * 
 * @author Eric Marcanio
 * 
 *         NOTE: 0. Put your Firstname and Lastname after above author tag. Make
 *         sure that in both cases the first letter is uppercase and all others
 *         are lowercase. 1. In all of these methods implementations you are
 *         allowed to use the StringBuilder class. 2. You are allowed to create
 *         and use your own private helper methods. 3. No data fields can be
 *         introduced. 4. No custom classes of your own can be introduced or
 *         used. 5. Import statements are not allowed. 6. Fully qualified class
 *         names usage is not allowed. 7. You are allowed to reuse any part of
 *         the source codes provided or shown under lecture notes.
 * 
 */

public class SortingExercises {
	/**
	 * Helper method used for counting
	 */
	private int counter(int n) {
		n--;
		return n;
	}

	/**
	 * Recursive implementation of selection sort.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Rec(int[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		int n = arr.length;
		selection(arr, 0);
	}

	/**
	 * Helper method for selection that uses the length to insure its stopping
	 * 
	 * @param arr
	 *            array of int's being sorted
	 * @param start
	 *            Start index that will tell my method to stop
	 */
	private static void selection(int[] arr, int start) {
		int len = arr.length;
		int small = start;

		if (start >= len - 1) // Sorted the array. Stopping point
			return;
		for (int i = start + 1; i < len; i++) {
			if (arr[i] < arr[small]) // Find smallest
				small = i;
		}
		int temp = arr[start];
		arr[start] = arr[small];// flip de flop
		arr[small] = temp;
		selection(arr, start + 1);
	}

	/**
	 * Recursive implementation of insertion sort.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void insertionSort_Rec(int[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		insertion(arr, arr.length);
	}

	/**
	 * Insertion sort helper method
	 * 
	 * @param arr
	 *            Array of ints that need to be sorted
	 * @param cnt
	 *            Used to count down to make sure the whole array is sorted
	 */
	private static void insertion(int[] arr, int cnt) {
		int last = arr[cnt - 1];
		int spot = cnt - 2; // needs to be -2 to look 1 spot ahead

		if (cnt <= 1) // Used to stop the program
			return;

		insertion(arr, cnt - 1);

		while (spot >= 0 && arr[spot] > last) { // Moves elements to the right that are greater than spot
			arr[spot + 1] = arr[spot];
			spot--;
		}
		arr[spot + 1] = last;

	}

	/**
	 * Iterative implementation of selection sort with modifications as follows. On
	 * each pass in this case the method finds both the largest and smallest values
	 * in the unsorted portion of the array, and places them in the correct
	 * locations.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void selectionSort_Itr(int[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		// int[] sorted = new int[arr.length];
		SelectionSort(arr, 0, arr.length - 1);
	}

	/**
	 * Helper method that does selection sort but gets smaller each time.
	 * 
	 * @param arr
	 *            Array being passed in and getting smaller
	 * @param arrsort
	 *            Array that is being sorted each time
	 */
	private static void SelectionSort(int[] arr, int start, int end) {

		int small = arr[start], smallpos = start;
		int big = arr[end], bigpos = end;
		int tempstart = arr[start], tempend = arr[end];

		for (int i = start; i <= end; i++) {// Start moves forward and end moves back so it sorts from the outside in
			if (arr[i] > big) {// finds big num
				big = arr[i];
				bigpos = i;
			}
			if (arr[i] < small) {// finds small num
				small = arr[i];
				smallpos = i;
			}
		}

		if (start + 2 >= end) {
			if (tempstart > tempend) { // If there is only 3 left it sorts them seperatly because this gave me problems
				arr[end] = tempstart;
				arr[start] = tempend;
			}
			if (tempstart > small) {
				arr[start + 1] = arr[start];
				arr[start] = small;

			}
			return;
		}
		arr[start] = small;
		arr[end] = big;// Down here swaps the vlaues on the outsides with the new small and big
		arr[bigpos] = tempend;
		arr[smallpos] = tempstart;
		SelectionSort(arr, start + 1, end - 1);
	}

	/**
	 * A bubble sort can sort an array of n entries into ascending order by makeing
	 * n-1 passes through the array. On each pass, it compares adjacent entries and
	 * swaps them if they are out or order. For example, on the first pass, it
	 * compares the first and second entries, then the second and third entries, and
	 * so on. At the end of the first pass, the largest entry is in its proper
	 * position at the end of the array. We say that it has bubbled to its correct
	 * spot. Each subsequent pass ignores the entries at the end of the array, since
	 * they are sorted and are larger than any of the remaining entries. Thus, each
	 * pass makes one fewer comparison than the previous pass. Check the figure
	 * under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort iteratively.
	 * 
	 * @param arr
	 *            Array of objects (with specific bounds) to be sorted in
	 *            nondecreasing order.
	 */
	public static <T extends Comparable<? super T>> void bubbleSort_Itr(T[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;
		int length = arr.length;

		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j].compareTo(arr[j + 1]) >= 0) {// swaps the value
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
		// TODO
	}

	/**
	 * A bubble sort can sort an array of n entries into ascending order by makeing
	 * n-1 passes through the array. On each pass, it compares adjacent entries and
	 * swaps them if they are out or order. For example, on the first pass, it
	 * compares the first and second entries, then the second and third entries, and
	 * so on. At the end of the first pass, the largest entry is in its proper
	 * position at the end of the array. We say that it has bubbled to its correct
	 * spot. Each subsequent pass ignores the entries at the end of the array, since
	 * they are sorted and are larger than any of the remaining entries. Thus, each
	 * pass makes one fewer comparison than the previous pass. Check the figure
	 * under HW05 assignment on Canvas.
	 * 
	 * This method implements bubble sort recursively.
	 * 
	 * @param arr
	 *            Array of ints to be sorted in nondecreasing order.
	 */
	public static void bubbleSort_Rec(int[] arr) {
		if (arr == null)
			throw new NullPointerException();
		if (arr.length == 0)
			throw new IllegalArgumentException();
		if (arr.length == 1)
			return;

		BubbleSort(arr, arr.length);// Need more params
	}

	/**
	 * Helper for bubble sort uses a counter to stop. Uses recursion
	 * 
	 * @param arr
	 *            Array that is being sorted
	 * @param cnt
	 *            Counter to stop the recursion
	 */
	private static void BubbleSort(int[] arr, int cnt) {
		if (cnt == 1)// Stops the recursion when it went through the array
			return;

		for (int i = 0; i < cnt - 1; i++) {// Moves through the array
			if (arr[i] > arr[i + 1]) {// swaps the values
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		BubbleSort(arr, cnt - 1);
	}
}
