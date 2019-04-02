
package edu.iastate.cs228.hw08;



import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/**
 * 
 * 
 * A class that implements the ADT dictionary by using a chain of nodes.
 * The dictionary is unsorted and has distinct search keys, i.e., can have 
 * duplicate values, however, those are differentiated based on their keys.
 * 
 * @author Eric Marcanio
 * 
 * NOTEs and REQUIREMENTs:
 * 
 * Exactly same as the ones listed for SortedVectorDictionary class.
 * 
 * In addition to above ANSWER the following 6 QUESTIONS, inside these 
 * comments right below each question. Figures needed to answer questions
 * 3, 4, and 5 are shown on Canvas under description of HW08.
 * 
 * =========================================================================
 * Q1. (a) What is the height of the shortest binary tree that contains 22
 *     nodes? (b) Is this tree full? (c) Is it balanced?
 *     
 * A1. (a) 5
 *     (b) No, The tree would be missing nodes on the last layer
 *     (c) No, One of the nodes only has one child
 * =========================================================================
 * Q2. Consider a binary tree that has four levels.
 *     (a) What is the maximum number of nodes in this tree?
 *     (b) What is the maximum number of leaves in this tree?
 *     
 * A2. (a) 15
 *     (b) 8 
 * =========================================================================
 * Q3. Consider a traversal of a binary tree, which contains Integer data. 
 *     Suppose that visiting a node means to simply display the data in the 
 *     node. What are the results of each of the following traversals of the 
 *     binary tree shown in Figure 1.
 *     (a) Preorder
 *     (b) Postorder
 *     (c) Inorder
 *     (d) Level order
 *     
 * A3. (a) 6 ,4, 2, 1, 3, 5, 8, 7, 9, 10, 11
 *     (b) 1, 3 , 2, 5, 4, 9 , 7 , 11 ,10, 8, 6
 *     (c) 1, 2, 3, 4, 5 , 6 ,7, 9, 8 ,10 ,11
 *     (d) 6, 4, 8, 2, 5, 7, 10, 1, 3, 9, 11
 *     
 * =========================================================================
 * Q4. Repeat Q3 but for the binary tree shwn in Figure 2. 
 * A4. (a) 11, 8, 3, 2, 1, 5, 4, 6, 10, 9, 7
 *     (b) 2,1 3, 4, 6, 5, 8, 9, 7 ,10
 *     (c) 2, 3, 1 , 8, 4, 5, 6, 11, 9, 10, 7
 *     (d) 11, 8, 10, 3, 5 , 9, 7, 2, 1, 4, 6
 *  
 * =========================================================================
 * Q5. The two binary trees shown in Figures 1 and 2 contain Integer data.
 *     (a) Is the tree in Figure 1 a binary search tree? Why or why not?
 *     (b) Is the tree in Figure 2 a maxheap? Why or why not?
 *  
 * A5. (a) Yes, The left subtrees are all less than the parent and the right subtrees are all greater than the parnet
 *     (b) Yes, In a max heap parent Nodes are always greater than or equal to child nodes 
 *     
 * =========================================================================
 * Q6. Can a binary search tree ever be a maxheap? Explain.
 * A6.                           
 *     The only way you can do this is with a Two node tree
 *     The node child node would be to the left and would be less than the parents
 *     This would fulfill both properties.
 *     Other than that there is no other combination that would go with both
 *     
 *     
 *     
 *     
 *     
 */
public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>
{
 private Node firstNode;   // Reference to first node of chain
 private int  numberOfEntries; 
	
 public LinkedDictionary()
 {
  firstNode = null;
  numberOfEntries = 0;
 }
	
 public V add(K key, V value)
 {
  if(Objects.isNull(key) || Objects.isNull(value))
	throw new IllegalArgumentException();
  else {
	  V result = null;
	  Node cur = firstNode;
	  Node addThis = new Node(key,value);
	
	  if(isEmpty()) {//Empty- Adds it to firstNode
		  firstNode = addThis;
		  numberOfEntries++;
		  return null;
	  }
	  while(cur!= null) {
		  if(cur.key == key) {//Search for if the key is in the list
			  result = cur.value;
			  cur.value = value;
			  return result;
		  }
		  if(cur.next == null)
			  break;
		  cur = cur.next;
	  }
	 
	  numberOfEntries++;
	  cur.setNextNode(addThis);//If the Key is'nt in the list it adds it to the end
	  
	  return null; 
  }
  
 
 }

 public V remove(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
  
  Node pointer = firstNode;
  Node before = firstNode;
  V removed = null;
  
  if(pointer.key == key) {//If the removed node is the firstNode
	  removed = firstNode.value;
	  firstNode = firstNode.next;
	  numberOfEntries--;
	  return removed;
  }
  
  while(pointer != null) {
	  if (pointer.next == null) {
		  break;
	  }
	  pointer = pointer.next;
	  if(pointer.key == key) {// If the keys are equal it points the node behind it to the next node
		  removed = pointer.value;
		  before.next = pointer.next;
		  numberOfEntries--;
	  }
	  before = before.next;
  }
  // TODO
  
  return removed;  
 }

 public V getValue(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
	 Node pointer = firstNode;
	 V sock = null;
	 
	 while(pointer != null) {//Search for the given key
		 if(pointer.key == key) {
			 sock = pointer.value;
			 return sock;
		 }
		 if(pointer.next == null)//If it went through and did'nt find the key it breaks here in order for me return null
			 break;
		 pointer = pointer.next;
	 }

  
  return null;
 }

 public boolean contains(K key)
 {
  if(Objects.isNull(key))
	throw new IllegalArgumentException();
  
  	Node pointer = firstNode;
	while(pointer != null) {
		if (pointer.key == key) {//IF the key is in return true
			return true;
		}
		pointer = pointer.next;
	}
	return false;
 
 }

 public boolean isEmpty()
 {
  return numberOfEntries ==0;
 }
	
 public int getSize()
 {
  return numberOfEntries;
 }

 public void clear()
 {
	 numberOfEntries =0;
	 firstNode = null;		
 }

 // Needs to output String representation in exact same
 // format as the one done by SortedVectorDictionary.
 public String toString()
 {
  String returnThis = "[";
  Node point = firstNode.next;
  
  returnThis += "(" + firstNode.key + ":" + firstNode.value + ")";//First node is done separate due to how i did my comma
  while(point != null) {
	  returnThis += ", ";
	  returnThis += "(" + point.key + ":" + point.value + ")";
	  point = point.next;
  }
  return returnThis + "]";
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
  private Node nextNode;
		
  private KeyIterator()
  {
	 nextNode = firstNode;
  }
		
  public boolean hasNext() 
  {
   
   return nextNode != null;
  }
		
  public K next()
  {
   K result;
   if(hasNext()) {
	   result = nextNode.getKey();//Returns keys
	   nextNode = nextNode.getNextNode();
	   
   }
   else
	   throw new NoSuchElementException();
   return result;
  }
 } 
	
 private class ValueIterator implements Iterator<V>
 {
  private Node nextNode;
  		
  private ValueIterator()
  {
   nextNode = firstNode;
  }
		
  public boolean hasNext() 
  {
	 return nextNode != null;
  }
		
  public V next()
  {
   V result;
   if(hasNext()) {
	   result = nextNode.getValue();//Returns values 
	   nextNode = nextNode.getNextNode();
   }else
	   throw new NoSuchElementException();
   
   return result;
  }
 }

 private class Node
 {
  private K key;
  private V value;
  private Node next;

  private Node(K searchKey, V dataValue)
  {
   key = searchKey;
   value = dataValue;
   next = null;	
  }
		
  private Node(K searchKey, V dataValue, Node nextNode)
  {
   key = searchKey;
   value = dataValue;
   next = nextNode;	
  }
		
  private K getKey()
  {
   return key;
  }
		
  private V getValue()
  {
   return value;
  }

  private void setValue(V newValue)
  {
   value = newValue;
  }

  private Node getNextNode()
  {
   return next;
  }
		
  private void setNextNode(Node nextNode)
  {
   next = nextNode;
  }
  
  public String toString()
  {
   return "("+key+":"+value+")";	
  }
 }
}
		
