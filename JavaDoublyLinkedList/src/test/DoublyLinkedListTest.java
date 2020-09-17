package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dll.DoublyLinkedList;

class DoublyLinkedListTest {
	
	private DoublyLinkedList dll;
	
	@BeforeEach
	void setupList() {
		dll = new DoublyLinkedList();
	}

	@Test
	void prependAndGetFromSingleTest() {
		int i = 1;
		dll.prepend(i);
		assertEquals(i, dll.getFrom(0), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void prependWithOneElementTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(i);
		assertEquals(i, dll.getFrom(0), "Object i should be at index zero");
		assertEquals(2, dll.size(), "Size should equal two");
	}
	
	@Test
	void prependWithTwoOrMoreElementTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(3);
		dll.prepend(i);
		assertEquals(i, dll.getFrom(0), "Object i should be at index zero");
		assertEquals(3, dll.size(), "Size should equal three");
	}
	
	@Test
	void appendAndGetIndexSingleTest() {
		int i = 1;
		dll.append(i);
		assertEquals(0, dll.getIndex(i), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void appendWithOneElementTest() {
		int i = 1;
		dll.prepend(2);
		dll.append(i);
		assertEquals(1, dll.getIndex(i), "Object i should be at index zero");
		assertEquals(2, dll.size(), "Size should equal one");
	}
	
	@Test
	void appendWithTwoOrMoreElementTest() {
		int i = 1;
		dll.prepend(3);
		dll.prepend(2);
		dll.append(i);
		assertEquals(2, dll.getIndex(i), "Object i should be at index zero");
		assertEquals(3, dll.size(), "Size should equal one");
	}
	
	@Test
	void addAtAndGetFromTest() {
		dll.prepend(2);
		dll.prepend(3);
		int i = 1;
		dll.addAt(1, i);
		assertEquals(i, dll.getFrom(1), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void removeOneTest() {
		int i = 1;
		dll.prepend(i);
		assertEquals(true, dll.remove(i), "Object i should be removed from list");
		assertEquals(false, dll.remove(i), "Object i should already be removed from list");
		assertEquals(0, dll.size(), "Size should be zero");
	}
	
	@Test
	void removeTwoTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(i);
		assertEquals(true, dll.remove(i), "Object i should be removed from list");
		assertEquals(false, dll.remove(i), "Object i should already be removed from list");
		assertEquals(1, dll.size(), "Size should be one");
	}
	
	@Test
	void removeMultiTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(3);
		dll.prepend(i);
		assertEquals(true, dll.remove(i), "Object i should be removed from list");
		assertEquals(false, dll.remove(i), "Object i should already be removed from list");
		assertEquals(2, dll.size(), "Size should be two");
	}
	
	@Test
	void removeFromOneTest() {
		int i = 1;
		dll.prepend(i);
		dll.removeFrom(i);
		assertEquals(0, dll.size(), "Size should be zero after removal");
	}
	
	@Test
	void removeFromTwoTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(i);
		dll.removeFrom(1);
		assertEquals(i, dll.getFrom(0), "Object at index zero should be i");
		assertEquals(1, dll.size(), "Size should be one");
	}
	
	@Test
	void removeFromOneHeadTest() {
		int i = 1;
		dll.prepend(i);
		dll.prepend(2);
		dll.removeFrom(0);
		assertEquals(i, dll.getFrom(0), "Object at index zero should be i");
		assertEquals(1, dll.size(), "Size should be one");
	}
	
	@Test
	void removeFromMultiTest() {
		int i = 1;
		dll.prepend(2);
		dll.prepend(3);
		dll.append(i);
		dll.removeFrom(1);
		assertEquals(i, dll.getFrom(1), "Object at index one should be i");
		assertEquals(2, dll.size(), "Size should be two");
	}
	
	@Test
	void removeFromMultiHeadTest() {
		int i = 2;
		dll.prepend(3);
		dll.prepend(i);
		dll.prepend(1);
		dll.removeFrom(0);
		assertEquals(i, dll.getFrom(0), "Object at head should be i");
		assertEquals(2, dll.size(), "Size should be two");
		
	}
	
	@Test
	void containsTest() {
		int i = 1;
		dll.prepend(i);
		assertEquals(true, dll.contains(i), "Object i should exist in list");
		int j = 2;
		assertEquals(false, dll.contains(j), "Object j should not exist in list");
	}

}
