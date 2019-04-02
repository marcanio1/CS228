package edu.iastate.cs228.proj4;

import java.util.Arrays;
import java.util.LinkedList;



/**
 * 
 * @author Eric Marcanio
 *
 *
 * An entry tree class.
 *
 *
 */
public class EntryTree<K, V> 
{
 // Dummy root node. 
 // Made public for grading.
 public Node root;
	
 /**
  * 
  * You are allowed to add at most TWO more data fields to 
  * EntryTree class of int type ONLY if you need to.
  *  
  */
 
 
 // All made public for grading.
 public class Node implements EntryNode<K, V> 
 {
  public Node child; // reference to the first child node
  public Node parent; // reference to the parent node
  public Node prev; // reference to the previous sibling
  public Node next; // reference to the next sibling
  public K key; // the key for this node
  public V value; // the value at this node

  public Node(K aKey, V aValue) 
  {
   key = aKey;
   value = aValue;
   child = null;
   parent = null;
   prev = null;
   next = null;
  }

  @Override
  public EntryNode<K, V> parent() 
  {
   return parent;
  }

  @Override
  public EntryNode<K, V> child() 
  {
   return child;
  }

  @Override
  public EntryNode<K, V> next() 
  {
   return next;
  }

  @Override
  public EntryNode<K, V> prev() 
  {
   return prev;
  }

  @Override
  public K key() 
  {
   return key;
  }

  @Override
  public V value() 
  {
   return value;
  }
 }

 public EntryTree() 
 {
  root = new Node(null, null);
 }

 /**
  * Returns the value of the entry with a specified key sequence, 
  * or {@code null} if this tree contains no entry with this key 
  * sequence.
  * 
  * This method returns {@code null} if {@code keyarr} is null or 
  * if its length is {@code 0}. If any element of {@code keyarr} 
  * is {@code null}, then the method throws a 
  * {@code NullPointerException}.
  * 
  *  The method returns the value of 
  * the entry with the key sequence in {@code keyarr} or {@code null} 
  * if this tree contains no entry with this key sequence. An example 
  * is given in provided sample input and output files to illustrate 
  * this method.  
  *
  * @param keyarr Read description.
  * @return Read description.
  * @throws NullPointerException Read description.
  */
 public V search(K[] keyarr) 
 {
	
	//If Either are null return false or length is 0
	if(keyarr == null || keyarr.length ==0) {
		return null;
	}
	checkNull(keyarr);
	Node node = root;
	
	for(int i =0; i < keyarr.length; i++) {
		node = findChild(node, keyarr[i]);//Same as prefix
		
		if(node == null)//If it is null then no child has this key.. findchild returns null if not found
			return null;
		
	}
  return node.value;
 }

 /**
  * 
  * This method returns an array of type {@code K[]} with the longest 
  * prefix of the key sequence specified in {@code keyarr} such that 
  * the keys in the prefix label the nodes on the path from the root 
  * to a node. The length of the returned array is the length of the 
  * longest prefix.
  * 
  * This method returns {@code null} if {@code keyarr} is {@code null}, 
  * or if its length is {@code 0}. If any element of {@code keyarr} is
  * {@code null}, then the method throws a {@code NullPointerException}. 
  * 
  * A prefix of the array {@code keyarr} is a key sequence in the subarray 
  * of {@code keyarr} from index {@code 0} to any index {@code m>=0}, 
  * i.e., greater than or equal to; the corresponding suffix is a key
  * sequence in the subarray of {@code keyarr} from index {@code m+1} to
  * index {@code keyarr.length-1}. The method returns an array of type
  * {@code K[]} with the longest prefix of the key sequence specified in
  * {@code keyarr} such that the keys in the prefix are, respectively,
  * with the nodes on the path from the root to a node. The lngth of the
  * returned array is the length of the longest prefix. Note that if the
  * length of the longest prefix is {@code 0}, then the method returns 
  * {@code null}. This method can be used to select a shorted key sequence
  * for an {@code add} command to create a shorter path of nodes in the
  * tree. An example is given in the attachment to illustrate how this
  * method is used with the {@code #add(K[] keyarr, V aValue)} method.  
  * 
  * NOTE: In this method you are allowed to use 
  * {@link java.util.Arrays}'s {@code copyOf} method only.
  * 
  * @param keyarr Read description.
  * @return Read description.
  * @throws NullPointerException Read description.
  */
 public K[] prefix(K[] keyarr) 
 {
	 //TBH just copied search and made a different return. Seems to be woorrking
	 K[] returnThis = null;
	//If Either are null return false or length is 0
	if(keyarr == null || keyarr.length ==0) {
		return null;
	}
	checkNull(keyarr);
	int len = 0;
	Node cur = root;
	
	for(int i =0; i< keyarr.length; i++) {//Loop through key
		
		cur = findChild(cur, keyarr[i]);//It will find the node with that key
		len++;
		if(cur == null)//The prefix has hit a spot where there is no mas
			break;//Get to the chopper
		
	}
	returnThis = Arrays.copyOf(keyarr, len-1);//Copy over the keyarr and the length we found from parsing through
  return returnThis;
 }

 /**
  * 
  * This method returns {@code false} if {@code keyarr} is {@code null}, 
  * its length is {@code 0}, or {@code aValue} is {@code null}. If any 
  * element of {@code keyarr} is {@code null}, then the method throws a
  * {@code NullPointerException}.
  * 
  * This method locates the node {@code P} corresponding to the longest 
  * prefix of the key sequence specified in {@code keyarr} such that the 
  * keys in the prefix label the nodes on the path from the root to the node. 
  * If the length of the prefix is equal to the length of {@code keyarr}, 
  * then the method places {@code aValue} at the node {@code P} (in place of 
  * its old value) and returns {@code true}. Otherwise, the method creates a 
  * new path of nodes (starting at a node {@code S}) labelled by the 
  * corresponding suffix for the prefix, connects the prefix path and suffix 
  * path together by making the node {@code S} a child of the node {@code P}, 
  * and returns {@code true}. An example input and output files illustrate 
  * this method's operation.
  *
  * NOTE: In this method you are allowed to use 
  * {@link java.util.Arrays}'s {@code copyOf} method only.
  * 
  * @param keyarr Read description.
  * @param Read description.
  * @return Read description.
  * @throws NullPointerException Read description.
  * 	
  */
 public boolean add(K[] keyarr, V aValue) 
 {
	 //If Either are null return false or length is 0
	 if(keyarr == null || keyarr.length ==0|| aValue == null) {
		 return false;
	 }
	 int length = keyarr.length;
	 checkNull(keyarr);
	 Node node = root;
	 
	 for(int i =0; i< length; i++) {
		 Node cNode = findChild(node, keyarr[i]);
		
		 if(cNode == null) {//If there is no child then make another one
			cNode = new Node(keyarr[i],null);//No data till last key
			cNode.parent = node; //Make sure it is pointing up to Node
			
			if(node.child != null) {//If there is a child point it to  
				Node brother = node.child; 
				while(brother.next != null) {//Getting the highest next value
					brother = brother.next;
				}
				cNode.prev = brother;//Make sure this new node points to 
				brother.next = cNode;
			}
			else {//If its null then it doesnt link to anything
				cNode.parent.child = cNode;
			}
			 
			 
			 
		 }
		 
		 node = cNode;
	 }
	 node.value = aValue;
  return true;//Always returns true if everything is inputed correctly
 }
 
 /**
  * Removes the entry for a key sequence from this tree and returns its value
  * if it is present. Otherwise, it makes no change to the tree and returns
  * {@code null}.
  * 
  * This method returns {@code null} if {@code keyarr} is {@code null} or its
  * length is {@code 0}. If any element of {@code keyarr} is {@code null}, then
  * the method throws a {@code NullPointerException}. The method returns 
  * {@code null} if the tree contains no entry with the key sequence specified
  * in {@code keyarr}. Otherwise, the method finds the path with the key sequence,
  * saves the value field of the node at the end of the path, sets the value field
  * to {@code null}.
  * 
  * The following rules are used to decide whether the current node and higher
  * nodes on the path need to be removed. The root cannot be removed. Any node 
  * whose value is not {@code null} cannot be removed. Consider a non-root node 
  * whose value is {@code null}. If the node is a leaf node (has no children),
  * then the node is removed. Otherwise, if the node is the parent of a single
  * child and the child node is removed, then the node is removed. Finally, the
  * method returns the saved old value.
  * 
  * 
  * @param keyarr Read description.
  * @return Read description.
  * @throws NullPointerException Read description.
  *   
  */
 public V remove(K[] keyarr) 
 {
	 if(keyarr == null || keyarr.length ==0) {
		 return null;
	 }
	 checkNull(keyarr);
	 Node node = root;
	 for(int i = 0; i< keyarr.length; i++) {
		 node = findChild(node, keyarr[i]);//Find what we are removing
		 
		 if(node == null)
			 return null;//There is nothing to remove 
	 }
	 
	 
	 
	 V returnThis = node.value;//The value we are deleting
	 node.value = null;//Delete it
	 removerecursive(node);
  return returnThis;//return the node being deleted 
 }
 /**
  * 
  * @param node
  */
 private void removerecursive(Node node) {
	 if(node == null) {
		 return;
	 }
	 
		if (node.child == null) {//If its a leaf

			if (node.parent != null && node.parent.child.equals(node)) {
				node.parent.child = node.next;
				removerecursive(node.parent);
			}

			if (node.next != null) {
				node.next.prev = node.prev;
			}
			if (node.prev != null) {
				node.prev.next = node.next;
			}
		}
	 
 }

 /**
  * 
  * This method prints the tree on the console in the output format 
  * shown in provided sample output file. If the tree has no entry, 
  * then the method just prints out the line for the dummy root node.
  * 
  */
 public void showTree() 
 {
	helpTree(root, 0);//Print tree recursively
 }
 
 public void helpTree(Node node, int row) {
	 
	 int row2 = row;//Count the periods
	 String temp = "";//Holds each line
	 
	 for(int i =0; i < row2; i++) {
		temp += ".";//Add periods to each line
	 }
	 
	 temp += node.key + "::" + node.value;// Format the Key::Data
	 System.out.println(temp);
	 
	 if(row == 0) {
		 row2 = 5;//Adds the extra 5 periods to the first line 
	 }
	 if(node.child != null) {
		 helpTree(node.child, row2+ 1);//Call child first
	 }
	 if(node.next != null) {
		 helpTree(node.next, row2);//Then check nexts
	 }
	 
	 
 }
 /**
  * 
  * Returns all values in this entry tree together with their keys.
  * The order of outputs would be similar to level order traversal,
  * i.e., first you would get all values together with their keys in
  * first level from left to right, then second level, and so on.
  * If tree has no values then it would return {@code null}.
  *
  * For the example image given in description, the 
  * returned String[][] would look as follows:
  * 
  *  {{"IA","Grow"}, {"ISU","CS228"}}   
  * 
  * NOTE: In this method you are allowed to use 
  * {@link java.util.LinkedList}.
  * 
  *  
  */	
 public String[][] getAll()
 {

  LinkedList<Node> array = new LinkedList<Node>();
  LinkedList<Node> spot = new LinkedList<Node>();
  String[][] rt = new String[array.size()][2];
  Node node;
  String key = "";
  
  spot.addLast(root);
  
  while(spot.isEmpty() == false) {
	  node = spot.getFirst();//Take the first element
	  spot.removeFirst();
	  if(node.value != null) {
		  array.add(node);//Put it into the array
	  }
	  node = node.child;
	  while(node != null) {
		  spot.addLast(node);
		  node = node.next;
	  }
  }
  
  for(int i = 0; i < rt.length; i++) {
	  node = array.get(i);
	  while(node.key != null) {
		  key = node.key.toString() + key;
		  node = node.parent;
	  }
	  rt[i][0] = key;
	  rt[i][1] = array.get(i).value.toString();
  }
  return rt;
 }
 /**
  * Checks if any element in keyarr is null. If it is than it throws an exception 
  * @param keyarr
  */
private void checkNull(K[] keyarr) {
	
	if(keyarr != null) {
		for (K E : keyarr) {
			if (E == null) {
				throw new NullPointerException();//Throws my exceptions
			}
		}
	}
}
/**
 * Finds the Node that has the key we are giving it 
 * @param cur
 * Parent node that is being searched to see if anything below it equals they key
 * @param key
 * This is what we are searching for
 * @return
 * Null if it is not found or the Node with the correct key
 */
private Node findChild(Node cur, K key) {
	if(cur.child == null) {return null;} // If it does not have a kid return null
	
	cur = cur.child;//We are looking at cur's children
	
	while(cur != null) {
		if(cur.key.equals(key)) {
			return cur; //Found what child it is
		}
		cur = cur.next; //If not keep going
	}
	return null;// Might change.. But if its not found return null
}
 
}
