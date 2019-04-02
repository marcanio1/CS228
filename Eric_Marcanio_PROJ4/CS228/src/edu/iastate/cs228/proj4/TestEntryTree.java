package edu.iastate.cs228.proj4;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * 
 * @author Eric Marcanio
 *
 */
public class TestEntryTree {
	EntryTree<Object, String> tree = new EntryTree<Object, String>();
	/**
	 * All These keys are just used to test all the methods
	 */
	Object[] keyarr1 = {'A', 'B', 'C'};
	Object[] keyarr1sib = {'A', 'B', 'C', 'D'};
	Object[] keyarr2 = {'E', 'g', 'G', 'A', 'B', 'X'};
	Object[] keyarr3 = {'D', 'B', 'E', 'A', 'B', 'C'};
	Object[] keyarr4 = {'D', 'F', 'C', 'A', 'E', 'T'};
	Object[] nothing = {};
	/**
	 * Used To throw exceptions
	 */
	Object[] keyNull = {'D', 'F', null , 'A', 'E', 'T'};
	
	/**
	 * First Test just makes sure everything starts off as null
	 */
	@Test
	public void nullCheck() {
		assertEquals(tree.root.key(), null);
		assertEquals(tree.root.value(), null);
		assertEquals(tree.root.child(), null);
		assertEquals(tree.root.parent(), null);
		assertEquals(tree.root.prev(), null);
		assertEquals(tree.root.next(), null);
	}
	
	/*
	 * 
	 * Testing the Add method by using search to see if what we added is in the methods
	 * Test to see if they actually show up somewhere in the tree
	 */
	@Test
	public void test_add() {
		tree.add(keyarr1, "Eric");
		tree.add(keyarr2, "BoyoBoy");
		tree.add(keyarr3, " ");
		tree.add(keyarr4, "Top");
		assertTrue(tree.add(keyarr4, "Maur"));
		assertEquals(tree.search(keyarr1), "Eric");
		assertEquals(tree.search(keyarr2), "BoyoBoy");
		assertEquals(tree.search(keyarr3), " ");
		assertFalse(tree.add(nothing, "Whatup"));
	}
	/**
	 * This test if they what is being added is in the correct position
	 */
	@Test
	public void test_addLocation() {
		//'A', 'B', 'C', 'A', 'B', 'C'
		assertEquals(tree.root.key(), null);
		tree.add(keyarr1, "Eric");
		tree.add(keyarr1sib, "ESCAPE");
		
		assertEquals(tree.root.child().key(), 'A');
		assertEquals(tree.root.child().value(),null);
		assertEquals(tree.root.child().child().key(), 'B');
		assertEquals(tree.root.child().child().value(),null);
		assertEquals(tree.root.child().child().child().key(), 'C');
		assertEquals(tree.root.child().child().child().value(), "Eric");
		
	}
	/**
	 * Test the remove to make sure what we added is not in the tree anymore
	 */
	@Test
	public void test_remove() {
		tree.add(keyarr1, "Eric");
		tree.add(keyarr2, "BoyoBoy");
		tree.add(keyarr3, " ");
		
		assertEquals(tree.search(keyarr1), "Eric");
		tree.remove(keyarr1);
		assertEquals(tree.search(keyarr1), null);
		
		assertEquals(tree.search(keyarr2), "BoyoBoy");
		tree.remove(keyarr2);
		assertEquals(tree.search(keyarr2), null);
		
		assertEquals(tree.search(keyarr3), " ");
		tree.remove(keyarr3);
		assertEquals(tree.search(keyarr3), null);
		
		
	}
	
	
	@Test
	public void test_search() {
		tree.add(keyarr1, "Eric");
		tree.add(keyarr2, "BoyoBoy");
		tree.add(keyarr3, " ");
		assertTrue(tree.add(keyarr4, "Maur"));
		assertEquals(tree.search(keyarr1), "Eric");
		assertEquals(tree.search(keyarr2), "BoyoBoy");
		assertEquals(tree.search(keyarr3), " ");
		
	}
	/**
	 * Test every method to make sure they throw an exception when a key with a null in a spot is used
	 */
	@Test(expected = NullPointerException.class)
	public void test_ALLCASESofNullPointer() {
		tree.add(keyNull, " ");
		tree.remove(keyNull);
		tree.search(keyNull);
		tree.prefix(keyNull);
	}
	/**
	 * Prefix returns the longest value key it has when you input a diferent key
	 */
	@Test 
	public void test_prefix() {
		tree.add(keyarr1, "Eric");
		tree.add(keyarr1sib, "BoyoBoy");
		tree.prefix(keyarr1);
		tree.prefix(keyarr2);
		tree.prefix(keyarr3);
		tree.prefix(keyarr4);
		//assertEquals(tree.prefix(keyarr1sib), keyarr1); //They are simualr up until keyarr1 sib has an extra letter		
	}

}
