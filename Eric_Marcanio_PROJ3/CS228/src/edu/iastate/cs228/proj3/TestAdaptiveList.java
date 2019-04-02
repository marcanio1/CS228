package edu.iastate.cs228.proj3;
/**
 *  @author Eric Marcanio
 */
import static org.junit.Assert.*;

import org.junit.Test;

import edu.iastate.cs228.hw06.AList;
import edu.iastate.cs228.hw06.LListWithTail;
//import edu.iastate.cs228.proj3.AdaptiveList.AdaptiveListIterator;
//import edu.iastate.cs228.proj3.AdaptiveList.AdaptiveListIterator;
import edu.iastate.cs228.proj3.AdaptiveList.ListNode;

public class TestAdaptiveList {

	
	/**
	 * Test AdaptiveList constructor with collection param
	 */
	@Test
	public void Test_AdaptiveList() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] {"B", "A", "C"};
		 seq.add("B"); 
		 seq.add("A"); 
		 seq.add("C");
	  //  seq.AdaptiveList(expected);
		 
		 if(seq.equals(expected)) {
			 fail("Adaptive");
		 }
		 
		//assertArrayEquals(expected, seq.toArray());
		 //seq.AdaptiveList();
		 
	}
	
	/**
	 * Test Size on the listnode
	 */
	@Test
	public void Test_sizeListNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("B");
		seq.add("B");
		seq.add("B");
		seq.add("B");
		
		if(seq.size() != 4) {
			fail("Not correct size");
		}
	}
	/**
	 * Test is empty on ListNode
	 */
	@Test
	public void Test_IsEmptyListNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		AdaptiveList<String> seqempty = new AdaptiveList<String>();
		seq.add("B");
		seq.add("B");
		seq.add("B");
		
		if(seq.isEmpty())
			fail("List should not be empty");
		if(!seqempty.isEmpty())
			fail("List should be empty");
	}
	/**
	 * Test add and get on list node
	 */
	@Test
	public void Test_AddlistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		String[] expected = new String[] {"B", "A", "C"};
		seq.add("B");
		seq.add("A");
		seq.add("C");
		assertEquals("B", seq.get(0));
		assertEquals("A", seq.get(1));
		assertEquals("C", seq.get(2));
	}
	/**
	 * Test add all on list node
	 */
	@Test
	public void Test_AddAlllistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
	}
	/**
	 * Test Remove on list node
	 */
	@Test
	public void Test_RemovelistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("B");
		seq.add("A");
		seq.add("C");
		seq.remove("B");
		assertEquals("A", seq.get(0));
		seq.remove("A");
		assertEquals("C", seq.get(0));
	}
	/**
	 * Test add at a certain position on list node
	 */
	@Test
	public void Test_AddatposlistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("B");
		seq.add("A");
		seq.add("C");
		seq.add(1,"E");
		assertEquals("E", seq.get(1));
		seq.add(1, "F");
		assertEquals("F", seq.get(1));
	}
	/**
	 * Test add all on a certain position on list node
	 */
	@Test
	public void Test_AddAllposlistNode() {
		
	}
	/**
	 * Test remove on a certain position on list node
	 */
	@Test
	public void Test_RemoveposlistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("B");
		seq.add("A");
		seq.add("C");
		seq.remove(0);
		assertEquals("A", seq.get(0));
		seq.remove(0);
		assertEquals("C", seq.get(0));
	}
	
	/**
	 * Test set on list node
	 */
	@Test
	public void Test_SetlistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("B");
		seq.add("A");
		seq.add("C");
		seq.set(2,"X");
		
		assertEquals("X", seq.get(2));
	}
	/**
	 * Test reverse on list node
	 */
	@Test
	public void Test_reversellistNode() {
		String[] array = {"A","B","C","D"};
		
	}
	/**
	 * Test reorder odd and even on list node
	 */
	@Test
	public void Test_reorderoddevenllistNode() {
		
	}
	/**
	 * Test cointains on list node
	 */
	@Test
	public void Test_CointainslistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		seq.add("A");
		seq.add("B");
		seq.add("C");
		seq.add("D");
		assertTrue(seq.contains("B"));
		//assertFalse(seq.contains("E"));
	}
	/**
	 * Test Cointains All on list node
	 */
	@Test
	public void Test_CointainsallllistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		AdaptiveList<String> seq2 = new AdaptiveList<String>();
		AdaptiveList<String> seq3 = new AdaptiveList<String>();
		seq.add("A");
		seq.add("B");
		seq2.add("C");
		seq2.add("D");
		seq3.add("C");
		seq3.add("D");
		//assertFalse(seq.containsAll(seq2));
		//assertTrue(seq2.containsAll(seq3));
	}
	/**
	 * Test IndexOff on list node
	 */
	@Test
	public void Test_IndexOfllistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("A");
		seq.add("B");
		seq.add("C");
		seq.add("B");
		assertEquals(1, seq.indexOf("C"));
	}
	/**
	 * Test last index of on list node
	 */
	@Test
	public void Test_LastindexofflistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("A");
		seq.add("A");
		seq.add("B");
		seq.add("C");
		seq.add("A");
		//assertEquals(4, seq.lastIndexOf("C"));
	}
	/**
	 * Test removeAll on list node
	 */
	@Test
	public void Test_removeAlllistNode() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("A");
		seq.add("A");
		seq.add("B");
		seq.add("C");
		seq.add("A");
	//	seq.removeAll("A");
	}
	/**
	 * Test RetainAll on list node
	 */
	@Test
	public void Test_RetainAllllistNode() {
		
	}
	/**
	 * Test To array on list node
	 */
	@Test
	public void Test_toArraylistNode() {
		
	}
	/**
	 * Test to array object T on list node
	 */
	@Test
	public void Test_toArrayTllistNode() {
		
	}
	/**
	 * Test Adaptive List iterator constructor in adaptive List Iterator
	 */
	@Test
	public void Test_AdaptiveListIterator() {
		
	}
	/**
	 * Test Adaptive List iterator constructor with param in adaptive List Iterator
	 */
	@Test
	public void Test_AdaptiveListIteratorparam() {
		
	}
	/**
	 * Test Adaptive List Remove
	 */
	@Test
	public void Test_AdaptiveListremove() {
		AdaptiveList<String> seq = new AdaptiveList<String>();
		
		seq.add("A");
		seq.add("A");
		seq.add("B");
		
		
	}
}
