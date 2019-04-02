package edu.iastate.cs228.proj3;


/*
 *  @author Eric Marcanio
 *
 *
 *  An implementation of List<E> based on a doubly-linked list 
 *  with an array for indexed reads/writes
 *
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

//import edu.iastate.cs228.hw06.LList.Node;

public class AdaptiveList<E> implements List<E>
{
  public class ListNode 
  {        
	  //real 1
    public E data;        
    public ListNode next; 
    public ListNode prev; 
    
    public ListNode(E item)
    {
      data = item;
      next = prev = null;
    }
  }
  
  public ListNode head;  // dummy node made public for testing.
  public ListNode tail;  // dummy node made public for testing.
  private int numItems;  // number of data items
  private boolean linkedUTD; // true if the linked list is up-to-date.

  public E[] theArray;  // the array for storing elements
  private boolean arrayUTD; // true if the array is up-to-date.

  public AdaptiveList()
  {
    clear();
  }

  @Override
  public void clear()
  {
    head = new ListNode(null);
    tail = new ListNode(null);
    head.next = tail;
    tail.prev = head;
    numItems = 0;
    linkedUTD = true;
    arrayUTD = false;
    theArray = null;
  }

  public boolean getlinkedUTD()
  {
    return linkedUTD;
  }

  public boolean getarrayUTD()
  {
    return arrayUTD;
  }

  public AdaptiveList(Collection<? extends E> c)
  {
    clear(); //Start with a new list
    addAll(c);// add given values
  }

  // Removes the node from the linked list.
  // This method should be used to remove a node 
  // from the linked list.
  private void unlink(ListNode toRemove)
  {
    if ( toRemove == head || toRemove == tail )
      throw new RuntimeException("An attempt to remove head or tail");
    toRemove.prev.next = toRemove.next;
    toRemove.next.prev = toRemove.prev;
  }

  // Inserts new node toAdd right after old node current.
  // This method should be used to add a node to the linked list.
  private void link(ListNode current, ListNode toAdd)
  {
    if ( current == tail )
      throw new RuntimeException("An attempt to chain after tail");
    if ( toAdd == head || toAdd == tail )
      throw new RuntimeException("An attempt to add head/tail as a new node");
    toAdd.next = current.next;
    toAdd.next.prev = toAdd;
    toAdd.prev = current;
    current.next = toAdd;
  }


private void updateArray() // makes theArray up-to-date.
  {
    if ( numItems < 0 )
      throw new RuntimeException("numItems is negative: " + numItems);
    if ( ! linkedUTD )
      throw new RuntimeException("linkedUTD is false");
    E[] swap = (E[]) new Object[numItems];
    ListNode cur = head.next;
    
    for(int i = 0; i< numItems; i++) {
    	swap[i] = cur.data;
    	cur = cur.next;
    }
    theArray = swap;
    arrayUTD = true;
  }

  private void updateLinked() // makes the linked list up-to-date.
  {
    if ( numItems < 0 )
      throw new RuntimeException("numItems is negative: " + numItems);
    if ( ! arrayUTD )
      throw new RuntimeException("arrayUTD is false");

    if ( theArray == null || theArray.length < numItems )
      throw new RuntimeException("theArray is null or shorter");
    head.next = tail;
    tail.prev = head;
    head.next = new ListNode(theArray[0]);
    ListNode cur = head.next;
    for(int i =1; i< theArray.length -1; i ++) {
    	cur.next = new ListNode(theArray[i]);
    	cur = cur.next;
    	
    }
    cur.next = new ListNode(theArray[theArray.length -1]);
    tail = cur.next.next;
    linkedUTD = true;
    
  }

  @Override
  public int size()
  {
	  //TEST
    return numItems;
  }

  @Override
  public boolean isEmpty()
  {
	  //TEST
    return numItems ==0;
  }

  @Override
  public boolean add(E obj)
  {
	  if(!linkedUTD) updateLinked();
	  
	  ListNode n = new ListNode(obj);
	  link(tail.prev, n);
	  
      arrayUTD = false;
      numItems++;
      
      return true;
  }

  @Override
  public boolean addAll(Collection< ? extends E> c)
  {
	  if(!linkedUTD) updateLinked();
	  if(c.isEmpty())
		  return false;
	 
	  for(E item : c) {
		  add(item);
	  }
	  
	  return true;
	  
      //TEST
  }

  @Override
  public boolean remove(Object obj)
  {
	  //TEST
	  if(!linkedUTD) updateLinked();
	  
	  if(isEmpty()) return false;
	  
	  ListNode point = head.next;
	  while(point.next != null) {
		  if(point.data.equals(obj))
			  unlink(point);
		  
			  point = point.next;
	  }
	  return true;
  }

  private void checkIndex(int pos) // a helper method
  {
    if ( pos >= numItems || pos < 0 )
     throw new IndexOutOfBoundsException(
       "Index: " + pos + ", Size: " + numItems);
  }

  private void checkIndex2(int pos) // a helper method
  {
    if ( pos > numItems || pos < 0 )
     throw new IndexOutOfBoundsException(
       "Index: " + pos + ", Size: " + numItems);
  }

  private void checkNode(ListNode cur) // a helper method
  {
    if ( cur == null || cur == tail )
     throw new RuntimeException(
      "numItems: " + numItems + " is too large");
  }

  private ListNode findNode(int pos)   // a helper method
  {
    ListNode cur = head;
    for ( int i = 0; i < pos; i++ )
    {
      checkNode(cur);
      cur = cur.next;
    }
    checkNode(cur);
    return cur;
  }

  @Override
  public void add(int pos, E obj)
  {
	  
	 if(!linkedUTD) updateLinked();
	  
	  ListNode n = new ListNode(obj);
	  link(findNode(pos), n);
	  
     arrayUTD = false;
     numItems++;
     
  }

  @Override
  public boolean addAll(int pos, Collection< ? extends E> c)
  {
	  if(!linkedUTD) updateLinked();
	 
	  AdaptiveListIterator pointer = new AdaptiveListIterator(pos-1);
	  if(c.isEmpty())
		  return false;
	 
	  for(E item : c) {
		  add(item);
	  }
	  
	  
	 
	  
    return true; 
  }

  @Override
  public E remove(int pos)
  {
	  checkIndex(pos);
	  ListNode cur = head.next;
	  	
	  if(!linkedUTD) updateLinked();
	  int index =0;
	  E returnthis = null;
	  while(cur.next != null) {
		  
		  if(index == pos) {
			  unlink(cur);
			  returnthis = cur.data;
		  } 
		  	index++;
			cur = cur.next;
	  }
	 
	  //TEST
    return returnthis; 
  }

  @Override
  public E get(int pos)
  {
    //TEST
	  //updateArray();
	  ListNode cur = head;
	    for ( int i = 0; i <= pos; i++ )
	    {
	      checkNode(cur);
	      cur = cur.next;
	    }
	    checkNode(cur);
	    arrayUTD = true;
	    return cur.data;
  }

  @Override
  public E set(int pos, E obj)
  {
	 updateArray();
	 checkIndex(pos);
	 
	 ListNode cur = findNode(pos+1);
	 E prev = get(pos);
	 cur.data = obj;
	 //linkedUTD = false;
	 return prev;
    
  } 

  /**
   *  If the number of elements is at most 1, 
   *  the method returns false. Otherwise, it 
   *  reverses the order of the elements in the 
   *  array without using any additional array, 
   *  and returns true. Note that if the array 
   *  is modified, then linkedUTD needs to be set 
   *  to false.
   */
  public boolean reverse()
  {
	E test;
    if(numItems <= 1)
    	return false;
    updateArray();
    int j = theArray.length -1;
    for(int i =0; i < numItems/2; i++) {
    	test = theArray[i];
    	theArray[i] = theArray[j];
    	theArray[j] = test;
    }
    linkedUTD = false;
    return true;
    
  }

  
  /** 
   *  If the number of elements is at most 1, 
   *  the method returns false. Otherwise, it 
   *  swaps the items positioned at even index 
   *  with the subsequent one in odd index without 
   *  using any additional array, and returns true.
   *  Note that if the array is modified, then 
   *  linkedUTD needs to be set to false. 
   */
  public boolean reorderOddEven()
  {
	 E flip;
    if(numItems <= 1 || isEmpty())
    	return false;
    for(int i =0; i< theArray.length/2; i+= 2) {
    	if(i+1 < theArray.length) {
    		flip = theArray[i];
    		theArray[i] = theArray[i+1];
    		theArray[i+1] = flip;
    	}
    	linkedUTD = false;
    }
    return true;
  }
  
  @Override
  public boolean contains(Object obj)
  {
	  if(isEmpty()) {
		  return false;
	  }
	  AdaptiveListIterator c = new AdaptiveListIterator();
      for (int i = 0; i < numItems; i++) {
          if (c.next() == obj)
              return true;
      }
      return false;
  }

  @Override
  public boolean containsAll(Collection< ? > c)
  {
	  
      for(Object e : c) {
    	  if(contains(e))
    		  return true;
      }
      return false;  
  }


  @Override
  public int indexOf(Object obj)
  {
	  AdaptiveListIterator point = new AdaptiveListIterator();
	     
	  if (this.isEmpty())
          return -1;
      int i = 0;
     
      while (point.hasNext()) {
          if (!point.next().equals(obj)) {
              i++;
          } else {
              return i;
          }
          
      }
      return -1;
  }

  @Override
  public int lastIndexOf(Object obj)
  {
	  AdaptiveListIterator point = new AdaptiveListIterator(); 
	  int i = 0;
	  int retthis =-1;
	 
	  
	  while(point.next() != null) {
		  
		  if(point.equals(obj)) {
			  retthis = i;
		  }
		  point.next();
		  i++;
	  }
	  
    return retthis; 
  }

  @Override
  public boolean removeAll(Collection<?> c)
  {
	  //Objects.requireNonNull(c);
      boolean modified = false;
      Iterator<?> it = iterator();
      while (it.hasNext()) {
          if (c.contains(it.next())) {
              it.remove();
              modified = true;
          }
      }
      return modified;
  }

  @Override
  public boolean retainAll(Collection<?> c)
  {
	  boolean modified = false;
      Iterator<E> it = iterator();
      while (it.hasNext()) {
          if (!c.contains(it.next())) {
              it.remove();
              modified = true;
          }
      }
      return modified; 
  }

  @Override
  public Object[] toArray()
  {
    //TEST
	Object[] returnT = new Object[numItems];
	AdaptiveListIterator c = new AdaptiveListIterator();
	
	for(int i =0; i < numItems; i ++) {
		
	}
    return null; 
  }
  
  
  /**
   * In here you are allowed to use only 
   * java.util.Arrays.copyOf method.
   */
  @Override
  public <T> T[] toArray(T[] arr)
  {
    updateArray();
    //DO THIS
    return null; 
  }

  @Override
  public List<E> subList(int fromPos, int toPos)
  {
    throw new UnsupportedOperationException();
  }

  private class AdaptiveListIterator implements ListIterator<E>
  {
    private int    index;  // index of next node;
    private ListNode cur;  // node at index - 1
    private ListNode last; // node last visited by next() or previous()

    public AdaptiveListIterator()
    {
      if ( ! linkedUTD ) updateLinked();
      cur = new ListNode(null);
      index =0;
      cur.next = head.next;
      cur.prev = head;
      last = null;
      //TEST
    }
    public AdaptiveListIterator(int pos)
    {
      if ( ! linkedUTD ) updateLinked();
      cur = new ListNode(null);
      index =0;
      cur.next = head.next;
      cur.prev = head;
      last = null;
      for(int i= 0; i< pos; i++)
    	  next();
      //TEST
    }

    @Override
    public boolean hasNext()
    {
    	//Test
      if(cur.next != null)
    	  return true;
      return false;
    }

    @Override
    public E next()
    {
      //Test
    	if(hasNext()) {
    		cur.next = cur.next.next;
    		cur.prev = cur.next;
    		last = cur.prev;
    		index++;
    		return last.data;
    	}
    	else
    		throw new NoSuchElementException();
      
    } 

    @Override
    public boolean hasPrevious()
    {
    	//TEST
      if(cur.prev == head)
    	  return false;
      return true; 
    }

    @Override
    public E previous()
    {
    	if(hasPrevious()) {
    		cur.next = cur.prev;
    		cur.prev= cur.prev.prev;
    		last = cur.next;
    		index--;
    		return cur.next.data;
    	}
    	else 
    		throw new NoSuchElementException();
      //TEST
      
    }
    
    @Override
    public int nextIndex()
    {
      //TEST
      return index; 
    }

    @Override
    public int previousIndex()
    {
      // TEST
      return index -1; 
    }

    @Override
    public void remove()
    {
      unlink(cur);
      updateLinked();
    }

    @Override
    public void add(E obj)
    { 
    	updateLinked();
      ListNode new1 = new ListNode(obj);
      link(cur, new1);
      numItems++;
    } 

    @Override
    public void set(E obj)
    {
      if(last != null)
    	  last.data = obj;
      else
    	  throw new IllegalStateException();
    	//Replaces the last element returned by next() or previous() with the specified element
    	//(optional operation). This call can be made only if neither remove() nor add(E) have been
    	//called after the last call to next or previous.
    }
  } // AdaptiveListIterator
  
  @Override
  public boolean equals(Object obj)
  {
    if ( ! linkedUTD ) updateLinked();
    if ( (obj == null) || ! ( obj instanceof List<?> ) )
      return false;
    List<?> list = (List<?>) obj;
    if ( list.size() != numItems ) return false;
    Iterator<?> iter = list.iterator();
    for ( ListNode tmp = head.next; tmp != tail; tmp = tmp.next )
    {
      if ( ! iter.hasNext() ) return false;
      Object t = iter.next();
      if ( ! (t == tmp.data || t != null && t.equals(tmp.data) ) )
         return false;
    }
    if ( iter.hasNext() ) return false;
    return true;
  }

  @Override
  public Iterator<E> iterator()
  {
    return new AdaptiveListIterator();
  }

  @Override
  public ListIterator<E> listIterator()
  {
    return new AdaptiveListIterator();
  }

  @Override
  public ListIterator<E> listIterator(int pos)
  {
    checkIndex2(pos);
    return new AdaptiveListIterator(pos);
  }

  // Adopted from the List<E> interface.
  @Override
  public int hashCode()
  {
    if ( ! linkedUTD ) updateLinked();
    int hashCode = 1;
    for ( E e : this )
       hashCode = 31 * hashCode + ( e == null ? 0 : e.hashCode() );
    return hashCode;
  }

  // You should use the toString*() methods to see if your code works as expected.
  @Override
  public String toString()
  {
   // Other options System.lineSeparator or
   // String.format with %n token...
   // Not making data field.
   String eol = System.getProperty("line.separator");
   return toStringArray() + eol + toStringLinked();
  }

  public String toStringArray()
  {
    String eol = System.getProperty("line.separator");
    StringBuilder strb = new StringBuilder();
    strb.append("A sequence of items from the most recent array:" + eol );
    strb.append('[');
    if ( theArray != null )
      for ( int j = 0; j < theArray.length; )
      {
        if ( theArray[j] != null )
           strb.append( theArray[j].toString() );
        else
           strb.append("-");
        j++;
        if ( j < theArray.length )
           strb.append(", ");
      }
    strb.append(']');
    return strb.toString();
  }

  public String toStringLinked()
  {
    return toStringLinked(null);
  }

  // iter can be null.
  public String toStringLinked(ListIterator<E> iter)
  {
    int cnt = 0;
    int loc = iter == null? -1 : iter.nextIndex();

    String eol = System.getProperty("line.separator");
    StringBuilder strb = new StringBuilder();
    strb.append("A sequence of items from the most recent linked list:" + eol );
    strb.append('(');
    for ( ListNode cur = head.next; cur != tail; )
    {
      if ( cur.data != null )
      {
        if ( loc == cnt )
        {
          strb.append("| ");
          loc = -1;
        }
        strb.append(cur.data.toString());
        cnt++;

        if ( loc == numItems && cnt == numItems )
        {
          strb.append(" |");
          loc = -1;
        }
      }
      else
         strb.append("-");
      
      cur = cur.next;
      if ( cur != tail )
         strb.append(", ");
    }
    strb.append(')');
    return strb.toString();
  }
}
