package edu.iastate.cs228.hw05;

/**
 * A class of priority queues represented by an array.
 * 
 * @author Eric Marcanio
 * 
 *         NOTE: 0. Put your Firstname and Lastname after above author tag. Make
 *         sure that in both cases the first letter is uppercase and all others
 *         are lowercase. 1. You are allowed to create and use your own private
 *         helper methods. 2. No additional data fields can be introduced. 3. No
 *         custom classes of your own can be introduced or used. 4. Import
 *         statements are not allowed. 5. Fully qualified class names usage is
 *         not allowed. (Except for the methods that are provided already for
 *         you, which do not need to be implemented as part of this HW, i.e.
 *         needs to be used as it is.) 6. You are allowed to reuse any part of
 *         the source codes of provided source codes or shown under lecture
 *         notes.
 * 
 *         DESCRIPTION: A class of priority queues represented by an array.
 * 
 *         For details of priority queue implementation using arrays, check
 *         slide number 14 of "queueDequePriorityQueueImplementations_part3.pdf"
 *         file under lecture notes of Friday of Week 5 on Canvas.
 */

public class ArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private T[] queue; // The contents of the priority queue
	private int frontIndex; // The index of the current front entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayPriorityQueue() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	public ArrayPriorityQueue(int initialCapacity) {
		checkCapacity(initialCapacity);

		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Comparable[initialCapacity]; // Unchecked cast
		queue = tempQueue;
		frontIndex = -1;
		initialized = true;
	}

	public void add(T newEntry) {
		checkInitialization();
		ensureCapacity();

		for (int i = 0; i < queue.length - 1; i++) {
			if (queue[i] == null) { // If it is the biggest entry it will get placed last
				queue[i] = newEntry;
				return;
			}
			if (queue[i].compareTo(newEntry) >= 0) { // If the new entry is smaller it will get placed before but needs
														// to moves everything over to the right to go in the middle of
														// 2 values
				for (int j = queue.length - 2; j >= i; j--) {
					queue[j + 1] = queue[j];
				}
				queue[i] = newEntry;
				return;
			} else {
				for (int g = 0; g < queue.length; g++) {
					if (queue[i] == null) {
						queue[i] = newEntry;
						return;
					}
				}

			}
		}
	}

	// TODO

	public T remove() {
		checkInitialization();
		T look = null;
		int cnt = queue.length - 1;
		if (queue[0] != null) {
			while (cnt >= 0) {
				if (queue[cnt] != null) {// Pointing the second to last to a null. removes last node
					look = queue[cnt];
					queue[cnt] = null;
					return look;
				}
				cnt--;
			}

		}
		return look;
	}

	public T peek() {
		checkInitialization();
		T look = null;
		int cnt = queue.length - 1;
		if (queue[0] != null) {
			while (cnt >= 0) {
				if (queue[cnt] != null) { // Show the last one
					look = queue[cnt];
					return look;
				}
				cnt--;
			}

		}
		return look;
	}

	/**
	 * If queue is empty returns []. Else, returns as [1, 2, 3] Important: note a
	 * comma and single space before every item except the last, and after last
	 * there is no space. In both cases before and after square brackets there is no
	 * space.
	 * 
	 */
	@Override
	public String toString() {
		String s = "[";
		if (queue[0] == null) { // If empty return empty brackets
			return s + "]";
		} else {
			for (int i = 0; i < queue.length - 1; i++) {
				s += queue[i]; // Adding the thing to the string

				if (queue[i + 1] == null) {
					return s + "]"; // Ending bracket
				} else {
					s += ", "; // If its not the last node it will add a coma
				}
			}
		}
		return s;
	}

	public boolean isEmpty() {
		return (frontIndex < 0);
	}

	public int getSize() {
		return frontIndex + 1;
	}

	public void clear() {
		checkInitialization();
		for (int x = 0; x < queue.length; x++)
			queue[x] = null;
		frontIndex = -1;
	}

	// Throws an exception if this object is not initialized.
	private void checkInitialization() {
		if (!initialized)
			throw new SecurityException("ArrayPriorityQueue object is not " + "initialized properly.");
	}

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException(
					"Attempt to create a priority queue " + "whose capacity exceeds allowed maximum.");
	}

	// Doubles the size of the array queue if it is full.
	// Precondition: checkInitialization has been called.
	private void ensureCapacity() {
		if (frontIndex == queue.length - 1) {
			checkCapacity(queue.length * 2);
			queue = java.util.Arrays.copyOf(queue, queue.length * 2);
		}
	}
} // end ArrayPriorityQueue
