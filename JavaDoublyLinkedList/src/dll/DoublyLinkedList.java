package dll;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	private Node head; // Node at index 0
	private int size;
	
	public DoublyLinkedList() {}
	
	public DoublyLinkedList(Object obj) {
		addFront(obj);
	}
	
	public void addFront(Object obj) {
		if (head == null) {
			// List is empty, create new node
			head = new Node(obj, null, null);
		} else if (head.next == null) {
			// List only has head, create second node and interlink
			Node temp = new Node(obj, head, head);
			head.next = head.prev = temp;
			head = temp;
		} else {
			//List 
			Node temp = new Node(obj, head, head.prev);
			head.prev.next = temp;
			head.prev = temp;
			head = temp;
		}
		size++;
	}
	
	public void addBack(Object obj) {
		
	}
	
	public void addAt(int index, Object obj) {
		if (index != 0)
			verifyNotEmpty();
		
	}
	
	public boolean remove(Object obj) {
		return false;
	}
	
	public void removeFrom(int index) {
		verifyNotEmpty();
		
	}
	
	public Object getFrom(int index) {
		verifyNotEmpty();
		
		int parsedIndex = parseIndex(index);
		
		if (parsedIndex == 0)
			return head.obj;
		
		Node curr = head;
		
		if (parsedIndex <= size/2)	// If in front half of list
			for (int i = 0; i < parsedIndex; i++)
				curr = curr.next;
		else						// If in rear half of list
			for (int i = size; i > parsedIndex; i--)
				curr = curr.prev;
		
		return curr.obj;
	}
	
	public int getIndex(Object obj) {
		return 0;
	}
	
	public boolean contains(Object obj) {
		return false;
	}
	
	public int size() {
		return size;
	}
	
	// Allows use of given indices out of range, as the LinkedList loops anyway
	// For example, if list is of size 10, an index of 15 will retrieve index 5
	// Also allows negatives, for size 10, -3 will retrieve item at index 7
	private int parseIndex(int index) {
		boolean negative = index < 0;
		int temp = Math.abs(index);
		
		while(temp > size)
			temp -= size;
		
		if (negative)
			temp = size - temp;
		
		return temp;
	}
	
	private void verifyNotEmpty() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException("Cannot perform operation on empty DoublyLinkedList");
	}
}
