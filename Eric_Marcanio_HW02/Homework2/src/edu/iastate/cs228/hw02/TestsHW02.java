package edu.iastate.cs228.hw02;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

/**
 * @author Cory Smith
 * @author Jamie Sampson
 *
 */

public class TestsHW02 {
	
	@Test
	public void test01_ResizableArrayBagUnion() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"a", "b", "b", "b", "c", "d", "e"};
		Object[] result = bag.union(bag2).toArray();
		Object[] result2 = bag2.union(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	public static String error(Object[] a, Object[] b) {
		return "Expected " + Arrays.toString(a) + " and " + Arrays.toString(b) + " to be the same, but they weren't";
	}
	public static boolean arrayContainsObject(Object[] a, Object o) {
		if (a == null || o == null || a.length == 0) return false;
		for (Object n : a) {
			if (n.equals(o)) return true;
		}
		return false;
	}
	@Test
	public void test05_ResizableArrayBagIntersection() {
		String[] bagStrings = {"a", "b", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"b", "b"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	@Test
	public void test02_ResizableArrayBagIntersection() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"b"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	@Test
	public void test03_ResizableArrayBagIntersection() {
		String[] bagStrings = {"a", "b", "b", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"b", "b"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	@Test
	public void test06_ResizableArrayBagDifference() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"a", "c"};
		String[] expected2 = {"b", "d", "e"};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}


	 
	//check this < other
	
	//check this > other
	
	//check none intersect
	@Test
	public void test04_ResizableArrayBagIntersection() {
		String[] bagStrings = {"a", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	
	//check this = other
	
	
	//check this < other
	
	
	//check this > other
	@Test
	public void test07_ResizableArrayBagDifference() {
		String[] bagStrings = {"a", "b", "b", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"a", "b", "c"};
		String[] expected2 = {"d", "e"};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	//check none different
	@Test
	public void test08_ResizableArrayBagDifference() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"a", "b", "c"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {};
		String[] expected2 = {};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	//check all different
	@Test
	public void test09_ResizableArrayBagDifference() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"d", "d", "e", "e"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
		String[] expected = {"a", "b", "c"};
		String[] expected2 = {"d", "d", "e", "e"};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	@Test
	public void test04_ResizableArrayBagReplace() {
		String[] bagStrings = {"a", "b", "c"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>();
		
		assertNotEquals(bag.replace("g"), null); 
		assertEquals(bag2.replace("g"), null);
		assertTrue(arrayContainsObject(bag.toArray(), "g"));
		// I'm assuming that calling replace on an empty bag is not supposed to add the object to the bag
		// If this is wrong, I'll fix it later
		assertFalse(arrayContainsObject(bag2.toArray(), "g"));
	}
	
	@Test
	public void test05_ResizableArrayBagRemoveEvery() {
		String[] bagStrings = {"b", "a", "b", "c"};
		ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
		String[] expected = {"a", "c"};
		bag.removeEvery("b");
		Object[] result = bag.toArray();
		
		Arrays.sort(expected);
		Arrays.sort(result);
		
		assertArrayEquals(error(expected, result), expected, result);
	}
	@Test
	public void test11_LinkedBagRemoveEvery() {
		String[] bagStrings = {"b", "a", "b", "c"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		String[] expected = {"a", "c"};
		bag.removeEvery("b");
		Object[] result = bag.toArray();
		
		Arrays.sort(expected);
		Arrays.sort(result);
		
		assertArrayEquals(error(expected, result), expected, result);
	}
	@Test
	public void test10_LinkedBagReplace() {
		String[] bagStrings = {"a", "b", "c"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		
		assertNotEquals(bag.replace("g"), null); 
		assertEquals(bag2.replace("g"), null);
		assertTrue(arrayContainsObject(bag.toArray(), "g"));
		// I'm assuming that calling replace on an empty bag is not supposed to add the object to the bag
		// If this is wrong, I'll fix it later
		assertFalse(arrayContainsObject(bag2.toArray(), "g"));
	}
	@Test
	public void test07_LinkedBagUnion() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"b", "b", "d", "e", "a", "b", "c"};
		Object[] result = bag.union(bag2).toArray();
		Object[] result2 = bag2.union(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	@Test
	public void test08_LinkedBagIntersection() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"b"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	
	//check same
	@Test
	public void test10_LinkedBagIntersection() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"a", "b", "c"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"a", "b", "c"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	
	//check none
	@Test
	public void test11_LinkedBagIntersection() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"d", "e", "f", "g"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	
	//check this > other
	@Test
	public void test09_LinkedBagIntersection() {
		String[] bagStrings = {"a", "b", "b", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"b", "b"};
		Object[] result = bag.intersection(bag2).toArray();
		Object[] result2 = bag2.intersection(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected, result2), expected, result2);
	}
	@Test
	public void test09_LinkedBagDifference() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"a", "c"};
		String[] expected2 = {"b", "d", "e"};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	//check this > other
	@Test
	public void test12_LinkedBagDifference() {
		String[] bagStrings = {"a", "b", "b", "b", "c"};
		String[] bagStrings2 = {"b", "b", "d", "e"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {"a", "b", "c"};
		String[] expected2 = {"d", "e"};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	//check none different
	@Test
	public void test10_LinkedBagDifference() {
		String[] bagStrings = {"a", "b", "c"};
		String[] bagStrings2 = {"a", "b", "c"};
		LinkedBag<String> bag = new LinkedBag<String>();
		for (String s : bagStrings) bag.add(s);
		LinkedBag<String> bag2 = new LinkedBag<String>();
		for (String s : bagStrings2) bag2.add(s);
		String[] expected = {};
		String[] expected2 = {};
		Object[] result = bag.difference(bag2).toArray();
		Object[] result2 = bag2.difference(bag).toArray();
		
		Object[] base = bag.toArray();
		Object[] base2 = bag2.toArray();
		
		Arrays.sort(base);
		Arrays.sort(base2);
		
		assertArrayEquals(error(bagStrings, base), bagStrings, base);
		assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
		
		Arrays.sort(expected);
		Arrays.sort(expected2);
		Arrays.sort(result);
		Arrays.sort(result2);
		
		assertArrayEquals(error(expected, result), expected, result);
		assertArrayEquals(error(expected2, result2), expected2, result2);
	}
	
	//check all different
		@Test
		public void test11_LinkedBagDifference() {
			String[] bagStrings = {"a", "b", "c"};
			String[] bagStrings2 = {"d", "e", "f"};
			LinkedBag<String> bag = new LinkedBag<String>();
			for (String s : bagStrings) bag.add(s);
			LinkedBag<String> bag2 = new LinkedBag<String>();
			for (String s : bagStrings2) bag2.add(s);
			String[] expected = {"a", "b", "c"};
			String[] expected2 = {"d", "e", "f"};
			Object[] result = bag.difference(bag2).toArray();
			Object[] result2 = bag2.difference(bag).toArray();
			
			Object[] base = bag.toArray();
			Object[] base2 = bag2.toArray();
			
			Arrays.sort(base);
			Arrays.sort(base2);
			
			assertArrayEquals(error(bagStrings, base), bagStrings, base);
			assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
			
			Arrays.sort(expected);
			Arrays.sort(expected2);
			Arrays.sort(result);
			Arrays.sort(result2);
			
			assertArrayEquals(error(expected, result), expected, result);
			assertArrayEquals(error(expected2, result2), expected2, result2);
		}
		@Test
		public void test12_LinkedBagEquals() {
			String[] bagStrings = {"b", "a", "b", "c"};
			String[] bagStrings2 = {"a", "c", "b", "b"};
			LinkedBag<String> bag = new LinkedBag<String>();
			for (String s : bagStrings) bag.add(s);
			LinkedBag<String> bag2 = new LinkedBag<String>();
			for (String s : bagStrings2) bag2.add(s);
			
			assertTrue(bag.equals(bag2));
			
			String[] bagStrings3 = {"b", "a", "b", "c", "b"};
			LinkedBag<String> bag3 = new LinkedBag<String>();
			for (String s : bagStrings3) bag3.add(s);
			
			assertFalse(bag.equals(bag3));
			
			Object[] bagObjects = { new Double(2), new Double(6) };
			LinkedBag<Object> bag4 = new LinkedBag<Object>();
			for (Object o : bagObjects) bag4.add(o);
			
			assertFalse(bag.equals(bag4));
			
			Arrays.sort(bagStrings);
			Arrays.sort(bagStrings2);
			Arrays.sort(bagStrings3);
			Arrays.sort(bagObjects);
			
			Object[] base = bag.toArray();
			Object[] base2 = bag2.toArray();
			Object[] base3 = bag3.toArray();
			Object[] base4 = bag4.toArray();
			
			Arrays.sort(base);
			Arrays.sort(base2);
			Arrays.sort(base3);
			Arrays.sort(base4);
			
			assertArrayEquals(error(bagStrings, base), bagStrings, base);
			assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
			assertArrayEquals(error(bagStrings3, base3), bagStrings3, base3);
			assertArrayEquals(error(bagObjects, base4), bagObjects, base4);
		}
		
		@Test
		public void test13_LinkedBagEquals() {
			String[] bagStrings = {"b", "a", "b", "c"};
			LinkedBag<String> bag = new LinkedBag<String>();
			for (String s : bagStrings) bag.add(s);
			
			assertFalse(bag.equals(null));
		}
		
	
		@Test
		public void test06_ResizableArrayBagEquals() {
			String[] bagStrings = {"b", "a", "b", "c"};
			String[] bagStrings2 = {"a", "c", "b", "b"};
			ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
			ResizableArrayBag<String> bag2 = new ResizableArrayBag<String>(bagStrings2);
			
			assertTrue(bag.equals(bag2));
			
			String[] bagStrings3 = {"b", "a", "b", "c", "b"};
			ResizableArrayBag<String> bag3 = new ResizableArrayBag<String>(bagStrings3);
			
			assertFalse(bag.equals(bag3));
			
			Object[] bagObjects = { new Double(2), new Double(6) };
			ResizableArrayBag<Object> bag4 = new ResizableArrayBag<Object>(bagObjects);
			
			assertFalse(bag.equals(bag4));
			
			Arrays.sort(bagStrings);
			Arrays.sort(bagStrings2);
			Arrays.sort(bagStrings3);
			Arrays.sort(bagObjects);
			
			Object[] base = bag.toArray();
			Object[] base2 = bag2.toArray();
			Object[] base3 = bag3.toArray();
			Object[] base4 = bag4.toArray();
			
			Arrays.sort(base);
			Arrays.sort(base2);
			Arrays.sort(base3);
			Arrays.sort(base4);
			
			assertArrayEquals(error(bagStrings, base), bagStrings, base);
			assertArrayEquals(error(bagStrings2,base2),bagStrings2, base2);
			assertArrayEquals(error(bagStrings3, base3), bagStrings3, base3);
			assertArrayEquals(error(bagObjects, base4), bagObjects, base4);
		}
		
		@Test
		public void test09_ResizableArrayBagEquals() {
			String[] bagStrings = {"b", "a", "b", "c"};
			ResizableArrayBag<String> bag = new ResizableArrayBag<String>(bagStrings);
			assertEquals(bag.equals(null), false);
		}
		
	/**
	
	
	//check this < other
	
	
	
	
	
	
	
	
	
	// A basic array-contains-object method in order to test replace
	
*/
}