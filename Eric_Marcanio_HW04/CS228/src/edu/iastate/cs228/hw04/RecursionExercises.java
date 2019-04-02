package edu.iastate.cs228.hw04;

/**
 * 
 * @author Eric Marcanio
 * 
 * NOTE: 
 * 0. Put your Firstname and Lastname after above author tag.
 * 	  Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase (and separated by a space).
 * 1. In all of these methods implementations you are allowed
 *    to use the StringBuilder class. 
 * 2. You are allowed to create and use your own private helper methods.
 * 3. No data fields can be introduced.
 * 4. No custom classes of your own can be introduced or used.
 * 5. Import statements are not allowed.
 * 6. Fully qualified class names usage is not allowed.
 * 
 * 
 */
public final class RecursionExercises
{
 /**
  This method displays a given character the specified
  number of times on one line. For example, the call
   displayRowOfChacaters('+', 5);
  returns "+++++"
   
  Implement this method using recursion.
   
  @param toShow The character to display.
  @param n The number of times to display it; n>0.  
  @return String representations of n toShow chars.
  */
	 public static String displayRowOfCharacters(char toShow, int n)
	 {
		String returnThis = "";
		
	 	if( n <= 0) 
	 		return returnThis;
	 	
	 	return toShow + displayRowOfCharacters(toShow, n -1);
	 }
	 
	 /**
	  * Recursively display an array backward starting at position n.
	  * E.g., displayBackwards(new Integer[]{1,2,3,4}, 2)
	  * would return "21".
	  * 
	  * Implement this method using recursion.
   * 
	  *  @param arr The array to display will have at least two elements.
	  *  @param n The number of entries to be returned; 1<=n<=arr.length.
	  *  @return String value of first n values of arr backwards.
	  */
	 public static String displayBackwards(int[] arr, int n)
	 {
		String returnThis = "";
	 	if(n<=0) {
	 		return returnThis;
	 	}
	 	
	 	return arr[n-1] + displayBackwards(arr, n-1);
	 }
	 
	 /**
	  * A palindrome is a string that reads the same forward and backward.
	  * For example deed and level are palindromes. Implement this method
	  * using recursion.
	  * 
	  * @param aString A string under consideration; nonempty and 
	  * consists only of upper/lowercase letters and digits.
	  * @return true if the given string is a palindrome, and false otherwise.
	  */
	 public static boolean isPalindrome(String aString)
	 {
		 int length = aString.length()-1;
		 int n =0;
		 
		 if (aString.length() == 1|| aString.length() ==0)
			 return true;
		 
	 	if(aString.charAt(n) != aString.charAt(length)) {   //Seeing if first and last our equal
	 	return false;
	 	}
	 	else {
	 		n++;
	 		
	 		aString = aString.substring(n, length);         //If first and last our equal takes them out
	 		return isPalindrome(aString);
	 		
	 	}
	 	
	 }
	 
	 /**
	  * Recursive method that finds the second smallest object in an array of
	  * Comparable objects. E.g., getSecondSmallest(new Integer[]{-1,10,3,2},4)
	  * would return 2.
	  *  
	  * @param arr An array of Comparable objects; arr.length>=2.
	  * @param len Length/size of arr array.
	  * @return Second smallest (Comparable) object in this array.
	  */
	 public static <T extends Comparable<? super T>> T getSecondSmallest(T[] arr, int len)
	 {
		T largest = arr[0];

	 	if(len <= 2) {
	 		if(arr[0].compareTo(arr[1]) >=0) {   //Takes the 2nd largest between the first 2
	 			return arr[0];
	 		}
	 		else 
	 			return arr[1];
	 	}
	 	else {
	 		
	 		for(int i =0; i< len-1; i++) {
	 			if(arr[i+1].compareTo(arr[i])> 0) {   //Finds the largest #
	 				largest = arr[i+1];
	 			}
	 		}
	 		
	 		for(int i=0; i< len-1; i++) {
	 			if (largest.compareTo(arr[i]) == 0) {  //Moves largest # to end
	 				T temp = arr[len-1];
	 				arr[len-1] = arr[i];
	 				arr[i]= temp;
	 			}
	 		}
	 		return getSecondSmallest(arr, len -1);  //Sorts array
	 	}
	 		
	 		
	 }
	 
	 
}
