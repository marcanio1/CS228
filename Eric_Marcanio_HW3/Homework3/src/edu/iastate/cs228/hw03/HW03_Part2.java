package edu.iastate.cs228.hw03;

/**
 * 
 * @author Eric Marcanio
 *
 */
public class HW03_Part2
{
 /*
  * Answers to short questions:
  * 
  * 1. O(n)
  * 
  * 2. O(log2n)
  * 
  * 3. O(n^2)
  * 
  * 4. O(n^2)
  * 
  * 5. O(n)
  * 
  */
	
	/*
	 In all of the following methods you can assume that
	 array will always have elements (ints) in it.
	 And will have proper integers as defined in the 
	 description of HW03, i.e., in first two it will be
	 in the range, and in last two it will be composed of
	 negative and positive values only.
	*/
	
	public static int findMissingInt_a_On2(int [] array)
	{
			int[] Arr = new int[array.length+2];
	        int Total = 0;
	        int actualTotal = 0;
	        
	        for(int m = 1; m < Arr.length; m++) {
	            Arr[m] = m;  //fill array numerically
	            actualTotal = Arr[m] + actualTotal;
	        }

	        for(int i = 0; i < Arr.length; i++) {
	            for(int j = 0; j < array.length; j++) {
	                if(Arr[i] == array[j]) {
	                    Total = Arr[i] + Total;
	                }
	            }
	        }

	        return actualTotal - Total;
	}
	
	public static int findMissingInt_b_On1(int [] array)
	{
		int length = array.length;
		int total =(length+1)*(length+2)/2; //total if you added up all number n to n+1
		for(int i=0; i< length; i++) {
			total -= array[i];              
		}
		return total;  
	}
	
	public static void rearrange_a_On2(int [] array)
	{
		int temp =0;
		for(int i =0; i< array.length -1; i++) {
			for(int j= i+1; j< array.length; j++) {
				if(array[i]> array[j]) {
					temp = array[j];
					array[j]= array[i];
					array[i]= temp;
				}
			}
		
	}

	}
	
	public static void rearrange_b_On1(int [] array)
	{
		int cnt =0;
		int temp;
		for(int i =0; i< array.length; i++ ) {
			if(array[i] <0) {
				temp = array[i];
				array[i]= array[cnt];
				array[cnt] = temp;
				cnt++;
			}
		}
	}
	
}
