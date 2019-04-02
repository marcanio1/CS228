package edu.iastate.cs228.hw08;


import java.util.Vector;
import java.util.Iterator;
import java.util.Objects;
import java.util.NoSuchElementException;

/**
 * A class that implements a sorted dictionary by using a Vector.
 * Entries are sorted based on keys in nondecreasing order. 
 * The dictionary has distinct search keys, i.e., can have duplicate
 * values, however, those are differentiated based on their keys.
 * 
 * @author Eric Marcanio
 * 
 * 
 * 
 * NOTEs and REQUIREMENTs:
 *  
 * 0. Put your Firstname and Lastname after above empty author tag.
 * 	  Make sure that in both cases the first letter is uppercase
 *    and all others are lowercase.
 * 1. You are allowed to create and use your own private helper methods.
 * 	  If you are introducing your own helper methods those need to be 
 *    private and properly documented as per Javadoc style. Already 
 *    existing methods declaration cannot be changed, too.     
 * 2. No additional data fields can be introduced in any of the 
 *    classes below. You are not allowed to change the case of the ones
 *    already existing, or rename those.
 * 3. No custom classes of your own can be introduced or used.
 * 4. Import statements are not allowed, besides the ones that are
 *    already provided.
 * 5. Fully qualified class names usage is not allowed.
 * 6. You are allowed to reuse any part of the provided source codes
 *    or shown under lecture notes section of Canvas, which do not 
 *    violate any of above.
 * 7. If you have any additional questions PLEASE ask on Piazza Q/A
 *    platform, but first PLEASE search and make sure that it was not
 *    already asked and answered. PLEASE setup your notifications for 
 *    both Canvas and Piazza so that you are updated whenever there
 *    are any changes immediately.
 * 8. You need to provide implementation to all methods and constructors
 *    which have a comment //TODO in their body. For all of these methods
 *    and constructors there is no need to provide comments.    
 * 
 *    
 *    
 * 
 */ 

public class SortedVectorDictionary<K extends Comparable<? super K>, V> 
       implements DictionaryInterface<K, V>
{
 private Vector<Entry> dict; 	

 public SortedVectorDictionary()
 {
  dict = new Vector<>();
 }

 public SortedVectorDictionary(int initialCapacity)
 {
  dict = new Vector<>(initialCapacity);
 }

 public V add(K key, V value)
 {
  if(Objects.isNull(key) || Objects.isNull(value))
	throw new IllegalArgumentException();
  else {
	  int num =0;
	  V result =null;
	  Entry add = new Entry(key, value);
	  for(Entry e: dict) {
		  if(e.key.compareTo(key)== 0) {// If they are equal then put it in the current spot
			  dict.set(num, add);
			  result = e.getValue();
			  return result;
		  }
		  else if(e.key.compareTo(key)> 0) {// If its greater than put it in the next spot
			  break;
		  }
		  num++;
	  }
	  dict.add(num, add);// Use the add method to put it in the spot i sorted it to
  return result;
  }
 }
 

 public V remove(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
  
  V new1 = null;
  int i = 0;
  if(getValue(key) != null) {//Only returns null if it is not in the dict
	  
	  for(Entry e: dict) {
		  if(e.key == key) {
			  new1 = e.value;
			  break;
		  }
		  i++;
	  }
	  dict.remove(i);// Use the remove method with the spot i found
  }
  
  
  return new1;
 }

 public V getValue(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
	  V ret = null;
  for(Entry e: dict) {
	  if(e.key == key) {//If the keys are equal retun the value at that spot 
		  ret = e.value;
	  }
		  
  }
  
  
  return ret;
 }

 public boolean contains(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
		   
  for(Entry e: dict) {
	  if(e.key.compareTo(key)== 0) {// If they are equal then put it in the current spot
		  return true;
	  }
	  
  }
	   
  return false; 
 }

 public boolean isEmpty()
 {
  if(dict.size() == 0)
	  return true;
  return false;
 }
	
 public int getSize()
 {
  
  return dict.size();
 }

 public void clear()
 {
  dict.clear();		
 }

 public String toString()
 {
  return dict.toString();  
 }
 
 public Iterator<K> getKeyIterator()
 {
  return new KeyIterator();
 }
	
 public Iterator<V> getValueIterator()
 {
  return new ValueIterator();
 }

 private class KeyIterator implements Iterator<K>
 {
  private Iterator<Entry> iter;
		
  private KeyIterator()
  {
   iter = dict.iterator();
  }
		
  public boolean hasNext() 
  {
  	
   return iter.hasNext();
  }
		
  public K next()
  {
   	
   return iter.next().key;	
  }
 } 
	
 private class ValueIterator implements Iterator<V>
 {
  private Iterator<Entry> iter;
		
  private ValueIterator()
  {
   iter = dict.iterator();
  }
		
  public boolean hasNext() 
  {
   	 
   return iter.hasNext();
  }
		
  public V next()
  {
   
   return iter.next().value;
  }
 }
	
 private class Entry
 {
  private K key;
  private V value;
		
  private Entry(K searchKey, V dataValue)
  {
   key = searchKey;
   value = dataValue;
  }
  
  private K getKey()
  {
   return key;
  }
		
  private V getValue()
  {
   return value;
  }
		
  private void setValue(V dataValue)
  {
   value = dataValue;
  }
  
  public String toString()
  {
   return "("+key+":"+value+")";	
  }
 }
}
		
