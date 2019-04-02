package edu.iastate.cs228.hw05;

/**
 * A class of priority queues represented by a chain of linked nodes.
 * 
 * @author Eric Marcanio
 * 
 *         NOTE: 0. Put your Firstname and Lastname after above author tag. Make
 *         sure that in both cases the first letter is uppercase and all others
 *         are lowercase. 1. You are allowed to create and use your own private
 *         helper methods. 2. No additional data fields can be introduced. 3. No
 *         custom classes of your own can be introduced or used. 4. Import
 *         statements are not allowed. 5. Fully qualified class names usage is
 *         not allowed. 6. You are allowed to reuse any part of the source codes
 *         of provided source codes or shown under lecture notes. 7. You are not
 *         allowed to create arrays of objects and manipulate queue objects
 *         using arrays.
 * 
 *
 *         DESCRIPTION: A class of priority queues represented by a linked chain
 *         of nodes.
 * 
 *         For details of priority queue implementation using linked chain of
 *         nodes, check slide number 14 of
 *         "queueDequePriorityQueueImplementations_part3.pdf" file under lecture
 *         notes of Friday of Week 5 on Canvas.
 */

public final class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private Node firstNode; // Reference to first node of chain and the front
							// of the priority queue, which has the highest priority
	private int length; // Number of entries in chain

	public LinkedPriorityQueue() {
		firstNode = null;
		length = 0;
	}

	public void add(T newEntry) {
		Node newOne = new Node(newEntry);
		Node point = firstNode;
		if (firstNode == null) { // If its empty place it in the first spot
			firstNode = newOne;
			length++;
		}

		else {
			length++;
			while (point.next != null) {
				if (point.next.data.compareTo(newOne.data) >= 0) {
					newOne.next = point.next;// If there is more than one spot sort the arry
					point.next = newOne;

					return;
				}

				point = point.next;// move through firstNode

			}
			point.next = newOne;
		}

		return;
	}

	public T remove() {

		T first = null;
		Node point = firstNode;
		if (point == null)
			return null; // If its empty then return null
		Node point2 = point.next;

		if (point2 == null) {
			first = firstNode.data; // If there is one left return that
			firstNode = null;
			return first;
		}

		if (!isEmpty()) {

			while (point != null) {
				if (point2.next == null) { // two pointers so that the second to last node points to a null
					first = point2.data;
					point.next = null;
					length--;
					return first;
				} else {
					point2 = point2.next;
					point = point.next; // parsing through nodes
				}

			}

			// point = point.next;

		}

		return first;
	}

	public T peek() {// Same thing as remove but just shows the last one(doesnt remove)
		T first = null;
		Node point = firstNode;
		if (!isEmpty()) {
			while (point != null) {
				if (point.next == null) {
					first = point.data;
					point = null;
				} else {
					point = point.next;
				}

			}

		}

		return first;
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
		String returnThis = "[";
		Node point = firstNode;
		if (length == 0) {
			return returnThis += "]";// Empty bracket for nothing
		} else {
			while (point != null) {
				returnThis += point.data;
				if (point.next != null) {
					returnThis += ", "; // add a comma if its not the last one
				}
				point = point.next;
			}
		}

		return returnThis += "]";
	}

	public boolean isEmpty() {
		boolean result;

		if (length == 0) {
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		}

		return result;
	}

	public int getSize() {
		return length;
	}

	public void clear() {
		firstNode = null;
		length = 0;
	}

	private class Node {
		private T data; // Entry in priority queue
		private Node next; // Link to next node

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
} // end LinkedPriorityQueue