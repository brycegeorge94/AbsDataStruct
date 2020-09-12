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
	void addFrontAndGetFromSingleTest() {
		int i = 1;
		dll.addFront(i);
		assertEquals(i, dll.getFrom(0), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void addBackAndGetIndexSingleTest() {
		int i = 1;
		dll.addBack(i);
		assertEquals(0, dll.getIndex(i), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void addAtAndGetFromTest() {
		dll.addFront(2);
		dll.addFront(3);
		int i = 1;
		dll.addAt(1, i);
		assertEquals(i, dll.getFrom(1), "Object i should be at index zero");
		assertEquals(1, dll.size(), "Size should equal one");
	}
	
	@Test
	void removeTest() {
		int i = 1;
		dll.addFront(i);
		assertEquals(true, dll.remove(i), "Object i should be removed from list");
		assertEquals(false, dll.remove(i), "Object i should already be removed from list");
	}
	
	@Test
	void removeFromTest() {
		int i = 1;
		dll.addFront(2);
		dll.addAt(0, i);
		dll.removeFrom(0);
		assertEquals(2, dll.getFrom(0), "Object at index zero should be two");
	}
	
	@Test
	void containsTest() {
		int i = 1;
		dll.addFront(i);
		assertEquals(true, dll.contains(i), "Object i should exist in list");
		int j = 2;
		assertEquals(false, dll.contains(j), "Object j should not exist in list");
	}

}
